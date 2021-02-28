/**--- Generated at Sun Feb 28 15:38:46 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Middle;
import java.util.Optional;
public interface IMiddle extends IPriceCategory{
   public Middle getTheObject();
   public Integer getId();
   public Optional<Integer> getMiddleprice() ;
   public void setMiddleprice(Integer newMiddleprice) throws PersistenceException;
}
