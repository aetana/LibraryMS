package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable {
    public List<CheckoutEntry> checkoutRecordEntries = new ArrayList<>();

    CheckoutRecord() {
    }

    public void addCheckOutEntry(CheckoutEntry checkoutRecordEntry) {
    	//checkoutRecordEntries = new ArrayList<>();
    	//checkoutRecordEntries.add(new CheckoutEntry(new BookCopy(new Book("1234567891", "1234567891", 7, Author.getAuthors()), 2, false), LocalDate.now(), LocalDate.now()));
        checkoutRecordEntries.add(checkoutRecordEntry);
    }
/*
    public static List<CheckoutEntry> getAllCheckoutRecordEntries(){
    	
    }
   */ 
    public List<CheckoutEntry> getCheckoutRecordEntries() {
    	if(checkoutRecordEntries == null) 
    	{
    		checkoutRecordEntries = new ArrayList<>();
    		checkoutRecordEntries.add(new CheckoutEntry(new BookCopy(new Book("1234567891", "1234567891", 7, Author.getAuthors()), 2, false), LocalDate.now().minusDays(4), LocalDate.now().minusDays(2)));
    	}  
    	return checkoutRecordEntries;
    }

    private static final long serialVersionUID = -2222297306790745013L;
}