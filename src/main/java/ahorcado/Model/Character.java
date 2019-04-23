package ahorcado.Model;

public class Character {

    protected char letter;
    protected char state = '_';

    public Character(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public boolean isCorrect() {
        return this.state != '_';
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }
}
