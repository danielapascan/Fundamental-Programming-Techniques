package DataAccess;

import Model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import Connection.ConnectionFactory;

public class OrderDAO extends AbstractDAO<Order> {
    private final static String selectallstatement="SELECT * FROM orders";
    private final static String insertStatementString= "INSERT INTO orders VALUES (?,?,?,?,?)";
    public ArrayList<Order> findAll() {
        Connection connection = null;
        connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Order> orders = new ArrayList<>();
        try {
            statement = connection.prepareStatement(selectallstatement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nameC = resultSet.getString("namec");
                String nameP = resultSet.getString("namep");
                int quantity = resultSet.getInt("quantity");
                int price = resultSet.getInt("price");
                Order c;
                c = new Order(nameC, nameP, quantity, price);
                orders.add(c);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return orders;
    }

    public int insert(Order order) {
        Connection connection = null;
        connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        int resultSet = 0;
        try {
            statement= connection.prepareStatement(insertStatementString);
            statement.setString(1,String.valueOf(order.getId()));
            statement.setString(2,order.getNameClient());
            statement.setString(3,order.getNameProduct());
            statement.setString(4,String.valueOf( order.getQuantity()));
            statement.setString(5,String.valueOf( order.getPrice()));
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
