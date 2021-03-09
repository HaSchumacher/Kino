/**--- Generated at Fri Mar 05 14:10:20 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
import client.Controller;


import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
//20 ===== Editable : Your Import Section =========
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.sql.ResultSet;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import java.util.Base64;
import java.util.Optional;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.DBExecuterFactory;
import db.executer.PersistenceException;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.ISecurity;
import observation.Observable;
import observation.Observer;
//25 ===== GENERATED:      Header Section =========
public class Security extends Observable implements java.io.Serializable, ISecurity
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Optional<Security> theInstance = Optional.empty();
   private Integer id;
   private Optional<String> securityMap;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Security(Integer id, Optional<String> securityMap, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.securityMap = securityMap;
      if(objectOnly) return;
   }
   private static Security createAlreadyPersistent(Integer id, Optional<String> securityMap){
      return new Security(id, securityMap, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Security getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static Security load() throws PersistenceException {
      try{
         Integer typeKey = TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Security");
         ResultSet rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectEntriesOfTable("Security", typeKey);
         rs.next();
         Optional<String> securityMap = (rs.getObject("securityMap") == null ? Optional.empty() : Optional.of(rs.getString("securityMap")));
         return Security.createAlreadyPersistent(rs.getInt("id"), securityMap);
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Security getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISecurity)) return false;
      return ((ISecurity)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Optional<String> getSecurityMap() {
      return this.securityMap;
   }
   public void setSecurityMap(String newSecurityMap) throws PersistenceException{
      this.securityMap = Optional.of(newSecurityMap);
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Security", "securityMap", "'" + newSecurityMap + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
   public static String decrypt(byte[] chiffrat, PrivateKey sk)
	{
		byte[] dec = null;
		Cipher cipher = null;
		try
		{
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, sk);
		} catch (NoSuchAlgorithmException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidKeyException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			dec = cipher.doFinal(chiffrat);
		} catch (IllegalBlockSizeException | BadPaddingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(dec);
	}
//public static String decrypt(String data, String base64PrivateKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
//       return decrypt(Base64.getDecoder().decode(data.getBytes()), base64PrivateKey);
//}

public static PrivateKey getPrivateKey(String base64PrivateKey){
       PrivateKey privateKey = null;
       PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
       KeyFactory keyFactory = null;
       try {
           keyFactory = KeyFactory.getInstance("RSA");
       } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
       }
       try {
           privateKey = keyFactory.generatePrivate(keySpec);
       } catch (InvalidKeySpecException e) {
           e.printStackTrace();
       }
       return privateKey;
   }
   
//90 ===== GENERATED: End of Your Operations ======
}
