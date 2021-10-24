package model;

import java.util.Vector;

/**
 * this class is create the answer the wrong answer and a good to know feelds if the player
 * loss
 */

public class Question_Answer {
    private String question;
    private String correct_ans;
    private String wrong_ans;
    private String good_to_know;


    public Question_Answer(String question, String correct_ans, String wrong_ans, String good) {
        this.question = question;
        this.correct_ans = correct_ans;
        this.wrong_ans = wrong_ans;
        this.good_to_know = good;
    }

    public String get_q() {
        return this.question;
    }
    public String get_a_c(){ return this.correct_ans;}
    public String get_a_w(){ return this.wrong_ans;}
    public String get_g(){ return this.good_to_know;}


    public String getGood_to_know() {
        return filterFact(good_to_know);
    }

    public String getCorrect_ans() {
        return filter(this.correct_ans);
    }

    public int getLength_ans_co() {
        int num = (this.correct_ans).split(" ").length;

        return num;
    }

    public boolean corrct_too_long() {
        String[] num = (this.correct_ans).split(" ");

        for (int i = 0; i < num.length; i++) {
            if ((num[i]).length() > 8) {
                return true;
            }
        }
        return false;
    }

    public boolean wrong_too_long() {
        String[] num = (this.wrong_ans).split(" ");

        for (int i = 0; i < num.length; i++) {
            if ((num[i]).length() > 8) {
                return true;
            }
        }
        return false;
    }

    public int getLength_ans_wr() {
        int num = (this.wrong_ans).split(" ").length;
        return num;
    }


    public String getWrong_ans() {
        return filter(this.wrong_ans);
    }

    public String getQuestion() {
        return filterQue(this.question);
    }

    private String filter(String str) {
        String[] splitStr = str.split(" ");
        String ans = ("<html><div style='text-align: center;'>");
        for (int i = 0; i < splitStr.length; i++) {
            ans += splitStr[i];
            ans += "<br>";
        }
        ans += "</html>";
        return ans;
    }

    private String filterQue(String str) {
        String[] splitStr = str.split(" ");
        String ans = ("<html><div style='text-align: center;'>");
        int rownum = 0;
        for (int i = 0; i < splitStr.length; i++) {
            ans += splitStr[i];
            rownum += splitStr[i].length() + 1;
            ans += " ";
            if (i == 6 || rownum > 32) {
                ans += "<br>";
                rownum = 0;
            }
        }
        //ans+="<br>";
        ans += "</html>";
        return ans;
    }

    private String filterFact(String str) {
        String[] splitStr = str.split(" ");
        String ans = ("<html><div style='text-align: center;'>");
        int flag=0;
        int rownum = 0;
        for (int i = 0; i < splitStr.length; i++) {
            ans += splitStr[i];
            rownum += splitStr[i].length() + 1;
            ans += " ";
            if ((i == 8 || rownum > 50)&&flag==0) {
                flag=1;
                ans += "<br>";
                rownum = 0;
            }
        }
        //ans+="<br>";
        ans += "</html>";
        return ans;
    }
}