package DB;



import model.Question_Answer;

import java.sql.*;
import java.util.*;

/**
 * this class in incharch to do all the things with the data base
 */
public class JDBC {
    private String user_name;
    private String password;
    private Connection conn ;
    private String port;
    private String schema_name;
    private boolean connect;
    private Map<Integer, String> map_question = new HashMap<Integer, String>();
    private Boolean problem_with_data;


    //constractor
    public JDBC(String user_name,String password,String port,String schema_name){
        this.port = port;
        this.schema_name = schema_name;
        this.password = password;
        this.user_name = user_name;
       //set this map with the query
        this.set_dict();
        this.conn = null;
        this.connect = false;
    }

    /**
     * this is set all the query in a map
     */
    private void set_dict(){
        //it return a table of artsist a number of songs the singer has
        this.map_question.put(0,"SELECT artists.ArtistName,COUNT(songs.ArtistID) as" +
                " ll FROM artists Join songs ON songs.ArtistID = artists.ArtistID GROUP BY songs.ArtistID ORDER BY ll DESC");
        //it return a table of singers and place they live
        this.map_question.put(2, "SELECT ArtistName,ArtistLocation FROM artists WHERE ArtistHotness > 0.6 AND ArtistLocation NOT LIKE '-'");
        //it return a table of album and songs
        this.map_question.put(4,"SELECT albums.AlbumName , songs.Title FROM albums JOIN songs ON albums.AlbumID = songs.AlbumID WHERE songs.SongHotttnesss > 0.7");
        //it return table of songs and the year that each song was relesed
        this.map_question.put(1,"SELECT Title ,Year,ArtistName FROM artists a Join songs s ON a.ArtistID = s.ArtistID Join (SELECT ArtistID FROM bestsingers ORDER BY RAND() LIMIT 1) as t ON t. ArtistID = a. ArtistID");
        //return a table of singer and all the singer songs
        this.map_question.put(3, "SELECT ArtistName ,Title FROM artists a Join songs s ON a.ArtistID = s.ArtistID Join bestsingers b ON b. ArtistID = a. ArtistID ");
    }


    /**
     * this function conecction to the mysql server
     * @return a boolean if the connection failed or not
     */
    public boolean connection(){
        String url = "jdbc:mysql://localhost:"+this.port+"/"+this.schema_name;


        try{
            this.conn = DriverManager.getConnection(url,this.user_name, this.password);
            this.connect = true;
            return true;
        }catch (SQLException e){
            //System.out.println(e);
            return false;
        }

    }

    /**
     * this function take the qurey from the map and return what the sql return
     * @param question number of query we need
     * @return the table the sql return as a list
     */
    public ArrayList<ArrayList<String>> get_ans(Integer question){

        //question = "Which album does the song belong to";
        ArrayList<ArrayList<String>> listOLists = get_info_from_db(this.map_question.get(question));
        return listOLists;
    }

    /**
     * this fuction ask the sql the query
     * @param query the query to the sql
     * @return the table ad arraylist
     */
    private ArrayList<ArrayList<String>> get_info_from_db(String query){
        int i  = 0;
            try {

                //try to 'speek' with the sql
                Statement stmt = this.conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);


                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
                rs.first();

                //take the table and make it list
                while (rs.next()) {
                    ArrayList<String> mini_list= new ArrayList<String>();
                    for(int j = 1;j<=columnsNumber;j++){

                        mini_list.add(rs.getString(j));
//                        System.out.print(rs.getString(j));
//                        System.out.print("                   ");


                    }
                    i++;
//                    System.out.println("");
                    listOLists.add(mini_list);

                }

                //System.out.println(i);
                return listOLists;

            } catch (SQLException e) {
                e.printStackTrace();
                return null;

            }





    }

    /**
     * this function close the connection to the sql
     * @return a boolean if it seccssed or not
     */
    public boolean close_conn(){
//        System.out.println("conn close");
        if (this.connect){
            try {
                conn.close();
                return true;
            } catch (SQLException e) {
//                System.out.println("error close");
                e.printStackTrace();
            }
        }
        return false;


    }
}
