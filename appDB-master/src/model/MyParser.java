package model;

import java.util.ArrayList;
import java.util.List;

/**
 * this interface is to create fro each query anther answer
 */
public interface MyParser {
    Question_Answer Parse( ArrayList<ArrayList<String>> lines);
}
