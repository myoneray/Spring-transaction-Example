package com.upsmart;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Title:MainTest.java <br>
 * Description:
 * <p>
 * 
 * @author Wangming
 * @since 2016年2月24日
 */
@Service
public class MainTest {

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        mainTest.test();
    }

    @Transactional(rollbackFor = { RuntimeException.class })
    public void test() {
        ApplicationContext mySqlContext = new ClassPathXmlApplicationContext("config/jpa.xml");
        ApplicationContext mongoContext = new ClassPathXmlApplicationContext("config/mongo.xml");

        PersonServiceImpl mySqlBean = (PersonServiceImpl) mySqlContext.getBean("personServiceImpl");
        PersonRepository mongoBean = (PersonRepository) mongoContext.getBean("personRepository");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Person person = new Person("Test", 18, dateFormat.format(new Date()));
        int row = mySqlBean.save(person);
        System.out.println("row>" + row);
        mongoBean.insert(person);
        throw new RuntimeException("Test");
    }
}
