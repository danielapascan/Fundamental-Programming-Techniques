package BusinessLogic;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import DataAccess.ClientDAO;
import Model.Clients;

import javax.swing.*;

public class ClientBLL {

        private ClientDAO clientDAO;

        public ClientBLL() {
            clientDAO = new ClientDAO();
        }

        public Clients findClientById(int id) {
            Clients st = clientDAO.findById(id);
            if (st == null) {
                throw new NoSuchElementException("The client with id =" + id + " was not found!");
            }
            return st;
        }

    public void deleteById(int id) {
        int st = clientDAO.deleteById(id);
        if (st == 0) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
    }
    public void insertClient(Clients c) {
       int cr=clientDAO.insert(c);
        if (cr == 0) {
            throw new NoSuchElementException("The client cannot be inserted!");
        }
    }

    public void updateClient(Clients c) {
        int cr=clientDAO.update(c);
        if (cr == 0) {
            throw new NoSuchElementException("The client cannot be updated!");
        }
    }
    public ArrayList<Clients> findallClients() {
        ArrayList<Clients> clients= new ArrayList<>();
        clients= clientDAO.findAll();
        if (clients == null) {
            throw new NoSuchElementException("The tabel was not found!");
        }
        return clients;
    }

    public JTable makeTableClients()
    {
        JTable t = new JTable();
        ArrayList<Clients> clients= new ArrayList<>();
        clients= clientDAO.findAll();
        t=clientDAO.makeTable(clients);
        return t;
    }


}
