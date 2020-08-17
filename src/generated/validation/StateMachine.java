/**--- Generated at Mon Aug 17 20:02:50 CEST 2020 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.validation;
//10 ===== GENERATED:      Import Section =========
import observation.Observable;
import java.util.Set;
import java.util.List;
import exceptions.ConstraintViolation;
import idManagement.IDManager;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class StateMachine extends Observable implements java.io.Serializable
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public StateMachine(State startState)
   {
      super();
      SM_StartStateSupervisor.getInstance().set(this, startState);
      this.id = IDManager.getTheInstance().getNextId();
      Validation.getInstance().getTheStateMachines().add(this);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public State getStartState(){
      return SM_StartStateSupervisor.getInstance().getStartState(this);
   }
   private void setStartState(State newStartState){
      SM_StartStateSupervisor.getInstance().change(this, this.getStartState(), newStartState);
   }
   public Set<State> getStates(){
      return SM_StatesSupervisor.getInstance().getStates(this);
   }
   public void addToStates(State arg) {
      SM_StatesSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromStates(State arg) {
      return SM_StatesSupervisor.getInstance().remove(this, arg);
   }
   public List<Event> getEvents(){
      return SM_EventsSupervisor.getInstance().getEvents(this);
   }
   public void addToEvents(Event arg) throws ConstraintViolation{
      SM_EventsSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromEvents(Event arg) throws ConstraintViolation{
      return SM_EventsSupervisor.getInstance().remove(this, arg);
   }
   public List<Transition> getTransitions(){
      return SM_TransitionsSupervisor.getInstance().getTransitions(this);
   }
   public void addToTransitions(Transition arg) {
      SM_TransitionsSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromTransitions(Transition arg) {
      return SM_TransitionsSupervisor.getInstance().remove(this, arg);
   }
   public Integer getId(){
      return this.id;
   }
   //80 ===== Editable : Your Operations =============
/**
 * Fuegt eine Transition von <from> nach <to> mit event <e> hinzu
 */
   public void addTransition(State from, State to, Event e){
      // TODO: Implement Operation addTransition
      return;
   }
/**
 * Fuegt eine (isFinal-)Zustand mit Namen <name> hinzu
 */
   public void addState(String name, Boolean isFinal){
      // TODO: Implement Operation addState
      return;
   }
//90 ===== GENERATED: End of Your Operations ======
}
