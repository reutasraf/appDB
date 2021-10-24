package view;

import model.Question_Answer;
import model.queue_question;
import controller.controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class Game extends JFrame {
    Color color = new Color(93,138,168);
    public static int flag=0;
    model.queue_question questions;
    String font="Comic Sans MS";
    JPanel contentPane;
    int count;
    int initialCount;
    JLabel timeLabel = new JLabel(" ");
    java.util.Timer timer = new Timer(true);
    Question_Answer question_answer;
    controller controller;
    public Game(controller controller, queue_question queue_question,int initCount) {
        super("quicky");
        this.controller=controller;
        this.count = initCount;
        this.initialCount = controller.getInitialCount();
        this.questions = queue_question;
        //questions = new GetQuest();
        setBackground(color);
        //Details.life = numoflife;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = General.width;
        int height = General.height;
        setBounds((General.screenWidth - General.width) / 2, (General.screenHeight - General.height) / 2, width, height);
        contentPane = new JPanel();
        contentPane.setBackground(color);
        //if problem happend
        if(controller.getProblem_while()){
            if(queue_question.empty()){
                this.setVisible(false);
                Problem p=new Problem();
                p.setVisible(true);
                controller.set_exit();
                return;
            }
        }
        timeLabel.setBackground(color);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font(font, Font.BOLD, height / 20));
        timeLabel.setSize(new Dimension(height / 2, height / 3 + 40));
        timeLabel.setLocation(10, 27);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        contentPane.add(timeLabel);


        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                count--;
                timeLabel.setText(String.valueOf(count));
                if (count == 0) {
                    //timer.cancel();

                    timer.cancel();
                    controller.wrong();
                    if (controller.getLife() == 0) {
                        setVisible(false);
                        JFrame frame = new JFrame();
                        int s=controller.getScore();
                        Facts f = new Facts(controller,frame, true, s, questions,question_answer);
                        f.setVisible(true);
                        controller.initGame();
                    } else {
                        Game g = new Game(controller, questions,initialCount);
                        g.setVisible(true);
                        setVisible(false);
                        g.runGame();
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }
    public void addLivesLabel(int height){
        String str = "";
        for (int i = 0; i < controller.getLife(); i++) {
            str += "♥";
        }
        JLabel livesLabel = new JLabel("<html>" + str + "</html>");
        livesLabel.setBackground(color);
        livesLabel.setForeground(Color.WHITE);
        livesLabel.setFont(new Font(font, Font.BOLD, height / 20));
        livesLabel.setSize(new Dimension(height / 2, height / 3));
        livesLabel.setLocation(10, 18);
        livesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        livesLabel.setVerticalAlignment(SwingConstants.CENTER);
        contentPane.add(livesLabel);
    }
    public void addScoreLabel(int height){
        JLabel scoreLabel = new JLabel("<html>" + "score: " + controller.getScore() + "</html>");
        scoreLabel.setBackground(color);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font(font, Font.BOLD, height / 20));
        scoreLabel.setSize(new Dimension(height / 2, height / 3 - 40));
        scoreLabel.setLocation(10, 10);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setVerticalAlignment(SwingConstants.CENTER);
        contentPane.add(scoreLabel);
    }
    public void addLevelLabel(int height,int width){
        JLabel Jlevel = new JLabel("<html>" + "level " + controller.getLevel() + "</html>");
        Jlevel.setBackground(color);
        Jlevel.setForeground(color.BLACK);
        Jlevel.setFont(new Font("Tahoma", Font.BOLD, height / 15));
        Jlevel.setSize(new Dimension(height / 2, height / 3 - 100));
        Jlevel.setLocation(width/2-70, 8);
        Jlevel.setHorizontalAlignment(SwingConstants.CENTER);
        Jlevel.setVerticalAlignment(SwingConstants.CENTER);
        contentPane.add(Jlevel);
    }
    public void addQuestion(Question_Answer q,int height,int width){
        JLabel messageLabel = new JLabel(q.getQuestion());
        messageLabel.setBackground(color);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font(font, Font.BOLD, height / 20));
        //messageLabel.setSize(new Dimension(height / 2, height / 3));
        //messageLabel.setLocation(width / 2-15, width / 18-30);
        messageLabel.setBounds(2, 5, width + 120, height - 320);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        contentPane.add(messageLabel);
    }

//    public JLabel addError(int height,int width){
//        JLabel messageLabel = new JLabel("wait for connection");
//        messageLabel.setBackground(color);
//        messageLabel.setForeground(Color.RED);
//        messageLabel.setFont(new Font(font, Font.BOLD, height / 20));
//        //messageLabel.setSize(new Dimension(height / 2, height / 3));
//        //messageLabel.setLocation(width / 2-15, width / 18-30);
//        //messageLabel.setBounds(2, 5, width + 120, height - 320);
//        messageLabel.setFont(new Font(font, Font.BOLD, height / 20));
//        messageLabel.setSize(new Dimension(height / 2, height / 3 ));
//        messageLabel.setLocation(10, height / 2-50);
//        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        messageLabel.setVerticalAlignment(SwingConstants.CENTER);
//        messageLabel.setVisible(false);
//        contentPane.add(messageLabel);
//        return messageLabel;
//    }
    public void addLeftAns(String leftOpt,int height,int width,int truth){
        Question_Answer q=question_answer;
        JButton choose1 = new JButton(leftOpt);
        Color color1 = new Color(146, 45, 18);
        choose1.setBackground(color1);
        choose1.setForeground(Color.white);
        choose1.setFont(new Font(font, Font.BOLD, height / 15));
        choose1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.WHITE));
        choose1.setSize(new Dimension(height / 2, height / 2));
        choose1.setLocation(height / 2, width / 6);
        choose1.setFocusPainted(false);
        //choose1.setHorizontalAlignment(SwingConstants.CENTER);
        //choose1.setVerticalAlignment(SwingConstants.CENTER);
        choose1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                timer.cancel();

                if (isCorrect(1, truth)) {
                    controller.correct();
                    count = controller.getInitialCount();

                } else {
                    controller.wrong();
                    if (controller.getLife() == 0) {
                        //todo facts
                        //return ,gameover
                        setVisible(false);
                        Component component = (Component) arg0.getSource();
                        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                        int s=controller.getScore();
                        Facts f = new Facts(controller,frame, true, s, questions,q);
                        f.setVisible(true);
                        controller.initGame();
                        return;
                    }
                }

                Game g = new Game(controller, questions,initialCount);
//                g.setQ(questions);
                g.setVisible(true);
                setVisible(false);
                g.runGame();
            }
        });
        contentPane.add(choose1);

    }
    public void addRightAns(String rightOpt,int height,int width,int truth){
        Question_Answer q=question_answer;
        JButton choose2 = new JButton(rightOpt);
        //Color color1 = new Color(146,45,18);
        Color color1 = new Color(146, 45, 18);
        choose2.setBackground(color1);
        choose2.setForeground(Color.white);
        choose2.setFont(new Font(font, Font.BOLD, height / 15));
        choose2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.white));
        choose2.setSize(new Dimension(height / 2, height / 2));
        choose2.setLocation(width - height / 2 - width / 10, width / 6);
        choose2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //setVisible(false);
                //SelectRangeOfYears dialog = new SelectRangeOfYears();
                //dialog.setVisible(true);
                timer.cancel();
                if (isCorrect(2, truth)) {
                    controller.correct();
                    count = controller.getInitialCount();


                } else {
                    controller.wrong();
                    if (controller.getLife() == 0) {
                        //todo facts
                        //return ,gameover
                        setVisible(false);
                        Component component = (Component) arg0.getSource();
                        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                        int s=controller.getScore();
                        Facts f = new Facts(controller,frame, true, s, questions,q);
                        f.setVisible(true);
                        controller.initGame();
                        return;
                    }
                }

                Game g = new Game(controller, questions,initialCount);
//                g.setQ(questions);
                g.setVisible(true);
                setVisible(false);
                g.runGame();
            }
        });
        contentPane.add(choose2);

    }
    public void addHint(Question_Answer q,int height){
        String ans=q.getCorrect_ans();
        JLabel answer = new JLabel(ans);
        answer.setBackground(color);
        answer.setForeground(Color.WHITE);
        answer.setFont(new Font(font, Font.BOLD, height / 20));
        answer.setSize(new Dimension(height / 2, height / 3 ));
        answer.setLocation(10, height / 2-50);
        answer.setHorizontalAlignment(SwingConstants.CENTER);
        answer.setVerticalAlignment(SwingConstants.CENTER);
        answer.setVisible(false);
        //answer.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(answer);
        Color color1 = new Color(146, 45, 18);

        JButton hint = new JButton("hint");
        //Color color1 = new Color(146,45,18);
        hint.setBackground(color1);
        hint.setForeground(Color.orange);
        hint.setFont(new Font(font, Font.BOLD, 15));
        hint.setBorder(new MatteBorder(2, 2, 2, 2, (Color) color.white));
        hint.setSize(new Dimension(40, 40));
        hint.setLocation(20, height / 2);
        hint.setFocusPainted(false);
        hint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                answer.setVisible(true);
            }
        });
        contentPane.add(hint);
    }
    public void runGame() {
        int width = General.width;
        int height = General.height;


        if(controller.getProblem_while()){
            if(this.questions.empty()){
                setVisible(false);
                Problem p=new Problem();
                p.setVisible(true);
                controller.set_exit();
                return;
            }
        }
//        if(questions.empty()) {
//            Waiting w = new Waiting();
//            setVisible(false);
//            w.setVisible(true);
//
//            try
//            {
//                Thread.sleep(2500);
//            }
//            catch(InterruptedException ex)
//            {
//                Thread.currentThread().interrupt();
//            }
//            Game g = new Game(controller, questions,initialCount);
////                g.setQ(questions);
//            g.setVisible(true);
//            w.setVisible(false);
//            g.runGame();
//
//
//        }

        addLivesLabel(height);
        addScoreLabel(height);
        addLevelLabel(height,width);
        //JLabel error=addError(height,width);
        //get question and answers
        //Waiting w=null;
        Question_Answer q = questions.getQ();
//        Waiting w=null;
//        if(q==null){
//
//            w = new Waiting();
//            setVisible(false);
//            w.setVisible(true);
//            q = questions.getQ();
//            //error.setVisible(true);
//
//        }
//        while(q==null){
//            q = questions.getQ();
//            int reut=1;
//        }
//        if(w!=null) {
//            w.setVisible(false);
//
//        }
//        setVisible(true);

//
//            //w = new Waiting();
//            //w.setVisible(true);
////            setVisible(false);
//            q = questions.getQ();
//        }
//        error.setVisible(false);

//        if(w!=null) {
//            w.setVisible(false);
//
//        }
        //w.setVisible(false);
        //count = initialCount;
        //setVisible(true);

        question_answer=q;
        Random rand = new Random();
        int truth = rand.nextInt(2) + 1;
        String leftOpt, rightOpt;
        leftOpt = q.getCorrect_ans();
        rightOpt = q.getWrong_ans();
        if (truth == 2) {
            leftOpt = q.getWrong_ans();
            rightOpt = q.getCorrect_ans();
        }
        addQuestion(q,height,width);
        addLeftAns(leftOpt,height,width,truth);
        addRightAns(rightOpt,height,width,truth);
        addHint(q,height);
        repaint();
    }


    public boolean isCorrect(int choose, int answer) {
        return (choose == answer);
    }
}
