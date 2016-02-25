package com.upsmart;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Title:PersonServiceImpl.java <br>
 * Description:
 *
 * @author Wangming
 * @since 2016年2月23日
 */
@Service
public class PersonServiceImpl {

    /**
     * 数据源
     */
    private DataSource dataSource;
    /**
     * spring提供的jdbc操作辅助类
     */
    private JdbcTemplate jdbcTemplate;

    // 设置数据源
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int save(Person person) {
        int row = jdbcTemplate.update("insert into person(name,age,address)values(?,?,?)",
                new Object[] { person.getName(), person.getAge(), person.getAddress() }, new int[] {
                        java.sql.Types.VARCHAR, java.sql.Types.INTEGER, java.sql.Types.VARCHAR });
        return row;
    }

    public void update(Person person) {
        jdbcTemplate.update("update person set name=?,age=?,sex=? where id=?",
                new Object[] { person.getName(), person.getAge(), person.getAddress() }, new int[] {
                        java.sql.Types.VARCHAR, java.sql.Types.INTEGER, java.sql.Types.VARCHAR });

    }

    public Person getPerson(Integer id) {
        Person person = (Person) jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
                new int[] { java.sql.Types.INTEGER }, new PersonRowMapper());
        return person;

    }

    @SuppressWarnings("unchecked")
    public List<Person> getPerson() {
        List<Person> list = jdbcTemplate.query("select * from person", new PersonRowMapper());
        return list;

    }

    public void delete(Integer id) {
        jdbcTemplate.update("delete from person where id = ?", new Object[] { id },
                new int[] { java.sql.Types.INTEGER });

    }
}
