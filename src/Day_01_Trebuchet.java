import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Day_01_Trebuchet {
    public static void main(String[] args) {
        String inputPath = "sample.txt";
        int sum = 0;

        Set<String> numbers = new HashSet<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
        numbers.add("6");
        numbers.add("7");
        numbers.add("8");
        numbers.add("9");
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        numbers.add("one");
        numbers.add("one");
        numbers.add("one");
        numbers.add("one");

        Map<String, String> nums = new HashMap<>();
        nums.put("1", "one");
        nums.put("2", "two");
        nums.put("3", "three");
        nums.put("4", "four");
        nums.put("5", "five");
        nums.put("6", "six");
        nums.put("7", "seven");
        nums.put("8", "eight");
        nums.put("9", "nine");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));

            String line;
            while((line = reader.readLine()) != null) {
                char firstNum = '0';
                char secondNum = '0';

                for (int i = 0; i < line.length(); i++) {
                    char current = line.charAt(i);

                    if (numbers.contains(current)) {
                        firstNum = current;
                        break;
                    }
                }

                for (int i = line.length() - 1; i >= 0; i--) {
                    char current = line.charAt(i);

                    if (numbers.contains(current)) {
                        secondNum = current;
                        break;
                    }
                }

                int lineSum = Integer.parseInt(
                        Character.toString(firstNum) +
                                Character.toString(secondNum));

                sum += lineSum;

            }

            reader.close();

        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println(sum);

    }
}

//        zoneight234

//        get the number pos
//        see if you can find a word,
//        if so, check if its start index is before the number
//        use the word instead


// two1nine
// eightwothree
// abcone2threexyz
// xtwone3four
// 4nineeightseven2
// zoneight234
// 7pqrstsixteen
//
// 2 + 9
// 8 + 3