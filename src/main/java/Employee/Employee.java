package Employee;

public class Employee {
    private int id;
    private String name;
    private String Address;
    Employee(int id,String name,String Address){
        this.id=id;
        this.name=name;
        this.Address=Address;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
