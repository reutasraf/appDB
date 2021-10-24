package model;

import DB.JDBC;
import view.Facts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main_model {

    private String passwd;
    private String user;
    private String schema;
    private JDBC db;
    private int life=3;
    private int score = 0;
    private int level=1;
    private int flag=0;
    private int initialCount=11;
    private Make_Info qq;

    public void initGame(){
        life=3;
        score = 0;
        level=1;
        flag=0;
        initialCount=11;

    }
    public int getInitialCount() {
        return initialCount;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public int getLife() {
        return life;
    }
    public void correct(){
        score += 10;
        if (flag==4){
//            flag=0;
            if(initialCount>4) {
                initialCount = initialCount - 1;
//                System.out.print(initialCount);
            }
//            level++;

        }

        if (flag==5){
          flag=0;
            level++;
        }
        flag++;
    }
    public void wrong(){
        life--;
        if (life == 0) {
            //flag=0;
            level=1;
        }
    }
    public Boolean conn(){
        return db.connection();
    }

    public Main_model(){
//        this.passwd = "re12ut34";
//        this.user="root";
//        this.schema="data";
        this.passwd = "1gr1";
        this.user="team07";
        this.schema="db07";
        db = new JDBC(user,passwd,"3306",schema);
        qq = new Make_Info();
        db.connection();

    }
    public Question_Answer get_question(Integer db_q){
        ArrayList<ArrayList<String>> temp = db.get_ans(db_q);
        if(temp==null){
            Question_Answer n= new Question_Answer("problem_sql","","","");
            return n;
        }
        Question_Answer a = this.qq.get_The_Info(db_q,temp);
        return a;
    }
    public void exit(){
        this.db.close_conn();
    }
}
