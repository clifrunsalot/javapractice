package refresher.practice.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import refresher.practice.helpers.LogIt;

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
    private static Connection getConnection() throws SQLException {

        String URL = "jdbc:mysql://localhost/bedrock";
        String USER = "***";
        String PASS = "***";
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
            ResultSet rs = readTable(conn, "Employee");

            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                logger.getLogger().info(String.format("%4d %4d %10s %10s", id, age, first, last));
            }

            conn.close();

        } catch (SQLException sqle) {
            logger.getLogger().log(Level.SEVERE, sqle.getMessage());
        }
    }
}
