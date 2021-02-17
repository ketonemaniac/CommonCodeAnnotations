package net.ketone.commons.registrar;

import net.ketone.commons.template.BeanTemplate;
import net.ketone.commons.template.TestDependency;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * https://blog.pchudzik.com/201705/dynamic-beans/
 *
 */
@Component
public class DynamicBeanRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator) {
        String beanName = importingClassMetadata.getAnnotations()
                .get(EnableDynamicBean.class)
                .getString("value");
        final BeanDefinition dynamicBean = BeanDefinitionBuilder
                // root is needed for non-static methods
                // if you set factory method, then this class doesn't matter.
//                .rootBeanDefinition(BeanTemplate.class)
                .rootBeanDefinition(Object.class)
                .setFactoryMethodOnBean("createInstance", "dynamicBeanRegistrar")
                .setScope(SCOPE_PROTOTYPE)
                .addConstructorArgValue(beanName)
                .addDependsOn("testDependency")
                .addConstructorArgReference("testDependency")
                .getBeanDefinition();

        registry.registerBeanDefinition(beanName, dynamicBean);
    }


    BeanTemplate createInstance(String beanId, TestDependency testDependency) {
        return new BeanTemplate(beanId, testDependency);
    }

}
