package librarysystem;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;

import business.SystemController;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Cursor;


/**
 * 
 * @author teddy
 *
 */

public class MainWindow extends JFrame implements LibWindow{	
	
	public static final MainWindow INSTANCE = new MainWindow();
		
	private boolean isInitialized = false;
		
	private JPanel contentPane;
	JLayeredPane layeredPane;

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
	
	private MainWindow() {}
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850, 550);
		Util.centerFrameOnDesktop(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 79, 850, 550);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelCheckoutBook = new JPanel();
		layeredPane.add(panelCheckoutBook, "name_176444819990800");
		
		JLabel lblCheckOutBook = new JLabel("Checkout Book");
		lblCheckOutBook.setHorizontalAlignment(SwingConstants.CENTER);
		panelCheckoutBook.add(lblCheckOutBook);
		
		JPanel panelAddMember = new JPanel();
		layeredPane.add(panelAddMember, "name_176496424079300");
		
		JLabel lblAddMember = new JLabel("Add Member");
		panelAddMember.add(lblAddMember);
		
		JPanel panelAddBookCopy = new JPanel();
		layeredPane.add(panelAddBookCopy, "name_176498428824900");
		
		JLabel lblAddBookCopy = new JLabel("Add Book Copy");
		panelAddBookCopy.add(lblAddBookCopy);
		
		JPanel panelAllBookIds = new JPanel();
		layeredPane.add(panelAllBookIds, "name_176499964787600");
		
		JLabel lblAllBookIds = new JLabel("All Book Ids");
		panelAllBookIds.add(lblAllBookIds);
		
		JPanel panelAllMemberIds = new JPanel();
		layeredPane.add(panelAllMemberIds, "name_178507496023200");
		
		JLabel lblAllMemberIds = new JLabel("All Member Ids");
		panelAllMemberIds.add(lblAllMemberIds);
		
		JPanel panelAddBook = new JPanel();
		layeredPane.add(panelAddBook, "name_178636081207100");
		
		JLabel lblAddBook = new JLabel("Add Book");
		panelAddBook.add(lblAddBook);
		
		JPanel panelOverdue = new JPanel();
		layeredPane.add(panelOverdue, "name_178796255916100");
		
		JLabel lblOverdue = new JLabel("Overdue");
		panelOverdue.add(lblOverdue);
		
		JPanel panelCheckoutRecord = new JPanel();
		layeredPane.add(panelCheckoutRecord, "name_179092286329700");
		
		JLabel lblCheckoutRecord = new JLabel("Checkout Record");
		panelCheckoutRecord.add(lblCheckoutRecord);
		
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
				switchPanels(panelAllBookIds);
			}
		});
		mnDisplay.add(mnItemAllBookIds);
		
		JMenuItem mnItemAllMemberIds = new JMenuItem("Member IDs");
		mnItemAllMemberIds.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnItemAllMemberIds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return isInitialized ;
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
