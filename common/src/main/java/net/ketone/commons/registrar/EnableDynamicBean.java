package net.ketone.commons.registrar;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * You MUST have retention policy of runtime otherwise the annotation will go away after compilation!
 * https://www.java2novice.com/java-annotations/retention-policy/
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(value = {
        DynamicBeanConfiguration.class, DynamicBeanRegistrar.class
})
public @interface EnableDynamicBean {

    String value() default "defaultBeanName";

}
