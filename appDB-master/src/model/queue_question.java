package model;


import model.Question_Answer;

import java.util.ArrayList;
import java.util.List;


/**
 * class that hold list of "question" to the game
 */
public class queue_question {
    private List<Question_Answer> my_list  =new ArrayList<>();
    private Integer flag = 0;

    public void add_to_list(Question_Answer q){
        if(my_list.size()==1000){
            return;
        }else {
            this.my_list.add(q);
        }
    }
    public boolean empty(){
        if((my_list).size()==0){
            return true;
        }
        return false;
    }
    public boolean ready(){
        if((my_list).size()>30){
            return true;
        }
        return false;
    }
    public Question_Answer getQ(){

        Question_Answer qq;
        while (true){
            if(this.sizel()==0){
                //delete before submit
                List<Question_Answer> proList  =new ArrayList<>();
                proList.add(new Question_Answer("In which year was the song \"How Does It Feel\" released?","2004","2007","The song \"Innocence\" was released in 2007"));
                proList.add(new Question_Answer("Which singer has more songs?","Keb' Mo","Bruce Carroll","Keb' Mo has 6 songs"));
                proList.add(new Question_Answer("In which year was the song \"Paul\" released?","1999","2000","The song \"The Way I Am\" was released in 2000"));
                proList.add(new Question_Answer("who sings the song: \"The Way I Am\"?","Eminem","Kanye West","\"Kanye West\" sings \"Heard 'Em Say\""));
                proList.add(new Question_Answer("who sings the song:  \"When You Were Young\"?","The Killers","Bruce Carroll", "\"Britney Spears\" sings \"My Prerogative\""));
                proList.add(new Question_Answer("Which album does the song \"Liar in the Glass\" belong to?","Reach","Bright Like Neon Love","The song \"Future\" belongs to the \"Bright Like Neon Love\" album"));
                proList.add(new Question_Answer("Which singer has more songs?","Yami Bolo","Alex Fong","\"Yami Bolo\" has 3 songs"));
                proList.add(new Question_Answer("who sings the song:  \"I'm Back\"?","Eminem","Michael Jackson","\"Michael Jackson\" sings \"I Wanna Be Where You Are\""));proList.add(new Question_Answer("In which year was the song \"Trading Places\" released?","2008","2000","The song \"Mother's Luv\" was released in 2000"));
                proList.add(new Question_Answer("Which singer has more songs?","Rockit","Pascal Lejeune","\"Rockit\" has 2 songs"));


                this.flag=flag+1;
                if (flag==10)
                    this.flag=0;

                Question_Answer c =proList.get(flag);
                return c;

            }

            qq =  this.my_list.get(0);
            this.my_list.remove(0);
            if (qq.getLength_ans_co()<=5&&qq.getLength_ans_wr()<=5&&linesNum(qq.getQuestion())<=2){
                if (qq.corrct_too_long()==false && qq.wrong_too_long()==false){
                    break;
                }

            }


        }

        return qq;
    }
    public Integer sizel(){
        return this.my_list.size();
    }
    public int linesNum(String s){
        String[]arr=s.split("<br>");
        if (arr[arr.length-1].length()==7){
            return arr.length-1;
        }
        return arr.length;
    }
}
