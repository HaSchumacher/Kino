/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.KeyPair;
import java.sql.ResultSet;
public class KeyPairProxy implements IKeyPair{
   private Integer id;
   private Optional<KeyPair> theObject;
   public KeyPairProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public KeyPairProxy(KeyPair theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public KeyPair getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "KeyPair";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IKeyPair)) return false;
      return ((IKeyPair)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private KeyPair load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("KeyPair", this.id);
         String privateKey = rs.getString("privateKey");
         String publicKey = rs.getString("publicKey");
         return KeyPair.createAlreadyPersistent(this, privateKey, publicKey);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getPrivateKey() {
      return this.getTheObject().getPrivateKey();
   }
   public void setPrivateKey(String newPrivateKey) throws PersistenceException{
      this.getTheObject().setPrivateKey(newPrivateKey);
   }
   public String getPublicKey() {
      return this.getTheObject().getPublicKey();
   }
   public void setPublicKey(String newPublicKey) throws PersistenceException{
      this.getTheObject().setPublicKey(newPublicKey);
   }
}
