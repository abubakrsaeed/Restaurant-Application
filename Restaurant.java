package Project2;

import java.util.ArrayList;
import java.util.Random;

public class Restaurant {

    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    public Restaurant() {
        initEmployees();
        initProducts();
    }

    private void initEmployees() {

        addCook("Monica", 100);

        addWaiter("Ross");
        addWaiter("Phobe");
        addWaiter("Rachel");
    }

    private void initProducts() {

        // Parameters for Product Constructor:
        // Product Name, Selling Price, Purchase Price and Utility Cost

        products.add(new MainDish("Pizza", 6, 2, 2));
        products.add(new MainDish("Burger", 5, 1.5, 2));

        products.add(new Beverage("Coke", 2, 0.5));
        products.add(new Beverage("Lemonade", 2, 0.3));

        products.add(new Dessert("Tiramusu", 4, 1, 1));
        products.add(new Dessert("Cake", 3, 0.5, 1));
        products.add(new Dessert("Ice Cream", 3, 0.5, 0.5));

        ArrayList<Product> HGproducts = new ArrayList<>();
        HGproducts.add(new MainDish("Pizza", 6, 2, 2));
        HGproducts.add(new Beverage("Coke", 2, 0.5));
        HGproducts.add(new Dessert("Tiramusu", 4, 1, 1));
        products.add(new MenuProduct("Hunger Games Menu", HGproducts));

        ArrayList<Product> Kidsproducts = new ArrayList<>();
        Kidsproducts.add(new MainDish("Burger", 5, 1.5, 2));
        Kidsproducts.add(new Beverage("Lemonade", 2, 0.3));
        Kidsproducts.add(new Dessert("Ice Cream", 3, 0.5, 0.5));
        products.add(new MenuProduct("Kids Menu", Kidsproducts));
    }
    // Implement the rest of the class

    public void listEmployees() {
        for(int i=0;i<=employees.size()-1;i++){
            System.out.println(employees.get(i));
        }

    }
    public void addCook(String name, double salary) {
        int id = this.employees.size() + 1;
        this.employees.add(new Cook(id,name,salary));

    }

    public void addWaiter(String name) {
        int id = this.employees.size() + 1;
        this.employees.add(new Waiter(id,name));
    }

    public Waiter assignWaiter() {

        Random rand = new Random();
        ArrayList<Waiter> waiters = new ArrayList<>();

        for(Employee e : employees){
            if(e instanceof Waiter){
                waiters.add((Waiter)e);
            }
        }

        return waiters.get(rand.nextInt(waiters.size()));
    }

    public double calculateExpenses(){
        double employeeExp = 0;
        double orderExp = 0;
        for (int i = 0; i<=employees.size()-1;i++){
            employeeExp += employees.get(i).calculateExpense();
        }
        System.out.println("Employee expenses: "+employeeExp+"\n");
        for (int i=0;i<=employees.size()-1;i++) {
            if (employees.get(i) instanceof Waiter) {
                ArrayList<Order> order = ((Waiter)employees.get(i)).getOrdersReceived();
                for (int j=0;j<=order.size()-1;j++) {
                    ArrayList<Product> products = order.get(j).getOrderedProducts();
                    for (int k=0;k<=products.size()-1;k++) {
                        orderExp+= products.get(k).calculateExpense();
                    }}}}
        System.out.println("Order expenses: "+orderExp+"\n");
        return employeeExp + orderExp;
    }

    public double calculateRevenue() {
        double revenue = 0;
        for (int i = 0; i <= employees.size() - 1; i++) {
            if (employees.get(i) instanceof Waiter) {
                ArrayList<Order> orders = ((Waiter) employees.get(i)).getOrdersReceived();
                for (int j = 0; j <= orders.size() - 1; j++) {
                    revenue += orders.get(j).calculateTotalPrice();

                }
            }
        }
        return revenue;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }
}




