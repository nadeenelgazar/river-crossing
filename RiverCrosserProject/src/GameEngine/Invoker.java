package GameEngine;

public class Invoker {

	private Command command;
	
	void setCommand (Command command) {
		this.command=command;
	}
	
	public void pressButton () {
		command.excute();
	}
}
