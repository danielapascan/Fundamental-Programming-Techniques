package BusinessLogic;

import DataAccess.BillDAO;
import Model.Bill;
import java.util.NoSuchElementException;

public class BillBLL {
    BillDAO billDAO= new BillDAO();
    public void insertBill(Bill c) {
        int cr=billDAO.insert(c);
        if (cr == 0) {
            throw new NoSuchElementException("The bill cannot be inserted!");
        }
    }
}
