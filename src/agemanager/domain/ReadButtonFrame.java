package agemanager.domain;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import agemanager.database.read.ReadFromDataBase;

public class ReadButtonFrame extends JFrame  {

	private static final long serialVersionUID = 1L;
	private ReadFromDataBase data = new ReadFromDataBase();
	//private static ExecuteQueryHandlerImpl executeQueryHandlerImpl = new ExecuteQueryHandlerImpl();
	ReadFromDataBase base = new ReadFromDataBase();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					ReadButtonFrame frame = new ReadButtonFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ERROR with Database...Please Try Again");
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
			}
		});
	}

	public ReadButtonFrame() throws SQLException {

		setTitle("Database Data");
		setAlwaysOnTop(true);

		setBounds(100, 100, 512, 457);
		data.contentPane = new JPanel();
		data.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(data.contentPane);
		data.contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 42, 427, 314);
		data.contentPane.add(scrollPane);

		 base.readingDatabase(scrollPane);

	}



}
