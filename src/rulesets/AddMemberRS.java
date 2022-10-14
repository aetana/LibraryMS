package rulesets;

import java.awt.Component;

import business.LoginException;
import librarysystem.MainWindow;


public class AddMemberRS implements RuleSet{

	private MainWindow mainWin;

	@Override
	public void applyRules(Component ob) throws RuleException, LoginException {
		
		mainWin = (MainWindow) ob;
		nonemptyRule();
		telephoneNumericRule();
		zipNumericRule();
		stateRule();
	}

	private void nonemptyRule() throws RuleException {
		if(mainWin. getTextFirstNameValue().trim().isEmpty() ||
				mainWin.getTextLastNameValue().trim().isEmpty() ||
				mainWin.getTextTelephoneValue().trim().isEmpty() ||
				mainWin.getTextStreetValue().trim().isEmpty() ||
				mainWin.getTextCityValue().trim().isEmpty() ||
				mainWin.getTextStateValue().trim().isEmpty() ||
				mainWin.getTextZipValue().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}

	private void telephoneNumericRule() throws RuleException {
		String val = mainWin.getTextTelephoneValue().trim();
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("ID must be numeric");
		}
		if(val.length() != 10) throw new RuleException("Telephone must have 10 digits");
	}

	private void zipNumericRule() throws RuleException {
		String val = mainWin.getTextZipValue().trim();
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("Zipcode must be numeric");
		}
		if(val.length() != 5) throw new RuleException("Zipcode must have 5 digits");
	}

	private void stateRule() throws RuleException {
		String state = mainWin.getTextStateValue().trim();
		if(state.length() != 2) throw new RuleException("State field must have two characters");
		if(!Util.isInRangeAtoZ(state.charAt(0)) 
				|| !Util.isInRangeAtoZ(state.charAt(1))) {
			throw new RuleException("Characters is state field must be in range A-Z");
		}
	}

}
