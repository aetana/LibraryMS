package rulesets;

import java.awt.Component;

import business.ControllerInterface;
import business.SystemController;
import librarysystem.FrameLogin;
import librarysystem.MainWindow;
import librarysystem.Util;
import business.LoginException;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class FrameLoginRS implements RuleSet {
	ControllerInterface ci = new SystemController();
	
	private FrameLogin loginWin;
	
	@Override
	public void applyRules(Component ob) throws RuleException, LoginException {
		// TODO Auto-generated method stub
		loginWin = (FrameLogin) ob;
		nonemptyRule();
		isUserRegistered();
	}
	
	// 1. All fields must be nonempty 
	private void nonemptyRule() throws RuleException {
		if(loginWin.getTxtUsernameValue().trim().isEmpty() ||
				loginWin.getPwdPasswordValue().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}
	
	//2. User must be in the database
	private void isUserRegistered() throws LoginException{
		String uname = loginWin.getTxtUsernameValue().trim();
		String pword = loginWin.getPwdPasswordValue().trim();	
		ci.login(uname, pword);
	}
	
	

}
