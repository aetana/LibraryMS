package business;

import java.time.LocalDate;



public class CheckoutEntry {
	
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy bookCopy;
	private CheckoutRecord checkoutRecord;
	
	public CheckoutEntry(BookCopy bookCopy, LocalDate checkoutDate, LocalDate dueDate) {
		
		this.bookCopy=bookCopy;
		this.checkoutDate=checkoutDate;
		this.dueDate=dueDate;
		
		
	}

}
