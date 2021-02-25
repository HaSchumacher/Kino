/**--- Generated at Thu Feb 25 17:02:37 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import db.executer.PersistenceException;
import generated.cinemaBookingService.CinemaRow;
import generated.cinemaBookingService.Seat;
import java.util.List;
import generated.cinemaBookingService.Cinemahall;
import java.util.Set;
public abstract class CinemaRowProxy implements ICinemaRow{
   public abstract CinemaRow getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof ICinemaRow)) return false;
      return ((ICinemaRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public List<Seat> getMySeats() throws PersistenceException{
      return this.getTheObject().getMySeats();
   }
   public void addToMySeats(Seat arg) throws PersistenceException{
      this.getTheObject().addToMySeats(arg);
   }
   public boolean removeFromMySeats(Seat arg) throws PersistenceException{
      return this.getTheObject().removeFromMySeats(arg);
   }
   public Integer getPrice() {
      return this.getTheObject().getPrice();
   }
   public void setPrice(Integer newPrice) throws PersistenceException{
      this.getTheObject().setPrice(newPrice);
   }
   public Boolean getBookedUp() {
      return this.getTheObject().getBookedUp();
   }
   public void setBookedUp(Boolean newBookedUp) throws PersistenceException{
      this.getTheObject().setBookedUp(newBookedUp);
   }
   public Set<Cinemahall> getMyHall() throws PersistenceException{
      return this.getTheObject().getMyHall();
   }
}
