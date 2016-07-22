package models;

import java.util.Scanner;

public class Cinema{

	private User[] userList;
	private Ticket[] ticketList;
	private Movie[] movieList;
	private Scanner scanner;
	private Scanner sc;
	private Document document;
	private boolean b;

	public static final int MAX_NUMBER_USER = 10;
	public static final int MAX_NUMBER_TICKET = 10;
	public static final int MAX_NUMBER_MOVIE = 10;

	public Cinema(){
		userList = new User[MAX_NUMBER_USER];
		ticketList = new Ticket[MAX_NUMBER_TICKET];
		movieList = new Movie[MAX_NUMBER_MOVIE];
		scanner = new Scanner(System.in);
		b = true;
	}

	public void getMain(){
		while (b) {
			System.out.println("Hello welcome to cinemax . You want to do?");
			System.out.println("[1] User \n[2] Movie \n[3] Ticket \n[4] Exit");
			int answerOne = scanner.nextInt();
			switch (answerOne) {
				case 1:
					getMainUser();
					break;
				case 2:
					getMainMovie();
					break;
				case 3:
					getMainTicket();
					break;
				case 4:
					System.out.println("OK. Bye");
					return;
				default:
					System.out.println("Enter a correct number");
			}
		}	
	}

	public void getMainUser(){
		while (b) {
			System.out.println("You want to do?");
			System.out.println("[1] Add User \n[2] Delete User \n[3] Print user \n[4] Search user for age \n[5] Exit");
			int gh = scanner.nextInt();
			switch (gh) {
				case 1:
					addUser();
					break;
				case 2:
					deleteUser();
					break;
				case 3:
					printUser();
					break;
				case 4:
					searchUserForAge();
					break;
				case 5:
					return;
				default:
					System.out.println("Enter a correct number");
			}
		}			
	}

	public void getMainMovie(){
		System.out.println();
		while (b) {
			System.out.println("You want to do?");
			System.out.println("[1] Add Movie \n[2] Delete Movie \n[3] Print movie \n[4] Search movie for category \n[5] Exit");
			int y = scanner.nextInt();
			switch (y) {
				case 1:
					addMovie();
					break;
				case 2:
					deleteMovie();
					break;
				case 3:
					printMovie();
					break;
				case 4:
					searchMovieForCategory();
					break;
				case 5:
					return;
				default:
					System.out.println("Enter a correct number");
			}
		}
	}

	public void getMainTicket(){	
		while (b) {
			System.out.println("You want to do");
			System.out.println("[1] Add Ticket \n[2] Delete Ticket \n[3] Print Ticket \n[4] Exit");
			int h = scanner.nextInt();
			switch (h) {
				case 1:
					addTicket();
					break;
				case 2:
					deleteTicket();
					break;
				case 3:
					printTicket();
					break;
				case 4:
					return;
				default:
					System.out.println("Enter a correct number");
			}
		}
	}

	public void addUser(){
		System.out.println("Now enter your name");
		String n = scanner.next();
		System.out.println("Now enter your age");
		int a = scanner.nextInt();
		Document g = getDocument();
		for (int i = 0; i < userList.length; i++) {
			if (userList[i] == null) {
				userList[i] = new User(n, a, g);
				System.out.println("OK. User registred");
				return;
			}
		}
		System.out.println("Collection is full :/");
	}

	public Document getDocument(){
		Document option = null;
		System.out.println("Now enter your Document according to the number");
		System.out.println("[1] IDENTITY_CARD \n[2] ID_INDENTY \n[3] FOREING");
		int f = scanner.nextInt();
		switch (f) {
			case 1:
				option = Document.valueOf("IDENTITY_CARD");
				break;
			case 2:
				option = Document.valueOf("ID_INDENTY");
				break;
			case 3:
				option = Document.valueOf("FOREING");
				break;
			default:
				System.out.println("Enter a correct number");
		}
		return option;
	}

	public void deleteUser(){
		System.out.println("Enter the position in which the user is desired");
		printUser();
		int position = scanner.nextInt();
		if (userList[position - 1 ] != null) {
			userList[position - 1] = null;
			System.out.println("Ok. user delete");
		}else{
			System.out.println("This position is empty.");
		}
	}

	public void printUser(){
		for (User user: userList) {
			if (user != null ) {
				System.out.println(user);
			}else{
				System.out.println("---");
			}
		}
	}

	public void searchUserForAge(){
		System.out.println("Enter the desired age");
		int ag = scanner.nextInt();
		for (User user: userList) {
			if (user != null ) {
				if (user.getAge() == ag) {
					System.out.println(user);
				}else{
					System.out.println("We are sorry. Not exist user with " + ag + " age.");
				}
			}
		}
	}

	public void addMovie(){
		System.out.println("Now enter the name of the movie");
		String n = scanner.next();
		Category g = getCategory();
		for (int i = 0; i < movieList.length; i++) {
			if (movieList[i] == null) {
				movieList[i] = new Movie(n, g);
				System.out.println("OK. movie registred");
				return;
			}
		}
		System.out.println("Collection is full :/");
	}

	public Category getCategory(){
		scanner = new Scanner(System.in);
		Category option = null;
		System.out.println("Now enter the category according to the number");
		System.out.println("[1] ACTION \n[2] HORROR \n[3] ADVENTURE \n[4] FUTURISTIC \n[5] FUNNY \n[6] OTHER");
		int f = scanner.nextInt();
		switch (f) {
			case 1:
				option = Category.valueOf("ACTION");
				break;
			case 2:
				option = Category.valueOf("HORROR");
				break;
			case 3:
				option = Category.valueOf("ADVENTURE");
				break;
			case 4:
				option = Category.valueOf("FUTURISTIC");
				break;
			case 5:
				option = Category.valueOf("FUNNY");
				break;
			case 6:
				option = Category.valueOf("OTHER");
			default:
				System.out.println("Enter a correct number");
		}
		return option;
	}

	public void deleteMovie(){
		System.out.println("Enter the position in which the movie is desired");
		printMovie();
		int position = scanner.nextInt();
		if (movieList[position - 1 ] != null) {
			movieList[position - 1] = null;
			System.out.println("Ok. movie delete");
		}else{
			System.out.println("This position is empty.");
		}
	}

	public void printMovie(){
		for (Movie movie: movieList) {
			if (movie != null ) {
				System.out.println(movie);
			}else{
				System.out.println("---");
			}
		}
	}

	public void searchMovieForCategory(){
		System.out.println("Enter the desired Category");
		String ag = scanner.next();
		for (Movie movie: movieList) {
			if (movie != null) {
				if (movie.getCategory() == Category.valueOf(ag)) {
					System.out.println(movie);
				}
			}
		}
	}

	public void addTicket(){
		User g = checkUser();
		Movie u = checkMovie();
		for (int i = 0; i < userList.length; i++) {
			if (ticketList[i] == null) {
				ticketList[i] = new Ticket(g, u);
				System.out.println("OK. Ticket registred");
				return;	
			}
		}
		System.out.println("Collection is full :/");
	}

	public User checkUser(){
		System.out.println("Now enter your user");
		String n = scanner.next();
		for (User user: userList) {
			if (user.getName().equals(n)) {
				return user;
			}
		}
		System.out.println("The user not exist");
		return null;
	}

	public Movie checkMovie(){
		sc = new Scanner(System.in);
		System.out.println("Now enter the movie");
		String n = sc.next();
		for (Movie movie: movieList) {
			if (movie.getName().equals(n)) {
				return movie;
			}
		}
		System.out.println("The Movie not exist");
		return null;
	}

	public void printTicket(){
		for (Ticket ticket: ticketList) {
			if (ticket != null ) {
				System.out.println(ticket);
			}else{
				System.out.println("---");
			}
		}
	}

	public void deleteTicket(){
		System.out.println("Enter the position in which the Ticket is desired");
		printTicket();
		int position = scanner.nextInt();
		if (ticketList[position - 1 ] != null) {
			ticketList[position - 1] = null;
			System.out.println("Ok. movie delete");
		}else{
			System.out.println("This position is empty.");
		}
	}

	public static void main(String[] args) {
		Cinema t = new Cinema();
		t.getMain();
	}
}
