package com.upsmart.mongo;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upsmart.Person;

@Service
public class PersonRepository implements AbstractRepository {

    private MongoTemplate mongoTemplate;

    /*
     * (non-Javadoc)
     * 
     * @see com.mongo.dao.AbstractRepository#insert(com.mongo.bean.Person)
     */
    public void insert(Person person) {
        // TODO Auto-generated method stub
        getMongoTemplate().insert(person);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mongo.dao.AbstractRepository#findAll()
     */

    public List<Person> findAll() {
        // TODO Auto-generated method stub
        return getMongoTemplate().find(new Query(), Person.class);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mongo.dao.AbstractRepository#findAndModify(java.lang.String)
     */

    public void findAndModify(String id) {
        // TODO Auto-generated method stub
        // new Query(Criteria.where("id").is(id)), new Update().inc("age", 3)

        // getMongoTemplate().updateFirst(new
        // Query(Criteria.where("id").is(id)), new Update().inc("age", 3));

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mongo.dao.AbstractRepository#findByRegex(java.lang.String)
     */

    public List<Person> findByRegex(String regex) {
        // TODO Auto-generated method stub
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Criteria criteria = new Criteria("name").regex(pattern.toString());
        return getMongoTemplate().find(new Query(criteria), Person.class);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mongo.dao.AbstractRepository#findOne(java.lang.String)
     */
    public Person findOne(String id) {
        // TODO Auto-generated method stub
        return getMongoTemplate().findOne(new Query(Criteria.where("id").is(id)), Person.class);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mongo.dao.AbstractRepository#removeAll()
     */

    public void removeAll() {
        // TODO Auto-generated method stub
        List<Person> list = this.findAll();
        if (list != null) {
            for (Person person : list) {
                getMongoTemplate().remove(person);
            }
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mongo.dao.AbstractRepository#removeOne(java.lang.String)
     */
    public void removeOne(String id) {
        // TODO Auto-generated method stub
        Criteria criteria = Criteria.where("id").in(id);
        if (criteria == null) {
            Query query = new Query(criteria);
            if (query != null && getMongoTemplate().findOne(query, Person.class) != null)
                getMongoTemplate().remove(getMongoTemplate().findOne(query, Person.class));
        }

    }

    /**
     * @return the mongoTemplate
     */
    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    /**
     * @param mongoTemplate the mongoTemplate to set
     */
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

}
