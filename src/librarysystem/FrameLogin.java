package librarysystem;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JButton;

/**
 * 
 * @author teddy
 *
 */

public class FrameLogin extends JFrame implements LibWindow{
	private Image logo = new ImageIcon(FrameLogin.class.getResource("libraryLogo.png")).getImage().getScaledInstance(90, 99, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JLabel lblLogo;
	
	public static final FrameLogin INSTANCE = new FrameLogin();
	
	private boolean isInitialized = false;

	private static LibWindow[] allWindows = { 
	    	LibrarySystem.INSTANCE,
			LoginWindow.INSTANCE,
			AllMemberIdsWindow.INSTANCE,	
			AllBookIdsWindow.INSTANCE,
			FrameLogin.INSTANCE
		};
	    	
	public static void hideAllWindows() {
		
		for(LibWindow frame: allWindows) {
			frame.setVisible(false);
			
		}
	}
	/**
	 * Create the frame.
	 */
	/* This class is a singleton */
	private FrameLogin() { }

	@Override
	public void init() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setTitle("MIU Library");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(255, 255, 255), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel userNamePanel = new JPanel();
		userNamePanel.setBounds(166, 142, 250, 40);
		contentPane.add(userNamePanel);
		userNamePanel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 11));
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 11, 170, 20);
		userNamePanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setBounds(166, 216, 250, 40);
		contentPane.add(passwordPanel);
		passwordPanel.setLayout(null);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBorder(null);
		pwdPassword.setText("Password");
		pwdPassword.setBounds(10, 11, 170, 20);
		passwordPanel.add(pwdPassword);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(logo));
		lblLogo.setBounds(166, 11, 250, 120);
		contentPane.add(lblLogo);
		
		JButton btnLogin = new JButton("LOG IN");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 25));
		btnLogin.setBackground(new Color(0, 64, 64));
		btnLogin.setBounds(166, 278, 250, 53);
		addLoginButtonListener(btnLogin);
		contentPane.add(btnLogin);
		//setUndecorated(true);
		setLocationRelativeTo(null);
		
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
	
	private void addLoginButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			FrameLogin.hideAllWindows();
			LibrarySystem.INSTANCE.init();
			Util.centerFrameOnDesktop(LibrarySystem.INSTANCE);
			LibrarySystem.INSTANCE.setVisible(true);
			JOptionPane.showMessageDialog(this,"Successful Login");
				
		});
	}
}
