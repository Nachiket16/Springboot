package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Tutorial;

@Repository
public class TutorialDaoImpl implements ITutorialDao {
	//dep : EntityMgr
	@Autowired
	private EntityManager mgr;

	@Override
	public List<Tutorial> findByTopicId(long topicId) {
		String jpql="select t from Tutorial t join t.selectedTopic tp where tp.id=:id";
		return mgr.createQuery(jpql, Tutorial.class).setParameter("id", topicId).getResultList();
	}

	@Override
	public Tutorial findByTutorialName(String tutName) {
		String jpql="select t from Tutorial t where t.tutName=:name";
		return mgr.createQuery(jpql, Tutorial.class).setParameter("name",tutName).getSingleResult();
	}

	@Override
	public String addNewTutorial(Tutorial newTut) {
		mgr.persist(newTut);
		return "New tutorial added successfully with ID : "+newTut.getId();
	}
	
	

}
