package model;

import java.util.HashMap;
import java.util.Map;

/**
 * this class map the number to the right qusetion that going to be on the screen of the game
 * this is a singelton class we want all the program to know that map
 */

public class Qusetion_Map {
    private Map<Integer,String> qusetion = new HashMap<Integer,String>();
    private static Qusetion_Map single_instance = null;

    private Qusetion_Map(){
        this.qusetion.put(0,"Which singer has more songs?");
        this.qusetion.put(1,"Which year the song was released");
        this.qusetion.put(2,"Where the singer lives");
        this.qusetion.put(3,"who sings the song: ");
        this.qusetion.put(4,"Which album does the song belong to");

    }

    /**
     * the singelton
     * @return instance of the Qusetion_Map
     */

    public static Qusetion_Map getInstance()
    {
        if (single_instance == null)
            single_instance = new Qusetion_Map();
        return single_instance;
    }

    public String get_question_to_DB(Integer i){
        return this.qusetion.get(i);
    }

    public int get_size(){
        return this.qusetion.size();
    }
}
