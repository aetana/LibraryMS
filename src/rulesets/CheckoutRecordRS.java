package rulesets;

import java.awt.Component;

import librarysystem.MainWindow;

public class CheckoutRecordRS implements RuleSet{
	private MainWindow mainWin;

	@Override
	public void applyRules(Component ob) throws RuleException {
		// TODO Auto-generated method stub
		mainWin = (MainWindow) ob;
		nonemptyRule();
		idNumericRule();
		
	}
	
	//1. All fields must be nonempty
	private void nonemptyRule() throws RuleException {
		if(mainWin.getTextCheckoutRecordMemberID().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}

	
	// MemberID must be numeric
	private void idNumericRule() throws RuleException {
		String val = mainWin.getTextCheckoutRecordMemberID().trim();
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("MemberID must be numeric");
		}
		
		
	}
	
}
