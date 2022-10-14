package rulesets;

import java.awt.Component;

import business.LoginException;

public interface RuleSet {
	public void applyRules(Component ob) throws RuleException,LoginException;
}
