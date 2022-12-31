package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tutorials_tbl")
public class Tutorial extends BaseEntity {
	@Column(name = "tut_name", unique = true, length = 100)
	private String tutName;
	@Column(name = "publish_date")
	private LocalDate publishDate;
	private int visits;
	@Column(length = 400)
	private String contents;
	// additional prop. to establish uni dir asso from Tut *--->1 Topic (eg : of
	// many -to-one)
	@ManyToOne(fetch = FetchType.LAZY) // MANDATORY --o.w hib throws MappingExc
	@JoinColumn(name = "topic_id", nullable = false) // OPTIONAL BUT Reco --specifies name of FK column + NOT NULL
														// constraint added --to avoid orphan recs in the child table
	private Topic selectedTopic;
	//Establish uni dir many-to-one association between User(under role of Author) 1<-----* Tutorial
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id",nullable = false) //same name is going to be generated by hib.
	private User author;

	public Tutorial() {
		// TODO Auto-generated constructor stub
	}

	public Tutorial(String tutName, LocalDate publishDate, int visits) {
		super();
		this.tutName = tutName;
		this.publishDate = publishDate;
		this.visits = visits;
		}

	public String getTutName() {
		return tutName;
	}

	public void setTutName(String tutName) {
		this.tutName = tutName;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Topic getSelectedTopic() {
		return selectedTopic;
	}

	public void setSelectedTopic(Topic selectedTopic) {
		this.selectedTopic = selectedTopic;
	}
	

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Tutorial ID " + getId() + " [tutName=" + tutName + ", publishDate=" + publishDate + ", visits=" + visits
				+ ", contents=" + contents + "]";
	}

}
