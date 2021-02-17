package net.ketone.commons.template;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BeanTemplate {

    private final String beanId;

    private final TestDependency testDependency;

    public String someCommonFunction() {
        System.out.println("Welcome to the common routine");
        return beanId;
    }
}