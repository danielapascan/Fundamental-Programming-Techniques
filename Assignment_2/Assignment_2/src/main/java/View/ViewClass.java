package View;
import Controller.ControllerClass;
import Model.SimulationManager;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewClass extends JFrame {
    private JPanel principalPanel;
    private JPanel data;
    private JLabel numClients;
    private JTextField numClientsText;

    private JLabel simTime;
    private JTextField simTimeText;
    private JLabel numServers;
    private JTextField numServersText;
    private JLabel maxArr;
    private JTextField maxArrText;
    private JLabel minArr;
    private JTextField minArrText;
    private JLabel maxProc;
    private JTextField maxProcText;
    private JLabel minProc;
    private JTextField minProcText;
    private JLabel simTimeUser;
    private JTextField simTimeUserText;
    private JLabel results;
    private JTextArea resultsTxt;
    private JButton start;
    ControllerClass con= new ControllerClass(this);

    Color fundal= new Color(128,100,145);
    Color buton= new Color(185,132,140);
    Color scris= new Color(2,49,94);
    Color casute= new Color(171,170,200);
    Color casute2= new Color(47,112,175);


    //SimulationManager sm= new SimulationManager(this);
    public ViewClass(String name) {
        super(name);
        this.deschideinter();
    }
    public void addstartListener(ActionListener e)
    {
        start.addActionListener(e);
    }
    public void receiveResults(String s)
    {
        resultsTxt.append(s);
    }
    public void deschideinter()
    {
        this.setSize(1000, 650);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.principalPanel=new JPanel(new GridLayout(1,2));
        this.prepareDatapanel();
        this.setContentPane(this.principalPanel);
        this.setVisible(true);
    }

    private void prepareDatapanel()
    {
        this.data=new JPanel();
        this.data.setLayout(null);
        this.data.setBackground(fundal);
        prepareTextnumC();
        prepareTextnumS();
        prepareTextminArr();
        prepareTextmaxArr();
        prepareTextminProc();
        prepareTextmaxProc();
        prepareTextIntSim();
        prepareResults();
        prepareButton();
        this.principalPanel.add(data);
    }
    private void prepareTextnumC()
    {
        this.numClients= new JLabel("Number of Clients:");
        this.numClients.setFont(new Font("Arial", Font.BOLD, 20));
        this.numClients.setForeground(scris);
        this.numClients.setBounds(30, 15,200,100);
        this.numClientsText= new JTextField(20);
        this.numClientsText.setFont(new Font("Aerial",Font.PLAIN, 24));
        this.numClientsText.setBackground(casute);
        this.numClientsText.setBorder(new BevelBorder(BevelBorder.LOWERED,casute2, scris));
        this.numClientsText.setBounds(300,40,50,50);
        this.data.add(numClients);
        this.data.add(numClientsText);
    }

    private void prepareTextnumS()
    {
        this.numServers= new JLabel("Number of Queues:");
        this.numServers.setFont(new Font("Arial", Font.BOLD, 20));
        this.numServers.setBounds(30, 75,200,100);
        this.numServers.setForeground(scris);
        this.numServersText= new JTextField(20);
        this.numServersText.setFont(new Font("Aerial",Font.PLAIN, 24));
        this.numServersText.setBackground(casute);
        this.numServersText.setBorder(new BevelBorder(BevelBorder.LOWERED,casute2, scris));
        this.numServersText.setBounds(300,100,50,50);
        this.data.add(numServers);
        this.data.add(numServersText);
    }
    private void prepareTextminArr()
    {
        this.maxArr= new JLabel("Min Arrival Time:");
        this.maxArr.setFont(new Font("Arial", Font.BOLD, 20));
        this.maxArr.setBounds(30, 135,250,100);
        this.maxArrText= new JTextField(20);
        this.maxArrText.setFont(new Font("Aerial",Font.PLAIN, 24));
        this.maxArr.setForeground(scris);
        this.maxArrText.setBounds(300,160,50,50);
        this.maxArrText.setBackground(casute);
        this.maxArrText.setBorder(new BevelBorder(BevelBorder.LOWERED,casute2, scris));
        this.data.add(maxArr);
        this.data.add(maxArrText);
    }
    private void prepareTextmaxArr()
    {
        this.minArr= new JLabel("Max Arrival Time:");
        this.minArr.setFont(new Font("Arial", Font.BOLD, 20));
        this.minArr.setBounds(30, 195,250,100);
        this.minArrText= new JTextField(20);
        this.minArrText.setFont(new Font("Aerial",Font.PLAIN, 24));
        this.minArr.setForeground(scris);
        this.minArrText.setBounds(300,220,50,50);
        this.minArrText.setBackground(casute);
        this.minArrText.setBorder(new BevelBorder(BevelBorder.LOWERED,casute2, scris));
        this.data.add(minArr);
        this.data.add(minArrText);
    }
    private void prepareTextminProc()
    {
        this.minProc= new JLabel("Min Processing Time:");
        this.minProc.setFont(new Font("Arial", Font.BOLD, 20));
        this.minProc.setBounds(30, 255,270,100);
        this.minProcText= new JTextField(20);
        this.minProcText.setFont(new Font("Aerial",Font.PLAIN, 24));
        this.minProc.setForeground(scris);
        this.minProcText.setBounds(300,280,50,50);
        this.minProcText.setBackground(casute);
        this.minProcText.setBorder(new BevelBorder(BevelBorder.LOWERED,casute2, scris));
        this.data.add(minProc);
        this.data.add(minProcText);
    }
    private void prepareTextmaxProc()
    {
        this.maxProc= new JLabel("Max Processing Time:");
        this.maxProc.setFont(new Font("Arial", Font.BOLD, 20));
        this.maxProc.setBounds(30, 315,270,100);
        this.maxProcText= new JTextField(20);
        this.maxProcText.setFont(new Font("Aerial",Font.PLAIN, 24));
        this.maxProc.setForeground(scris);
        this.maxProcText.setBounds(300,340,50,50);
        this.maxProcText.setBackground(casute);
        this.maxProcText.setBorder(new BevelBorder(BevelBorder.LOWERED,casute2, scris));
        this.data.add(maxProc);
        this.data.add(maxProcText);
    }

    private void prepareTextIntSim()
    {
        this.simTimeUser= new JLabel("Simulation Interval:");
        this.simTimeUser.setFont(new Font("Arial", Font.BOLD, 20));
        this.simTimeUser.setBounds(30, 375,270,100);
        this.simTimeUserText= new JTextField(20);
        this.simTimeUserText.setFont(new Font("Aerial",Font.PLAIN, 24));
        this.simTimeUser.setForeground(scris);
        this.simTimeUserText.setBounds(300,400,50,50);
        this.simTimeUserText.setBackground(casute);
        this.simTimeUserText.setBorder(new BevelBorder(BevelBorder.LOWERED,casute2, scris));
        this.data.add(simTimeUser);
        this.data.add(simTimeUserText);
    }

    private void prepareResults()
    {
        this.results= new JLabel("Simulation Results:");
        this.results.setFont(new Font("Arial", Font.BOLD, 40));
        this.results.setBounds(520, 10,400,100);
        this.resultsTxt= new JTextArea(100, 20);
        this.results.setForeground(scris);
        this.resultsTxt.setBounds(400,100,550,460);
        JScrollPane scroll= new JScrollPane(resultsTxt);
        this.resultsTxt.setEditable(false);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.data.add(results);
        //this.data.add(resultsTxt);
        scroll.setBounds(400, 100, 550, 460);
        scroll.setBackground(casute);
        resultsTxt.setBorder(new BevelBorder(BevelBorder.LOWERED,casute2, scris));
        resultsTxt.setBackground(casute);
        resultsTxt.setFont(new Font("Aerial",Font.PLAIN, 20));

        this.data.add(scroll);
    }

    private void prepareButton()
    {
        this.start=new JButton("START");
        this.start.setBounds(120,490,150,70);
        this.start.setFont(new Font("Arial", Font.BOLD, 20));
        this.start.setBackground(buton);
        //this.start.setBorder(new BevelBorder(BevelBorder.RAISED,scris2, scris));
        this.start.setActionCommand("START");
        this.start.addActionListener(this.con);
        this.data.add(start);
    }
    public JTextField getNumClients()
    {
        return numClientsText;
    }
    public JTextField getNumServers()
    {
        return numServersText;
    }
    public JTextField getInterval()
    {
        return simTimeUserText;
    }
    public JTextField getArrmin()
    {
        return minArrText;
    }
    public JTextField getArrmax()
    {
        return maxArrText;
    }
    public JTextField getSermin()
    {
        return minProcText;
    }
    public JTextField getSermax()
    {
        return maxProcText;
    }
    public JTextArea getResultsTxt()
    {
        return resultsTxt;
    }
}
