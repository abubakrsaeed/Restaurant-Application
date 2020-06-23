public abstract class Employee implements Expense {
    private int id;
    private String name;

    public Employee(String name, int id) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "Employee "+this.id + ":" +this.name+"\n";
    }
}
