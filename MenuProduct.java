import java.util.ArrayList;
import java.util.List;

public class MenuProduct extends Product {

    private ArrayList<Product> products;

    public MenuProduct(String menu, ArrayList<Product> products) {
        super(menu);
        this.products=products;
        super.setSellingPrice(this.calculateSellingPrice());
    }

    public double calculateExpense() {
        double expense = 0;
        for (int i = 0; i <= products.size() - 1; i++) {
            expense += products.get(i).calculateExpense();
        }
        return expense;
    }

    public double calculateSellingPrice() {
        double sellingPrice = 0;
        for (int i = 0; i <= products.size() - 1; i++) {
            if (products.get(i) instanceof MainDish) {
                sellingPrice += products.get(i).getSellingPrice() * 0.9;
            } else if (products.get(i) instanceof Beverage) {
                sellingPrice += products.get(i).getSellingPrice() * 0.5;
            } else if (products.get(i) instanceof Dessert) {
                sellingPrice += products.get(i).getSellingPrice() * 0.8;
            }
        }
        return sellingPrice;
    }
}