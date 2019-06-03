package com;

import java.util.ArrayList;
import java.util.List;

public class Phonemini {

    private static String[][] letters = {{"A","B","C"},{"D","E","F"},{"G","H","I"},{"J","K","L"},{"M","N","O"},{"P","Q","R","S"},{"T","U","S"},{"W","X","Y","Z"}};

    public static void main(String[] args){
        int[] a = {2,98};
        printLetter(a);
    }

    private static void printLetter(int[] ar){
        printLetter("",ar);
    }

    private static void printLetter(String s,int[] ar){
        if(ar.length==1){
            String[] re = getletters(ar[0]);
            if(re!=null){
                for(String c:re)System.out.print(s+c+" ");
            }
        }else{
            for(int i=0;i<ar.length;i++){
                String[] re = getletters(ar[i]);
                if(re!=null){
                    for(String c:re){
                        printLetter(s+c,exclude(i,ar));
                    }
                }else{
                    printLetter(s,exclude(i,ar));
                }
            }
        }
    }

    private static String[] getletters(int num){
        if(num<2){
            return null;
        }else if(num<10){
            return letters[num-2];
        }else{
            int a = num/10;
            int b = num%10;
            if(a<2&&b<2)return null;
            if(a<2)return letters[b-2];
            if (b<2)return letters[a-2];
            String[] re = new String[letters[a-2].length*letters[b-2].length*2];
            int j = 0;
            for(String s:letters[a-2])
                for (String c:letters[b-2])
                    re[j++]=s+c;

            for(String s:letters[b-2])
                for (String c:letters[a-2])
                    re[j++]=s+c;

            return re;


        }
    }

    private static int[] exclude(int index,int[] ar){
        int[] arb = new int[ar.length-1];
        int j = 0;
        for(int i=0;i<ar.length;i++){
            if(i==index)continue;
            arb[j++]=ar[i];
        }
        return arb;
    }

}
