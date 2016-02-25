package com.upsmart.mongo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.upsmart.Person;

public class MongoTest {

    private PersonRepository pr = null;

    public void init() {
        System.out.println("开始启动");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/mongo.xml");
        pr = (PersonRepository) ctx.getBean("personRepository");
    }

    public void insert() {
        Person p = new Person("Wangming", 18, "上海市浦东新区");
        pr.insert(p);
        System.out.println("添加完成");
    }

    public void start() {
        init();
        insert();
    }

    public static void main(String[] args) {
        MongoTest t = new MongoTest();
        t.start();
    }

}
