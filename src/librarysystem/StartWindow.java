package librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import java.awt.CardLayout;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import business.SystemController;
import java.awt.Color;
import javax.swing.SwingConstants;

public class StartWindow extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel panelCheckoutBook;
	private JPanel panelAddMember;
	private JPanel panelAddBookCopy;
	private JPanel panelAllBookIds;
	private JPanel panelAllMemberIds;
	private JPanel panelAddBook;
	private JPanel panelCheckOverdue;
	private JPanel panelPrintCheckoutRecord;
	
	SystemController controller  = new SystemController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow frame = new StartWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(950,650);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(12, 617, 932, -542);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelCheckoutBook = new JPanel();
		panelCheckoutBook.setBackground(new Color(213, 100, 110));
		layeredPane.setLayer(panelCheckoutBook, 0);
		layeredPane.add(panelCheckoutBook, "name_11049073755219");
		
		panelAddMember = new JPanel();
		layeredPane.add(panelAddMember, "name_11088207929604");
		
		panelAddBookCopy = new JPanel();
		layeredPane.add(panelAddBookCopy, "name_11105756774478");
		panelAddBookCopy.setLayout(null);
		
		panelAllBookIds = new JPanel();
		layeredPane.add(panelAllBookIds, "name_11122774260044");
		panelAllBookIds.setLayout(null);
		
		panelAllMemberIds = new JPanel();
		layeredPane.add(panelAllMemberIds, "name_11141373074786");
		
		panelAddBook = new JPanel();
		layeredPane.add(panelAddBook, "name_11185853476534");
		panelAddBook.setLayout(null);
		
		panelCheckOverdue = new JPanel();
		panelCheckOverdue.setBackground(new Color(88, 198, 115));
		layeredPane.add(panelCheckOverdue, "name_11203956756790");
		panelCheckOverdue.setLayout(null);
		
		panelPrintCheckoutRecord = new JPanel();
		layeredPane.add(panelPrintCheckoutRecord, "name_11227773061120");
		panelPrintCheckoutRecord.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 0, 938, 63);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 932, 63);
		panel.add(menuBar);
		
		JMenu menuAdd = new JMenu("Add");
		menuBar.add(menuAdd);
		
		JMenuItem mnItemAddBook = new JMenuItem("Book");
		mnItemAddBook.addActionListener(controller.INSTANCE.getAddBookListener(layeredPane, panelAddBook));
		menuAdd.add(mnItemAddBook);
		
		JMenuItem mnItemAddBookCopy = new JMenuItem("Book Copy");
		menuAdd.add(mnItemAddBookCopy);
		mnItemAddBookCopy.addActionListener(controller.INSTANCE.getAddBookCopyListener(layeredPane, panelAddBookCopy)); 
		
		JMenuItem mnItemAddMemeber = new JMenuItem("Member");
		mnItemAddMemeber.addActionListener(controller.INSTANCE.getAddMemberCopyListener(layeredPane, panelAddMember));
		menuAdd.add(mnItemAddMemeber);
		
		JMenu menuCheckout = new JMenu("Checkout");
		menuBar.add(menuCheckout);
		
		JMenuItem mnItemCheckoutBook = new JMenuItem("Create");
		mnItemCheckoutBook.addActionListener(controller.INSTANCE.getCheckoutBookListener(layeredPane, panelCheckoutBook));
		menuCheckout.add(mnItemCheckoutBook);
		
		JMenuItem mnItemCheckoutHistory = new JMenuItem("HIstory");
		menuCheckout.add(mnItemCheckoutHistory);
		
		JMenu menuOverdue = new JMenu("Overdue");
		menuBar.add(menuOverdue);
		
		JMenuItem mnItemCheckOverdue = new JMenuItem("Check");
		mnItemCheckOverdue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.switchPanel(layeredPane, panelCheckOverdue);
			}
		});
		menuOverdue.add(mnItemCheckOverdue);
		
		JMenu menuDisplay = new JMenu("Display");
		menuBar.add(menuDisplay);
		
		JMenuItem mnItemBookIds = new JMenuItem("Book IDs");
		menuDisplay.add(mnItemBookIds);
		
		JMenuItem mnItemMemeberIds = new JMenuItem("Member IDs");
		menuDisplay.add(mnItemMemeberIds);
		
		JMenu menuUser = new JMenu("User");
		menuBar.add(menuUser);
		
		JMenuItem mnItemLogout = new JMenuItem("Logout");
		menuUser.add(mnItemLogout);
		panelAddMember.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Add Memebr");
		panelAddMember.add(lblNewLabel_1, "name_16268214674695");
		panelCheckoutBook.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CheckoutBook");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(59, 78, 305, 71);
		panelCheckoutBook.add(lblNewLabel);
	}
}
