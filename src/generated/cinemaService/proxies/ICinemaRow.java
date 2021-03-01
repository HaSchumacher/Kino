/**--- Generated at Mon Mar 01 12:40:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.CinemaRow;
import generated.cinemaService.Seat;
import java.util.List;
import exceptions.ConstraintViolation;
import generated.cinemaService.PriceCategory;
public interface ICinemaRow extends Identifiable{
   public CinemaRow getTheObject();
   public Integer getId();
   public List<Seat> getMySeats() throws PersistenceException;
   public void addToMySeats(Seat arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromMySeats(Seat arg) throws ConstraintViolation, PersistenceException;
   public PriceCategory getPriceCategory() throws PersistenceException;
   public void setPriceCategory(PriceCategory newPriceCategory)throws PersistenceException;
   public Integer getNumber() ;
   public void setNumber(Integer newNumber) throws PersistenceException;
   public Boolean getBookedUp() ;
   public void setBookedUp(Boolean newBookedUp) throws PersistenceException;
}
