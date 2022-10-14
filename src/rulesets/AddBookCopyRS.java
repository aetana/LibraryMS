package rulesets;

import java.awt.Component;

import librarysystem.MainWindow;

public class AddBookCopyRS implements RuleSet {
	
	private MainWindow mainWin;

	@Override
	public void applyRules(Component ob) throws RuleException {
		// TODO Auto-generated method stub
		mainWin = (MainWindow) ob;
		nonemptyRule();
		isbnNumericCharacterRule();
		numberOfCopiesNumericRule();
		
	}
	
	//1. All fields must be nonempty
		private void nonemptyRule() throws RuleException {
			if(mainWin.getTextAddCopyISBNValue().trim().isEmpty() ||
					mainWin.getTextbNumOfCopyValue().trim().isEmpty()) {
				throw new RuleException("All fields must be non-empty!");
			}
		}
		
		//2. Isbn must be numeric and consist of either 10 or 13 characters
		//3. If Isbn has length 10, the first digit must be 0 or 1
		//4. If Isbn has length 13, the first 3 digits must be either 978 or 979
		private void isbnNumericCharacterRule() throws RuleException {
			String val = mainWin.getTextAddCopyISBNValue().trim();
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
			String val = mainWin.getTextbNumOfCopyValue().trim();
			try {
				Integer.parseInt(val);
				//val is numeric
			} catch(NumberFormatException e) {
				throw new RuleException("Price must be an Integer number!");
			}
			
		}

}
