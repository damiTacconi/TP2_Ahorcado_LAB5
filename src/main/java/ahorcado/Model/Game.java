package ahorcado.Model;

import java.util.*;

public class Game {
    protected List<java.lang.Character> letters;
    protected String word;
    protected String players_word;
    protected List<Character> characters;

    public Game(String word) {
        this.word = word;
        this.players_word = "";
        this.characters = new ArrayList<>();
        this.inicListLetters();
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            characters.add(new Character(c , false));
        }
    }

    public void compareCharacter(char character ){
        characters.stream()
                .filter(c -> !c.isCorrect())
                .filter(c -> c.getLetter() == character)
                .forEach(c -> c.setCorrect(true));
        copyToPlayersWord();
    }

    private void copyToPlayersWord(){
        players_word = "";
         characters.stream()
         .filter(Character::isCorrect)
         .forEach(c -> players_word += c.getLetter());

         if(players_word.equals(word))System.out.println("SON IGUALES ! " + players_word + " | " + word  );
    }

    public void showWord(){
        for(Character c : characters){
            if(c.isCorrect()) System.out.print(c.getLetter() + " ");
            else System.out.print("_" + " ");
        }
    }

    private void inicListLetters(){
        this.letters = new ArrayList<>(Arrays.asList(
                'A','B','C','D','E','F','G','H','I','J',
                'K','N','Ñ','M','O','P','Q','R','S','T',
                'U','V','W','X','Y','Z'
        ));
    }

    public char getLetter(){
        Random r = new Random();
        return letters.get(r.nextInt(letters.size()));
    }
}
