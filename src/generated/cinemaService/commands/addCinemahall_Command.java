/**--- Generated at Sun Feb 28 15:10:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class addCinemahall_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -1683912495L;
   private String name;
   private Integer rows;
   private Integer Seats;
   public addCinemahall_Command(String name, Integer rows, Integer Seats){
      super();
      this.name = name;
      this.rows = rows;
      this.Seats = Seats;
   }
   public void execute(){
      try{CinemaService.getInstance().addCinemahall(name, rows, Seats);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
