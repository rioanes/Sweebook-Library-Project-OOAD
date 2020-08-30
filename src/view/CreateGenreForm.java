package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateGenreForm extends JInternalFrame implements ActionListener{
	private JTextField textId;
	private JTextField textType;
	public CreateGenreForm() {
		setVisible(true);
		setSize(340, 335);
		setLocation(225, 10);
		getContentPane().setLayout(null);
		
		//genre id
		JLabel IdLbl = new JLabel("Genre ID");
		IdLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IdLbl.setBounds(24, 71, 89, 29);
		getContentPane().add(IdLbl);
		
		textId = new JTextField();
		textId.setBounds(137, 73, 151, 29);
		getContentPane().add(textId);
		textId.setColumns(10);
		
		//genre type
		JLabel lblType= new JLabel("Genre Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblType.setBounds(24, 135, 89, 20);
		getContentPane().add(lblType);
		
		textType = new JTextField();
		textType.setColumns(10);
		textType.setBounds(137, 133, 151, 29);
		getContentPane().add(textType);
		
		JButton create = new JButton("Create");
		create.setBounds(74, 203, 82, 29);
		getContentPane().add(create);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(166, 203, 76, 29);
		getContentPane().add(btnBack);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
