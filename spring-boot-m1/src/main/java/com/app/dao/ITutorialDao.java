package com.app.dao;

import java.util.List;

import com.app.pojos.Tutorial;

public interface ITutorialDao {
//add a method to get all tutorial for specified topic id
	List<Tutorial> findByTopicId(long topicId);
	//add a method to get tutorial's (updated visit count wise)  detailt
	Tutorial findByTutorialName(String tutName);
	//under admin role , add a method to insert new tut contents
	String addNewTutorial(Tutorial newTut);
	
}
