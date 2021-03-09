/**--- Generated at Fri Mar 05 14:10:20 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;

//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.KeyPairProxy;
import observation.Observable;
import generated.cinemaService.proxies.IKeyPair;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
//25 ===== GENERATED:      Header Section =========
public class KeyPair extends Observable implements java.io.Serializable, IKeyPair
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String privateKey;
   private String publicKey;
   //40 ===== Editable : Your Attribute Section ======
   public java.security.KeyPair keypair;
   //50 ===== GENERATED:      Constructor ============
   private KeyPair(Integer id, String privateKey, String publicKey, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.privateKey = privateKey;
      this.publicKey = publicKey;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static KeyPair createAlreadyPersistent(KeyPairProxy proxy, String privateKey, String publicKey){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new KeyPair(proxy.getId(), privateKey, publicKey, true);
   }
   public static KeyPair createFresh(String privateKey, String publicKey)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("KeyPair", "id, typeKey, privateKey, publicKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "KeyPair").toString() + ", " + "'" + privateKey + "'" + ", " + "'" + publicKey + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      KeyPair me = new KeyPair(id, privateKey, publicKey, false);
      CinemaService.getInstance().addKeyPairProxy(new KeyPairProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   public KeyPair(boolean own) throws NoSuchAlgorithmException, PersistenceException {
	   super();
	   db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
	   int id = dmlExecuter.getNextId();
	   this.setId(id);
	   KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	   SecureRandom secure = new SecureRandom();
       keyGen.initialize(1024, secure);;
       java.security.KeyPair pair = keyGen.generateKeyPair();
       this.privateKey = pair.getPrivate().toString();
       this.publicKey = pair.getPublic().toString();
       this.keypair = pair;
       CinemaService.getInstance().addKeyPairProxy(new KeyPairProxy(this));
   }
   
   //70 ===== GENERATED:      Feature Access =========
   public KeyPair getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IKeyPair)) return false;
      return ((IKeyPair)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getPrivateKey() {
      return this.privateKey;
   }
   public void setPrivateKey(String newPrivateKey) throws PersistenceException{
      this.privateKey = newPrivateKey;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("KeyPair", "privateKey", "'" + newPrivateKey + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getPublicKey() {
      return this.publicKey;
   }
   public void setPublicKey(String newPublicKey) throws PersistenceException{
      this.publicKey = newPublicKey;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("KeyPair", "publicKey", "'" + newPublicKey + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
