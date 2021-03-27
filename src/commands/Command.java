package commands;
import java.io.Serializable;
/**
 * An arbitrary command to call an operation, which returns a value of type R or an exception
 * @param <R>
 */
public abstract class Command<R> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6974630575859675043L;
	protected R result;
	protected Exception e;
	public abstract void execute();
	public R getResult() throws Exception{
		if(this.e!=null) throw e;
		return this.result;
	}
}
