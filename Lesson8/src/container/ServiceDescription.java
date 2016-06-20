package container;

public class ServiceDescription implements Service {
    String type;
    @Override
    public String test() {
        return type;
    }

    public ServiceDescription() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
