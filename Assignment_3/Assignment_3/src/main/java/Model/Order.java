package Model;

/**
 *Această clasă servește drept model pentru stocarea și manipularea
 * informațiilor despre o comandă în cadrul aplicației de gestionare a depozitului.
 * Poate fi utilizată pentru a crea obiecte Order și pentru a accesa și actualiza detaliile acestora.
 */
public class Order {
   String nameClient;
   String nameProduct;
   int quantity;
   int price;
   int id;

    /**
     * Class constructor.
     */
    public Order(String nameClient, String nameProduct, int quantity, int price) {
        this.nameClient = nameClient;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
    }


    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
