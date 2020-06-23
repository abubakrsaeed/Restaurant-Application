import java.util.ArrayList;

public class Waiter extends Employee {
    private ArrayList<Order> orders;
    private double orderRate;

    public Waiter(int id, String name){
        super(name, id);
        this.orders=new ArrayList<Order>();
        this.orderRate=0.10;
    }

    public ArrayList<Order> getOrdersReceived() {
        return this.orders;
    }


    public double calculateExpenses(){
        double expense =0;
        for (int i=0;i<=orders.size()-1;i++){
            expense+= (((Expense) orders.get(i)).calculateExpense())*this.orderRate;
        }
        return expense;

    }


    public void createOrder(Order order) {
        orders.add(order);
    }

    @Override
    public double calculateExpense() {
        return 0;
    }
}
