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
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;

/**
 * 
 * @author teddy
 *
 */

public class FrameLogin extends JFrame {
	private Image logo = new ImageIcon(FrameLogin.class.getResource("libraryLogo.png")).getImage().getScaledInstance(90, 99, Image.SCALE_SMOOTH);
	private Image user = new ImageIcon(FrameLogin.class.getResource("user.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image pass = new ImageIcon(FrameLogin.class.getResource("pass.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JLabel lblLogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
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
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 15));
		txtUsername.setBounds(52, 0, 198, 40);
		userNamePanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUserLogo = new JLabel("");
		lblUserLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserLogo.setBackground(new Color(255, 255, 255));
		lblUserLogo.setBounds(0, 0, 54, 40);
		lblUserLogo.setIcon(new ImageIcon(user));
		userNamePanel.add(lblUserLogo);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setBounds(166, 216, 250, 40);
		contentPane.add(passwordPanel);
		passwordPanel.setLayout(null);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pwdPassword.setBorder(null);
		pwdPassword.setBounds(54, 0, 196, 40);
		passwordPanel.add(pwdPassword);
		
		JLabel lblPassLogo = new JLabel("");
		lblPassLogo.setBackground(new Color(255, 255, 255));
		lblPassLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassLogo.setBounds(0, 0, 54, 40);
		lblPassLogo.setIcon(new ImageIcon(pass));
		passwordPanel.add(lblPassLogo);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(logo));
		lblLogo.setBounds(166, 11, 250, 120);
		contentPane.add(lblLogo);
		
		JButton btnLogin = new JButton("LOG IN");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 25));
		btnLogin.setBackground(new Color(64, 128, 128));
		btnLogin.setBounds(166, 278, 250, 53);
		contentPane.add(btnLogin);
		//setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
