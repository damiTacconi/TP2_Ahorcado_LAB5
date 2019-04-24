package ahorcado;

import ahorcado.Database.WordsDB;
import ahorcado.Model.Game;
import ahorcado.Model.Player;

import java.util.Objects;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final int THREAD_SLEEP = 300;
    public static void main( String[] args )
    {
        String word = WordsDB.getInstance().getRandomWord();
        if(Objects.nonNull(word)) {

            System.out.println(String.format("\t\t\t LA PALABRA ES: %s !" , word));
            Game game = new Game(word);

            Player player1 = new Player("Damian", 10, game);
            Player player2 = new Player("Christian", 10, game);
            Player player3 = new Player("Rocio", 10, game);

            player1.start();
            player2.start();
            player3.start();
        }else System.out.println("NO HAY NINGUNA PALABRA PARA JUGAR");

    }
}
