package Model;

import View.ViewClass;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import static java.lang.Integer.MIN_VALUE;

public class SimulationManager implements Runnable {
    private int numberClients;
    private int numberServers;
    private int simulationInterval;
    private int minArrivalTime;
    private int maxArrivalTime;
    private int minServiceTime;
    private int maxServiceTime;
    private int maxPeriodOfTime;
    private Scheduler scheduler;
    private ArrayList<Client> generatedClients= new ArrayList<Client>();
    private BlockingQueue<Client> clients;
    private ArrayList<Server>servers= new ArrayList<Server>();
    public FileWriter myfile;
    private ViewClass view;
    Thread t;

    {
        try {
            myfile = new FileWriter("rezultate.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public SimulationManager(ViewClass v, int numberClients, int numberServers, int simulationInterval, int minArrivalTime, int maxArrivalTime, int minServiceTime, int maxServiceTime)
    {
        this.view=v;
        this.numberClients=numberClients;
        this.numberServers=numberServers;
        this.simulationInterval=simulationInterval;
        this.minArrivalTime=minArrivalTime;
        this.maxArrivalTime=maxArrivalTime;
        this.minServiceTime=minServiceTime;
        this.maxServiceTime=maxServiceTime;

        generateRandomClients();
        maxPeriodOfTime = maxtimeperiod();
        servers = new ArrayList<Server>(numberServers);
        scheduler = new Scheduler(numberServers, numberClients);

    }
    public int getNumberClients() {
        return numberClients;
    }

    public int getNumberServers() {
        return numberServers;
    }

    public int getSimulationInterval() {
        return simulationInterval;
    }

    public int getMinArrivalTime() {
        return minArrivalTime;
    }

    public int getMaxArrivalTime() {
        return maxArrivalTime;
    }

    public int getMinServiceTime() {
        return minServiceTime;
    }

    public int getMaxServiceTime() {
        return maxServiceTime;
    }

    public void setNumberClients(int numberClients) {
        this.numberClients = numberClients;
    }

    public void setNumberServers(int numberServers) {
        this.numberServers = numberServers;
    }

    public void setSimulationInterval(int simulationInterval) {
        this.simulationInterval = simulationInterval;
    }

    public void setMinArrivalTime(int minArrivalTime) {
        this.minArrivalTime = minArrivalTime;
    }

    public void setMaxArrivalTime(int maxArrivalTime) {
        this.maxArrivalTime = maxArrivalTime;
    }

    public void setMinServiceTime(int minServiceTime) {
        this.minServiceTime = minServiceTime;
    }

    public void setMaxServiceTime(int maxServiceTime) {
        this.maxServiceTime = maxServiceTime;
    }

    public ArrayList<Client> getClients() {
        return generatedClients;
    }

    //sortam clientii dupa timpul de sosire la coada
    public void sortClients(ArrayList<Client> clientstosort)
    {
        Collections.sort(clientstosort);
        for(int i=0;i<clientstosort.size();i++)
        {
            clientstosort.get(i).setIdClient(i+1);
        }
    }
    //functia pentru generarea unei liste de clienti, fiecare cu id, arrivaltime si servicetime random dintr un interval
    public ArrayList<Client> generateRandomClients()
    {
        for (int i=0;i<this.numberClients;i++) {
            int idClient;
            int timeArrival;
            int timeService;
            idClient = i+1;
            timeArrival = (int) ((Math.random() * (this.maxArrivalTime - this.minArrivalTime)) +1+ this.minArrivalTime);
            timeService = (int) ((Math.random() * (this.maxServiceTime - this.minServiceTime)) + 1+ this.minServiceTime);
            Client c = new Client(idClient, timeArrival, timeService);
            generatedClients.add(c);
        }
        sortClients(generatedClients);
        return generatedClients;
    }

public float averageService()
{
    float average=0;
    for (Client c:generatedClients) {
        average+=c.getTimeService();
    }
    float nr=generatedClients.size();
    return average/nr;
}

public float averageWaiting(ArrayList <Server> servers)
{
    float average=0;
    for(Server s: servers)
    {
        average+=s.medWaitingTime;
    }
    return average/(float)numberClients;
}

public void printPeakHour(int peak)
{
    try {
        myfile.write("Peak hour: "+ peak+"\n");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    view.receiveResults("Peak hour: "+ peak+"\n");
}
public void printWaitinigTime()
{
    float averageWait;
    averageWait=averageWaiting(scheduler.getServers());
    try {
        myfile.write("Average waiting time: "+averageWait+"\n");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    view.receiveResults(String.valueOf("Average waiting time: "+averageWait+"\n"));
}
public void printServiceTime(float averageServ)
{
    try {
        myfile.write(String.valueOf("Average service time: " +averageServ +"\n"));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    view.receiveResults(String.valueOf("Average service time: " +averageServ+"\n"));

}

public void printWaitingClients()
{
    try {
        myfile.write("waiting tasks : " + waitingClients(generatedClients) +"\n");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    view.receiveResults("Waiting tasks : " + waitingClients(generatedClients) +"\n");
}
public void printServerStatus(int currentTime)
{
    try {
        myfile.write(serverNow(scheduler.getServers(), currentTime)+"\n");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    view.receiveResults(serverNow(scheduler.getServers(), currentTime)+"\n");
}

public void printCurrentTime(int currentTime)
{
    try {
        myfile.write("Time :" + currentTime + "\n");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    view.receiveResults("Time :" + currentTime + "\n");
}

    public void run() {
        float averageServ;
        averageServ=averageService();
        int max=MIN_VALUE;
        int peak=0;
        int currentTime=0;
        while(currentTime<simulationInterval ) {
            printCurrentTime(currentTime);
            boolean valid=true;
            Client client=null;
            while(valid==true&&generatedClients.size()>0) {
                valid = false;
                if (generatedClients.get(0).getTimeService() > 0 && currentTime == generatedClients.get(0).getTimeArrival()) {
                    client = generatedClients.get(0);
                    scheduler.strategy(client);
                    generatedClients.remove(0);
                    valid = true;
                }
            }
            int calc=0;
            for (Server s : scheduler.getServers()) {
                calc+=s.nrClients(); }
            if(calc>max) {
                max=calc;
                peak=currentTime; }
            printWaitingClients();
            printServerStatus(currentTime);
            try { Thread.sleep(1000);
            } catch (InterruptedException e) {
                    e.printStackTrace(); }
                currentTime++;
        }
        printServiceTime(averageServ);
        printWaitinigTime();
        printPeakHour(peak);
        try { myfile.close();
        } catch (IOException e) {
            throw new RuntimeException(e); }
        scheduler.end();
    }

    /*o metoda pentru a calcula in ce limita de timp se incadreaza clientul
    cu suma dintre timpul la care se pune la coada si timpul cat dureaza procesarea
    lui cea mai mare*/
    public int maxtimeperiod()
    {
        int maxtime=0;
        for (Client c:generatedClients) {
            if(c.getTimeService()+c.getTimeArrival()>maxtime)
                maxtime=c.getTimeArrival()+c.getTimeService();
        }
        return maxtime;
    }

    public String serverNow(ArrayList<Server> serv, int currentTime) {

        StringBuilder b= new StringBuilder();
        for (Server s :serv)
        {
            b.append(s.serverString(currentTime));
            b.append("\n");
        }
        String s= null;
        s=b.toString();
        return s;
    }

    public String waitingClients(ArrayList<Client> client) {
        StringBuilder b= new StringBuilder();
        for(Client c: client)
           b.append(c.toString());
        String s= null;
        s=b.toString();
        return s;
    }
}
