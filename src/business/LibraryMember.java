package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


final public class LibraryMember extends Person implements Serializable {
	private String memberId;
	private CheckoutRecord checkoutRecord;
//	{
//		checkoutRecord = new CheckoutRecord();
//	}
	
	public LibraryMember(String memberId, String fname, String lname, String tel,Address add) {
		super(fname,lname, tel, add);
		this.memberId = memberId;
		checkoutRecord = new CheckoutRecord();
	}
	
	public CheckoutRecord getCheckoutRecord(){
		if(checkoutRecord == null) checkoutRecord = new CheckoutRecord();
		return checkoutRecord;
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
