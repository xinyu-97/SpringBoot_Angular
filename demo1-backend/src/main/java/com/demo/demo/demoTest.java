package com.demo.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class demoTest {
    private static HashMap<Integer, ArrayList<Character>> map = new HashMap<>();
    private static ArrayList<String> resultSet = new ArrayList<>();
//    public static void main(String[] args){
//        initMap();
//        String str = "2403866106";
//        helper(str.length(), str, "");
//        for(String s:resultSet){
//            System.out.println(s);
//        }
//        System.out.println(resultSet.size());
//    }

    public static void run(String input){
        initMap();
        resultSet = new ArrayList<>();
        helper(input.length(), input, "");
    }

    public static void initMap(){
        map.put(0, new ArrayList<Character>(Arrays.asList('+')));
        map.put(1, new ArrayList<Character>(Arrays.asList('1')));
        map.put(2, new ArrayList<Character>(Arrays.asList('A', 'B', 'C')));
        map.put(3, new ArrayList<Character>(Arrays.asList('D', 'E', 'F')));
        map.put(4, new ArrayList<Character>(Arrays.asList('G', 'H', 'I')));
        map.put(5, new ArrayList<Character>(Arrays.asList('J', 'K', 'L')));
        map.put(6, new ArrayList<Character>(Arrays.asList('M', 'N', 'O')));
        map.put(7, new ArrayList<Character>(Arrays.asList('P', 'Q', 'R', 'S')));
        map.put(8, new ArrayList<Character>(Arrays.asList('T', 'U', 'V')));
        map.put(9, new ArrayList<Character>(Arrays.asList('W', 'X', 'Y', 'Z')));
    }

    public static void helper(int counter, String input, String output){
        // base case
        if(counter == 1){
            ArrayList<Character> list = map.get(Character.getNumericValue(input.charAt(0)));
            for(Character c:list){
                String str = output + c;
                resultSet.add(str);
            }
        }
        else{
            ArrayList<Character> list = map.get(Character.getNumericValue(input.charAt(0)));
            int newCounter = counter - 1;
            if(input.charAt(0) != '0' || input.charAt(0) != '1') {
                helper(newCounter, input.substring(1), output + input.charAt(0));
            }
            for(Character c:list){
                String out = output + c;
                helper(newCounter, input.substring(1), out);
            }
        }
    }

    public static ArrayList<String> getResultSet(){
        return resultSet;
    }
}
