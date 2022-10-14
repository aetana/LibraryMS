package librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;

import business.AddMemberException;
import business.Author;
import business.BookException;
import business.ControllerInterface;
import business.LoginException;
import business.SystemController;
import dataaccess.DataAccess;
import rulesets.RuleException;
import rulesets.RuleSet;
import rulesets.RuleSetFactory;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;

/**
 * 
 * @author teddy
 *
 */

public class MainWindow extends JFrame implements LibWindow {

	public static final MainWindow INSTANCE = new MainWindow();
	//ControllerInterface ci = new SystemController();

	private boolean isInitialized = false;

	private JPanel contentPane;
	JLayeredPane layeredPane;
	private JPanel panelCheckoutBook;
	private JPanel panelAddMember;
	private JPanel panelAddBookCopy;
	private JPanel panelAllBookIds;
	private JPanel panelAllMemberIds;
	private JPanel panelAddBook;
	private JPanel panelOverdue;
	
	//why is this used outside the scope of panel?
	private JScrollPane scrollPaneBookID;
	private JScrollPane scrollPaneAllMemberID;
	
	private JTextField textMemberID;
	private JTextField textISBN;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textTelephone;
	private JTextField textCity;
	private JTextField textState;
	private JTextField textZip;
	private JTextField textStreet;
	private JTextField textAddCopyISBN;
	private JTextField textbNumOfCopy;
	private JTextField textCheckoutRecordMemberID;
	private JTable tableRecord;
	private JTextField textAddBookISBN;
	private JTextField textTitle;
	private JTextField textCheckoutPeriod;
	private JTextField textFNumberOfCopies;
	private JTextField textOverdueISBN;
	private JTable tableOverdue;
	private SystemController controller = new SystemController();
	
	public String getTextMemberIDValue() {
		return textMemberID.getText();
	}

	public String getTextISBNValue() {
		return textISBN.getText();
	}

	private void checkoutBookPanel() {
		panelCheckoutBook = new JPanel();
		panelCheckoutBook.setName("panelCheckoutBook");
		panelCheckoutBook.setBackground(new Color(64, 128, 128));
		layeredPane.add(panelCheckoutBook, "name_176444819990800");
		panelCheckoutBook.setLayout(null);

		JLabel lblCheckOutBook = new JLabel("CHECKOUT BOOK");
		lblCheckOutBook.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblCheckOutBook.setForeground(new Color(255, 255, 255));
		lblCheckOutBook.setBounds(286, 44, 259, 46);
		lblCheckOutBook.setHorizontalAlignment(SwingConstants.CENTER);
		panelCheckoutBook.add(lblCheckOutBook);

		textMemberID = new JTextField();
		textMemberID.setBounds(299, 149, 246, 33);
		panelCheckoutBook.add(textMemberID);
		textMemberID.setColumns(10);

		JLabel lblMemberId = new JLabel("MEMBER ID");
		lblMemberId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMemberId.setForeground(new Color(255, 255, 255));
		lblMemberId.setAutoscrolls(true);
		lblMemberId.setBounds(152, 147, 121, 33);
		panelCheckoutBook.add(lblMemberId);

		textISBN = new JTextField();
		textISBN.setColumns(10);
		textISBN.setBounds(299, 222, 246, 33);
		panelCheckoutBook.add(textISBN);

		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setForeground(Color.WHITE);
		lblISBN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblISBN.setAutoscrolls(true);
		lblISBN.setBounds(152, 222, 121, 33);
		panelCheckoutBook.add(lblISBN);

		JButton btnCheckout = new JButton("CHECKOUT");
		btnCheckout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCheckout.setBorder(null);
		btnCheckout.setForeground(Color.WHITE);
		btnCheckout.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCheckout.setBackground(new Color(0, 64, 64));
		btnCheckout.setBounds(344, 313, 157, 53);
		panelCheckoutBook.add(btnCheckout);
	}
	

	public String getTextFirstNameValue() {
		return textFirstName.getText();
	}

	public String getTextLastNameValue() {
		return textLastName.getText();
	}

	public String getTextTelephoneValue() {
		return textTelephone.getText();
	}

	public String getTextStreetValue() {
		return textStreet.getText();
	}
	
	public String getTextCityValue() {
		return textCity.getText();
	}

	public String getTextStateValue() {
		return textState.getText();
	}

	public String getTextZipValue() {
		return textZip.getText();
	}

	

	private void addMemberPanel() {
		panelAddMember = new JPanel();
		panelAddMember.setName("panelAddMember");
		panelAddMember.setBackground(new Color(64, 128, 128));
		layeredPane.add(panelAddMember, "name_176496424079300");
		panelAddMember.setLayout(null);

		JLabel lblAddMember = new JLabel("ADD NEW MEMBER");
		lblAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMember.setForeground(Color.WHITE);
		lblAddMember.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAddMember.setBounds(255, 21, 259, 46);
		panelAddMember.add(lblAddMember);

		JLabel lblFirstName = new JLabel("FIRST NAME");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFirstName.setAutoscrolls(true);
		lblFirstName.setBounds(148, 113, 121, 33);
		panelAddMember.add(lblFirstName);

		textFirstName = new JTextField();
		textFirstName.setColumns(10);
		textFirstName.setBounds(312, 113, 246, 33);
		panelAddMember.add(textFirstName);

		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastName.setAutoscrolls(true);
		lblLastName.setBounds(148, 157, 121, 33);
		panelAddMember.add(lblLastName);

		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(312, 157, 246, 33);
		panelAddMember.add(textLastName);

		JLabel lblTelephone = new JLabel("TELEPHONE");
		lblTelephone.setForeground(Color.WHITE);
		lblTelephone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTelephone.setAutoscrolls(true);
		lblTelephone.setBounds(148, 201, 121, 33);
		panelAddMember.add(lblTelephone);

		textTelephone = new JTextField();
		textTelephone.setColumns(10);
		textTelephone.setBounds(312, 201, 246, 33);
		panelAddMember.add(textTelephone);

		textStreet = new JTextField();
		textStreet.setColumns(10);
		textStreet.setBounds(312, 246, 246, 33);
		panelAddMember.add(textStreet);

		JLabel lblStreet = new JLabel("STREET");
		lblStreet.setForeground(Color.WHITE);
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStreet.setAutoscrolls(true);
		lblStreet.setBounds(148, 246, 121, 33);
		panelAddMember.add(lblStreet);
		
		JLabel lblCity = new JLabel("CITY");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCity.setAutoscrolls(true);
		lblCity.setBounds(148, 289, 121, 33);
		panelAddMember.add(lblCity);

		textCity = new JTextField();
		textCity.setColumns(10);
		textCity.setBounds(312, 289, 246, 33);
		panelAddMember.add(textCity);

		JLabel lblState = new JLabel("STATE");
		lblState.setForeground(Color.WHITE);
		lblState.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblState.setAutoscrolls(true);
		lblState.setBounds(148, 333, 121, 33);
		panelAddMember.add(lblState);

		textState = new JTextField();
		textState.setColumns(10);
		textState.setBounds(312, 333, 246, 33);
		panelAddMember.add(textState);

		JLabel lblZiP = new JLabel("ZIP");
		lblZiP.setForeground(Color.WHITE);
		lblZiP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblZiP.setAutoscrolls(true);
		lblZiP.setBounds(148, 377, 121, 33);
		panelAddMember.add(lblZiP);

		textZip = new JTextField();
		textZip.setColumns(10);
		textZip.setBounds(312, 377, 246, 33);
		panelAddMember.add(textZip);

		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(evt -> {
			try {
				RuleSet rules = RuleSetFactory.getRuleSet(getPanel());
				rules.applyRules(this);
				
				String fname = textFirstName.getText().trim();
				String lname = textLastName.getText().trim();
				String telephone = textTelephone.getText().trim();
				String street = textTelephone.getText().trim();
				String city = textCity.getText().trim();
				String state = textState.getText().trim();
				String zip = textZip.getText().trim();
				
				controller.addMember(fname, lname, telephone, street, city, state, zip);					
				showMessage("Library Member Added Successfully!");
				
				//JOptionPane.showMessageDialog(this,"Successful Login");
				
			} catch(RuleException e) {
				//JOptionPane.showMessageDialog(contentPane, );
				//clearFields();
				showMessage(e.getMessage());
			}
			
			catch(AddMemberException e) {
				showMessage(e.getMessage());
			}
			catch(Exception e) {
				showMessage(e.getMessage());
			}
/*
			String fname = textFirstName.getText().trim();
			String lname = textLastName.getText().trim();
			String telephone = textTelephone.getText().trim();
			String street = textTelephone.getText().trim();
			String city = textCity.getText().trim();
			String state = textState.getText().trim();
			String zip = textZip.getText().trim();
			if (fname.isEmpty() || lname.isEmpty() || telephone.isEmpty() || city.isEmpty() || state.isEmpty()
					|| zip.isEmpty()) {
				showMessage("All fields are required !");
			} else {

				try {
					controller.addMember(fname, lname, telephone, street, city, state, zip);					
					showMessage("Library Member Added Successfully!");

				} catch (AddMemberException e) {
					showMessage(e.getMessage());
				}

			}
*/
		});

		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(0, 64, 64));
		btnAdd.setBounds(357, 415, 140, 46);
		panelAddMember.add(btnAdd);

		
	}
	
	
	public String getTextAddCopyISBNValue() {
		return textAddCopyISBN.getText();
	}

	public String getTextbNumOfCopyValue() {
		return textbNumOfCopy.getText();
	}
	private void addBookCopyPanel() {
		panelAddBookCopy = new JPanel();
		panelAddBookCopy.setName("panelAddBookCopy");
		panelAddBookCopy.setBackground(new Color(64, 128, 128));
		layeredPane.add(panelAddBookCopy, "name_176498428824900");
		panelAddBookCopy.setLayout(null);

		JLabel lblAddMember_1 = new JLabel("ADD BOOK COPY");
		lblAddMember_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMember_1.setForeground(Color.WHITE);
		lblAddMember_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAddMember_1.setBounds(292, 76, 300, 46);
		panelAddBookCopy.add(lblAddMember_1);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setForeground(Color.WHITE);
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIsbn.setAutoscrolls(true);
		lblIsbn.setBounds(154, 166, 121, 33);
		panelAddBookCopy.add(lblIsbn);

		textAddCopyISBN = new JTextField();
		textAddCopyISBN.setColumns(10);
		textAddCopyISBN.setBounds(349, 168, 246, 33);
		panelAddBookCopy.add(textAddCopyISBN);

		JLabel lblNumberOfCopy = new JLabel("NUMBER OF COPY");
		lblNumberOfCopy.setForeground(Color.WHITE);
		lblNumberOfCopy.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNumberOfCopy.setAutoscrolls(true);
		lblNumberOfCopy.setBounds(154, 212, 152, 33);
		panelAddBookCopy.add(lblNumberOfCopy);

		textbNumOfCopy = new JTextField();
		textbNumOfCopy.setColumns(10);
		textbNumOfCopy.setBounds(349, 212, 246, 33);
		panelAddBookCopy.add(textbNumOfCopy);

		JButton btnAddCopy = new JButton("ADD COPY");
		btnAddCopy.addActionListener(evt -> {

			String isbn = textAddCopyISBN.getText().trim();
			String numOfCopies = textbNumOfCopy.getText().trim();
			
			if (isbn.isEmpty() || numOfCopies.isEmpty() ) {
				showMessage("All fields are required !");
			} else {

				try {
					controller.addBookCopy(isbn, numOfCopies);					
					showMessage("Book Copy Added Successfully!");
				} catch (BookException e) {
					showMessage(e.getMessage());
				}

			}

		});
		btnAddCopy.setForeground(Color.WHITE);
		btnAddCopy.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddCopy.setBorder(null);
		btnAddCopy.setBackground(new Color(0, 64, 64));
		btnAddCopy.setBounds(408, 297, 157, 53);
		panelAddBookCopy.add(btnAddCopy);
	}

	private void allBookIdsPanel() {
		panelAllBookIds = new JPanel();
		panelAllBookIds.setName("panelAllBookIds");
		panelAllBookIds.setBackground(new Color(64, 128, 128));
		layeredPane.add(panelAllBookIds, "name_176499964787600");
		panelAllBookIds.setLayout(null);

		JLabel lblAllBookIds = new JLabel("ALL BOOK IDs");
		lblAllBookIds.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllBookIds.setForeground(Color.WHITE);
		lblAllBookIds.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAllBookIds.setBounds(272, 32, 227, 32);
		panelAllBookIds.add(lblAllBookIds);

		scrollPaneBookID = new JScrollPane();
		scrollPaneBookID.setBounds(59, 87, 718, 357);
		panelAllBookIds.add(scrollPaneBookID);
	}
	
	private void allMemberIdsPanel() {
		panelAllMemberIds = new JPanel();
		panelAllMemberIds.setName("panelAllMemberIds");
		panelAllMemberIds.setBackground(new Color(64, 128, 128));
		layeredPane.add(panelAllMemberIds, "name_178507496023200");
		panelAllMemberIds.setLayout(null);

		JLabel lblAllMemberIds = new JLabel("ALL MEMBER IDs");
		lblAllMemberIds.setBounds(269, 27, 227, 32);
		lblAllMemberIds.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllMemberIds.setForeground(Color.WHITE);
		lblAllMemberIds.setFont(new Font("Tahoma", Font.BOLD, 26));
		panelAllMemberIds.add(lblAllMemberIds);

		scrollPaneAllMemberID = new JScrollPane();
		scrollPaneAllMemberID .setBounds(56, 82, 718, 357);
		panelAllMemberIds.add(scrollPaneAllMemberID );
	}
	
	public String getTextAddBookISBN() {
		return textAddBookISBN.getText();
	}

	public String getTextTitleValue() {
		return textTitle.getText();
	}

	public String getTextCheckoutPeriodValue() {
		return textCheckoutPeriod.getText();
	}

	public String getTextFNumberOfCopiesValue() {
		return textFNumberOfCopies.getText();
	}
	
	public void addBookPanel() {
		panelAddBook = new JPanel();
		panelAddBook.setName("panelAddBook");
		panelAddBook.setBackground(new Color(64, 128, 128));
		layeredPane.add(panelAddBook, "name_178636081207100");
		panelAddBook.setLayout(null);

		JLabel lblAddNewBook = new JLabel("ADD NEW BOOK");
		lblAddNewBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewBook.setForeground(Color.WHITE);
		lblAddNewBook.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAddNewBook.setBounds(305, 11, 259, 46);
		panelAddBook.add(lblAddNewBook);

		JLabel lblIsbn_1 = new JLabel("ISBN");
		lblIsbn_1.setForeground(Color.WHITE);
		lblIsbn_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIsbn_1.setAutoscrolls(true);
		lblIsbn_1.setBounds(142, 101, 121, 33);
		panelAddBook.add(lblIsbn_1);

		textAddBookISBN = new JTextField();
		textAddBookISBN.setColumns(10);
		textAddBookISBN.setBounds(362, 103, 246, 33);
		panelAddBook.add(textAddBookISBN);

		JLabel lblTitle = new JLabel("TITLE");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setAutoscrolls(true);
		lblTitle.setBounds(142, 145, 121, 33);
		panelAddBook.add(lblTitle);

		textTitle = new JTextField();
		textTitle.setColumns(10);
		textTitle.setBounds(362, 147, 246, 33);
		panelAddBook.add(textTitle);

		JLabel lblCheckoutPeriod = new JLabel("CHECKOUT PERIOD");
		lblCheckoutPeriod.setForeground(Color.WHITE);
		lblCheckoutPeriod.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCheckoutPeriod.setAutoscrolls(true);
		lblCheckoutPeriod.setBounds(142, 189, 163, 33);
		panelAddBook.add(lblCheckoutPeriod);

		textCheckoutPeriod = new JTextField();
		textCheckoutPeriod.setColumns(10);
		textCheckoutPeriod.setBounds(362, 191, 246, 33);
		panelAddBook.add(textCheckoutPeriod);

		JLabel lblNumberOfCopies = new JLabel("NUMBER OF COPIES");
		lblNumberOfCopies.setForeground(Color.WHITE);
		lblNumberOfCopies.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNumberOfCopies.setAutoscrolls(true);
		lblNumberOfCopies.setBounds(142, 233, 177, 33);
		panelAddBook.add(lblNumberOfCopies);

		textFNumberOfCopies = new JTextField();
		textFNumberOfCopies.setColumns(10);
		textFNumberOfCopies.setBounds(362, 235, 246, 33);
		panelAddBook.add(textFNumberOfCopies);

		JLabel lblAuthor = new JLabel("AUTHOR");
		lblAuthor.setForeground(Color.WHITE);
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAuthor.setAutoscrolls(true);
		lblAuthor.setBounds(142, 277, 121, 33);
		panelAddBook.add(lblAuthor);

		JButton btnAddNewBook = new JButton("ADD");
		btnAddNewBook.setForeground(Color.WHITE);
		btnAddNewBook.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddNewBook.setBorder(null);
		btnAddNewBook.setBackground(new Color(0, 64, 64));
		btnAddNewBook.setBounds(405, 357, 157, 53);
		panelAddBook.add(btnAddNewBook);
		btnAddNewBook.addActionListener(evt -> {
			try {
				RuleSet rules = RuleSetFactory.getRuleSet(getPanel());
				rules.applyRules(this);
				
				String isbn = textAddBookISBN.getText().trim();
				String title = textTitle.getText().trim();
				String checkoutPeriod = textCheckoutPeriod.getText().trim();
				String numOfCopies = textFNumberOfCopies.getText().trim();
//				String author = listAuthor.
				
				controller.addBook(isbn, title, checkoutPeriod, numOfCopies, Author.getAuthors());					
				showMessage("New Book Added Successfully!");
				
				//JOptionPane.showMessageDialog(this,"Successful Login");
				
			} catch(RuleException e) {
				//JOptionPane.showMessageDialog(contentPane, );
				//clearFields();
				showMessage(e.getMessage());
			}
			
			catch(BookException e) {
				showMessage(e.getMessage());
			}
			catch(Exception e) {
				showMessage(e.getMessage());
			}

		});
		DefaultListModel<String> model = new DefaultListModel();
		JList listAuthor = new JList(model);
		List<Author> authors = Author.getAuthors();
		// Initialize the list with items
		for (Author auth: authors) {
		  model.add(authors.indexOf(auth), auth.toString());

		}
		listAuthor.setBounds(362, 279, 246, 33);
		panelAddBook.add(listAuthor);
	}
	
	private void overduePanel() {
		panelOverdue = new JPanel();
		panelOverdue.setName("panelOverdue");
		panelOverdue.setBackground(new Color(64, 128, 128));
		layeredPane.add(panelOverdue, "name_178796255916100");
		panelOverdue.setLayout(null);

		JLabel lblOverdueBooks = new JLabel("OVERDUE BOOKS");
		lblOverdueBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblOverdueBooks.setForeground(Color.WHITE);
		lblOverdueBooks.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblOverdueBooks.setBounds(251, 29, 273, 46);
		panelOverdue.add(lblOverdueBooks);

		JLabel lblOverdueISBN = new JLabel("ISBN");
		lblOverdueISBN.setForeground(Color.WHITE);
		lblOverdueISBN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOverdueISBN.setAutoscrolls(true);
		lblOverdueISBN.setBounds(32, 119, 121, 33);
		panelOverdue.add(lblOverdueISBN);

		textOverdueISBN = new JTextField();
		textOverdueISBN.setColumns(10);
		textOverdueISBN.setBounds(163, 121, 233, 33);
		panelOverdue.add(textOverdueISBN);

		JButton btnOverdueCheck = new JButton("CHECK");
		btnOverdueCheck.setForeground(Color.WHITE);
		btnOverdueCheck.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnOverdueCheck.setBorder(null);
		btnOverdueCheck.setBackground(new Color(0, 64, 64));
		btnOverdueCheck.setBounds(195, 191, 164, 53);
		panelOverdue.add(btnOverdueCheck);

		tableOverdue = new JTable();
		tableOverdue.setBounds(415, 119, 401, 305);
		panelOverdue.add(tableOverdue);
	}
	
	private void checkoutRecordPanel() {
		JPanel panelCheckoutRecord = new JPanel();
		panelCheckoutRecord.setName("panelCheckoutRecord");
		panelCheckoutRecord.setBackground(new Color(64, 128, 128));
		layeredPane.add(panelCheckoutRecord, "name_179092286329700");
		panelCheckoutRecord.setLayout(null);

		JLabel lblCheckoutRecord = new JLabel("CHECKOUT RECORD");
		lblCheckoutRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckoutRecord.setForeground(Color.WHITE);
		lblCheckoutRecord.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblCheckoutRecord.setBounds(245, 48, 273, 46);
		panelCheckoutRecord.add(lblCheckoutRecord);

		JLabel lblCheckoutMemberID = new JLabel("MEMBER ID");
		lblCheckoutMemberID.setForeground(Color.WHITE);
		lblCheckoutMemberID.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCheckoutMemberID.setAutoscrolls(true);
		lblCheckoutMemberID.setBounds(26, 138, 121, 33);
		panelCheckoutRecord.add(lblCheckoutMemberID);

		textCheckoutRecordMemberID = new JTextField();
		textCheckoutRecordMemberID.setColumns(10);
		textCheckoutRecordMemberID.setBounds(157, 140, 233, 33);
		panelCheckoutRecord.add(textCheckoutRecordMemberID);

		JButton btnShowRecord = new JButton("SHOW RECORD");
		btnShowRecord.setForeground(Color.WHITE);
		btnShowRecord.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnShowRecord.setBorder(null);
		btnShowRecord.setBackground(new Color(0, 64, 64));
		btnShowRecord.setBounds(191, 213, 164, 53);
		panelCheckoutRecord.add(btnShowRecord);

		tableRecord = new JTable();
		tableRecord.setBounds(409, 138, 401, 305);
		panelCheckoutRecord.add(tableRecord);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.setBounds(0, 0, 850, 55);
		contentPane.add(menuBar);

		JMenu mnAdd = new JMenu(" Add");
		mnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAdd.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnAdd);

		JMenuItem mnItemAddBook = new JMenuItem("Book");
		mnItemAddBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnItemAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelAddBook);
			}
		});
		mnAdd.add(mnItemAddBook);

		JMenuItem mnItemAddBookCopy = new JMenuItem("Book Copy");
		mnItemAddBookCopy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnItemAddBookCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panelAddBookCopy);
			}
		});
		mnAdd.add(mnItemAddBookCopy);

		JMenuItem mnItemAddMember = new JMenuItem("Member");
		mnItemAddMember.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnItemAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelAddMember);
			}
		});
		mnAdd.add(mnItemAddMember);

		JMenu mnCheckout = new JMenu("Checkout");
		menuBar.add(mnCheckout);

		JMenuItem mnItemCheckoutBook = new JMenuItem("Book");
		mnItemCheckoutBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelCheckoutBook);
			}
		});
		mnItemCheckoutBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnCheckout.add(mnItemCheckoutBook);

		JMenuItem mnItemCheckoutRecord = new JMenuItem("Record");
		mnItemCheckoutRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnItemCheckoutRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelCheckoutRecord);
			}
		});
		mnItemCheckoutRecord.setHorizontalAlignment(SwingConstants.CENTER);
		mnCheckout.add(mnItemCheckoutRecord);

		JMenu mnOverDue = new JMenu("Overdue");
		menuBar.add(mnOverDue);

		JMenuItem mnItemOverdue = new JMenuItem("Overdue");
		mnItemOverdue.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnItemOverdue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelOverdue);
			}
		});
		mnOverDue.add(mnItemOverdue);

		JMenu mnDisplay = new JMenu("Display");
		mnDisplay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnDisplay);

		JMenuItem mnItemAllBookIds = new JMenuItem("Book IDs");
		mnItemAllBookIds.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnItemAllBookIds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<String> books = controller.allBookIds();
				System.out.println(Arrays.toString(books.toArray()));
				JTextArea textArea = new JTextArea(Arrays.toString(books.toArray()), books.size(), 0);
				scrollPaneBookID.setViewportView(textArea);
				switchPanels(panelAllBookIds);
				
			}
		});
		mnDisplay.add(mnItemAllBookIds);

		JMenuItem mnItemAllMemberIds = new JMenuItem("Member IDs");
		mnItemAllMemberIds.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnItemAllMemberIds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<String> members = controller.allMemberIds();
				System.out.println(Arrays.toString(members.toArray()));
				JTextArea textArea = new JTextArea(Arrays.toString(members.toArray()), members.size(), 0);
				scrollPaneAllMemberID.setViewportView(textArea);
				switchPanels(panelAllMemberIds);
						
				
			}
		});
		mnItemAllMemberIds.setHorizontalAlignment(SwingConstants.CENTER);
		mnDisplay.add(mnItemAllMemberIds);

		JMenu mnUser = new JMenu("User");
		menuBar.add(mnUser);

		JMenuItem mnItemLogout = new JMenuItem("Logout");
		mnItemLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addLogoutListener(mnItemLogout);
		mnItemLogout.addActionListener(null);
		mnUser.add(mnItemLogout);

		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		JMenuItem mnItemAbout = new JMenuItem("About");
		mnItemAbout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAbout.add(mnItemAbout);
	}
	
	private void formatContentPane() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setAlignmentY(0.0f);
		layeredPane.setAlignmentX(0.0f);
		layeredPane.setBackground(new Color(0, 128, 128));
		layeredPane.setBounds(0, 50, 850, 550);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850, 550);
		Util.centerFrameOnDesktop(this);
		setResizable(false);
		
		formatContentPane();
		
		checkoutBookPanel();
		addMemberPanel();
		addBookCopyPanel();
		allBookIdsPanel();
		allMemberIdsPanel();
		addBookPanel();
		overduePanel();
		checkoutRecordPanel();

	}

	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(INSTANCE, msg);
	}
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					INSTANCE.init();
					INSTANCE.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private MainWindow() {
	}

	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		System.out.println(layeredPane.getComponent(0).getName());
	}
	
	public Component getPanel() {
		return layeredPane.getComponent(0);
	}
	
	private void clearFields() {
		textFirstName.setText("");
		textLastName.setText("");
		textTelephone.setText("");
		textStreet.setText("");
		textCity.setText("");
		textState.setText("");
		textZip.setText("");
	}
	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		// TODO Auto-generated method stub
		isInitialized = val;
	}

	private void addLogoutListener(JMenuItem menuItem) {
		menuItem.addActionListener(evt -> {
			FrameLogin.hideAllWindows();
			FrameLogin.INSTANCE.setVisible(true);
			SystemController.currentAuth = null;
		});
	}
}
