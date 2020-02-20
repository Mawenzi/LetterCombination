package com.pactera;

import java.util.HashMap;
import java.util.LinkedList;

public class LetterCombination {

    public String genStringByNum(int num){
        if (num > 99|| num < 0){
            return "暂不支持";
        }
        HashMap<Integer,String> stringMap = new HashMap<>();
        stringMap.put(2,"abc");
        stringMap.put(3,"def");
        stringMap.put(4,"ghi");
        stringMap.put(5,"jkl");
        stringMap.put(6,"mno");
        stringMap.put(7,"pqrs");
        stringMap.put(8,"tuv");
        stringMap.put(9,"wxyz");
        int[] numArray = getIntArray(num);
        LinkedList<String> strList = new LinkedList<>();
        LinkedList<String> nextStrList = new LinkedList<>();
        for (int i = 0; i < numArray.length; i++) {
            String numStr = stringMap.get(numArray[i]);
            for (int j = 0; j <numStr.length() ; j++) {
                if (i==0){
                    strList.add(String.valueOf(numStr.charAt(j)));
                    if (numArray.length==1){
                        nextStrList = strList;
                    }
                }else {
                    for (int k = 0; k <strList.size() ; k++) {
                        nextStrList.add(strList.get(k)+String.valueOf(numStr.charAt(j)));
                    }
                }
            }

        }
        return nextStrList.toString();
    }

    private int[] getIntArray(int num){
        String numString = String.valueOf(num);
        numString = numString.replace("0","");
        numString = numString.replace("1","");
        int[] numArr = new  int [numString.length()];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(String.valueOf(numString.charAt(i)));
        }

        return numArr;
    }
}
