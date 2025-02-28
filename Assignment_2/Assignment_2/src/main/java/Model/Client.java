package Model;

public class Client implements Comparable<Client>{
    int idClient;
    int timeArrival;
    int timeService;

    public Client(int idClient, int timeArrival, int timeService)
    {
        super();
        this.idClient=idClient;
        this.timeArrival=timeArrival;
        this.timeService=timeService;
    }
    public int getIdClient()
    {
        return idClient;
    }
    public int getTimeArrival()
    {
        return timeArrival;
    }
    public int getTimeService()
    {
        return timeService;
    }
    public void setIdClient(int idClient)
    {
        this.idClient=idClient;
    }
    public void setTimeArrival(int timeArrival)
    {
        this.timeArrival=timeArrival;
    }
    public void setTimeService(int timeService)
    {
        this.timeService=timeService;
    }

    @Override
    public int compareTo(Client o) {
       if(this.getTimeArrival()==o.getTimeArrival())
       {
           return 0;
       }
       else if(this.getTimeArrival()>o.getTimeArrival())
        {
            return 1;
        }
        else return -1;
    }

    @Override
    public String toString() {
        return "(" + idClient +
                "," + timeArrival +
                "," + timeService +
                ") ";
    }
}
