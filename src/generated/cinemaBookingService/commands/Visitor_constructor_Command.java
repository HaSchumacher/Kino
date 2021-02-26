/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class Visitor_constructor_Command extends ServiceCommand<Visitor>{
   private static final long serialVersionUID = 1470375016L;
   private String  name;
   public Visitor_constructor_Command(String  name){
      super();
      this.name = name;
   }
   public void execute(){
      try{this.result = Visitor.createFresh(name);
      }catch(Exception e){this.e = e;
      }finally{CinemaBookingService.getInstance().notifyObservers(this);}
   }
}
