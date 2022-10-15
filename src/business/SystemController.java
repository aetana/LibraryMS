package business;

import java.time.LocalDate;
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
	public List<LibraryMember> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<LibraryMember> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().values());
		return retval;
	}
	
	@Override
	public List<Book> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<Book> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().values());
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
	
	public void addBook(String isbn, String title, String checkoutPeriod, String numOfCopies, List<Author> authors) throws BookException{
		DataAccess da = new DataAccessFacade();
		Book book = da.searchBook(isbn);
		if(book != null) throw new BookException("Book Already Exists, Please add copy instead");

		Book newBook = new Book(isbn, title, Integer.parseInt(checkoutPeriod), authors);
		newBook.setCopy(Integer.parseInt(numOfCopies));
		da.saveNewBook(newBook);
		System.out.println("book: "+ newBook.getNumCopies());
	}
	 
	public void checkoutBook(String memberId,String isbn) throws CheckoutException{
		
		DataAccess data= new DataAccessFacade();
		LibraryMember member=data.searchMember(memberId);
		if(member==null)throw new CheckoutException("member with id "+ memberId+" not found");
		Book book = data.searchBook(isbn);
		if(book==null)throw new CheckoutException("book with ISBN "+ isbn+" not found");
		if(book.isAvailable()) {
			BookCopy bookCopy = book.getNextAvailableCopy();
			int checkoutLength= book.getMaxCheckoutLength();
			member.checkout(bookCopy,LocalDate.now(),LocalDate.now().plusDays(checkoutLength));
			data.saveMember(member);
			data.saveBook(book);
			
		}else {
			throw new CheckoutException("book with ISBN "+ isbn+" not avilable for checkout");
		}
	}
	
	public List<CheckoutRecord> displayCheckoutRecord(String memberId)throws CheckoutException{
		DataAccess data= new DataAccessFacade();
		LibraryMember member=data.searchMember(memberId);
		if(member==null)throw new CheckoutException("member with id "+ memberId+" not found");
		return member.getEntry();
	}
	
	
}
