package com.upsmart;

import java.util.List;

/**
 * Title:PersonService.java <br>
 * Description:PersonService
 *
 * @author Wangming
 * @since 2016年2月23日
 */
public interface PersonService {

    /**
     * 保存Person
     * 
     * @param person
     */
    public abstract void save(Person person);

    /**
     * 更新Person
     * 
     * @param person
     */
    public abstract void update(Person person);

    /**
     * 获取Person
     * 
     * @param id
     * @return
     */
    public abstract Person getPerson(Integer id);

    /**
     * 获取所有Person
     * 
     * @return
     */
    public abstract List<Person> getPerson();

    /**
     * 删除指定id的Person
     * 
     * @param id
     */
    public abstract void delete(Integer id);

}
