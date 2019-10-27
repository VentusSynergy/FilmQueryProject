package com.skilldistillery.filmquery.entities;


public class Actor {
	private int id;
	private String firstName;
	private String lastName;
	
	public Actor findActorById(int actorId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Actor(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Actor: " + firstName + " " + lastName;
	}
	
	
	


}
