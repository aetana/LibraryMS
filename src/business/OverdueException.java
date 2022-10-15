package business;

import java.io.Serializable;

public class OverdueException extends Exception implements Serializable {

	public OverdueException() {
		super();
	}
	public OverdueException(String msg) {
		super(msg);
	}
	public OverdueException(Throwable t) {
		super(t);
	}
	private static final long serialVersionUID = 8978723266036027364L;
	
}
