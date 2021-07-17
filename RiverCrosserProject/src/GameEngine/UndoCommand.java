package GameEngine;

public class UndoCommand implements Command {
	
	private Game game;
	
	public UndoCommand (Game game) {
		this.game=game;
	}

	@Override
	public void excute() {
		game.undo();
	}
	
	

}
