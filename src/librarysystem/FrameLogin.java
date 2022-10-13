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

/**
 * 
 * @author teddy
 *
 */

public class FrameLogin extends JFrame {
	private Image logo = new ImageIcon(FrameLogin.class.getResource("libraryLogo.png")).getImage().getScaledInstance(90, 99, Image.SCALE_SMOOTH);
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
		contentPane.add(btnLogin);
		//setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
