package Model;

import java.util.ArrayList;

import static java.lang.Integer.MAX_VALUE;


public class Scheduler {
    private ArrayList<Server> servers;
    private int maxNoServers;
    private int maxClientsPerServer;

    public Scheduler(int maxNoServers, int maxClientsPerServer)
    {
        super();
        servers= new ArrayList<Server>(maxNoServers);
        for(int i=0;i<maxNoServers;i++)
        {
            Server server= new Server(i+1);
            servers.add(server);
        }
        for(Server server: servers){
            Thread t = new Thread(server);
            t.start();
        }
        this.maxNoServers=maxNoServers;
        this.maxClientsPerServer=maxClientsPerServer;
    }
    public ArrayList<Server> getServers() {
        return servers;
    }
    public int getMaxNoServers() {
        return maxNoServers;
    }

    public int getMaxClientsPerServer() {
        return maxClientsPerServer;
    }

    public void setServers(ArrayList<Server> servers) {
        this.servers = servers;
    }

    public void setMaxNoServers(int maxNoServers) {
        this.maxNoServers = maxNoServers;
    }
    public void setMaxClientsPerServer(int maxClientsPerServer) {
        this.maxClientsPerServer = maxClientsPerServer;
    }

    //practic trebuie sa vedem care casa are cei mai putini clienti si acolo
    //il vom trimite pe urmatorul
    public void strategy (Client client)
    {
        Server newServer=null;
        int minnumberclients=MAX_VALUE;
        for (Server s:servers) {

            if(!s.isClosed() && s.nrClients()<minnumberclients)
            {
                minnumberclients=s.nrClients();
                newServer=s;
            }
            if(s.isClosed())
            {
                newServer=s;
            }
            s.setClosed(false);
        }
        newServer.addClient(client);
    }
    public void end()
    {
        for (Server s : servers) {
            s.setClosed(false);
        }
    }

}
