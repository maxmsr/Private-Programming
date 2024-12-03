package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class extraClasses {
    public static int sumValidMulInstructions(String memory) {
        // Regular expression to match valid mul(X,Y) instructions in a continuous string
        String regexDo = "do\\(\\)";
        String regexDont = "dont\\(\\)";
        String regex = "mul\\((\\d+),(\\d+)\\)";

        Pattern pattern = Pattern.compile(regex);
        Pattern patternDo = Pattern.compile(regexDo);
        Pattern patternDont = Pattern.compile(regexDont);

        Matcher matcher = pattern.matcher(memory);
        Matcher matcherDo = patternDo.matcher(memory);
        Matcher matcherDont = patternDont.matcher(memory);


        int sum = 0;

        for (int i = 0; i < memory.length(); i++) {// Find all matches
            while (matcherDo.find()) {
                if(matcher.find()){
                    // Extract X and Y from the match and compute the product
                    int x = Integer.parseInt(matcher.group(1));
                    int y = Integer.parseInt(matcher.group(2));
                    sum += x * y;
            } if (matcherDont.find()) {

                }

            return sum;
        }
    }
        return sum;
    }

        int sum = 0;
        boolean isActive = true; // Starts in active mode (multiplications enabled)

}

