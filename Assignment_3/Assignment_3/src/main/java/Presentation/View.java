package Presentation;

import Model.Clients;
import Model.Products;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JFrame{

    Color c1= new Color(32,106,93);
    Color c2= new Color(129,178,20);
    Color c3= new Color(255,204,41);
    Color c4= new Color(245,134,52);
    JFrame frame1= new JFrame();
    JFrame frame2 =new JFrame();
    JFrame frame3 =new JFrame();
    JFrame frame4= new JFrame();
    JFrame tabelClienti= new JFrame();
    JFrame tabelProducts= new JFrame();
    JPanel principalPanel;
    JPanel principalPanel2;
    JPanel principalPanel3;
    JComboBox c= new JComboBox();
    JComboBox pro= new JComboBox();
    JLabel titlu;
    JLabel titlu2;
    JButton clients;
    JButton back;
    JPanel p=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    JPanel p5=new JPanel();
    JPanel p6=new JPanel();
    JPanel p7=new JPanel();
    JPanel p8=new JPanel();
    JButton orders;
    JButton showall;
    JButton add;
    JButton delete;
    JButton edit;
    JButton products;
    JButton place;
    JTextField t= new JTextField();
    JTextField t1= new JTextField();

    JTextField t2= new JTextField();
    JTextField t5= new JTextField();
    JTextField t6= new JTextField();

    JTextField t7= new JTextField();
    JTextField t8= new JTextField();
    JTextField t9= new JTextField();
    JTextField t10= new JTextField();
    JTextField t11= new JTextField();
    JTextField t12= new JTextField();
    JTextField t3= new JTextField();

    JTextField t4= new JTextField();
    JTextField t13= new JTextField();
    JTextField t14= new JTextField();
    JTextField t15= new JTextField();
    JTextField t16= new JTextField();

    JTextField t17= new JTextField();
    JTextField t18= new JTextField();
    JTextField t19= new JTextField();
    JTextField t20= new JTextField();
    Controller con= new Controller(this);
    JFrame frame= new JFrame();

    public View(String name) {
        super(name);
        viewmeniu();
    }

    public void viewmeniu(){
        frame2.setVisible(false);
        frame3.setVisible(false);
        frame4.setVisible(false);
        this.deschideinter();

    }
    public void deschideinter()
    {
        frame1.setSize(400, 400);
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        principalPanel=new JPanel(new GridLayout(4,1));
        principalPanel.setBackground(c3);
        frame1.add(principalPanel);
        preparePanel();
        frame1.setContentPane(this.principalPanel);
        frame1.setVisible(true);
    }

    public void viewClients()
    {
        frame1.setVisible(false);
        frame2.setVisible(false);
        frame4.setVisible(false);
        deschideinter2();
    }

    public void viewProducts()
    {
        frame1.setVisible(false);
        frame2.setVisible(false);
        frame4.setVisible(false);
        deschideinter3();
    }

    /*pentru interfata la pagina de client*/
    public void deschideinter2()
    {
        frame2.setSize(700, 500);
        frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        principalPanel2=new JPanel(new GridLayout(5,1));
        principalPanel2.setBackground(c3);
        frame2.add(principalPanel2);
        preparePanel2();
        frame2.setContentPane(this.principalPanel2);
        frame2.setVisible(true);
    }

    public void deschideinter3()
    {
        frame3.setSize(700, 500);
        frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
        principalPanel3=new JPanel(new GridLayout(5,1));
        principalPanel3.setBackground(c3);
        frame3.add(principalPanel3);
        preparePanel3();
        frame3.setContentPane(this.principalPanel3);
        frame3.setVisible(true);
    }
    public void preparePanel()
    {
        principalPanel.setLayout(null);
        prepareTitle();
        prepareClients();
        prepareOrders();
        prepareProducts();

    }

    public void preparePanel2()
    {
        principalPanel2.setLayout(null);
        prepareTitle2();
        prepareButtons();
    }

    public void preparePanel3()
    {
        principalPanel3.setLayout(null);
        prepareTitle3();
        prepareButtons3();
    }

    public void prepareTitle()
    {
        titlu= new JLabel("Orders Management");
        titlu.setFont(new Font("Arial", Font.BOLD, 20));
        titlu.setBounds(100, 5,200,100);
        principalPanel.add(titlu);
    }
    public void prepareTitle2()
    {
        titlu2= new JLabel("Clients");
        titlu2.setFont(new Font("Arial", Font.BOLD, 40));
        titlu2.setBounds(250, 5,200,100);
        principalPanel2.add(titlu2);
    }

    public void prepareTitle3()
    {
        titlu2= new JLabel("Products");
        titlu2.setFont(new Font("Arial", Font.BOLD, 40));
        titlu2.setBounds(250, 5,200,100);
        principalPanel3.add(titlu2);
    }
    public void prepareButtons()
    {
        add=new JButton("ADD");
        add.setFont(new Font("Arial", Font.BOLD, 20));
        add.setBounds(50, 90,150,50);
        add.setActionCommand("ADD");
        add.setBackground(c2);
        add.addActionListener(this.con);

        edit=new JButton("EDIT");
        edit.setFont(new Font("Arial", Font.BOLD, 20));
        edit.setBounds(50, 160,150,50);
        edit.setActionCommand("EDIT");
        edit.setBackground(c2);
        edit.addActionListener(this.con);

        delete=new JButton("DELETE");
        delete.setFont(new Font("Arial", Font.BOLD, 20));
        delete.setBounds(50, 230,150,50);
        delete.setActionCommand("DELETE");
        delete.addActionListener(this.con);
        delete.setBackground(c2);

        showall=new JButton("SHOW ALL");
        showall.setFont(new Font("Arial", Font.BOLD, 20));
        showall.setBounds(50, 300,150,50);
        showall.setActionCommand("SHOWALL");
        showall.addActionListener(this.con);
        showall.setBackground(c2);

        back=new JButton("BACK");
        back.setFont(new Font("Arial", Font.BOLD, 20));
        back.setBounds(560, 420,100,30);
        back.setActionCommand("BACK");
        back.addActionListener(this.con);
        back.setBackground(c2);

        principalPanel2.add(add);
        principalPanel2.add(delete);
        principalPanel2.add(edit);
        principalPanel2.add(back);
        principalPanel2.add(showall);
    }

    public void prepareButtons3()
    {
        add=new JButton("ADD");
        add.setFont(new Font("Arial", Font.BOLD, 20));
        add.setBounds(50, 90,150,50);
        add.setActionCommand("ADD2");
        add.addActionListener(this.con);
        add.setBackground(c2);

        edit=new JButton("EDIT");
        edit.setFont(new Font("Arial", Font.BOLD, 20));
        edit.setBounds(50, 160,150,50);
        edit.setActionCommand("EDIT2");
        edit.addActionListener(this.con);
        edit.setBackground(c2);

        delete=new JButton("DELETE");
        delete.setFont(new Font("Arial", Font.BOLD, 20));
        delete.setBounds(50, 230,150,50);
        delete.setActionCommand("DELETE2");
        delete.addActionListener(this.con);
        delete.setBackground(c2);

        showall=new JButton("SHOW ALL");
        showall.setFont(new Font("Arial", Font.BOLD, 20));
        showall.setBounds(50, 300,150,50);
        showall.setActionCommand("SHOWALL2");
        showall.addActionListener(this.con);
        showall.setBackground(c2);

        back=new JButton("BACK");
        back.setFont(new Font("Arial", Font.BOLD, 20));
        back.setBounds(560, 420,100,30);
        back.setActionCommand("BACK");
        back.addActionListener(this.con);
        back.setBackground(c2);

        principalPanel3.add(add);
        principalPanel3.add(delete);
        principalPanel3.add(edit);
        principalPanel3.add(back);
        principalPanel3.add(showall);
    }
    public void editareClient()
    {
        p2.setVisible(false);
        p3.setVisible(false);
        p.setVisible(false);
        p7.setVisible(true);
        p7.setBackground(c3);
        p7.setLayout(null);
        JLabel l19= new JLabel("Enter the data for the new client:");
        l19.setFont(new Font("Arial", Font.BOLD, 20));
        l19.setBounds(250, 50,500,100);

        JLabel l20= new JLabel("ID Client:");
        l20.setFont(new Font("Arial", Font.BOLD, 20));
        l20.setBounds(250, 100,200,100);

        t13.setBounds(400, 130,280,40);

        JLabel l21= new JLabel("Name Client:");
        l21.setFont(new Font("Arial", Font.BOLD, 20));
        l21.setBounds(250, 160,200,100);

        t14.setBounds(400, 190,280,40);

        JLabel l22= new JLabel("Email Client:");
        l22.setFont(new Font("Arial", Font.BOLD, 20));
        l22.setBounds(250, 220,200,100);

        t15.setBounds(400, 250,280,40);

        JLabel l23= new JLabel("Address Client:");
        l23.setFont(new Font("Arial", Font.BOLD, 20));
        l23.setBounds(250, 280,200,100);

        t16.setBounds(400, 310,280,40);

        add=new JButton("EDIT");
        add.setFont(new Font("Arial", Font.BOLD, 20));
        add.setBounds(400, 380,100,30);
        add.setActionCommand("EDITCLIENT2");
        add.addActionListener(this.con);
        add.setBackground(c2);

        p7.add(l19);
        p7.add(l20);
        p7.add(t13);
        p7.add(l21);
        p7.add(t14);
        p7.add(l22);
        p7.add(t15);
        p7.add(l23);
        p7.add(t16);
        p7.add(add);
        p7.setBounds(0,0,700,650);
        principalPanel2.add(p7);
        principalPanel2.revalidate();
        principalPanel2.repaint();
    }
    public void editareProdus()
    {
        p5.setVisible(false);
        p6.setVisible(false);
        p8.setVisible(true);
        p8.setBackground(c3);
        p8.setLayout(null);
        JLabel l10= new JLabel("Enter the data for the product to be edited:");
        l10.setFont(new Font("Arial", Font.BOLD, 20));
        l10.setBounds(250, 50,500,100);

        JLabel l11= new JLabel("ID Product:");
        l11.setFont(new Font("Arial", Font.BOLD, 20));
        l11.setBounds(250, 100,200,100);

        t17.setBounds(420, 130,260,40);

        JLabel l12= new JLabel("Name Product:");
        l12.setFont(new Font("Arial", Font.BOLD, 20));
        l12.setBounds(250, 160,200,100);

        t18.setBounds(420, 190,260,40);

        JLabel l13= new JLabel("Quantity Product:");
        l13.setFont(new Font("Arial", Font.BOLD, 20));
        l13.setBounds(250, 220,200,100);

        t19.setBounds(420, 250,260,40);

        JLabel l14= new JLabel("Price Product:");
        l14.setFont(new Font("Arial", Font.BOLD, 20));
        l14.setBounds(250, 280,200,100);

        t20.setBounds(420, 310,260,40);

        add=new JButton("EDIT");
        add.setFont(new Font("Arial", Font.BOLD, 20));
        add.setBounds(400, 380,100,30);
        add.setActionCommand("EDITPRODUS2");
        add.addActionListener(this.con);
        add.setBackground(c2);

        p8.add(l10);
        p8.add(l11);
        p8.add(t17);
        p8.add(l12);
        p8.add(t18);
        p8.add(l13);
        p8.add(t19);
        p8.add(l14);
        p8.add(t20);
        p8.add(add);
        p8.setBounds(0,0,700,650);
        principalPanel3.add(p8);
        principalPanel3.revalidate();
        principalPanel3.repaint();
    }
    public void putText()
    {
        p2.setVisible(false);
        p3.setVisible(false);
        p7.setVisible(false);
        p.setVisible(true);
        p.setBackground(c3);
        p.setLayout(null);
        JLabel l= new JLabel("Enter the data for the new client:");
        l.setFont(new Font("Arial", Font.BOLD, 20));
        l.setBounds(250, 50,500,100);

        JLabel l2= new JLabel("ID Client:");
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setBounds(250, 100,200,100);

        t1.setBounds(400, 130,280,40);

        JLabel l3= new JLabel("Name Client:");
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setBounds(250, 160,200,100);

        t2.setBounds(400, 190,280,40);

        JLabel l4= new JLabel("Email Client:");
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setBounds(250, 220,200,100);

        t3.setBounds(400, 250,280,40);

        JLabel l5= new JLabel("Address Client:");
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setBounds(250, 280,200,100);

        t4.setBounds(400, 310,280,40);

        add=new JButton("ADD");
        add.setFont(new Font("Arial", Font.BOLD, 20));
        add.setBounds(400, 380,100,30);
        add.setActionCommand("ADDCLIENT");
        add.addActionListener(this.con);
        add.setBackground(c2);

        p.add(l);
        p.add(l2);
        p.add(t1);
        p.add(l3);
        p.add(t2);
        p.add(l4);
        p.add(t3);
        p.add(l5);
        p.add(t4);
        p.add(add);
        p.setBounds(0,0,700,650);
        principalPanel2.add(p);
        principalPanel2.revalidate();
        principalPanel2.repaint();
    }

    public void putText2()
    {
        p.setVisible(false);
        p3.setVisible(false);
        p7.setVisible(false);
        p2.setVisible(true);
        p2.setBackground(c3);
        p2.setLayout(null);
        JLabel l6= new JLabel("Enter the id of the client to be edited:");
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setBounds(250, 50,500,100);

        JLabel l7= new JLabel("ID Client:");
        l7.setFont(new Font("Arial", Font.BOLD, 20));
        l7.setBounds(250, 100,200,100);

        t5.setBounds(400, 130,280,40);

        add=new JButton("EDIT");
        add.setFont(new Font("Arial", Font.BOLD, 20));
        add.setBounds(400, 380,100,30);
        add.setActionCommand("EDITCLIENT");
        add.addActionListener(this.con);
        add.setBackground(c2);

        p2.add(l6);
        p2.add(t5);
        p2.add(l7);
        p2.add(add);

        principalPanel2.add(p2);
        p2.setBounds(0,0,700,650);
        principalPanel2.revalidate();
        principalPanel2.repaint();
    }
/*pentru delete*/
    public void putText3()
    {
        p2.setVisible(false);
        p.setVisible(false);
        p7.setVisible(false);
        p3.setVisible(true);
        p3.setBackground(c3);
        p3.setLayout(null);
        JLabel l8= new JLabel("Enter the customer ID to delete:");
        l8.setFont(new Font("Arial", Font.BOLD, 20));
        l8.setBounds(250, 50,500,100);

        JLabel l9= new JLabel("ID Client:");
        l9.setFont(new Font("Arial", Font.BOLD, 20));
        l9.setBounds(250, 100,200,100);

        t6.setBounds(400, 130,280,40);

        add=new JButton("DELETE");
        add.setFont(new Font("Arial", Font.BOLD, 20));
        add.setBounds(400, 380,120,30);
        add.setActionCommand("DELETECLIENT");
        add.addActionListener(this.con);
        add.setBackground(c2);

        p3.add(l8);
        p3.add(l9);
        p3.add(t6);
        p3.add(add);

        p3.setBounds(0,0,700,650);
        principalPanel2.add(p3);
        principalPanel2.revalidate();
        principalPanel2.repaint();
    }

    public void putText4()
    {
        p5.setVisible(false);
        p6.setVisible(false);
        p8.setVisible(false);
        p4.setVisible(true);
        p4.setBackground(c3);
        p4.setLayout(null);
        JLabel l10= new JLabel("Enter the data for the new product:");
        l10.setFont(new Font("Arial", Font.BOLD, 20));
        l10.setBounds(250, 50,500,100);

        JLabel l11= new JLabel("ID Product:");
        l11.setFont(new Font("Arial", Font.BOLD, 20));
        l11.setBounds(250, 100,200,100);

        t7.setBounds(420, 130,260,40);

        JLabel l12= new JLabel("Name Product:");
        l12.setFont(new Font("Arial", Font.BOLD, 20));
        l12.setBounds(250, 160,200,100);

        t8.setBounds(420, 190,260,40);

        JLabel l13= new JLabel("Quantity Product:");
        l13.setFont(new Font("Arial", Font.BOLD, 20));
        l13.setBounds(250, 220,200,100);

        t9.setBounds(420, 250,260,40);

        JLabel l14= new JLabel("Price Product:");
        l14.setFont(new Font("Arial", Font.BOLD, 20));
        l14.setBounds(250, 280,200,100);

        t10.setBounds(420, 310,260,40);

        add=new JButton("ADD");
        add.setFont(new Font("Arial", Font.BOLD, 20));
        add.setBounds(400, 380,100,30);
        add.setActionCommand("ADDPRODUS");
        add.addActionListener(this.con);
        add.setBackground(c2);

        p4.add(l10);
        p4.add(l11);
        p4.add(t7);
        p4.add(l12);
        p4.add(t8);
        p4.add(l13);
        p4.add(t9);
        p4.add(l14);
        p4.add(t10);
        p4.add(add);
        p4.setBounds(0,0,700,650);
        principalPanel3.add(p4);
        principalPanel3.revalidate();
        principalPanel3.repaint();
    }

    public void putText5()
    {
        p4.setVisible(false);
        p6.setVisible(false);
        p8.setVisible(false);
        p5.setVisible(true);
        p5.setBackground(c3);
        p5.setLayout(null);
        JLabel l15= new JLabel("Enter the id of the product to edit:");
        l15.setFont(new Font("Arial", Font.BOLD, 20));
        l15.setBounds(250, 50,500,100);

        JLabel l16= new JLabel("ID Product:");
        l16.setFont(new Font("Arial", Font.BOLD, 20));
        l16.setBounds(250, 100,200,100);

        t11.setBounds(400, 130,280,40);

        add=new JButton("EDIT");
        add.setFont(new Font("Arial", Font.BOLD, 20));
        add.setBounds(400, 380,100,30);
        add.setActionCommand("EDITPRODUS");
        add.addActionListener(this.con);
        add.setBackground(c2);

        p5.add(l15);
        p5.add(t11);
        p5.add(l16);
        p5.add(add);

        principalPanel3.add(p5);
        p5.setBounds(0,0,700,650);
        principalPanel3.revalidate();
        principalPanel3.repaint();
    }
    public void putText6()
    {
        p4.setVisible(false);
        p5.setVisible(false);
        p8.setVisible(false);
        p6.setVisible(true);
        p6.setBackground(c3);
        p6.setLayout(null);
        JLabel l17= new JLabel("Enter the product ID to delete:");
        l17.setFont(new Font("Arial", Font.BOLD, 20));
        l17.setBounds(250, 50,500,100);

        JLabel l18= new JLabel("ID Product:");
        l18.setFont(new Font("Arial", Font.BOLD, 20));
        l18.setBounds(250, 100,200,100);

        t12.setBounds(400, 130,280,40);

        add=new JButton("DELETE");
        add.setFont(new Font("Arial", Font.BOLD, 20));
        add.setBounds(400, 380,120,30);
        add.setActionCommand("DELETEPRODUS");
        add.addActionListener(this.con);
        add.setBackground(c2);

        p6.add(l17);
        p6.add(l18);
        p6.add(t12);
        p6.add(add);

        p6.setBounds(0,0,700,650);
        principalPanel3.add(p6);
        principalPanel3.revalidate();
        principalPanel3.repaint();
    }
    public void prepareClients()
    {
        clients=new JButton("Clients");
        clients.setFont(new Font("Arial", Font.BOLD, 20));
        clients.setBackground(c2);
        clients.setBounds(120, 90,150,50);
        clients.setActionCommand("CLIENTS");
        clients.addActionListener(this.con);
        principalPanel.add(clients);
    }

    public void prepareProducts()
    {
        products=new JButton("Products");
        products.setBackground(c2);
        products.setFont(new Font("Arial", Font.BOLD, 20));
        products.setBounds(120, 150,150,50);
        products.setActionCommand("PRODUCTS");
        products.addActionListener(this.con);
        principalPanel.add(products);
    }
    public void prepareOrders()
    {
        orders=new JButton("Orders");
        orders.setBackground(c2);
        orders.setFont(new Font("Arial", Font.BOLD, 20));
        orders.setBounds(120, 210,150,50);
        orders.setActionCommand("ORDERS");
        orders.addActionListener(this.con);
        principalPanel.add(orders);
    }

    public void tabelClienti(JTable t)
    {
        tabelClienti.setVisible(true);
        tabelClienti.setSize(600, 300);
        tabelClienti.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        t.setBounds(10, 10, 550, 250);
        t.setCellSelectionEnabled(false);
        t.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
        t.getTableHeader().setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        JPanel panou=new JPanel();
        JScrollPane sp= new JScrollPane(t);
        sp.setBounds(10,10,570,250);
        t.setFillsViewportHeight(true);
        t.setBackground(c3);
        t.getTableHeader().setBackground(c4);
        panou.setLayout(null);
        panou.setBackground(c3);
        panou.add(sp);
        tabelClienti.setContentPane(panou);
        tabelClienti.setVisible(true);
    }
    public void tabelProducts(JTable t)
    {
        tabelProducts.setVisible(true);
        tabelProducts.setSize(600, 300);
        tabelProducts.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        t.setBounds(10, 10, 550, 250);
        t.setCellSelectionEnabled(false);
        t.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
        t.getTableHeader().setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        JPanel panou=new JPanel();
        JScrollPane sp= new JScrollPane(t);
        sp.setBounds(10,10,570,250);
        t.setFillsViewportHeight(true);
        t.setBackground(c3);
        t.getTableHeader().setBackground(c4);
        panou.setLayout(null);
        panou.add(sp);
        panou.setBackground(c3);
        tabelProducts.setContentPane(panou);
        tabelProducts.setVisible(true);
    }

    public void placeOrder(ArrayList<Products> products, ArrayList<Clients> clients)
    {
        frame1.setVisible(false);
        frame2.setVisible(false);
        frame3.setVisible(false);
        frame4.setVisible(true);
        frame4.setBackground(c3);
        frame4.setSize(700, 500);
        frame4.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel p= new JPanel(new GridLayout(5,1));
        p.setLayout(null);
        p.setBackground(c3);

        JLabel order= new JLabel("Place Order");
        order.setFont(new Font("TimesNewRoman", Font.BOLD, 40));
        order.setBounds(230, 5,230,100);

        JLabel client= new JLabel("Chose the client:");
        client.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        client.setBounds(50, 100,230,100);

        c.setBounds(280,140, 250, 30);
        for(int i=0;i<clients.size();i++)
        {
            c.addItem(clients.get(i).getName());
        }

        JLabel product= new JLabel("Chose the product:");
        product.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        product.setBounds(50, 150,230,100);

        pro.setBounds(280,190, 250, 30);
        for(int i=0;i<products.size();i++)
        {
            pro.addItem(products.get(i).getName());
        }

        JLabel quantity= new JLabel("Chose the quantity:");
        quantity.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        quantity.setBounds(50, 200,230,100);

        t.setBounds(280, 240, 250, 30);

        place=new JButton("PLACE ORDER");
        place.setFont(new Font("Arial", Font.BOLD, 20));
        place.setBounds(220, 300,200,30);
        place.setActionCommand("PLACE");
        place.addActionListener(this.con);
        place.setBackground(c2);

        back=new JButton("BACK");
        back.setFont(new Font("Arial", Font.BOLD, 20));
        back.setBounds(560, 420,100,30);
        back.setActionCommand("BACK");
        back.addActionListener(this.con);
        back.setBackground(c2);

        p.add(order);
        p.add(client);
        p.add(product);
        p.add(quantity);
        p.add(place);
        p.add(t);
        p.add(c);
        p.add(pro);
        p.add(back);
        frame4.add(p);
        frame4.setContentPane(p);
        frame4.setVisible(true);

    }

    public JTextField getID()
    {
        return t1;
    }
    public JTextField getNume()
    {
        return t2;
    }
    public JTextField getemail()
    {
        return t3;
    }
    public JTextField getadresa()
    {
        return t4;
    }
    public JTextField clientdeeditat()
    {
        return t5;
    }
    public JTextField clienteditid()
    {
        return t13;
    }
    public JTextField clienteditnume()
    {
        return t14;
    }
    public JTextField clienteditemail()
    {
        return t15;
    }
    public JTextField clienteditadr()
    {
        return t16;
    }
    public JTextField clientsters()
    {
        return t6;
    }

    public JTextField idprod()
    {
        return t7;
    }
    public JTextField nameprod()
    {
        return t8;
    }
    public JTextField quanprod()
    {
        return t9;
    }
    public JTextField priceprod()
    {
        return t10;
    }
    public JTextField idprod2()
    {
        return t17;
    }
    public JTextField nameprod2()
    {
        return t18;
    }
    public JTextField quanprod2()
    {
        return t19;
    }
    public JTextField priceprod2()
    {
        return t20;
    }
    public JTextField idedit()
    {
        return t11;
    }
    public JTextField idsters()
    {
        return t12;
    }

    public JComboBox client()
    {
        return c;
    }
    public JComboBox produs()
    {
        return pro;
    }

    public JTextField cantitateComanda()
    {
        return t;
    }
    public void deleteCasute()
    {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        t10.setText("");
        t11.setText("");
        t12.setText("");
        t13.setText("");
        t14.setText("");
        t15.setText("");
        t16.setText("");
        t17.setText("");
        t18.setText("");
        t19.setText("");
        t20.setText("");

    }
}
