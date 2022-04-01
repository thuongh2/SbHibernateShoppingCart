package com.example.sbhibernateshoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.core.env.Environment;


@SpringBootApplication
public class SbHibernateShoppingCartApplication {
    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(SbHibernateShoppingCartApplication.class, args);
    }

}
