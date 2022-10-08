package com.ankur.interview.practice.arrays;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sample {
  public static String solution(String S, String C) {
     /*
    / get names , then remove middle names
    then get the last names and remove hyphnes
    create lookup as username and name if username exists then append number then
    create new email
    lowercase the email.
     */
      Map<String,Integer> uniqueId= new LinkedHashMap<>();
      List<String> result = new ArrayList<>();
    String[] input = S.split(";");

    for(int i=0;i<input.length;i++){
      String[] names = input[i].split(" ");
      String firstName,middleName,lastName="";
      if(names.length>0)
        firstName =  names[0].trim();
      else
        firstName ="";
      if(names.length>1)
        middleName= names[1].trim();
      else
        middleName ="";
      if(names.length>2)
        lastName = names[2].trim();
      else if(names.length<3){
        lastName =middleName;
      }
      if(lastName.contains("-")){
        lastName= lastName.replace("-","");
      }
      if(lastName.length()>8){
        lastName= lastName.substring(0,8);
      }
      String uName = firstName+"."+lastName;
      if(uniqueId.containsKey(uName)){
        Integer sequence = uniqueId.get(uName);
        uName = uName + sequence+1;
        uniqueId.put(uName,sequence+1);
      }else{
        uniqueId.put(uName,0);
      }
      String email = uName+"@"+C+".com";
      result.add(input[i]+" <"+email.toLowerCase()+">");
    }

    return result.stream().collect(Collectors.joining(";"));
  }

  public static void main(String[] args) {
    String s = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
    String c= "google";
    System.out.println(solution(s,c));
  }
}
