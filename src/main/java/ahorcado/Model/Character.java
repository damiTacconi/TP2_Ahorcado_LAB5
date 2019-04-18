package ahorcado.Model;

public class Character {

    protected char letter;
    protected boolean correct;

    public Character(char letter, boolean correct) {
        this.letter = letter;
        this.correct = correct;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
