package BusinessLogic;

import DataAccess.OrderDAO;
import Model.Order;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class OrderBLL {
    OrderDAO orderDAO= new OrderDAO();
    public ArrayList<Order> findallOrders() {
        ArrayList<Order> orders= new ArrayList<>();
        orders= orderDAO.findAll();
        if (orders == null) {
            throw new NoSuchElementException("The tabel was not found!");
        }
        return orders;
    }

    public void insertOrder(Order c) {
        int cr=orderDAO.insert(c);
        if (cr == 0) {
            throw new NoSuchElementException("The client cannot be inserted!");
        }
    }
}
