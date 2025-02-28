package Controller;

import Model.SimulationManager;
import View.ViewClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControllerClass implements ActionListener{
    private ViewClass view;
    public ControllerClass(ViewClass v)
    {
        this.view=v;
    }
    public void ruleazaSimulare() throws Exception {
        String numarClients=view.getNumClients().getText();
        String numarQueues= view.getNumServers().getText();
        String simInterval= view.getInterval().getText();
        String minArr= view.getArrmin().getText();
        String maxArr= view.getArrmax().getText();
        String minSer= view.getSermin().getText();
        String maxSer= view.getSermax().getText();
        try {
            int numarClients1 = Integer.parseInt(numarClients);
            int numarQueues1 = Integer.parseInt(numarQueues);
            int numarsimInterval1 = Integer.parseInt(simInterval);
            int minArr1 = Integer.parseInt(minArr);
            int maxArr1 = Integer.parseInt(maxArr);
            int minSer1 = Integer.parseInt(minSer);
            int maxSer1 = Integer.parseInt(maxSer);
            SimulationManager sm= new SimulationManager(view,numarClients1, numarQueues1, numarsimInterval1, minArr1, maxArr1, minSer1, maxSer1);
            Thread t =new Thread(sm);
            t.start();
        }
        catch(Exception e) {
            throw new Exception(e);
        }/*
        SimulationManager sm= new SimulationManager(view,numarClients1, numarQueues1, numarsimInterval1, minArr1, maxArr1, minSer1, maxSer1);
        Thread t =new Thread(sm);
        t.start();*/
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String command= e.getActionCommand();
        if(command=="START") {
            try {
                ruleazaSimulare();
            } catch (Exception ex) {
                view.receiveResults("The data is wrong!");
            }
        }
    }
}
