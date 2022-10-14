package rulesets;

@SuppressWarnings("serial")
final public class UserNotFound extends Exception {
	public UserNotFound() {
		super();
	}
	public UserNotFound(String msg) {
		super(msg);
	}
	public UserNotFound(Throwable t) {
		super(t);
	}
}

