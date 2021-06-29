import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;


public class FirstPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage window = new FirstPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstPage() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		final JFrame frame = new JFrame("Seoladh");
		frame.setResizable(false);
		frame.setSize(800,500);
		JPanel pan = new JPanel();
		pan.setBackground(new Color(111,168,220));
		JButton btnContact = new JButton("");
		btnContact.setBorderPainted(false); 
		btnContact.setContentAreaFilled(false); 
		btnContact.setFocusPainted(false); 
		btnContact.setOpaque(false);
		Image img = new ImageIcon(this.getClass().getResource("/Gestion Contacts.png")).getImage();
		btnContact.setIcon(new ImageIcon(img));
		btnContact.setBounds(20,20,150,30);
		JButton btnListe = new JButton("");
		btnListe.setFont(new Font("Arial", Font.BOLD, 16));
		btnListe.setBorderPainted(false); 
		btnListe.setContentAreaFilled(false); 
		btnListe.setFocusPainted(false); 
		btnListe.setOpaque(false);
		Image img3 = new ImageIcon(this.getClass().getResource("/Gestion Listes.png")).getImage();
		btnListe.setIcon(new ImageIcon(img3));
		btnListe.setBounds(20,20,150,30);
		btnListe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ViewContact inter = new ViewContact();
				inter.main(null);
			}
		});
		frame.getContentPane().add(pan);
		JButton btnCampagne = new JButton("");
		btnCampagne.setBorderPainted(false); 
		btnCampagne.setContentAreaFilled(false); 
		btnCampagne.setFocusPainted(false); 
		btnCampagne.setOpaque(false);
		Image img4 = new ImageIcon(this.getClass().getResource("/Gestion Campagnes.png")).getImage();
		btnCampagne.setIcon(new ImageIcon(img4));
		btnCampagne.setBounds(20,20,150,30);
		
		JLabel LabelPicture = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/Seoladh.png")).getImage();
		LabelPicture.setIcon(new ImageIcon(img2));
		
		JLabel lblNewLabel = new JLabel("Gestion Contacts");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Gestion Listes");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Gestion Campagnes");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		GroupLayout gl_pan = new GroupLayout(pan);
		gl_pan.setHorizontalGroup(
			gl_pan.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pan.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pan.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pan.createSequentialGroup()
							.addGroup(gl_pan.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pan.createSequentialGroup()
									.addGap(50)
									.addComponent(btnContact, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pan.createSequentialGroup()
									.addGap(67)
									.addComponent(lblNewLabel)))
							.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
							.addGroup(gl_pan.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_pan.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(91))
								.addGroup(Alignment.TRAILING, gl_pan.createSequentialGroup()
									.addComponent(btnListe, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
									.addGap(48)))
							.addGroup(gl_pan.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(btnCampagne))
							.addGap(114))
						.addGroup(gl_pan.createSequentialGroup()
							.addComponent(LabelPicture, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
							.addGap(127))))
		);
		gl_pan.setVerticalGroup(
			gl_pan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pan.createSequentialGroup()
					.addGap(52)
					.addComponent(LabelPicture, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_pan.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pan.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pan.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pan.createSequentialGroup()
									.addComponent(btnListe, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
									.addGap(18))
								.addGroup(Alignment.TRAILING, gl_pan.createSequentialGroup()
									.addComponent(btnCampagne)
									.addGap(36)))
							.addGroup(gl_pan.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)))
						.addGroup(gl_pan.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnContact, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
					.addGap(36))
		);
		pan.setLayout(gl_pan);
		
		frame.setVisible(true);
	
	}

}
