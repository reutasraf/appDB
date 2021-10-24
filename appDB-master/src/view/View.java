package view;


import model.Question_Answer;
import model.queue_question;

import java.awt.*;
import java.awt.event.ActionEvent;

import controller.controller;

import javax.swing.*;

public class View {
    MainWindow frame;

    public void openWindow(controller c,queue_question queue_question){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new MainWindow(c,queue_question);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void  problem(){

        Problem p=new Problem();
        p.setVisible(true);


//        if (controller.check_err()){
//            //Component component = (Component) arg0.getSource();
//            //JFrame frame = (JFrame) SwingUtilities.getRoot(component);
//            JFrame frame = new JFrame();
//            Problem p=new Problem(frame, true);
//            p.setVisible(true);
//        }
    }

}

