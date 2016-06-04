package observe;

public class ActionEvent {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) {
            name = this.toString();
        }

        this.name = name;
    }

    public ActionEvent(String name) {
        if(name == null) {
            name = this.toString();
        }

        this.name = name;
    }
}
