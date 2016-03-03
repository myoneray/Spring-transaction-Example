package com.upsmart;

/**
 * Title:Persion.java <br>
 * Description:Persion
 *
 * @author Wangming
 * @since 2016年2月23日
 */
public class Person {

    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private String department;

    /**
     * 获取id
     * 
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     * 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取department
     * 
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置department
     * 
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    public Person(Integer id, String name, Integer age, String address, String department) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.department = department;
    }

    public Person(Integer id) {
        super();
        this.id = id;
    }

    public Person(Integer id, String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person() {
        super();
    }

    /**
     * 获取name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取age
     * 
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置age
     * 
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取address
     * 
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置address
     * 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", department="
                + department + "]";
    }

}
