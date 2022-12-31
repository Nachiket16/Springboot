package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Topic;

@Repository
@Transactional // MUST add @Transactional : on dao layer , in the absence of service layer
public class TopicDaoImpl implements ITopicDao {
	// dep : EntityMgr
	// @PersistenceContext : JPA
	@Autowired
	private EntityManager mgr;

	@Override
	public List<Topic> getAllTopics() {
		String jpql = "select t from Topic t";
		return mgr.createQuery(jpql, Topic.class).getResultList();
	}

}
