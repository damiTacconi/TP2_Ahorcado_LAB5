package ahorcado.Model;

public class Player extends Thread {
    protected String playerName;
    protected int lives;

    public Player(String name, int lives) {
        this.playerName = name;
        this.lives = lives;
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
}
