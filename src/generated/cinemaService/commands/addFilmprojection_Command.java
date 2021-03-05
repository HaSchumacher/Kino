/**--- Generated at Fri Mar 05 15:44:03 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class addFilmprojection_Command extends ServiceCommand<Filmprojection>{
   private static final long serialVersionUID = 838853407L;
   private Cinemahall c;
   private Movie m;
   public addFilmprojection_Command(Cinemahall c, Movie m){
      super();
      this.c = c;
      this.m = m;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().addFilmprojection(c, m);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
