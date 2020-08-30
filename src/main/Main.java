package main;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.*;

public class Main extends JFrame {

	 public Main() {
//		FirstMenuView mainMenu = new FirstMenuView();
//		CreateMembershipForm createMember = new CreateMembershipForm();
		 PurchasingMainView purchasingMain = new PurchasingMainView();
//		 MemberMainView memberMain = new MemberMainView();
		 
//		 mainMenu.setVisible(true);
//		createMember.setVisible(true);
		 purchasingMain.setVisible(true);
//		 memberMain.setVisible(true);
	 }
	 
	 public static void main(String[] args) {
	  // TODO Auto-generated method stub
		 new Main();
	 }

}