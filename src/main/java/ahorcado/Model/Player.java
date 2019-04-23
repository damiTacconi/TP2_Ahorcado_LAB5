package ahorcado.Model;

public class Player extends Thread {
    protected String playerName;
    protected int lives;
    protected Game game;
    public Player(String name, int lives , Game game) {
        this.playerName = name;
        this.lives = lives;
        this.game = game;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public void run(){
        while( !game.isGameFinished() && lives > 0) {
            game.play(this);
        }
    }

}
