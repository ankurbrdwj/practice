package com.ankur.interview.hackerrank;

import java.util.LinkedHashMap;
import java.util.Scanner;

class FirstNonRepeatedCharacterEfficient {
    public static void main(String [] args){
        CharCountAndPosition [] array=new CharCountAndPosition[256];
        for(int i=0;i<256;i++)
        {
            array[i]=new CharCountAndPosition();
        }
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        int len=str.length();
        for(int i=0;i<len;i++){
            char c=str.charAt(i);
            int index=c-'\0';            
            int frequency=array[index].frequencyOfchar;
            if(frequency==0)
                array[index].firstIndex=i;
            array[index].frequencyOfchar=frequency+1;    
            //System.out.println(c+" "+array[index].frequencyOfchar);
        }
        boolean flag=false;
        int firstPosition=Integer.MAX_VALUE;
        for(int i=0;i<256;i++){            
            if(array[i].frequencyOfchar==1){
                //System.out.println("character="+(char)(i+(int)'a'));
                if(firstPosition> array[i].firstIndex){                    
                    firstPosition=array[i].firstIndex;
                    flag=true;
                }
            }            
        }
        if(flag==true)
            System.out.println(str.charAt(firstPosition));
        else
            System.out.println("There is no such type of character");
    } 
}
class CharCountAndPosition{
    int firstIndex;
    int frequencyOfchar;
    LinkedHashMap map = new LinkedHashMap();
}
