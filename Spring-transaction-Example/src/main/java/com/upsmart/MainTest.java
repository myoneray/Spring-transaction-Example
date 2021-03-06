package com.upsmart;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.upsmart.mongo.PersonRepository;
import com.upsmart.mysql.PersonServiceImpl;

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

    public void test() {
        ApplicationContext mySqlContext = new ClassPathXmlApplicationContext("config/jpa.xml");
        ApplicationContext mongoContext = new ClassPathXmlApplicationContext("config/mongo.xml");

        PersonServiceImpl mySqlBean = (PersonServiceImpl) mySqlContext.getBean("personServiceImpl");
        PersonRepository mongoBean = (PersonRepository) mongoContext.getBean("personRepository");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Person person = new Person("Test", 18, dateFormat.format(new Date()));
        mongoBean.insert(person);
        mySqlBean.save(person);

    }
}
