package relationManagement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Represents the elements of a binary relation \subseteq S x T 
 * It is a multi-set to enable lists, e.g,. in an association A->^theBList B  
 */
public class Relation<S,T> {
/**	
 * Redundant storage of relation: Symmetric, indexed over S, indexed over T
 * Class invariants in consistent states:
 * 		1. For all s\in S: SIndex.get(s) = {t | (s,t) \in R} (as Multi-Set)
 * 		2. For all t\in T: TIndex.get(t) = {s | (s,t) \in R} (as Multi-Set)
 *  	3. For both indices i in {SIndex, TIndex}: For all x: i.containsKey(x) => !(i.get(x).isEmpty())
 *  	4. For all (s,t)\in elements: s != null != t
 *  
 *     Consistent states are before and after 
 *     change
 *     addElement
 *     removeElement
 *     removeElementRevertible->removeElementCommit
 *     removeElementRevertible->removeElementRollback
 */
	private List<RelElement<S, T>> elements;
	private Map<S,List<T>> SIndex;
	private Map<T,List<S>> TIndex;
	public Relation() {
		this.elements = new ArrayList<>();
		this.SIndex = new HashMap<S,List<T>>();
		this.TIndex = new HashMap<T,List<S>>();
	}
/**
 * Unchecked and unrestricted addition of a relation element - null references are not added
 */
	public void addElement(S s, T t) {
		if(s==null || t==null) return;
		this.elements.add(new RelElement<S,T>(s, t));
		this.indexAdd(s, t, SIndex);
		this.indexAdd(t, s, TIndex);
		this.invariantCheck();
	}
/**	
 * Sets the new target @param newT for @param s
 * If s was related to @param oldT before, one of these relations is removed
 */
	public void change(S s, T oldT, T newT) {
		this.addElement(s, newT);
		this.removeElement(s, oldT);
		this.invariantCheck();
	}
	public List<T> getRelatedTargets(S s){
		if(!this.SIndex.containsKey(s)) return new ArrayList<T>();
		return this.SIndex.get(s);
	}
	public List<S> getRelatedSources(T t){
		if(!this.TIndex.containsKey(t)) return new ArrayList<S>();
		return this.TIndex.get(t);
	}	
// ======================= Remove Handling =============================== 
// 1. Irrevertible Remove	
/**
 * Unchecked and unrestricted removal of a relation element
 * Returns false, 																	 if (s,t) \not\in R
 * Returns true and removes THE LAST relation element with the given projections, otherwise
 * 
 * To enforce remove o add = id, <remove> must remove beginning from the end
 */
	public boolean removeElement(S s, T t) {
		boolean result = false;
		ListIterator<RelElement<S, T>> listIterator = this.elements.listIterator(this.elements.size());
		while(listIterator.hasPrevious()) {
			RelElement<S, T> current = listIterator.previous();
			if(current.getFirstProjection().equals(s)&&current.getSecondProjection().equals(t)) {
				listIterator.remove();
				result = true;
				this.indexRemove(s, t, SIndex);
				this.indexRemove(t, s, TIndex);
				break;
			}
		}
		this.invariantCheck();
		return result;
	}
/**	
 * Removes the last occurence of x from list, only used from outside by tests
 */
	public <X> void removeLastElementOf(List<X> list, X x) {
		ListIterator<X> listIterator = list.listIterator(list.size());
		while (listIterator.hasPrevious()) {
			X current = listIterator.previous();
			if(x==current) {
				listIterator.remove();
				break;
			}
		}
	}

// 2. Revertible removal of (s,t) :
// 2.1. Replace removee by (null,null) and leave indices unchanged (invariant is violated now!)	
	public boolean removeElementRevertible(S s, T t) {
		boolean result = false;
		ListIterator<RelElement<S, T>> listIterator = this.elements.listIterator(this.elements.size());
		while(listIterator.hasPrevious()) {
			RelElement<S, T> current = listIterator.previous();
			if(current.getFirstProjection().equals(s)&&current.getSecondProjection().equals(t)) {
				listIterator.set(new RelElement<S,T>(null,null));
				result = true;
				break;
			}
		}
		return result;
	}
// 2.2. remove (null,null)	and adjust indices -> invariants hold
	public void removeElementCommit(S s, T t) {
		this.indexRemove(s, t, SIndex);
		this.indexRemove(t, s, TIndex);
		this.removeNullPairFromElements();
		this.invariantCheck();
	}
/**
 * Removes the last element (null,null) from elements
 * REQUIRES at most one such pair
 */
	private void removeNullPairFromElements() {
		ListIterator<RelElement<S, T>> listIterator = this.elements.listIterator(this.elements.size());
		while(listIterator.hasPrevious()) {
			RelElement<S, T> rel = listIterator.previous();
			if(rel.getFirstProjection()==null && rel.getSecondProjection()==null) {
				listIterator.remove();
				break;
			}
		}
	}
// 2.3. Replace (null,null) by original contents, leave indices unchanged -> invariants hold	
	public void removeElementRollback(S s, T t) {
		this.replaceNullPairBy(s, t);
		this.invariantCheck();
	}
	private void replaceNullPairBy(S s, T t) {
		ListIterator<RelElement<S, T>> listIterator = this.elements.listIterator(this.elements.size());
		while(listIterator.hasPrevious()) {
			RelElement<S, T> rel = listIterator.previous();
			if(rel.getFirstProjection()==null && rel.getSecondProjection()==null) {
				listIterator.set(new RelElement<S,T>(s,t));
				break;
			}
		}
	}

// ============= Constraints ======================================
// --> They are all based on elements structure, ==================
//	   because they may be tested after a removeRevertible and ====
// 	   before the commit / rollback	
	public boolean isTotalMapAt(S s) {
		return this.elements.stream().filter(r->r.getFirstProjection()==s).collect(Collectors.toList()).size()==1;
	}
	public boolean isPartialMapAt(S s) {
		return this.elements.stream().filter(r->r.getFirstProjection()==s).collect(Collectors.toList()).size()<=1;
	}
	public boolean isSurjectiveAt(T t) {
		return this.elements.stream().filter(r->r.getSecondProjection()==t).collect(Collectors.toList()).size()>=1;
	}
	public boolean isInjectiveAt(T t) {
		return this.elements.stream().filter(r->r.getSecondProjection()==t).collect(Collectors.toList()).size()<=1;
	}
	public boolean isContainment() {
		for (T containedTarget : TIndex.keySet()) 
			if(containedTarget!=null && (!this.isInjectiveAt(containedTarget) || !this.isSurjectiveAt(containedTarget))) return false;
		return true;		
	}
	
// ============= Private Part ========================== 	
	private <A,B> void indexAdd(A a, B b, Map<A,List<B>> index){
		if(index.containsKey(a)) 
			index.get(a).add(b);
		else {
			List<B> bList = new ArrayList<B>();
			bList.add(b);
			index.put(a, bList);
		}			
	}
/**
 * REQUIRES (a,b)\in R	
 * Removes the LAST element x with x==b in XIndex.get(a) 
 */
	private <A,B> void indexRemove(A a, B b, Map<A,List<B>> index){
		this.removeLastElementOf(index.get(a),b);
		if(index.get(a).isEmpty()) index.remove(a);		
	}
//================= Target retrieval ===========================
/**
 * REQUIRES no key to be equal to null
 */
	private Set<T> getAllTargets(){
		return this.TIndex.keySet();
	}
	
// ==================== Invariant assertion ==========================
	private void invariantCheck() {
		for (S source : SIndex.keySet()) 
			assert ListUtilities.sameElements(this.getRelatedTargets(source), this.retrieveTargetsFromElementsFor(source)) : "Fatal Error: Inconsistency in Relation: In SIndex:" + this.getRelatedTargets(source) + ", in elements: " + this.retrieveTargetsFromElementsFor(source);	
		for (T target : TIndex.keySet()) 
			assert ListUtilities.sameElements(this.getRelatedSources(target), this.retrieveSourcesFromElementsFor(target)) : "Fatal Error: Inconsistency in Relation: In TIndex:" + this.getRelatedSources(target) + ", in elements: " + this.retrieveSourcesFromElementsFor(target);
		for (S s : SIndex.keySet()) assert !SIndex.get(s).isEmpty()	: "Fatal Error: Inconsistency in Relation: In SIndex: List for key " + s + " is empty."; 
		for (T t : TIndex.keySet()) assert !TIndex.get(t).isEmpty()	: "Fatal Error: Inconsistency in Relation: In TIndex: List for key " + t + " is empty.";
		assert noNullValue() : "Fatal error: Null Values in elements of relation";
	}
	private List<T> retrieveTargetsFromElementsFor(S s){
		return this.elements.stream().filter(r -> (r.getFirstProjection()==s)).map(r->r.getSecondProjection()).collect(Collectors.toList());
	}
	private List<S> retrieveSourcesFromElementsFor(T t){
		return this.elements.stream().filter(r -> (r.getSecondProjection()==t)).map(r->r.getFirstProjection()).collect(Collectors.toList());
	}
	private boolean noNullValue() {
		return this.elements.stream().allMatch(r->r.getFirstProjection()!=null && r.getSecondProjection()!=null);
	}	
}
