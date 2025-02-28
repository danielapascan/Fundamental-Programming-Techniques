package Presentation;

import BusinessLogic.BillBLL;
import BusinessLogic.ClientBLL;
import BusinessLogic.OrderBLL;
import BusinessLogic.ProductBLL;
import Model.Bill;
import Model.Clients;
import Model.Order;
import Model.Products;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller  implements ActionListener {
    private View view;
    JFrame frame= new JFrame();
    public Controller(View v)
    {
        this.view=v;
    }
    public void adaugaClient()
    {
        String id= String.valueOf(view.getID().getText());
        String name= String.valueOf(view.getNume().getText());
        String email= String.valueOf(view.getemail().getText());
        String adresa= String.valueOf(view.getadresa().getText());
        int id2=Integer.parseInt(id);
        Clients c= new Clients(id2, name, email, adresa);
        ClientBLL clientBLL= new ClientBLL();
        try{
        clientBLL.insertClient(c);
        JOptionPane.showMessageDialog(frame, "Clientul a fost inserat!");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(frame, "Clientul nu poate fi inserat!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editeazaClient()
    {
        String id= String.valueOf(view.clientdeeditat().getText());
        int id2=Integer.parseInt(id);
        ClientBLL clientBLL= new ClientBLL();
        try {
            clientBLL.findClientById(id2);
            view.editareClient();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(frame, "Clientul nu exista!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteClient()
    {
        String id= String.valueOf(view.clientsters().getText());
        int id2=Integer.parseInt(id);
        ClientBLL clientBLL= new ClientBLL();
        try {
            clientBLL.deleteById(id2);
            JOptionPane.showMessageDialog(frame, "Clientul a fost sters!");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(frame, "Clientul nu poate fi sters!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void editeazaClient2()
    {
        String id= String.valueOf(view.clienteditid().getText());
        String name= String.valueOf(view.clienteditnume().getText());
        String email= String.valueOf(view.clienteditemail().getText());
        String adresa= String.valueOf(view.clienteditadr().getText());
        int id2=Integer.parseInt(id);
        Clients c= new Clients(id2, name, email, adresa);
        ClientBLL clientBLL= new ClientBLL();
        try {
            clientBLL.updateClient(c);
            JOptionPane.showMessageDialog(frame, "Clientul a fost editat!");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(frame, "Clientul nu poate fi editat!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showClients()
    {
       ClientBLL clientBLL= new ClientBLL();
       JTable t=new JTable();
       t=clientBLL.makeTableClients();
       view.tabelClienti(t);
    }

    public void showProducts()
    {
        ProductBLL productBLL= new ProductBLL();
        JTable t=new JTable();
        t=productBLL.makeTableProducts();
        view.tabelProducts(t);
    }

    public void insertProdus()
    {
        String id= String.valueOf(view.idprod().getText());
        String name= String.valueOf(view.nameprod().getText());
        String quantity= String.valueOf(view.quanprod().getText());
        String price= String.valueOf(view.priceprod().getText());
        int id2=Integer.parseInt(id);
        int quantity2=Integer.parseInt(quantity);
        int price2=Integer.parseInt(price);
        Products c= new Products(id2, name, quantity2, price2);
        ProductBLL productBLL= new ProductBLL();
        try{
            productBLL.insertProduct(c);
            JOptionPane.showMessageDialog(frame, "Produsul a fost adaugat!");
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(frame, "Produsul nu a putut fi adaugat!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editeazaProdus()
    {
        String id= String.valueOf(view.idedit().getText());

        int id2=Integer.parseInt(id);
        ProductBLL productBLL= new ProductBLL();
        try {
            productBLL.findProductById(id2);
            view.editareProdus();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(frame, "Produsul nu exista!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editeazaProdus2()
    {
        String id= String.valueOf(view.idprod2().getText());
        String name= String.valueOf(view.nameprod2().getText());
        String quantity= String.valueOf(view.quanprod2().getText());
        String price= String.valueOf(view.priceprod2().getText());
        int id2=Integer.parseInt(id);
        int quantity2=Integer.parseInt(quantity);
        int price2=Integer.parseInt(price);
        Products c= new Products(id2, name, quantity2, price2);
        ProductBLL productBLL= new ProductBLL();
        try {
            productBLL.updateProduct(c);
            JOptionPane.showMessageDialog(frame, "Produsul a fost editat!");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(frame, "Produsul nu poate fi editat!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteProdus()
    {
        String id= String.valueOf(view.idsters().getText());

        int id2=Integer.parseInt(id);
        ProductBLL productBLL= new ProductBLL();
        try {
            productBLL.deleteById(id2);
            JOptionPane.showMessageDialog(frame, "Produsul a fost sters!");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(frame, "Produsul nu poate fi sters!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void placeOrder()
    {
        String client= view.client().getSelectedItem().toString();
        String produs= view.produs().getSelectedItem().toString();
        String cantitate=String.valueOf( view.cantitateComanda().getText());
        int cantitate2=Integer.parseInt(cantitate);
        ArrayList<Products> produse= new ArrayList<>();
        ProductBLL productBLL= new ProductBLL();
        produse=productBLL.findallProducts();
        int pretProdus=0;
        for(Products p: produse)
        {
            if(p.getName().equals(produs))
            {
                pretProdus=p.getPrice();
                if(cantitate2>p.getQuantity())
                {
                    JOptionPane.showMessageDialog(frame, "Cantitatea de produs selectata nu se afla in stoc!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    Products c= new Products(p.getId(), p.getName(), p.getQuantity()-cantitate2, p.getPrice());
                    productBLL.updateProduct(c);
                    int pretComanda=pretProdus*cantitate2;
                   // record Order(String client,String produs,int cantitate2,int pretComanda){};
                    Order o= new Order(client, produs, cantitate2, pretComanda);
                    OrderBLL orderBLL= new OrderBLL();
                    orderBLL.insertOrder(o);
                    int id=0;
                    Bill b= new Bill(client, produs, pretComanda, id);
                    BillBLL billBLL= new BillBLL();
                    billBLL.insertBill(b);
                    JOptionPane.showMessageDialog(frame, "Comanda a fost plasata!");
                }
            }
        }
    }

@Override
public void actionPerformed(ActionEvent e) {

            String command= e.getActionCommand();
            if(command=="CLIENTS") {
                try {
                    view.viewClients();
                } catch (Exception ex) {

                }
            }
            if(command=="ADD")
            {
                try {
                    view.deleteCasute();
                    view.putText();
                }
                catch (Exception ex)
                {
                }
            }
        if(command=="ADDCLIENT")
        {
            try {
                 adaugaClient();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="BACK")
        {
            try {
                view.viewmeniu();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="EDIT")
        {
            try {
                view.deleteCasute();
                view.putText2();

            }
            catch (Exception ex)
            {
            }
        }
        if(command=="EDITCLIENT")
        {
            try {
                editeazaClient();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="EDITCLIENT2")
        {
            try {
                editeazaClient2();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="DELETE")
        {
            try {
                view.deleteCasute();
                view.putText3();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="DELETECLIENT")
        {
            try {
                deleteClient();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="SHOWALL")
        {
            try {
                showClients();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="SHOWALL2")
        {
            try {
                showProducts();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="PRODUCTS") {
            try {
                view.viewProducts();
            } catch (Exception ex) {

            }
        }
        if(command=="ADD2")
        {
            try {
                view.deleteCasute();
                view.putText4();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="ADDPRODUS")
        {
            try {
                insertProdus();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="EDIT2")
        {
            try {
                view.deleteCasute();
                view.putText5();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="EDITPRODUS")
        {
            try {
                editeazaProdus();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="EDITPRODUS2")
        {
            try {
                editeazaProdus2();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="DELETE2")
        {
            try {
                view.deleteCasute();
                view.putText6();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="DELETEPRODUS")
        {
            try {
                deleteProdus();
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="ORDERS")
        {
            try {
                ArrayList<Clients> clients= new ArrayList<>();
                ClientBLL clientBLL= new ClientBLL();
                clients = clientBLL.findallClients();
                ArrayList<Products> products= new ArrayList<>();
                ProductBLL productBLL= new ProductBLL();
                products = productBLL.findallProducts();
                view.placeOrder(products, clients);
            }
            catch (Exception ex)
            {
            }
        }
        if(command=="PLACE")
        {
            placeOrder();
        }

        }

}
