/**
 * 
 */
package com.ems.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.WriteResultChecking;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author sachin.srivastava
 * Mongo DAO layer would be acting interface of DB interaction
 */
@Repository
public class MongoDAO {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public <T> T findOne(Query query, Class<T> entityClass) {
		return mongoTemplate.findOne(query, entityClass);
	}

	public <T> void insert(T obj) {
		mongoTemplate.insert(obj);
	}

	public <T> void save(T obj) {
		mongoTemplate.save(obj);
	}
	public <T> void delete(Query query , Class<T> entityClass)  {
		mongoTemplate.findAndRemove(query, entityClass);
	}
	public <T> List<T> findAll(Class<T> entityClass) {
		return mongoTemplate.findAll(entityClass);
	}
	public <T> List<T> find(Query query , Class<T> entityClass){
		return mongoTemplate.find(query, entityClass);
	}
}
