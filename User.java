package models;

public class User{

	private String name;
	private int age;
	private Document document;
	
	public User(String name, int age, Document document){
		this.name = name;
		this.age = age;
		this.document = document;
	}

	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}

	public Document getDocument(){
		return document;
	}

	@Override
	public String toString(){
		return "[" + name + "," + age + "," + document + "]";
	}	
}
