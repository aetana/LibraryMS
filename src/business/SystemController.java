package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;


public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
	public static final SystemController INSTANCE = new SystemController();
	public JLayeredPane layer;
	public JPanel panel;

	@Override
	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();

	}
	
	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}

	
	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}
	
	public void switchPanel(JLayeredPane layer, JPanel panel) {
		layer.removeAll();
		layer.add(panel);
		layer.repaint();
		layer.revalidate();
	}
	
	public class AddBookListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switchPanel(layer, panel);
			System.out.println("Add Book");
		}
		
	}
	public AddBookListener getAddBookListener(JLayeredPane layer, JPanel panel) {
		this.layer=layer;
		this.panel=panel;
		return new AddBookListener();
	}
	
	public class AddBookCopyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switchPanel(layer, panel);
			System.out.println("Book Copy");
			
		}
		
	}
	public AddBookCopyListener getAddBookCopyListener(JLayeredPane layer, JPanel panel) {
		this.layer=layer;
		this.panel=panel;
		return new AddBookCopyListener();
	}
	public class CheckoutBookListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switchPanel(layer, panel);
			System.out.println("Checkout Book");
			
		}
		
	}
	public CheckoutBookListener getCheckoutBookListener(JLayeredPane layer, JPanel panel) {
		this.layer=layer;
		this.panel=panel;
		return new CheckoutBookListener();
	}
	public class AddMemberListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switchPanel(layer, panel);
			System.out.println("Add Member");
			
		}
		
	}
	public AddMemberListener getAddMemberCopyListener(JLayeredPane layer, JPanel panel) {
		this.layer=layer;
		this.panel=panel;
		return new AddMemberListener();
	}


}
