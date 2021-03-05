/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class deleteFilmprojection_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = 1675638113L;
   private Filmprojection fp;
   public deleteFilmprojection_Command(Filmprojection fp){
      super();
      this.fp = fp;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().deleteFilmprojection(fp);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
