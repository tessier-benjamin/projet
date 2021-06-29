import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GestionContact {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionContact window = new GestionContact();
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
	public GestionContact() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		JButton btnexport = new JButton("export");
		JButton btnImport = new JButton("import");
		btnexport.setBounds(20,20,150,30);
		btnImport.setBounds(20,20,150,30);

		final JFrame frame = new JFrame("ma fenetre");
		frame.setSize(800,500);
		JPanel pan = new JPanel();
		pan.add(btnexport);
		pan.add(btnImport);
		frame.getContentPane().add(pan);

		frame.setVisible(true);
		btnImport.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
//				File file = new File ("\\");
//				Desktop desktop = Desktop.getDesktop();
//				try {
//					desktop.open(file);
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
				final JFileChooser fc = new JFileChooser();
				 int val_retour = fc.showOpenDialog(frame);

	                if (val_retour == JFileChooser.APPROVE_OPTION) {
	                   File file = fc.getSelectedFile();
	                   //afficher le nom du fichier
	                   System.out.println("Nom du fichier : "+file.getName()+"\n");
	                   //afficher le chemin absolu du fichier
	                   System.out.println("Chemin absolu : "+file.getAbsolutePath()+"\n");
	                } else {
	                     System.out.println("L'ouverture est annulée\n");
	                }
			}
		});
	
	}

}
