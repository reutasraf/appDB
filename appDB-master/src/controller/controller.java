package controller;

import model.*;
import view.Problem;
import view.View;

import java.util.Random;

public class controller {

    private Main_model model;
    private Boolean exit;
    private Boolean err;
    private Boolean problem_while;

    public controller(){

        this.model = new Main_model();
        this.exit = false;
        this.err = false;
        this.problem_while = false;

    }

    /**
     * the contrioller responsible for all the abstract logic
     */
    public void run_game(){
        View v = new View();
        Boolean conn_work = this.model.conn();
        if(!conn_work){
            this.err = true;
//            System.out.println("conn didnt work");
            v.problem();
            return;

        }


        queue_question q=new queue_question();
        Qusetion_Map my_question = Qusetion_Map.getInstance();
        Random rand = new Random();

        for (int i=0;i<20;i++){
            int db_q = rand.nextInt(my_question.get_size());
            Question_Answer q_a=model.get_question(db_q);
            if(q_a==null){
                i--;
                continue;
            }

            q.add_to_list(q_a);


        }
        v.openWindow(this,q);

        while (true){

            //System.out.println(q.sizel());
            if (this.exit){
                this.model.exit();
                return;
            }
            if (q.sizel()==100){
                continue;
            }
//            try {
//                Thread.sleep(5000);
//            }
//            catch (Exception e){
//                int reut=100;
//            }
            int db_q = rand.nextInt(my_question.get_size());
            Question_Answer q_a=model.get_question(db_q);
            if(q_a==null){
                continue;
            }
            if (q_a.get_q().equals("problem_sql")){
                this.problem_while = true;
                break;

            }


            q.add_to_list(q_a);

        }

        this.model.exit();
        while (!this.exit){

            int gg = 100;
        }
    }

    public Boolean getProblem_while() {
        return problem_while;
    }

    public void set_exit(){
        this.exit = true;
    }
    public void initGame(){
        model.initGame();
    }
    public int getLevel() {
        return model.getLevel();
    }

    public int getScore() {
        return model.getScore();
    }

    public int getLife() {
        return model.getLife();
    }
    public int getInitialCount() {
        return model.getInitialCount();
    }
    public void correct(){
        model.correct();
    }
    public void wrong(){
        model.wrong();
    }


}
