package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class extraClasses {
    public static int sumValidMulInstructions(String memory) {
        // Regular expression to match valid mul(X,Y) instructions in a continuous string
        String regex = "mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(memory);

        int sum = 0;

        // Find all matches
        while (matcher.find()) {
            // Extract X and Y from the match and compute the product
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            sum += x * y;
        }

        return sum;
    }
}
