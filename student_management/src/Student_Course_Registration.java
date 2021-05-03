import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Student_Course_Registration {

	private JFrame frame;
	private Connection connection;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldContact;
	private JTextField textFieldCourse;
	private JTable table;
	private JTextField textFieldSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Course_Registration window = new Student_Course_Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void reloadTable() {
		
		 try {
			 String query = "select ID, Name, Contact, Course from StudentInfo";
			 PreparedStatement pst = connection.prepareStatement(query);
			 ResultSet rs = pst.executeQuery();
			 
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 
			 textFieldID.setText(null);
			 textFieldName.setText(null);
			 textFieldContact.setText(null);
			 textFieldCourse.setText(null);
			
			 rs.close();
			 pst.close(); 
			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2);
		}
	}

	/**
	 * Create the application.
	 */
	public Student_Course_Registration() {
		initialize();
		connection = sqliteConnection.dbConnector();
		try {
			 String query = "select ID, Name, Contact, Course from StudentInfo";
			 PreparedStatement pst = connection.prepareStatement(query);
			 ResultSet rs = pst.executeQuery();
			
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 	 
			 rs.close();
			 pst.close(); 
			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 861, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Programs\\Project\\eclipse-workspace\\Lu_Honglin_1930758\\resources\\new_LaSalle_college.png"));
		lblNewLabel.setBounds(62, 10, 314, 87);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldID.setBounds(166, 127, 142, 31);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldName.setColumns(10);
		textFieldName.setBounds(166, 177, 142, 31);
		frame.getContentPane().add(textFieldName);
		
		textFieldContact = new JTextField();
		textFieldContact.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldContact.setColumns(10);
		textFieldContact.setBounds(166, 228, 142, 31);
		frame.getContentPane().add(textFieldContact);
		
		textFieldCourse = new JTextField();
		textFieldCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldCourse.setColumns(10);
		textFieldCourse.setBounds(166, 281, 142, 31);
		frame.getContentPane().add(textFieldCourse);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(43, 132, 88, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1.setBounds(43, 180, 88, 24);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Contact:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_2.setBounds(43, 231, 88, 24);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Course:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_3.setBounds(43, 284, 88, 24);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 String query = "insert into StudentInfo(ID, Name, Contact, Course) values (?,?,?,?)";
					 
					 PreparedStatement pst = connection.prepareStatement(query);
					 pst.setString(1,textFieldID.getText());
					 pst.setString(2,textFieldName.getText());
					 pst.setString(3,textFieldContact.getText());
					 pst.setString(4,textFieldCourse.getText());
					 
					 pst.execute();
					 JOptionPane.showMessageDialog(null, "Saved Successfully!");
					 pst.close(); 
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2);
				}
				
				reloadTable();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnAdd.setBounds(38, 361, 124, 31);
		frame.getContentPane().add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDTE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 String query = "update StudentInfo set ID='" + textFieldID.getText() + "', Name='" + textFieldName.getText() + 
							 "', Contact='" + textFieldContact.getText() + "', Course='" + textFieldCourse.getText() + "' where ID='" + textFieldID.getText() + "'";
					 
					 PreparedStatement pst = connection.prepareStatement(query);
					 
					 pst.execute();
					 JOptionPane.showMessageDialog(null, "Updated Successfully!");
					 pst.close(); 
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2);
				}
				
				reloadTable();
			}

			
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnUpdate.setBounds(214, 361, 124, 31);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Are You Sure?","Delete",JOptionPane.YES_NO_OPTION);
				if(action == 0) {
					try {
						 String query = "delete from StudentInfo where ID='" + textFieldID.getText() + "'";
						 
						 PreparedStatement pst = connection.prepareStatement(query);
						 
						 pst.execute();
						 JOptionPane.showMessageDialog(null, "Removed Successfully!");
						 pst.close(); 
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, e2);
					}
					
					reloadTable();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnDelete.setBounds(38, 420, 124, 31);
		frame.getContentPane().add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 textFieldID.setText(null);
				 textFieldName.setText(null);
				 textFieldContact.setText(null);
				 textFieldCourse.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnClear.setBounds(214, 420, 124, 31);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(385, 126, 438, 313);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(175, 238, 238));
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = table.getSelectedRow();
					String studId = table.getModel().getValueAt(row, 0).toString();
					String query = "select * from StudentInfo where ID = '" + studId + "'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						 textFieldID.setText(rs.getString("ID"));
						 textFieldName.setText(rs.getString("Name"));
						 textFieldContact.setText(rs.getString("Contact"));
						 textFieldCourse.setText(rs.getString("Course"));
						 
					}
					
					pst.close();
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Search By Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(396, 82, 151, 34);
		frame.getContentPane().add(lblNewLabel_2);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					 
					 String query = "select ID, Name, Contact, Course from StudentInfo where Name = ?";
					 PreparedStatement pst = connection.prepareStatement(query);
					 pst.setString(1, textFieldSearch.getText());
					 ResultSet rs = pst.executeQuery();
					 
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 rs.close();
					 pst.close(); 
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		textFieldSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(572, 85, 180, 31);
		frame.getContentPane().add(textFieldSearch);
	}
}
