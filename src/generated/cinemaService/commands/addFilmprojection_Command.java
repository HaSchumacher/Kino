/**--- Generated at Tue Mar 02 12:07:22 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class addFilmprojection_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -861091640L;
   private Cinemahall c;
   private Movie m;
   public addFilmprojection_Command(Cinemahall c, Movie m){
      super();
      this.c = c;
      this.m = m;
   }
   public void execute(){
      try{CinemaService.getInstance().addFilmprojection(c, m);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
