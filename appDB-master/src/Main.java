import controller.controller;
import DB.JDBC;
import model.Question_Answer;
import model.Make_Info;
import model.Qusetion_Map;
import model.queue_question;
import view.View;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        controller a = new controller();
        a.run_game();
        //System.out.println("end");
    }
}
