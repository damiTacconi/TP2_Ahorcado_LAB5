package ahorcado.Model;

import ahorcado.App;

import java.util.*;

public class Game {
    protected List<java.lang.Character> letters;
    protected String word;
    protected List<Character> characters;
    protected boolean gameFinished;


    public Game(String word) {
        this.word = word;
        this.characters = new ArrayList<>();
        this.inicListLetters();
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            characters.add(new Character(c));
        }
        this.gameFinished = false;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public synchronized void compareCharacter(char character , Player player){
        boolean lostLives = true;
        for (int i = 0; i < word.length() && lostLives; i++)
        {
            if(word.charAt(i) == character){
                lostLives = false;
                addCharacter(character);
                if(checkFinishedGame()){
                    gameFinished = true;
                    System.out.println(String.format("EL GANADOR ES %s !!" , player.getPlayerName()));
                }
            }
        }
        if(lostLives) {
            player.setLives( player.getLives() - 1);
            System.out.println(player.getPlayerName() + " SE EQUIVOCO !! LE QUEDAN " + player.getLives() + " VIDAS");
        }
    }

    private void addCharacter(char character){
        characters.stream()
                .filter(c -> !c.isCorrect())
                .filter(c -> c.getLetter() == character)
                .forEach(c -> c.setState(character));
    }

    private boolean checkFinishedGame(){
        boolean flag = true;
        for(int i = 0; i < word.length() && flag; i++){
            if(word.charAt(i) != characters.get(i).getState()){
                flag = false;
            }
        }
        return flag;
    }


    public synchronized void showWord(){
        characters.forEach( c -> System.out.print(c.getState() + " "));
    }

    public synchronized void selectLetter(Player player){
       if(!this.gameFinished && letters.size() > 0)
       {
           char c = this.getLetter();
           System.out.println(String.format("\n\n%s ELIGIO LA LETRA %c !!" , player.getPlayerName() , c));
           compareCharacter(c , player);
           showWord();
           try {
               Thread.sleep(App.THREAD_SLEEP);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       }else Thread.currentThread().interrupt();

    }
    private void inicListLetters(){
        this.letters = new ArrayList<>(Arrays.asList(
                'A','B','C','D','E','F','G','H','I','J',
                'K','L','N','Ñ','M','O','P','Q','R','S','T',
                'U','V','W','X','Y','Z'
        ));
    }

    public synchronized char getLetter(){
        Random r = new Random();
        return letters.remove(r.nextInt(letters.size()));
    }
}
