package ahorcado;

import ahorcado.Database.WinnerDB;
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
    public static final int THREAD_SLEEP = 700;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public static void main( String[] args )
    {
        String word = WordsDB.getInstance().getRandomWord();

        if(Objects.nonNull(word)) {
            final int lives = 6;
            System.out.println(String.format("\t\t\t LA PALABRA ES: %s !" , word));
            Game game = new Game(word);

            Player player1 = new Player("Damian", lives, game);
            Player player2 = new Player("Christian", lives, game);
            Player player3 = new Player("Rocio", lives, game);
            Player player4 = new Player("Franco" , lives , game);

            player1.start();
            player2.start();
            player3.start();
            player4.start();

            try {
                player1.join();
                player2.join();
                player3.join();
                player4.join();

                Player ganador = game.getGanador();
                if(Objects.isNull(ganador)){
                    System.out.println(String.format(ANSI_GREEN + "\nNO HAY GANADOR! LA PALABRA ES: %s !" + ANSI_RESET, word));
                }else{
                    System.out.println(String.format(ANSI_GREEN + "\n EL GANADOR ES %s !! " + ANSI_RESET
                            , game.getGanador().getPlayerName()));
                    WinnerDB.getInstance().insert(word, ganador.getPlayerName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }else System.out.println("NO HAY NINGUNA PALABRA PARA JUGAR");

    }
}
