import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day_02_Cube_Conundrum {

  public static int intFromString(String str) {
    Pattern pattern = Pattern.compile("\\b\\d+\\b");
    Matcher matcher = pattern.matcher(str);

    if (matcher.find()) {
      String numericValue = matcher.group();

      return Integer.parseInt(numericValue);
    }

    return 0;
  }

  public static void main(String[] args) {
    String inputPath = "input.txt";
    int sumOfPowers = 0;

    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputPath));

      String line;
      while ((line = reader.readLine()) != null) {

        // keeps tracks of the max red/green/blue values
        Map<String, Integer> hashmap = new HashMap<>();
        hashmap.put("red", 0);
        hashmap.put("green", 0);
        hashmap.put("blue", 0);

        // create array of parts
        String substring = line.substring(line.indexOf(":") + 2);
        String[] parts = substring.split("[,;]");

        // check if any values are over the limit
        for (String part : parts) {
          int amount = intFromString(part);

          for (String key : hashmap.keySet()) {
            int idx = part.indexOf(key);

            if (idx != -1) {
              // upgrade the max val in the hashmap
              hashmap.put(key, Math.max(hashmap.get(key), amount));
            }
          }
        }

        // loop over the hashmap values --> multiply --> add to the sum variable
        int powers = 1;
        for (int value : hashmap.values()) {
          powers *= value;
        }

        sumOfPowers += powers;

      }
      reader.close();

      System.out.println(sumOfPowers);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
