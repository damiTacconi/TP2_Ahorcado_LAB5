package ahorcado.Database;

import ahorcado.Config.MySQLConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WordsDB {

    private static final WordsDB INSTANCE = new WordsDB();
    private final String TABLE = "words";

    private WordsDB() {}

    public static WordsDB getInstance(){return INSTANCE;}

    public String getRandomWord(){
        String word = null;
        try {
            PreparedStatement preparedStatement = MySQLConnection.getInstance().getConnection().prepareStatement(
                    "SELECT * FROM " + TABLE + " ORDER BY RAND() LIMIT 1"
            );

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                word = resultSet.getString("word_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return word;
    }
}
