package ahorcado.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final MySQLConnection INSTANCE = new MySQLConnection();

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String USER = "root";
    private final String PASSWORD = "";
    private final String DB_URL = "jdbc:mysql://localhost:3306/ahorcado";
    private final String OPTIONS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    private Connection connection;

    private MySQLConnection(){

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(DB_URL+OPTIONS,USER, PASSWORD );
            //System.out.println(connection);

        } catch (SQLException e) {
            System.out.println("HUBO UN PROBLEMA EN LA BASE DE DATOS: " + e.getMessage());
        }
    }

    public Connection getConnection(){return connection;}

    public static MySQLConnection getInstance () { return INSTANCE; }



}
