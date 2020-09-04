package org.example.restaurants;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManagerFactory;

public class SpringMain {
    private static ApplicationContext appct = new ClassPathXmlApplicationContext("spring/spring-db.xml");

    public static void main(String[] args) {
        EntityManagerFactory emf = (EntityManagerFactory) appct.getBean("entityManagerFactory");
    }
}
