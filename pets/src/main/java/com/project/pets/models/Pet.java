package com.project.pets.models;


import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pet{
	@Id
	@GeneratedValue
	private long id;

	// Member variables and annotations go here.
	@Size(min=1, max =200, message="You need a name")
	private String Name;
	@Size(min=1, max =200, message="You need a species")
	private String species;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	// @DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	// private Date createdAt;
	
	// @DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	// private Date updatedAt;

	// @PrePersist
	// public void onCreate(){this.createdAt = new Date();}
	// @PreUpdate
	// public void onUpdate(){this.updatedAt = new Date();}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	// public Date getCreatedAt() {
	// 	return createdAt;
	// }
	// public void setCreatedAt(Date createdAt) {
	// 	this.createdAt = createdAt;
	// }
	// public Date getUpdatedAt() {
	// 	return updatedAt;
	// }
	// public void setUpdatedAt(Date updatedAt) {
	// 	this.updatedAt = updatedAt;
	// }
	
	// Setters and Getters go here
	
	public Pet(){

	}
	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}
	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.Name = name;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
