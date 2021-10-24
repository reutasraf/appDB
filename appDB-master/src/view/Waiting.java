


package view;
import controller.controller;
import model.queue_question;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import static java.lang.System.exit;
import controller.controller;
import model.Question_Answer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Waiting extends JFrame {
    Color color = new Color(178,132 ,190);
    public Waiting() {
        setBackground(color);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //int width = General.screenWidth / 3;
        //int height = General.screenHeight / 2;
        int width = General.width;
        int height = General.height;
        setBounds((General.screenWidth - width) / 2, (General.screenHeight - height) / 2, width, height);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(color);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);



        String massage="still conecting to the server";
        String massage2="please wait!!";
        JLabel messageLabel = new JLabel("<html><div style='text-align: center;'>"+massage+"<br>"+massage2+"</html>");
        messageLabel.setBackground(color);
        messageLabel.setForeground(color.BLACK);
        messageLabel.setFont(new Font("Comic Sans MS", Font.BOLD, height / 10));
        messageLabel.setBorder(new MatteBorder(2, 2, 2, 2,color));
        messageLabel.setSize(new Dimension(width , height / 3));
        messageLabel.setLocation(0, width / 3-40);
        //messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(messageLabel);


    }


}
