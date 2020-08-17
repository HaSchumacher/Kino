/**--- Generated at Mon Aug 17 20:02:50 CEST 2020 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.validation;
//10 ===== GENERATED: Import Section ==============
import java.util.Set;
import java.util.HashSet;
import baseTypes.Rational;
import idManagement.IDManager;
import java.io.IOException;
import utilities.XStreamManager;
import java.util.Collection;
//20 ===== Editable : Your import section =========
//30 ===== GENERATED: Main Section ================
public class Validation{
   private Set<Event> theEvents;
   private Set<State> theStates;
   private Set<Transition> theTransitions;
   private Tr_StateFromSupervisor theTr_StateFromSupervisor;
   private Tr_StateToSupervisor theTr_StateToSupervisor;
   private Tr_EventSupervisor theTr_EventSupervisor;
   private Set<StateMachine> theStateMachines;
   private SM_StartStateSupervisor theSM_StartStateSupervisor;
   private SM_StatesSupervisor theSM_StatesSupervisor;
   private SM_EventsSupervisor theSM_EventsSupervisor;
   private SM_TransitionsSupervisor theSM_TransitionsSupervisor;
   private static Validation theInstance = new Validation();
   private Integer serviceId;
   private Validation(){
      this.serviceId = IDManager.getTheInstance().getNextId();
      this.theEvents = new HashSet<>();
      this.theStates = new HashSet<>();
      this.theTransitions = new HashSet<>();
      this.theTr_StateFromSupervisor = Tr_StateFromSupervisor.getInstance();
      this.theTr_StateToSupervisor = Tr_StateToSupervisor.getInstance();
      this.theTr_EventSupervisor = Tr_EventSupervisor.getInstance();
      this.theStateMachines = new HashSet<>();
      this.theSM_StartStateSupervisor = SM_StartStateSupervisor.getInstance();
      this.theSM_StatesSupervisor = SM_StatesSupervisor.getInstance();
      this.theSM_EventsSupervisor = SM_EventsSupervisor.getInstance();
      this.theSM_TransitionsSupervisor = SM_TransitionsSupervisor.getInstance();
   }
   public static Validation getInstance(){return theInstance;}
   public Integer getServiceId(){
      return this.serviceId;
   }
   public void loadLatest() throws IOException {
      theInstance = new XStreamManager<Validation>().read("Validation");
   }
   public void persist() throws IOException {
      new XStreamManager<Validation>().write("Validation", theInstance);
   }
   public Set<Event> getTheEvents(){
      return this.theEvents;
   }
   public Set<State> getTheStates(){
      return this.theStates;
   }
   public Set<Transition> getTheTransitions(){
      return this.theTransitions;
   }
   public Tr_StateFromSupervisor getTheTr_StateFromSupervisor(){
      return this.theTr_StateFromSupervisor;
   }
   public Tr_StateToSupervisor getTheTr_StateToSupervisor(){
      return this.theTr_StateToSupervisor;
   }
   public Tr_EventSupervisor getTheTr_EventSupervisor(){
      return this.theTr_EventSupervisor;
   }
   public Set<StateMachine> getTheStateMachines(){
      return this.theStateMachines;
   }
   public SM_StartStateSupervisor getTheSM_StartStateSupervisor(){
      return this.theSM_StartStateSupervisor;
   }
   public SM_StatesSupervisor getTheSM_StatesSupervisor(){
      return this.theSM_StatesSupervisor;
   }
   public SM_EventsSupervisor getTheSM_EventsSupervisor(){
      return this.theSM_EventsSupervisor;
   }
   public SM_TransitionsSupervisor getTheSM_TransitionsSupervisor(){
      return this.theSM_TransitionsSupervisor;
   }
   //80 ===== Editable : Your Operations =============
/**
 * Liefert true genau dann wenn w in L(sm)
 */
   public Boolean validate(StateMachine sm, Collection<Event> w){
      // TODO: Implement Operation validate
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}
