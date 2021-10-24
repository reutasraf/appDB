package model;

import java.util.*;

/**
 * this class is incharch to make  from the data a question to the game
 */

public class Make_Info {
    //the map each qution has a function that fits to the needs
    private Map<Integer, MyParser> map_question = new HashMap<Integer, MyParser>();
    //this function enter to the map a key of qution and function
    public Make_Info(){
        this.init_map();
    }

    private void init_map(){
        this.map_question.put(4, new MyParser() {
            @Override
            public Question_Answer Parse( ArrayList<ArrayList<String>> lines) {

                int size_of_lines = lines.size();
                if (size_of_lines<2)
                {
                    return null;
                }
                Random r = new Random();

                int random_currect_ans  = r.nextInt(size_of_lines);
                List<String> cur_ans = lines.get(random_currect_ans);
                int random_fake;
                List<String> fake_ans;
                int stop = 0;
                while (true){
                    random_fake = r.nextInt(size_of_lines);
                    fake_ans = lines.get(random_fake);
                    if((random_currect_ans!=random_fake)&&(!cur_ans.get(0).equals(fake_ans.get(0)) )){
                        break;
                    }
                    if (stop==100){
                        return null;
                    }
                    stop++;
                }

                String ret = "Which album does the song "+"\""+ cur_ans.get(1)+"\""+" belong to?";
                String good = "The song "+"\""+ fake_ans.get(1)+"\""+" belongs to the "+"\""+ fake_ans.get(0)+"\""+" album";
                return new Question_Answer( ret,cur_ans.get(0),fake_ans.get(0),good);


            }
        });

        this.map_question.put(0, new MyParser() {
            @Override
            public Question_Answer Parse(ArrayList<ArrayList<String>> lines) {

                int size_of_lines = lines.size();
                if (size_of_lines<2)
                {
                    return null;
                }
                Random r = new Random();
                int random_currect_ans  = r.nextInt(size_of_lines);
                List<String> cur_ans = lines.get(random_currect_ans);
                while(Integer.parseInt(cur_ans.get(1))<2){
                    random_currect_ans  = r.nextInt(size_of_lines);
                    cur_ans = lines.get(random_currect_ans);
                }

                int random_fake;
                List<String> fake_ans;
                int stop=0;
                while (true){
                    random_fake = r.nextInt(size_of_lines);
                    fake_ans = lines.get(random_fake);
                    if((random_currect_ans!=random_fake)&&(Integer.parseInt(cur_ans.get(1))>Integer.parseInt((fake_ans.get(1))) )){
                        break;
                    }
                    if (stop==100){
                        return null;
                    }
                    stop++;
                }


                String good = "\""+ cur_ans.get(0)+"\""+" has "+ cur_ans.get(1)+" songs";
                return new Question_Answer(Qusetion_Map.getInstance().get_question_to_DB(0),cur_ans.get(0),fake_ans.get(0),good);


            }
        });
        this.map_question.put(1, new MyParser() {
            @Override
            //todo check what to do when its return one ans
            public Question_Answer Parse(ArrayList<ArrayList<String>> lines) {
                int size_of_lines = lines.size();
                if (size_of_lines<2)
                {
                    return null;
                }
                Random r = new Random();
                int random_currect_ans  = r.nextInt(size_of_lines);
                List<String> cur_ans = lines.get(random_currect_ans);
                int random_fake;
                List<String> fake_ans;
                int stop = 0;
                while (true){
                    random_fake = r.nextInt(size_of_lines);
                    fake_ans = lines.get(random_fake);
                    if((random_currect_ans!=random_fake)&&(Integer.parseInt(fake_ans.get(1))!=Integer.parseInt(cur_ans.get(1)))){
                        break;
                    }
                    if (stop==100){
                        return null;
                    }
                    stop++;
                }
                String ques ="In which year was the song "+"\""+ cur_ans.get(0)+"\""+" released?";

                String good = "The song "+"\""+ fake_ans.get(0)+"\""+" was released in "+fake_ans.get(1);
                return new Question_Answer( ques,cur_ans.get(1),fake_ans.get(1),good);
            }
        });
        this.map_question.put(2, new MyParser() {
            @Override
            public Question_Answer Parse(ArrayList<ArrayList<String>> lines) {
                int stop=0;
                int size_of_lines = lines.size();
                if (size_of_lines<2)
                {
                    return null;
                }
                Random r = new Random();
                int random_currect_ans  = r.nextInt(size_of_lines);
                List<String> cur_ans = lines.get(random_currect_ans);
                int random_fake;
                List<String> fake_ans;
                while (true){
                    random_fake = r.nextInt(size_of_lines);
                    fake_ans = lines.get(random_fake);
                    if((random_currect_ans!=random_fake)&&(!fake_ans.get(1).equals(cur_ans.get(1)))){
                        break;
                    }
                    if (stop==100){
                        return null;
                    }
                    stop++;
                }

                String ques ="Where does the singer "+"\""+ cur_ans.get(0)+"\""+"  live?";
                String goood = "The singer "+"\""+ fake_ans.get(0)+"\""+" lives in "+fake_ans.get(1);
                return new Question_Answer( ques,cur_ans.get(1),fake_ans.get(1),goood);
            }
        });

        this.map_question.put(3, new MyParser() {
            @Override

            public Question_Answer Parse(ArrayList<ArrayList<String>> lines) {
                int size_of_lines = lines.size();
                if (size_of_lines<2)
                {
                    return null;
                }
                Random r = new Random();
                int random_currect_ans  = r.nextInt(size_of_lines);
                List<String> cur_ans = lines.get(random_currect_ans);
                int random_fake;
                List<String> fake_ans;
                int stop=0;
                while (true){
                    random_fake = r.nextInt(size_of_lines);
                    fake_ans = lines.get(random_fake);
                    if((random_currect_ans!=random_fake)&&(!fake_ans.get(0).equals(cur_ans.get(0)))){
                        break;
                    }
                    if (stop==100){
                        return null;
                    }
                    stop++;
                }
                String goood ="\""+ fake_ans.get(0)+"\""+" sings "+"\""+fake_ans.get(1)+"\"";
                String ques =Qusetion_Map.getInstance().get_question_to_DB(3)+" "+"\""+ cur_ans.get(1)+"\""+"?";
                return new Question_Answer( ques,cur_ans.get(0),fake_ans.get(0),goood);
            }
        });





    }
    //this function get the right answer and return it to the view to play this in the game
    public Question_Answer get_The_Info(int question, ArrayList<ArrayList<String>> lines){

        return this.map_question.get(question).Parse(lines);


    }



}
