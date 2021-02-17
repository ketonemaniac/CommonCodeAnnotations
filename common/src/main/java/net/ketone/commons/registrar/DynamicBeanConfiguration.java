package net.ketone.commons.registrar;

import net.ketone.commons.template.TestDependency;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {TestDependency.class, DynamicBeanRegistrar.class})
public class DynamicBeanConfiguration {
}
