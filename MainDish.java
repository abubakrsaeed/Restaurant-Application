public class MainDish extends Product {

    public MainDish(String ProductName, double SellingPrice, double PurchasePrice, double UtilityCost) {
        super(ProductName,SellingPrice,PurchasePrice,UtilityCost);
    }

    public double calculateExpense(){
        return super.calculateExpense();
    }
}
