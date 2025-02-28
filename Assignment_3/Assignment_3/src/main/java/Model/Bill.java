package Model;

public record Bill (String client, String product, int price, int id){

    public String getClient() {
        return client;
    }

    public String getProdus() {
        return product;
    }

    public int getPretComanda() {
        return price;
    }

    public int getId()
    {
        return id;
    }


}
