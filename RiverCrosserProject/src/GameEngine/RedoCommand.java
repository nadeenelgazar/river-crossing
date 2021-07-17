package GameEngine;

public class RedoCommand implements Command {

private Game game;
	
	public RedoCommand (Game game) {
		this.game=game;
	}

	@Override
	public void excute() {
		game.redo();
	}
}
