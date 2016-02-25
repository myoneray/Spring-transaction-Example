package com.upsmart.mongo;

import java.util.List;

import com.upsmart.Person;

/**
 * Title:AbstractRepository.java <br>
 * Description:
 *
 * @author Wangming
 * @since 2016年2月23日
 */
public interface AbstractRepository {

    public void insert(Person person);

    public Person findOne(String id);

    public List<Person> findAll();

    public List<Person> findByRegex(String regex);

    public void removeOne(String id);

    public void removeAll();

    public void findAndModify(String id);
}
