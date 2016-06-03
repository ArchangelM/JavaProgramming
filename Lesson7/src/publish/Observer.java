package publish;


public class Observer {
    private String name;
    private String address;

    public void update(String event) {
        System.out.println("Вас ожидает " + event);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
