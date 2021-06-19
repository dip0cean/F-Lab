package annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
@Inherited
public @interface Auth {
    String name();

    String date();

    String description();
}
