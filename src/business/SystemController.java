package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
	
	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		for(User u:map.values()) {
			System.out.println(u.getId() +"  "+u.getPassword()+ " "+u.getAuthorization());
		}
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();
		
	}
	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}
	
	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}
	
	public void addMember (String fname, String lname, String telephone, String street, String city, String state, String zip) throws AddMemberException{
		DataAccess da = new DataAccessFacade();
		Address address = new Address(street, city, state, zip);
		String memberId = (int)(Math.random()*1000)+"";		
		LibraryMember member = new LibraryMember(memberId, fname, lname, telephone, address);
		da.saveNewMember(member);
	}
	
	public void addBookCopy(String isbn, String numOfCopies) throws BookException{
		DataAccess da = new DataAccessFacade();
		Book book = da.searchBook(isbn);
		if(book == null) throw new BookException("Book Not Found!");
		book.addCopy();
		da.saveBookCopy(book);
		System.out.println("book: "+ book.getNumCopies());
	}
	
	
}
