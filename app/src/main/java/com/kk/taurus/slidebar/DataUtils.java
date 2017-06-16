package com.kk.taurus.slidebar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by Taurus on 2017/6/16.
 */

public class DataUtils {

    private static char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m'
            ,'n','o','p','q','r','s','t','u','v','w','x','y','z'};

    private static Random mRandom = new Random();

    public static List<String> randomData(int size){
        List<String> result = new ArrayList<>();
        for(int i=0;i<size;i++){
            result.add(getRandomItem());
        }
        Collections.sort(result,new DataComparator());
        return result;
    }

    public static String getRandomItem(){
        int index = 0;
        int len = mRandom.nextInt(7) + 3;
        StringBuilder result = new StringBuilder();
        for(int i=0;i<len;i++){
            index = mRandom.nextInt(26);
            result.append(chars[index]);
        }
        return result.toString();
    }


    public static class DataComparator implements Comparator<String>{
        @Override
        public int compare(String s, String t1) {
            return s.compareTo(t1);
        }
    }

}
