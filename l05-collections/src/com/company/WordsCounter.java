package com.company;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WordsCounter {

    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        String sentence = "the first men on the moon";
        StringTokenizer stringTokenizer = new StringTokenizer(sentence);
        while (stringTokenizer.hasMoreTokens()) {
            String word = stringTokenizer.nextToken();
            Integer count = map.get(word);
            map.put(word, (count == null) ? 1 : count + 1);
        }
        for (String word : map.keySet()) {
            System.out.println(word + " " + map.get(word));
        }
    }
}
