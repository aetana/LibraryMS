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
		book.setCopy(Integer.parseInt(numOfCopies));
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
		LibraryMember member = data.searchMember(memberId);
		if(member == null)throw new CheckoutException("member with id "+ memberId+" not found");
		Book book = data.searchBook(isbn);
		if(book == null)throw new CheckoutException("book with ISBN "+ isbn+" not found");
		
		List<String[]> records = getMemberCheckoutEntries(memberId);
		if(book.isAvailable()) {
			for (String[] rec: records) {
	            if (memberId.equals(rec[0]) && isbn.equals(rec[1]))
	                throw new CheckoutException("Book ISBN " + rec[1] + " has been carried with the Member ID " + rec[0] + " before!");
	        }
			BookCopy bookCopy = book.getNextAvailableCopy();
			int checkoutLength= book.getMaxCheckoutLength();
			
			CheckoutEntry entry = new CheckoutEntry(bookCopy,LocalDate.now(),LocalDate.now().plusDays(checkoutLength));
			member.getCheckoutRecord().addCheckOutEntry(entry);
			data.updateMember(member);
			updateBook(book);
			
		}else {
			throw new CheckoutException("book with ISBN "+ isbn+" not avilable for checkout");
		}
	}
	
	public void updateBook(Book book) throws CheckoutException {
        DataAccess da = new DataAccessFacade();
        if (book == null) {
            throw new CheckoutException("Book is null");
        }
        da.updateBook(book);
    }
	
	public List<String[]> getMemberCheckoutEntries(String memberId) throws CheckoutException{
		DataAccess data= new DataAccessFacade();
		LibraryMember member = data.searchMember(memberId);
        if (member == null) {
            throw new CheckoutException("Member with with id '" + memberId + "' does not exist");
        }
        System.out.println("in get mebbere: "+ member.getCheckoutRecord());
        List<CheckoutEntry> checkoutBooks = new ArrayList<>();
        if(member.getCheckoutRecord() != null || member.getCheckoutRecord().getCheckoutRecordEntries() != null) {
        	 checkoutBooks = member.getCheckoutRecord().getCheckoutRecordEntries();
        }
        List<String[]> records = new ArrayList<>();
        //String pattern = "MM/dd/yyyy";
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        for (CheckoutEntry ch : checkoutBooks) {
            String[] recs = new String[]{
                    memberId,
                    ch.getBookCopy().getBook().getIsbn(),
                    Integer.toString(ch.getBookCopy().getCopyNum()),
                    ch.getCheckoutDate().toString(),
                    ch.getDueDate().toString(),
            };
//          System.out.println(Arrays.toString(recs) + " |||||||||||");
            records.add(recs);
        }
        return records;
    }

	public List<CheckoutEntry> checkOverdue(String isbn) throws OverdueException{
	    DataAccess data = new DataAccessFacade();
	    Book book = data.searchBook(isbn);
	    if(book==null)throw new OverdueException("book with ISBN "+ isbn+" not found");
	    List<CheckoutEntry> records = CheckoutRecord.getAllCheckoutRecordEntries();
	    List<String[]> strRecords = new ArrayList<>();
	    for(CheckoutEntry entry: records) {
	      System.out.println("entry :" + entry.isOverDue());
	      if(entry.isOverDue() && entry.getBookCopy().getBook().getIsbn() == isbn) {
	        records.add(entry);
	      }
	    }
	    return records;

	  }
//	public List<CheckoutRecord> displayCheckoutRecord(String memberId)throws CheckoutException{
//		DataAccess data= new DataAccessFacade();
//		LibraryMember member=data.searchMember(memberId);
//		if(member==null)throw new CheckoutException("member with id "+ memberId+" not found");
//		return member.getEntry();
//	}
//	
	
}
