package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BLOG")


public class Blog{
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator= "seq_blog")
	@SequenceGenerator(name="seq_blog", sequenceName="seq_blog",allocationSize=1,initialValue=1) 
	private int Id;
	@Column(name="TITLE")
	private String Title;
	@Column(name="DESCRIPTION")
	private String blogDescription;
	@Column(name="POSTEDON")
	private LocalDate postedOn;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}
	public LocalDate getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(LocalDate postedOn) {
		this.postedOn = postedOn;
	}
	
	
	
}