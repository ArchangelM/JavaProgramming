package container;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    List<Service> serviceList;

    public ServiceRepository() {
        serviceList = new ArrayList<>();

    }

    public void addElement(Service cur) {
        serviceList.add(cur);

    }

    public void addElement(Service cur, int index) {
        serviceList.add(index, cur);

    }

    public Service getElement() {
        return serviceList.get(serviceList.size());

    }

    public Service getElement(int index) {
        return serviceList.get(index);

    }
}
