package ahorcado.Database;

import ahorcado.Config.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WinnerDB {

    private static final WinnerDB INSTANCE = new WinnerDB();
    private final String TABLE = "winners";

    private WinnerDB() {}

    public static WinnerDB getInstance(){return INSTANCE;}

    public void insert(String word, String playerName){
        try {
            Connection c = MySQLConnection.getInstance().getConnection();
            c.setAutoCommit(false);
            c.setTransactionIsolation(c.TRANSACTION_REPEATABLE_READ);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String datetime = dtf.format(now);
            PreparedStatement preparedStatement = c.prepareStatement(
                    "INSERT INTO " + TABLE + " (winner_name, date_game, word) VALUES (?,?,?)");
            preparedStatement.setString(1, playerName);
            preparedStatement.setString(2, datetime);
            preparedStatement.setString(3, word);

            preparedStatement.execute();
            preparedStatement.close();
            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
