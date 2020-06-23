import java.util.ArrayList;

public abstract class Product implements Expense {
    private String name;
    private double purchasePrice;
    private double sellingPrice;
    private double utilityCost;

    public Product(String ProductName, double SellingPrice, double PurchasePrice, double UtilityCost) {
        this.name=ProductName;
        this.sellingPrice=SellingPrice;
        this.purchasePrice=PurchasePrice;
        this.utilityCost=UtilityCost;
    }

    public Product(String ProductName, double SellingPrice, double PurchasePrice) {
        this.name=ProductName;
        this.sellingPrice=SellingPrice;
        this.purchasePrice=PurchasePrice;
    }

    public Product(String menu) {
        this.name=menu;
    }

    public String getName() {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }
    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getUtilityCost() {
        return utilityCost;
    }

    @Override
    public double calculateExpense() {
        return purchasePrice + utilityCost;
    }

    public String toString(){
        return this.name;
    }
}
