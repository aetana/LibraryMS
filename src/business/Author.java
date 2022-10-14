package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final public class Author extends Person implements Serializable {
	private String bio;
	public static List<Author> aut = new ArrayList<>();
	public String getBio() {
		return bio;
	}
	
	public Author(String f, String l, String t, Address a, String bio) {
		super(f, l, t, a);
		this.bio = bio;
	}
	
	public static List<Author> getAuthors(){
		Address addr = new Address("N4th Street", "Fairfield", "IA", "52667");
		Author aut1 = new Author("Ted", "Laso", "1234567891", addr, "It is what It is");
		Author aut2 = new Author("Robert", "Kiyosaki", "1234567891", addr, "It is what It is");
		Author aut3 = new Author("Pablo", "Picaso", "1234567891", addr, "It is what It is");
		
		aut.addAll(Arrays.asList(aut1, aut2, aut3));
		return aut;
	}
	public String toString() {
		return this.getFirstName() +" "+ this.getLastName();
	}


	private static final long serialVersionUID = 7508481940058530471L;
}
