package rulesets;

import java.awt.Component;

import javax.swing.JPanel;

import librarysystem.FrameLogin;
import librarysystem.MainWindow;

public class AddBookRS implements RuleSet{
	private MainWindow addBookPanel;

	@Override
	public void applyRules(Component ob) throws RuleException {
		// TODO Auto-generated method stub
		addBookPanel = (MainWindow) ob;
		nonemptyRule();
		isbnNumericCharacterRule();
		numberOfCopiesNumericRule();
		
	}
	
	//1. All fields must be nonempty
	private void nonemptyRule() throws RuleException {
		if(addBookPanel.getTextAddBookISBN().trim().isEmpty() ||
				addBookPanel.getTextTitleValue().trim().isEmpty() ||
				addBookPanel.getTextCheckoutPeriodValue().trim().isEmpty() ||
				addBookPanel.getTextFNumberOfCopiesValue().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}


	//2. Isbn must be numeric and consist of either 10 or 13 characters
	//3. If Isbn has length 10, the first digit must be 0 or 1
	//4. If Isbn has length 13, the first 3 digits must be either 978 or 979
	private void isbnNumericCharacterRule() throws RuleException {
		String val = addBookPanel.getTextAddBookISBN().trim();
		try {
			Long.parseLong(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("ISBN must be numeric");
		}
		if(val.length() != 10 && val.length() != 13) throw new RuleException("ISBN must consist of either 10 or 13 characters");
		if(val.length() == 10 && (val.charAt(0) != 48 && val.charAt(0) != 49)) 
			throw new RuleException("If ISBN has length 10, the first digit must be 0 or 1");
			
		if(val.length() == 13 && (val.substring(0, 3).equals("978") || val.substring(0, 3).equals("979")))
			throw new RuleException("If ISBN has length 13, the first 3 digits must be either 978 or 979");
	}
	
	// numberOfCopiesNumericRule must be an integer
	private void numberOfCopiesNumericRule() throws RuleException {
		String val = addBookPanel.getTextFNumberOfCopiesValue().trim();
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("Price must be an Integer number!");
		}
		
	}
	
	

}
