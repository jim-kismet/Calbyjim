package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Cal extends JFrame {
	JTextField tf;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15,
			b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28,
			b29, b30;

	Vector v = new Vector();

	Cal() {
		v.add(0, "t");
		v.add(1, "0");
		v.add(2, "0");
		v.add(3, "0");

		MenuBar mb = new MenuBar();
		Menu m_menu = new Menu("Menu(V)");
		Menu m_edit = new Menu("Edit(E)");
		Menu m_help = new Menu("Help(H)");

		mb.add(m_menu);
		mb.add(m_edit);
		mb.add(m_help);
		this.setMenuBar(mb);

		tf = new JTextField(20);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		tf.setPreferredSize(new Dimension(50, 50));
		tf.setFont(new Font("arial", Font.BOLD, 20));
		tf.setText("0");
		b1 = new JButton("MC");
		b2 = new JButton("MR");
		b3 = new JButton("MS");
		b4 = new JButton("M+");
		b5 = new JButton("M-");
		b6 = new JButton("←");
		b6.addActionListener(new sol());
		b7 = new JButton("CE");
		b7.addActionListener(new sol());
		b8 = new JButton("C");
		b8.addActionListener(new sol());
		b9 = new JButton("±");
		b10 = new JButton("√");
		b11 = new JButton("7");
		b11.addActionListener(new num());
		b12 = new JButton("8");
		b12.addActionListener(new num());
		b13 = new JButton("9");
		b13.addActionListener(new num());
		b14 = new JButton("/");
		b14.addActionListener(new sol());
		b15 = new JButton("%");
		b15.addActionListener(new sol());
		b16 = new JButton("4");
		b16.addActionListener(new num());
		b17 = new JButton("5");
		b17.addActionListener(new num());
		b18 = new JButton("6");
		b18.addActionListener(new num());
		b19 = new JButton("*");
		b19.addActionListener(new sol());
		b20 = new JButton("1/x");
		b21 = new JButton("1");
		b21.addActionListener(new num());
		b22 = new JButton("2");
		b22.addActionListener(new num());
		b23 = new JButton("3");
		b23.addActionListener(new num());
		b24 = new JButton("-");
		b24.addActionListener(new sol());
		b25 = new JButton("=");
		b25.addActionListener(new sol());
		b26 = new JButton("0");
		b26.addActionListener(new num());
		b27 = new JButton("0");
		b27.addActionListener(new num());
		b28 = new JButton(".");
		b28.addActionListener(new num());
		b29 = new JButton("+");
		b29.addActionListener(new sol());
		b30 = new JButton("=");
		b30.addActionListener(new sol());
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 1, 10, 10));
		// p1.setSize(190, 50);
		// p1.setLocation(10, 10);
		p1.add(tf);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(6, 5, 5, 5));
		// p2.setSize(190,25);
		// p2.setLocation(10,65);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(b10);
		p2.add(b11);
		p2.add(b12);
		p2.add(b13);
		p2.add(b14);
		p2.add(b15);
		p2.add(b16);
		p2.add(b17);
		p2.add(b18);
		p2.add(b19);
		p2.add(b20);
		p2.add(b21);
		p2.add(b22);
		p2.add(b23);
		p2.add(b24);
		p2.add(b25);
		p2.add(b26);
		p2.add(b27);
		p2.add(b28);
		p2.add(b29);
		p2.add(b30);

		// JPanel p3 = new JPanel();
		// p3.add(p2);

		// this.setTitle("����");
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		// this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		// this.setSize(300,325);
		// this.setVisible(true);
	}

	class sol implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JButton jb = (JButton) arg0.getSource();
			String jbn = jb.getText();
			if (jbn.equals("C")) {
				tf.setText("0");} 
			else if(jbn.equals("CE")){
				tf.setText("0");
				v.set(0, "t");
				v.set(1, "0");
				v.set(2, "0");
				v.set(3, "0");
			} else if (jbn.equals("=")) {
				String fnum = (String) v.get(1);
				String y = (String) v.get(2);
				String snum = tf.getText();
				double fn = Double.parseDouble(fnum);
				double sn = Double.parseDouble(snum);
				double total = 0.0;
				if (y.equals("+"))
					total = fn + sn;
				else if (y.equals("-"))
					total = fn - sn;
				else if (y.equals("*"))
					total = fn * sn;
				else if (y.equals("/"))
					total = fn / sn;
				

				String stotal = Double.toString(total);
				String st[] = stotal.split("\\.");
				if (st[1].equals("0"))
					stotal = st[0];

				tf.setText(stotal);

				v.set(0, "t");
				v.set(1, stotal);
				v.set(2, "0");
				v.set(3, "0");} 
			
			else if (jbn.equals("←")) {
				String editVal = tf.getText().toString();
				editVal = editVal.substring(0,editVal.length()-1);
				tf.setText(editVal);

			} else { // + - * %
				String fnum = tf.getText();
				v.set(0, "t");
				v.set(1, fnum);
				v.set(2, jbn);
			}

		}
	}

	class num implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JButton jb = (JButton) arg0.getSource();
			String jbn = jb.getText();
			String tfn = tf.getText();
			String vs = (String) v.get(0);
			if (jbn.equals(".")) {
				if (!tf.getText().contains("."))
					tf.setText(tfn + jbn);
			} else if (tfn.equals("0") || vs.equals("t")) {
				tf.setText(jbn);
				v.set(0, "f");
			} else {
				tf.setText(tfn + jbn);
			}

		}
	}

	public static void main(String[] args) {
		Cal c = new Cal();
		c.setTitle("계산기");
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setSize(300, 325);
		c.setVisible(true);

	}
}
