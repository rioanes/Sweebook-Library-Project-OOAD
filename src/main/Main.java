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

import model.*;
import view.CreateMembershipForm;
import view.LogInView;
import view.ManagerMainView;
import view.MemberMainView;

public class Main extends JFrame {

	 public Main() {

		 FirstMenuView fmv = new FirstMenuView();
		 fmv.setVisible(true);

	 }
	 
	 public static void main(String[] args) {
	  // TODO Auto-generated method stub
	  new Main();
	 }

	}