import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ViewContact {

	private JFrame frame;
	private JTableHeader Theader;
	private JTable table;
	final JFileChooser fc = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewContact window = new ViewContact();
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
	public ViewContact() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		
		frame.getContentPane().setBackground(new Color(111,168,220));
		frame.setBounds(100, 100, 951, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		File file = new File("ListesContact");
		File[] files = file.listFiles();
		String[] data = new String[files.length];
		final JList listContact = new JList(data);
		int count = 0;
		for( File value : files) {
			if(value.getName().contains(".xml")) {
			System.out.println(value.getName());
			data[count] = value.getName();
			count = count +1;
			}
		}
		
		JLabel lblNewLabel = new JLabel("Listes de contact");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		JLabel LabelPicture = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Seoladh.png")).getImage();
		LabelPicture.setIcon(new ImageIcon(img));
		
		JButton btnUpdate = new JButton("Editer");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Edit inter = new Edit();
				inter.main(null);
			}
		});
		
		JButton btnAdd = new JButton("Ajouter");
		
		JButton btnImport = new JButton("Importer");
		btnImport.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 int val_retour = fc.showOpenDialog(frame);
			 	if (val_retour == JFileChooser.APPROVE_OPTION) {
			 		File file = fc.getSelectedFile();
	                Path src = Paths.get(file.getAbsolutePath());
	                Path dest = Paths.get("ListesContact\\" + file.getName());
	                try {
	                	Files.copy(src, dest);
	                	frame.dispose();
	                	main(null);
	            	}
	                catch (IOException e1) {
						e1.printStackTrace();
	                }
	            }
			}
	
		});

		
		JButton btnExporter = new JButton("Exporter");

		
		JButton btnDelete = new JButton("Supprimer");
		
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(315)
									.addComponent(lblNewLabel_1))
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(LabelPicture, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
									.addGap(86)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnImport)
											.addGap(46)
											.addComponent(btnExporter)
											.addGap(47)
											.addComponent(btnDelete))
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(btnUpdate)
							.addGap(29)
							.addComponent(btnAdd)))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(LabelPicture, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnAdd)
						.addComponent(btnExporter)
						.addComponent(btnDelete)
						.addComponent(btnImport))
					.addGap(29))
		);

		listContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList theList = (JList) e.getSource();
				int index = theList.locationToIndex(e.getPoint());
				String fichierClick = theList.getModel().getElementAt(index).toString();
				File xmlDoc = new File("ListesContact/"+fichierClick);
				try {
					DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuild = dbFact.newDocumentBuilder();
					Document doc = dBuild.parse(xmlDoc);
					System.out.println(doc.getDocumentElement().getNodeName());
					NodeList nList = doc.getElementsByTagName("Listcontacts");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for(int i=0;i<nList.getLength();i++) {
						Node nNode = nList.item(i);
						Element eElement = (Element) nNode;
						if(eElement.getAttribute("id") != "") {
						System.out.println("Listes contacts id : "+ eElement.getAttribute("id"));
						System.out.println("Listes contacts nom : "+eElement.getElementsByTagName("nom").item(0).getTextContent());

						model.addRow(new Object[]{eElement.getElementsByTagName("nom").item(0).getTextContent(), eElement.getElementsByTagName("prenom").item(0).getTextContent(), eElement.getElementsByTagName("email").item(0).getTextContent(),eElement.getElementsByTagName("Birthday").item(0).getTextContent()});
						}
					}
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		scrollPane_1.setViewportView(listContact);
		listContact.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContact.setToolTipText("");
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nom", "Pr\u00E9nom", "Email", "Date de naissance"
			}
		));
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
		btnExporter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 int val_retour = fc.showOpenDialog(frame);

	                if (val_retour == JFileChooser.APPROVE_OPTION) {
	                	File file = fc.getSelectedFile();
	                	Path dest = Paths.get(file.getAbsolutePath());
	                	int index = listContact.getSelectedIndex();
		                Path src = Paths.get("ListesContact\\"+ listContact.getModel().getElementAt(index).toString());
	                   try {
						Files.copy(src, dest);

					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
		}
	
	});

	}
}
