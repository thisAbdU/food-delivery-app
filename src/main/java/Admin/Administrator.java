package Admin;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;

public class Administrator extends JFrame{
    
	private JTable table;
	private JTextField fnametxt;
	private JTextField mnametxt;
	private JTextField lnametxt;
	private JTextField salarytxt;
	private JTextField addresstxt;
	private JScrollPane scrollbar;
	private DefaultTableModel dm;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	//private Operations op;
	private JLabel idtxt;
	private JSpinner agespin;
	private JButton deletebtn;
	private JButton updatebtn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator admin = new Administrator();
					admin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public Administrator(){
		this.getContentPane().setBackground(Color.red);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setIconImage(
				new ImageIcon("D:\\Code\\Java Programs\\Java Tutorial\\src\\project\\employee.png").getImage());

		JLabel lblNewLabel = new JLabel("Admin Page");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setBounds(266, 10, 503, 69);
		this.getContentPane().add(lblNewLabel);

		dm = new DefaultTableModel();
		String[] columns = { "ID", "First Name", "Middle Name", "Last Name", "Age", "Address", "Salary", "Post Name" };
		for (String col : columns) {
			dm.addColumn(col);
		}
		table = new JTable(dm) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false; // Disallow the editing of any cell
			}
		};
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 13));
		table.getTableHeader().getColumnModel().setColumnSelectionAllowed(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.setRowHeight(29);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setDragEnabled(false);
		//update();
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				updatebtn.setEnabled(true);
				deletebtn.setEnabled(true);
				//setTexts();
			}
		});
		scrollbar = new JScrollPane(table);
		scrollbar.setBounds(440, 89, 531, 540);
		scrollbar.setBackground(new Color(230, 230, 250));
		scrollbar.setBorder(new LineBorder(Color.black, 2, true));
		this.getContentPane().add(scrollbar);

		JButton addbtn = new JButton("ADD RESTAURANT");
		addbtn.setToolTipText("adds the restaurant to the system");
		addbtn.setForeground(new Color(255, 255, 255));
		addbtn.setBackground(new Color(100, 149, 237));
		addbtn.setFont(new Font("Serif", Font.PLAIN, 18));
		addbtn.setBounds(120, 586, 203, 43);
		addbtn.setBorder(new LineBorder(Color.BLACK, 3, true));
		this.getContentPane().add(addbtn);

        deletebtn = new JButton("DELETE");
		deletebtn.setToolTipText("Deletes the restaruant details");
		deletebtn.setForeground(new Color(255, 255, 255));
		deletebtn.setFont(new Font("Serif", Font.PLAIN, 18));
		deletebtn.setBackground(new Color(100, 149, 237));
		deletebtn.setBounds(10, 535, 203, 43);
		deletebtn.setBorder(new LineBorder(Color.BLACK, 3, true));
		this.getContentPane().add(deletebtn);
		deletebtn.setEnabled(false);

        updatebtn = new JButton("UPDATE");
		updatebtn.setToolTipText("Updates the restaurant details");
		updatebtn.setForeground(new Color(255, 255, 255));
		updatebtn.setFont(new Font("Serif", Font.PLAIN, 18));
		updatebtn.setBackground(new Color(100, 149, 237));
		updatebtn.setBounds(221, 535, 203, 43);
		updatebtn.setBorder(new LineBorder(Color.BLACK, 3, true));
		this.getContentPane().add(updatebtn);
		updatebtn.setEnabled(false);

        JLabel idlbl = new JLabel("Add new Restaurant");
		idlbl.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		idlbl.setBounds(127, 113, 53, 26);
		this.getContentPane().add(idlbl);

		JLabel fnamelbl = new JLabel("First Name :");
		fnamelbl.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		fnamelbl.setBounds(34, 160, 142, 26);
		this.getContentPane().add(fnamelbl);

		JLabel mnamelbl = new JLabel("Middle Name :");
		mnamelbl.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		mnamelbl.setBounds(10, 202, 170, 26);
		this.getContentPane().add(mnamelbl);

		JLabel lnamelbl = new JLabel("Last Name :");
		lnamelbl.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		lnamelbl.setBounds(34, 251, 139, 26);
		this.getContentPane().add(lnamelbl);

		JLabel agelbl = new JLabel("Age :");
		agelbl.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		agelbl.setBounds(110, 293, 70, 26);
		this.getContentPane().add(agelbl);

		JLabel salarylbl = new JLabel("Salary :");
		salarylbl.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		salarylbl.setBounds(87, 335, 90, 26);
		this.getContentPane().add(salarylbl);

		JLabel addresslbl = new JLabel("Address :");
		addresslbl.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		addresslbl.setBounds(70, 381, 115, 26);
		this.getContentPane().add(addresslbl);

		JLabel postlbl = new JLabel("Posting as :");
		postlbl.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		postlbl.setBounds(45, 428, 142, 26);
		this.getContentPane().add(postlbl);

		JButton clrbtn = new JButton("CLEAR");
		clrbtn.setToolTipText("Clears the form");
		clrbtn.setBackground(new Color(221, 160, 221));
		clrbtn.setFont(new Font("Serif", Font.PLAIN, 18));
		clrbtn.setBounds(120, 479, 211, 42);
		clrbtn.setBorder(new LineBorder(Color.BLACK, 3, true));
		this.getContentPane().add(clrbtn);

        idtxt = new JLabel(".....");
		idtxt.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		idtxt.setBounds(180, 113, 244, 26);
		this.getContentPane().add(idtxt);

		fnametxt = new JTextField();
		fnametxt.setFont(new Font("Serif", Font.PLAIN, 22));
		fnametxt.setBounds(180, 149, 244, 35);
		this.getContentPane().add(fnametxt);
		fnametxt.setColumns(10);

		mnametxt = new JTextField();
		mnametxt.setFont(new Font("Serif", Font.PLAIN, 22));
		mnametxt.setColumns(10);
		mnametxt.setBounds(180, 193, 244, 35);
		this.getContentPane().add(mnametxt);

		lnametxt = new JTextField();
		lnametxt.setFont(new Font("Serif", Font.PLAIN, 22));
		lnametxt.setColumns(10);
		lnametxt.setBounds(180, 242, 244, 35);
		this.getContentPane().add(lnametxt);

		salarytxt = new JTextField();
		salarytxt.setFont(new Font("Serif", Font.PLAIN, 22));
		salarytxt.setColumns(10);
		salarytxt.setBounds(180, 326, 244, 35);
		this.getContentPane().add(salarytxt);

		addresstxt = new JTextField();
		addresstxt.setFont(new Font("Serif", Font.PLAIN, 22));
		addresstxt.setColumns(10);
		addresstxt.setBounds(180, 372, 244, 35);
		this.getContentPane().add(addresstxt);

		agespin = new JSpinner();
		agespin.setModel(new SpinnerNumberModel(18, 18, 60, 1));
		agespin.setFont(new Font("Serif", Font.PLAIN, 22));
		agespin.setBounds(180, 287, 70, 32);
		this.getContentPane().add(agespin);

        this.setTitle("Employee Management System");
		this.setBounds(100, 100, 995, 676);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void cleartxts() {
		deletebtn.setEnabled(false);
		updatebtn.setEnabled(false);
		idtxt.setText("....");
		fnametxt.setText(null);
		mnametxt.setText(null);
		lnametxt.setText(null);
		salarytxt.setText(null);
		agespin.setModel(new SpinnerNumberModel(18, 18, 60, 1));
		addresstxt.setText(null);
		comboBox.setSelectedIndex(0);
	}

    private void setTexts() {
		int rowindex = table.getSelectedRow();
		idtxt.setText((String) table.getValueAt(rowindex, 0));
		fnametxt.setText((String) table.getValueAt(rowindex, 1));
		mnametxt.setText((String) table.getValueAt(rowindex, 2));
		lnametxt.setText((String) table.getValueAt(rowindex, 3));
		int intial = Integer.valueOf(table.getValueAt(rowindex, 4).toString());
		agespin.setModel(new SpinnerNumberModel(intial, 18, 60, 1));
		addresstxt.setText(table.getValueAt(rowindex, 5).toString());
		comboBox.setSelectedItem(table.getValueAt(rowindex, 7).toString());
		salarytxt.setText(table.getValueAt(rowindex, 6).toString());

	}

	// private boolean validate() {
	// 	if (fnametxt.getText().isBlank() || lnametxt.getText().isBlank() || addresstxt.getText().isBlank()
	// 			|| mnametxt.getText().isBlank() || salarytxt.getText().isBlank()) {

	// 		return false;
	// 	}
	// 	return true;
	// }
    
}
