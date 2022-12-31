package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="topics_tbl")
public class Topic extends BaseEntity{
	@Column(name="topic_name",length = 30,unique = true)
	private String topicName;
	@Column(name="topic_desc",length = 100)
	private String description;
	public Topic() {
		// TODO Auto-generated constructor stub
	}
	public Topic(String topicName, String description) {
		super();
		this.topicName = topicName;
		this.description = description;
	}
	//getters n setters
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Topic ID "+getId()+" [topicName=" + topicName + ", description=" + description + "]";
	}
	
}
