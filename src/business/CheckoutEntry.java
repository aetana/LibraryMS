package business;

import java.io.Serializable;
import java.time.LocalDate;



public class CheckoutEntry implements Serializable{
	
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy bookCopy;
	
	public CheckoutEntry(BookCopy bookCopy, LocalDate checkoutDate, LocalDate dueDate) {
		
		this.bookCopy=bookCopy;
		this.checkoutDate=checkoutDate;
		this.dueDate=dueDate;	
		
	}
	
	public boolean isOverDue() {
	    return LocalDate.now().isAfter(dueDate);
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}
	private static final long serialVersionUID = -1222297306790745013L;

}
