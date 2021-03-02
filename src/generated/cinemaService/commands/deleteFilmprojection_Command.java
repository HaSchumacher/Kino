/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class deleteFilmprojection_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = 1199848484L;
   private Filmprojection fp;
   public deleteFilmprojection_Command(Filmprojection fp){
      super();
      this.fp = fp;
   }
   public void execute(){
      try{CinemaService.getInstance().deleteFilmprojection(fp);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
