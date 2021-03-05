/**--- Generated at Fri Mar 05 15:44:03 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class KeyPair_constructor_Command extends ServiceCommand<KeyPair>{
   private static final long serialVersionUID = -1520595903L;
   private String  privateKey;
   private String  publicKey;
   public KeyPair_constructor_Command(String  privateKey, String  publicKey){
      super();
      this.privateKey = privateKey;
      this.publicKey = publicKey;
   }
   public void execute(){
      try{this.result = KeyPair.createFresh(privateKey, publicKey);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
