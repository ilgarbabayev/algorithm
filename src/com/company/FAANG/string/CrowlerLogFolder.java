package com.company.FAANG.string;

import java.util.HashMap;
import java.util.Map;

public class CrowlerLogFolder {
    public static void main(String[] args) {
        String[] logs = {"d1/","d2/","../","d21/","./"};
        System.out.println(minOperations(logs));
    }

    public static int minOperations(String[] logs) {

        int curr = 0;

        for (String step : logs) {
            if ("../".equals(step)) {
                curr = Math.max(0, curr - 1);
            } else if ("./".equals(step)){
            } else {
                curr++;
            }
        }

        return curr;
    }
}
