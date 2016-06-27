package container;

/*
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
*/

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
/*
    @Target(value = ElementType.TYPE)
    @Retention(value = RetentionPolicy.RUNTIME)
    //@Retention.RetentionPolicy.RUNTIME
    @interface Service {
        String name() default "runtimeCheck";
    }
*/

}
