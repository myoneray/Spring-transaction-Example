package com.upsmart.mysql;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.upsmart.Person;

/**
 * Title:MysqlTest.java <br>
 * Description:
 *
 * @author Wangming
 * @since 2016年2月23日
 */
public class MysqlTest {
    public static Logger logger = Logger.getLogger(MysqlTest.class);
    public static ApplicationContext context = new ClassPathXmlApplicationContext("config/jpa.xml");
    public static PersonServiceImpl personService = (PersonServiceImpl) context.getBean("personServiceImpl");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

    /**
     * readOnly = true测试
     * <p>
     * 条件:为当save&getPerson&update&delete方法添加@Transactional <br>
     * 结果:两者皆操作成功!
     * <p>
     * 条件:为当save&getPerson&update&delete方法添加@Transactional(readOnly = true)<br>
     * 结果:getPerson成功,其他失败!
     * 
     * @throws Exception
     */
    @Test
    public void doReadOnly() throws Exception {
        // 添加
        Person savePerson = new Person("Test003", 18, dateFormat.format(new Date()));
        personService.save(savePerson);
        // Execute添加
        // personService.saveExecute(savePerson);
        // 查询
        Person getPerson = personService.getPerson(74);
        logger.info(getPerson.toString());
        // 修改
        Person updatePerson = new Person("Test001", 11, "北京");
        personService.update(updatePerson);
        // 删除
        Person deletePerson = new Person(55);
        personService.delete(deletePerson);
    }
}
