package ahorcado;

import ahorcado.Model.Game;
import ahorcado.Model.Player;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final int THREAD_SLEEP = 300;
    public static void main( String[] args )
    {
        Game game = new Game("BARCA");

        Player player1 = new Player("Damian" , 10 , game);
        Player player2 = new Player("Christian" , 10, game);
        Player player3 = new Player("Rocio" , 10 , game);

        player1.start();
        player2.start();
        player3.start();

    }
}
