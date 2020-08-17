package commands;
/**
 * An arbitrary command to call an operation, which returns a value or an exception
 * @param <R>
 */
public abstract class Command<R> {
	protected R result;
	protected Exception e;
	public abstract void execute();
	public R getResult() throws Exception{
		if(this.e!=null) throw e;
		return this.result;
	}
}
