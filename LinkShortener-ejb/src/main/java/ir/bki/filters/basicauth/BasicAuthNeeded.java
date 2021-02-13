package ir.bki.filters.basicauth;

import javax.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by m-asvadi on 6/10/2018.
 */
@NameBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface BasicAuthNeeded {
}
