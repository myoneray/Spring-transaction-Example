package com.upsmart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title:MysqlTest.java <br>
 * Description:
 *
 * @author Wangming
 * @since 2016年2月23日
 */
public class MysqlTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/jpa.xml");
        PersonServiceImpl personService = (PersonServiceImpl) context.getBean("personServiceImpl");
        Person person = new Person();
        person.setAddress("shanghai");
        person.setName("wangmingTest");
        person.setAge(18);
        // 保存一条记录
        System.out.println(personService.save(person));
    }

}
