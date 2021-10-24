package view;

import model.Question_Answer;
import model.queue_question;
import controller.controller;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class MainWindow extends JFrame {
	Color color = new Color(89,131 ,130);
	Game g;
	controller c;



	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					queue_question q=new queue_question();
//					q.add_to_list(new Question_Answer("what is  gr gd gds gd gsd sg ge gewg my name?","pfshhf ff az","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","the singer michael jackson lives in hunululu and dont like to play"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					q.add_to_list(new Question_Answer("what is my name?","paz","tehila","jd"));
//					controller c=new controller();
//					MainWindow frame = new MainWindow(c,q);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}



	/**
	 * Create the frame.
	 */
	public MainWindow(controller controller,queue_question queue_question) {


		super("quicky");
		c=controller;
		setBackground(color);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = General.width;
		int height = General.height;
		setBounds((General.screenWidth - General.width) / 2, (General.screenHeight - General.height) / 2, width, height);
		JPanel contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image image =null;


				try {
					InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("image.png");
					image = ImageIO.read(inputStream);
				} catch (Exception e) {
					e.printStackTrace();
				}
				g.drawImage(image, 0, 0, null);
			}
		};
		contentPane.setBackground(color);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel name = new JLabel("quicky");
		name.setForeground(new Color(146,45,18));
		name.setFont(new Font("Ariel", Font.BOLD, height /3));
		name.setSize(name.getPreferredSize());
		name.setLocation((width - name.getWidth()) / 2-20, height / 20-28);
		contentPane.add(name);

		JButton start = new JButton("<html>start</html>");
		Color color11 = new Color(146,45,18);
		start.setBackground(color11);
		start.setFocusPainted(false);
		start.setForeground(Color.white);
		start.setFont(new Font("Ariel", Font.BOLD, height / 15));
		start.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.WHITE));
		start.setSize(new Dimension(height / 2, height / 3));
		start.setLocation(width / 3, width / 4);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Component component = (Component) arg0.getSource();
				setVisible(false);
				//Problem p =new Problem();
				//Waiting w=new Waiting();
				//check c=new check();
				//w.setVisible(true);
				//c.setVisible(true);
				//p.setVisible(true);
//				while (queue_question.empty()){
//					Waiting w=new Waiting();
//					w.setVisible(true);
//
//				}
				g = new Game(c,queue_question,11);
				g.setVisible(true);
				g.runGame();

			}
		});

		contentPane.add(start);

	}
}
