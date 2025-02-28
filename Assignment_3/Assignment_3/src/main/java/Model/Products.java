package Model;

/**
 *Această clasă servește drept model pentru stocarea și manipularea
 * informațiilor despre produse în cadrul aplicației de gestionare a depozitului.
 * Poate fi utilizată pentru a crea obiecte Products și pentru a accesa și actualiza detaliile acestora.
 */
public class Products {
    private int id;
    private String name;
    private int quantity;
    private int price;

    public Products() {
    }

    /**
     * Class constructor.
     */
    public Products(int id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price= price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
