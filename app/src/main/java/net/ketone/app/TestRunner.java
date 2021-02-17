package net.ketone.app;

import net.ketone.commons.template.BeanTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    private BeanTemplate dynamicBeanName;

    @Override
    public void run(String... args) {
        System.out.println(Optional.ofNullable(dynamicBeanName)
                .map(BeanTemplate::someCommonFunction)
                .orElse("NO BEAN"));
    }

}
