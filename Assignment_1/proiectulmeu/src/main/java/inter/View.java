package inter;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
public class View extends JFrame{
    private JPanel panouPrincipal;
    private JPanel polinom1;
    private JPanel butoane;
    private JTextField text1;
    private JLabel lab1;
    private JLabel lab2;
    private JTextField text2;
    private JPanel polinom2;
    private JButton adunare;
    private JButton scadere;
    private JButton inmultire;
    private JButton integrare;
    private JButton derivare;
    private JButton impartire;
    private JLabel rez;
    private JTextField rezultat;
    Color c1= new Color(252,163,122);
    Color scris= new Color(80,46,72);
    Color but= new Color(201,62,79);
    Color bor=new Color(252,106,103);
    Color scris2= new Color(245,234,149);
    Color scris3= new Color(250, 245,202);

    Border border = BorderFactory.createLineBorder(scris);
    Controller con= new Controller(this);
    public View(String name) {
        super(name);
        this.deschideinter();
    }
    public void deschideinter()
    {
        this.setSize(850, 650);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.panouPrincipal = new JPanel(new GridLayout(2,2));
        this.panouPrincipal.setBackground(c1);
        this.preparePolinoamePanel();
        this.prepareButoanePanel();
        this.setContentPane(this.panouPrincipal);
        this.setVisible(true);
    }

    private  void prepareRezultat()
    {
        this.rez= new JLabel("REZULTAT: ");
        this.rez.setFont(new Font("Arial", Font.BOLD, 30));
        this.rez.setBounds(30,190,200,100);
        this.rezultat= new JTextField(20);
        this.rezultat.setBounds(210,210,600,50);
        this.rezultat.setBackground(bor);
        this.rezultat.setBorder(new BevelBorder(BevelBorder.LOWERED,scris2, scris));
        this.rezultat.setFont(new Font("Aerial",Font.PLAIN, 24));
        this.rezultat.setForeground(scris3);
        this.rez.setForeground(scris);
    }

    private void preparePolinoame()
    {
        this.lab1= new JLabel("POLINOM 1: ");
        this.lab1.setBounds(30,10,200,100);
        this.lab1.setFont(new Font("Aerial", Font.BOLD, 30));
        this.lab1.setForeground(scris);

        this.lab2= new JLabel("POLINOM 2: ");
        this.lab2.setBounds(30,100,200,100);
        this.lab2.setFont(new Font("Arial", Font.BOLD, 30));
        this.lab2.setForeground(scris);

        this.text1= new JTextField(20);
        this.text1.setBounds(210,35,600,50);
        this.text1.setBackground(bor);
        this.text1.setBorder(new BevelBorder(BevelBorder.LOWERED,scris2, scris));
        this.text1.setFont(new Font("Aerial",Font.PLAIN, 24));
        this.text1.setForeground(scris3);

        this.text2= new JTextField(20);
        this.text2.setBounds(210,120,600,50);
        this.text2.setBackground(bor);
        this.text2.setBorder(new BevelBorder(BevelBorder.LOWERED,scris2, scris));
        this.text2.setFont(new Font("Aerial",Font.PLAIN, 24));
        this.text2.setForeground(scris3);
    }
    private void preparePolinoamePanel()
    {
        this.polinom1= new JPanel();
        this.polinom1.setLayout(null);
        this.polinom1.setBackground(c1);

        preparePolinoame();
        prepareRezultat();

        this.polinom1.add(lab1);
        this.polinom1.add(text1);
        this.polinom1.add(lab2);
        this.polinom1.add(text2);
        this.polinom1.add(rez);
        this.polinom1.add(rezultat);

        this.panouPrincipal.add(polinom1);
    }

    private void prepareAdunare()
    {
        this.adunare= new JButton("ADUNARE");
        this.adunare.setBounds(70,10,190,100);
        this.adunare.setFont(new Font("Arial", Font.BOLD, 20));
        this.adunare.setBackground(but);
        this.adunare.setBorder(new BevelBorder(BevelBorder.RAISED,scris2, scris));
        this.adunare.setForeground(scris2);
        this.adunare.setActionCommand("ADUNARE");
        this.adunare.addActionListener(this.con);
    }

    private void prepareScadere()
    {
        this.scadere= new JButton("SCADERE");
        this.scadere.setBounds(320,10,190,100);
        this.scadere.setFont(new Font("Arial", Font.BOLD, 20));
        this.scadere.setBackground(but);
        this.scadere.setBorder(new BevelBorder(BevelBorder.RAISED,scris2, scris));
        this.scadere.setForeground(scris2);
        this.scadere.setActionCommand("SCADERE");
        this.scadere.addActionListener(this.con);
    }

    private void prepareInmultire()
    {
        this.inmultire= new JButton("INMULTIRE");
        this.inmultire.setBounds(570,10,190,100);
        this.inmultire.setFont(new Font("Arial", Font.BOLD, 20));
        this.inmultire.setBackground(but);
        this.inmultire.setBorder(new BevelBorder(BevelBorder.RAISED,scris2, scris));
        this.inmultire.setForeground(scris2);
        this.inmultire.setActionCommand("INMULTIRE");
        this.inmultire.addActionListener(this.con);
    }

    private void prepareDerivare()
    {
        this.derivare= new JButton("DERIVARE");
        this.derivare.setBounds(70,130,190,100);
        this.derivare.setFont(new Font("Arial", Font.BOLD, 20));
        this.derivare.setBackground(but);
        this.derivare.setBorder(new BevelBorder(BevelBorder.RAISED,scris2, scris));
        this.derivare.setForeground(scris2);
        this.derivare.setActionCommand("DERIVARE");
        this.derivare.addActionListener(this.con);
    }

    private void prepareIntegrare()
    {
        this.integrare= new JButton("INTEGRARE");
        this.integrare.setBounds(320,130,190,100);
        this.integrare.setFont(new Font("Arial", Font.BOLD, 20));
        this.integrare.setBackground(but);
        this.integrare.setBorder(new BevelBorder(BevelBorder.RAISED,scris2, scris));
        this.integrare.setForeground(scris2);
        this.integrare.setActionCommand("INTEGRARE");
        this.integrare.addActionListener(this.con);
    }

    private void prepareImpartire()
    {
        this.impartire= new JButton("IMPARTIRE");
        this.impartire.setBounds(570,130,190,100);
        this.impartire.setFont(new Font("Arial", Font.BOLD, 20));
        this.impartire.setBackground(but);
        this.impartire.setBorder(new BevelBorder(BevelBorder.RAISED,scris2, scris));
        this.impartire.setForeground(scris2);
        this.impartire.setActionCommand("IMPARTIRE");
        this.impartire.addActionListener(this.con);
    }
    private void prepareButoanePanel()
    {
        this.butoane = new JPanel();
        this.butoane.setBackground(c1);
        this.butoane.setLayout(null);

        prepareAdunare();
        prepareScadere();
        prepareInmultire();
        prepareDerivare();
        prepareIntegrare();
        prepareImpartire();

        this.butoane.add(adunare);
        this.butoane.add(scadere);
        this.butoane.add(inmultire);
        this.butoane.add(derivare);
        this.butoane.add(integrare);
        this.butoane.add(impartire);
        this.panouPrincipal.add(butoane);
    }
    public JTextField getFirstPolinom() {
        return text1;
    }
    public JTextField getSecondPolinom() {
        return text2;
    }
    public JTextField getRezultat()
    {
        return rezultat;
    }

}
