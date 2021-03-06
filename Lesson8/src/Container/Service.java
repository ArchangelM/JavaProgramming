package container;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface Service {
    public String test();
}

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
        //@Retention.RetentionPolicy.RUNTIME
@interface ServiceC {
    String name() default "runtimeCheck";
}

