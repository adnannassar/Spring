package com.adnan.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// annotate the class as an Entity and map to db table
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	// defile the fields & annotate the fields with db column names
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "youtube_channel")
	private String youtubeChannel;

	@Column(name = "hobby")
	private String hobby;
	
	
	//@OneToOne(mappedBy = "instructorDetail" , cascade = CascadeType.ALL)
	// if we would like to delete the InstructorDetail without deleting the Instructor then :
	// select every CascadeType except the REMOVE
	@OneToOne(mappedBy = "instructorDetail" , cascade = {CascadeType.DETACH
														,CascadeType.MERGE
														,CascadeType.PERSIST
														,CascadeType.REFRESH})
	private Instructor instructor;
	
	// create constructors
	public InstructorDetail() {
	}
	
	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	
	// generate getters & setters methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	
	// generate toString method
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
	
	
}
