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

import model.Question_Answer;

public class Facts extends JDialog{
    Color color = new Color(178,132 ,190);
    private controller c;
    public Facts(controller c,Frame owner, boolean modal, int score, queue_question q,Question_Answer qu) {
        super(owner, modal);
        this.c=c;
        setBackground(color);
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
        //did you know:
        String know=qu.getGood_to_know();
        JLabel messageLabel = new JLabel("<html><div style='text-align: center;'>"+"good to know!" +"<br>"+know+"</html>");
        messageLabel.setBackground(color);
        Color color1 = new Color(146, 45, 18);
        messageLabel.setForeground(color.WHITE);
        messageLabel.setFont(new Font("Comic Sans MS", Font.BOLD, height / 20));

        messageLabel.setBorder(new MatteBorder(2, 2, 2, 2,color));
        messageLabel.setSize(new Dimension(width , height / 3-20));
        messageLabel.setLocation(0, width / 3+2);
        //messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(messageLabel);



        int textFieldHeight = height / 30;
        JButton exitGame = new JButton("exit game");
        //Color color1 = new Color(146,45,18);
        //Color color1 = new Color(146, 45, 18);
        exitGame.setBackground(color1);
        exitGame.setForeground(Color.WHITE);
        exitGame.setFont(new Font("Tahoma", Font.BOLD, height / 15));
        exitGame.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.PINK));
        exitGame.setSize(new Dimension(height / 2, height / 2-65));
        exitGame.setLocation((height / 6)+30, (width / 6)-30);
        exitGame.setFocusPainted(false);
        exitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                to_controlller();
                setVisible(false);
                exit(0);

            }
        });
        JButton menuButton = new JButton("back to menu");
        //Color color1 = new Color(146,45,18);
        menuButton.setBackground(color1);
        menuButton.setForeground(Color.WHITE);
        menuButton.setFont(new Font("Tahoma", Font.BOLD, height / 15));
        menuButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.PINK));
        menuButton.setSize(new Dimension(height / 2, height / 2-65));
        menuButton.setLocation(height+10 , (width / 6)-30);
        Timer timer = new Timer(500, new ActionListener() {
            private int counter = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                if (counter % 2 == 0) {
                    menuButton.setBackground(new Color(146, 45, 18));
                } else {
                    menuButton.setBackground(new Color(90, 0, 0));
                }
            }
        });
        timer.start();
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                MainWindow frame = new MainWindow(c,q);
                frame.setVisible(true);
            }

        });


        JLabel scoreLabel = new JLabel("<html>" + "your score is: "+score + "</html>");
        scoreLabel.setBackground(color);
        scoreLabel.setForeground(color1);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, height / 13));
        scoreLabel.setSize(new Dimension(width/2+440, height/3-45 ));
        //scoreLabel.setLocation(width / 2-200, 20);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setVerticalAlignment(SwingConstants.CENTER);

        contentPane.add(scoreLabel);
        contentPane.add(menuButton);
        contentPane.add(exitGame);



    }
    public void to_controlller(){
        this.c.set_exit();
    }

}
