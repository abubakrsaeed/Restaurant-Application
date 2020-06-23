public class Dessert extends Product {

    public Dessert(String ProductName, double SellingPrice, double PurchasePrice, double UtilityCost) {
        super(ProductName,SellingPrice,PurchasePrice,UtilityCost);
    }

    public double calculateExpense(){
        return super.calculateExpense();
    }

}
