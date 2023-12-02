import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day_01_Trebuchet {
    public static void main(String[] args) {
        String inputPath = "input.txt";
        int sum = 0;

        Map<String, Character> hashmap = new HashMap<>();
        hashmap.put("one", '1');
        hashmap.put("two", '2');
        hashmap.put("three", '3');
        hashmap.put("four", '4');
        hashmap.put("five", '5');
        hashmap.put("six", '6');
        hashmap.put("seven", '7');
        hashmap.put("eight", '8');
        hashmap.put("nine", '9');
        hashmap.put("1", '1');
        hashmap.put("2", '2');
        hashmap.put("3", '3');
        hashmap.put("4", '4');
        hashmap.put("5", '5');
        hashmap.put("6", '6');
        hashmap.put("7", '7');
        hashmap.put("8", '8');
        hashmap.put("9", '9');

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));

            String line;
            while ((line = reader.readLine()) != null) {
                int firstNumIdx = line.length() - 1;
                char firstNum = '0';

                int secondNumIdx = 0;
                char secondNum = '0';

                // find the first number
                for (String key : hashmap.keySet()) {
                    int idx = line.indexOf(key);

                    if (idx != -1 && idx <= firstNumIdx) {
                        firstNumIdx = idx;
                        firstNum = hashmap.get(key);
                    }
                }

                // find the second number
                for (String key : hashmap.keySet()) {
                    int idx = line.lastIndexOf(key);

                    if (idx != -1 && idx >= secondNumIdx) {
                        secondNumIdx = idx;
                        secondNum = hashmap.get(key);
                    }
                }

                int lineSum = Integer.parseInt(Character.toString(firstNum) + Character.toString(secondNum));
                sum += lineSum;
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sum);
    }
}
