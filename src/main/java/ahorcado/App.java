package ahorcado;

import ahorcado.Model.Game;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Game game = new Game("BARCA");

        game.compareCharacter('A');
        game.compareCharacter('B');

        game.compareCharacter('R');
        game.showWord();

    }
}
