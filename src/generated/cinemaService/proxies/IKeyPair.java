/**--- Generated at Fri Mar 05 15:44:03 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.KeyPair;
public interface IKeyPair extends Identifiable{
   public KeyPair getTheObject();
   public Integer getId();
   public String getPrivateKey() ;
   public void setPrivateKey(String newPrivateKey) throws PersistenceException;
   public String getPublicKey() ;
   public void setPublicKey(String newPublicKey) throws PersistenceException;
}
