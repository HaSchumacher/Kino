/**--- Generated at Fri Mar 05 15:44:03 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.CinemaRow;
import java.sql.ResultSet;
import generated.cinemaService.Seat;
import java.util.List;
import exceptions.ConstraintViolation;
import generated.cinemaService.PriceCategory;
import generated.cinemaService.relationControl.CinemaRow_PriceCategorySupervisor;
public class CinemaRowProxy implements ICinemaRow{
   private Integer id;
   private Optional<CinemaRow> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public CinemaRowProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public CinemaRowProxy(CinemaRow theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public CinemaRow getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "CinemaRow";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ICinemaRow)) return false;
      return ((ICinemaRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private CinemaRow load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("CinemaRow", this.id);
         PriceCategory priceCategory = CinemaRow_PriceCategorySupervisor.getInstance().getPriceCategory(this).getTheObject();
         Integer number = rs.getInt("number");
         Boolean bookedUp = rs.getBoolean("bookedUp");
         return CinemaRow.createAlreadyPersistent(this, priceCategory, number, bookedUp);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public List<Seat> getMySeats() throws PersistenceException{
      return this.getTheObject().getMySeats();
   }
   public void addToMySeats(Seat arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToMySeats(arg);
   }
   public boolean removeFromMySeats(Seat arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromMySeats(arg);
   }
   public PriceCategory getPriceCategory() throws PersistenceException{
      return this.getTheObject().getPriceCategory();
   }
   public void setPriceCategory(PriceCategory newPriceCategory)throws PersistenceException{
      this.getTheObject().setPriceCategory(newPriceCategory);
   }
   public Integer getNumber() {
      return this.getTheObject().getNumber();
   }
   public void setNumber(Integer newNumber) throws PersistenceException{
      this.getTheObject().setNumber(newNumber);
   }
   public Boolean getBookedUp() {
      return this.getTheObject().getBookedUp();
   }
   public void setBookedUp(Boolean newBookedUp) throws PersistenceException{
      this.getTheObject().setBookedUp(newBookedUp);
   }
}
