package org.example.restaurants;

import org.example.restaurants.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    private static ApplicationContext appct = new ClassPathXmlApplicationContext("spring/spring-app.xml");

    public static void main(String[] args) {
        User user = (User)appct.getBean("user");
        System.out.println(user);
    }
}
