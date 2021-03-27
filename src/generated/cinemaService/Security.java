/**--- Generated at Fri Mar 05 14:10:20 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
//20 ===== Editable : Your Import Section =========
import java.security.PrivateKey;
import java.sql.ResultSet;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import java.util.Optional;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.DBExecuterFactory;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.ISecurity;
import observation.Observable;

//25 ===== GENERATED:      Header Section =========
public class Security extends Observable implements java.io.Serializable, ISecurity {
	private static final long serialVersionUID = -6498514825865484551L;
	// 30 ===== GENERATED: Attribute Section ======
	private static Optional<Security> theInstance = Optional.empty();
	private Integer id;
	// 40 ===== Editable : Your Attribute Section ======

	// 50 ===== GENERATED: Constructor ============
	private Security(Integer id, boolean objectOnly) {
		super();
		this.setId(id);
	}

	private static Security createAlreadyPersistent(Integer id) {
		return new Security(id, true);
	}
	// 60 ===== Editable : Your Constructors ===========

	// 70 ===== GENERATED: Feature Access =========
	public static Security getInstance() throws PersistenceException {
		if (!theInstance.isPresent())
			theInstance = Optional.of(load());
		return theInstance.get();
	}

	private static Security load() throws PersistenceException {
		try {
			Integer typeKey = TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Security");
			ResultSet rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectEntriesOfTable("Security",
					typeKey);
			rs.next();
			return Security.createAlreadyPersistent(rs.getInt("id"));
		} catch (SQLException | NoConnectionException e) {
			throw new PersistenceException(e.getMessage());
		}
	}

	public Security getTheObject() {
		return this;
	}

	public Integer getId() {
		return this.id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	public boolean equals(Object o) {
		if (!(o instanceof ISecurity))
			return false;
		return ((ISecurity) o).getId().equals(this.getId());
	}

	public int hashCode() {
		return this.getId().hashCode();
	}

	// 80 ===== Editable : Your Operations =============
	public static String decrypt(byte[] chiffrat, PrivateKey sk) {
		byte[] dec = null;
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, sk);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			e.printStackTrace();
		}

		try {
			dec = cipher.doFinal(chiffrat);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return new String(dec);
	}

//90 ===== GENERATED: End of Your Operations ======
}
