import java.util.ArrayList;

public class Order {

    private ArrayList<Product> products;

    public Order(){
        this.products = new ArrayList<Product>();
    }
    public void addProduct(Product product){
        this.products.add(product);
    }
    public void listOrder() {
        if (this.products.size() == 0) {
            System.out.println("You have not ordered anything yet!");
        } else {
            for (int i = 0; i <= products.size() - 1; i++) {
                System.out.println(products.get(i).getName() + "=" + products.get(i).getSellingPrice());
            }
        }
    }

    public ArrayList<Product> getOrderedProducts() {
        return this.products;
    }

    public double calculateTotalPrice() {
        double total=0;
        for (int i=0;i<=products.size()-1;i++){
            total+=products.get(i).getSellingPrice();
        }
        return total;
    }
}
