/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonparser;

/**
 *
 * @author asmat
 */
public class JSONParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String json = "{ id:57,"
                + "name: \"The Hellfire Club\","
                + "created: \"1985-11-03\","
                + "location : {"
                + "city: \"St. Paul\","
                + "state : \"MN\","
                + "zip: 5555"
                + "}";
        //+ "}";

        System.out.println(json);

        Location location = new Location();
//        if (json.charAt(0) != '{' && json.charAt(json.length()-1) != '}')
//        {
//            System.out.println("Invalid JSON");
//        }
//        else
//        {
//            System.out.println("Good Json");
//        }

        char[] jsonCharSeq = json.toCharArray();

    }

}
