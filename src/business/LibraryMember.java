package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

final public class LibraryMember extends Person implements Serializable {
	private String memberId;
	private List<CheckoutRecord> checkoutRecords =new ArrayList<>();
	
	public LibraryMember(String memberId, String fname, String lname, String tel,Address add) {
		super(fname,lname, tel, add);
		this.memberId = memberId;		
	}
	
	public void checkout(BookCopy bookCopy,LocalDate checkoutDate,LocalDate dueDate) {
		
		bookCopy.setAvailablity(false);
		CheckoutEntry checkoutEntry= new CheckoutEntry(bookCopy,checkoutDate,dueDate);
		CheckoutRecord checkoutRecord= new CheckoutRecord(checkoutEntry);
		checkoutRecords.add(checkoutRecord);
	}
	
	public List<CheckoutRecord> getEntry(){
		
		return this.checkoutRecords;
	}
	public String getMemberId() {
		return memberId;
	}

	
	
	@Override
	public String toString() {
		return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() + 
				", " + getTelephone() + " " + getAddress();
	}
	
	public String[] toStringArray() {
		return new String[] {getMemberId(), getFirstName(),getLastName(),getTelephone()+""};
	}

	private static final long serialVersionUID = -2226197306790714013L;
}
