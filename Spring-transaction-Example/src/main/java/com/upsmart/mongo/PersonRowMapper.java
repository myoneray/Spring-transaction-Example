package com.upsmart.mongo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.upsmart.Person;

public class PersonRowMapper implements RowMapper {
    public Object mapRow(ResultSet set, int index) throws SQLException {
        System.out.println("index:"+index);
        Person person = new Person(set.getInt("id"), set.getString("name"), set.getInt("age"), set.getString("address"));
        return person;
    }
}
