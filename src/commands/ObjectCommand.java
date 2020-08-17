package commands;

import observation.Observable;

/**
 * A command targeted at an object of type @param <T> and returning a value of type @param <R>
 */
public abstract class ObjectCommand<T extends Observable, R> extends Command<R>{
	protected T receiver;
	public ObjectCommand(T receiver) {this.receiver = receiver;}
	public void execute() {
		this.doExecute();
		receiver.notifyObservers(this);
	}
	protected abstract void doExecute();
	public T getReceiver() {return receiver;}
}
