package rulesets;

import java.awt.Component;
import java.util.HashMap;

import librarysystem.FrameLogin;
import librarysystem.MainWindow;


final public class RuleSetFactory {
	private RuleSetFactory(){}
	static HashMap<String, RuleSet> map = new HashMap<>();
	
	static {
		map.put("loginContentPane", new FrameLoginRS());
		map.put("panelCheckoutBook", new CheckoutBookRS());
		map.put("panelAddMember", new FrameLoginRS());
		map.put("panelAddBookCopy", new FrameLoginRS());
		//map.put("panelAllBookIds", new FrameLoginRS());		
		//map.put("panelAllMemberIds", new FrameLoginRS());		
		map.put("panelAddBook", new FrameLoginRS());		
		//map.put("panelOverdue", new FrameLoginRS());
		map.put("panelCheckoutRecord", new FrameLoginRS());

	}
	public static RuleSet getRuleSet(Component c) {
		String key = c.getName();// getClass();
		if(!map.containsKey(key)) {
			throw new IllegalArgumentException(
					"No RuleSet found for this Component");
		}
		return map.get(key);
	}
	
}
