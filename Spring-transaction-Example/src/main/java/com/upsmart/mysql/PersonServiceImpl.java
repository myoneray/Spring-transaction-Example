package com.upsmart.mysql;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upsmart.Person;
import com.upsmart.mongo.PersonRowMapper;

/**
 * Title:PersonServiceImpl.java <br>
 * Description:
 *
 * @author Wangming
 * @since 2016年2月23日
 */
@Service
public class PersonServiceImpl {
    Logger logger = Logger.getLogger(PersonServiceImpl.class);
    /**
     * 数据源
     */
    private DataSource dataSource;
    /**
     * spring提供的jdbc操作辅助类
     */
    public JdbcTemplate jdbcTemplate;

    // 设置数据源
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public PersonServiceImpl(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public PersonServiceImpl() {
        super();
    }

    @Transactional
    public void save(Person person) {
        jdbcTemplate.update("insert into person(name,age,address)values(?,?,?)", new Object[] { person.getName(),
                person.getAge(), person.getAddress() }, new int[] { java.sql.Types.VARCHAR, java.sql.Types.INTEGER,
                java.sql.Types.VARCHAR });
    }

    @Transactional
    public void saveExecute(Person person) {
        logger.debug(person);
        jdbcTemplate.execute("insert into person(name,age,address)values('" + person.getName() + "'," + person.getAge()
                + ",'" + person.getAddress() + "')");
    }

    @Transactional
    public void update(Person person) {
        // logger.debug(person);
        int row = jdbcTemplate.update("update person set name= ?,age= ?,address= ? where name= ?", new Object[] {
                person.getName(), person.getAge(), person.getAddress(), person.getName() }, new int[] {
                java.sql.Types.VARCHAR, java.sql.Types.INTEGER, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR });

    }

    @Transactional(readOnly = true)
    public Person getPerson(Integer id) {
        logger.debug(id);
        Person person = (Person) jdbcTemplate.queryForObject("select * from person where id= ?", new Object[] { id },
                new int[] { java.sql.Types.INTEGER }, new PersonRowMapper());
        return person;

    }

    @SuppressWarnings("unchecked")
    public List<Person> getPerson() {
        logger.debug("getPerson");
        List<Person> list = jdbcTemplate.query("select * from person", new PersonRowMapper());
        return list;

    }

    @Transactional
    public void delete(Person person) {
        jdbcTemplate.update("delete from person where id = ?", new Object[] { person.getId() },
                new int[] { java.sql.Types.INTEGER });

    }
}
