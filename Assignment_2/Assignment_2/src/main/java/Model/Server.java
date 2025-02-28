package Model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{

    public AtomicInteger waitingPeriod;
    public BlockingQueue<Client> clients;
    public int idServer;
    public boolean closed;
    public int medWaitingTime=0;
    public Server(int idServer)
    {
        this.idServer=idServer;
        this.closed=false;
        waitingPeriod=new AtomicInteger(0);
        clients= new LinkedBlockingQueue<Client>();
    }

    public void setClosed()
    {
        this.closed=true;
    }
    public boolean isClosed()
    {
        return false;
    }
    public int nrClients()
    {
        return clients.size();
    }
    public void setClients(BlockingQueue<Client> clients)
    {
        this.clients=clients;
    }
    public BlockingQueue<Client> getClientsQueue()
    {
        return clients;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }
    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public void setIdServer(int idServer) {
        this.idServer = idServer;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public int getIdServer() {
        return idServer;
    }

    //adaugam un client la coada
    void addClient(Client client)
    {
        clients.add(client);
        this.waitingPeriod.addAndGet(client.getTimeService());
        this.closed=false;
    }

    @Override
    public void run() {
        while (true) {
            //take next client from queue
            //stop the thread for a time equal with the task's processing time
            //decrement the waitingperiod
                Client c = clients.peek();
                try {
                    if (c != null) {
                        while (c.getTimeService() > 0) {
                            Thread.sleep(1000); //transform to sec
                            c.setTimeService(c.getTimeService() - 1);
                            waitingPeriod.decrementAndGet();
                        }
                        if(c.getTimeService()==0)
                        {
                            medWaitingTime+=waitingPeriod.get();
                        }
                        clients.remove(c);
                    }
                    } catch(InterruptedException e){
                        throw new RuntimeException(e);
                    }
        }
    }
    public Client[] getClients()
    {
        Client[] clientArr= new Client[clients.size()];
        clients.toArray(clientArr);
        return clientArr;
    }
    public String serverString(int time)
    {
        StringBuilder s= new StringBuilder();
        s.append("Queue");
        s.append(idServer);
        s.append(":");
        if(clients.isEmpty())
           s.append(" Closed");
        for(Client c: clients){
            s.append(c.toString());
        }
        String rez=null;
        rez=s.toString();
        return rez;
    }

}
