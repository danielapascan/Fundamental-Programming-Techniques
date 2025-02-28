package DataAccess;
import Model.Bill;

import java.sql.Connection;
import Connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

public class BillDAO extends AbstractDAO<Bill>{
    private final static String insertStatementString= "INSERT INTO bill VALUES (?,?,?,?)";
    public int insert(Bill bill) {
        Connection connection = null;
        connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        int resultSet = 0;
        try {
            statement= connection.prepareStatement(insertStatementString);
            statement.setString(1,String.valueOf(bill.getId()));
            statement.setString(2,bill.getClient());
            statement.setString(3,bill.getProdus());
            statement.setString(4,String.valueOf(bill.getPretComanda()));
            resultSet= statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,  "OrderDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return resultSet;
    }
}
