/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaBookingService.Visitor;
import java.sql.ResultSet;
public class VisitorProxy implements IVisitor{
   private Integer id;
   private Optional<Visitor> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public VisitorProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public VisitorProxy(Visitor theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Visitor getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Visitor";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IVisitor)) return false;
      return ((IVisitor)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Visitor load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Visitor", this.id);
         String name = rs.getString("name");
         return Visitor.createAlreadyPersistent(this, name);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getName() {
      return this.getTheObject().getName();
   }
   public void setName(String newName) throws PersistenceException{
      this.getTheObject().setName(newName);
   }
}
