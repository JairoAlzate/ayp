package models;

public class Ticket{

	private User user;
	private Movie movie;
	
	public Ticket(User user, Movie movie){
		this.user = user;
		this.movie = movie;
	}

	public String getUser(){
		return user.getName();
	}
	@Override
	public String toString(){
		return "[" + getUser() + "," + movie + "]";
	}	
}
