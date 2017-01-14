package refresher.practice.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import refresher.practice.helpers.AppProperties;
import refresher.practice.helpers.LogIt;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Created by clif on 1/13/17.
 * <p>
 * Demonstrates simple CRUD exercises on a mysql database.
 */
public class Crud {

    private static LogIt logger = new LogIt(Crud.class.getName());

    /**
     * Returns results of read query.
     *
     * @param conn      Connection reference.
     * @param tableName Table name.
     * @return Query results.
     */
    private static ResultSet readTable(Connection conn, String tableName) {
        try {
            Statement action = (Statement) conn.createStatement();
            return action.executeQuery("Select * from Employee");
        } catch (SQLException e) {
            logger.getLogger().log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    /**
     * Returns a connection handle to the DB.
     *
     * @return Database Connection
     * @throws SQLException Thrown if connection attempt fails.
     */
    private static Connection getConnection() throws SQLException, IOException {

        AppProperties p = new AppProperties();

        String URL = "jdbc:mysql://localhost/bedrock";
        String USER = p.getPropValues().getProperty("user");
        String PASS = p.getPropValues().getProperty("password");
        Connection conn = (Connection) DriverManager.getConnection(URL, USER, PASS);
        logger.getLogger().info("Connected to database");
        return conn;
    }

    /**
     * Returns true if the database daemon is active.
     *
     * @return False if database is not active.
     */
    private static boolean isActive() {
        boolean active = false;
        try {
            if (Class.forName("com.mysql.jdbc.Driver").newInstance() != null)
                active = true;

        } catch (Exception E) {
            logger.getLogger().log(Level.SEVERE, "JDBC Driver error");
        }
        return active;
    }

    public static void main(String[] args) {

        try (Connection conn = getConnection()) {

            logger.getLogger().info("Database Active: " + isActive());

            if (isActive()) {
                ResultSet rs = readTable(conn, "Employee");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int age = rs.getInt("age");
                    String first = rs.getString("first");
                    String last = rs.getString("last");

                    logger.getLogger().info(String.format("%4d %4d %10s %10s", id, age, first, last));
                }

                conn.close();
            } else {
                logger.getLogger().log(Level.WARNING, "Database is Active: " + isActive());
            }

        } catch (SQLException sqle) {
            logger.getLogger().log(Level.SEVERE, sqle.getMessage());
        } catch (IOException e) {
            logger.getLogger().log(Level.SEVERE, e.getMessage());
        }
    }
}
