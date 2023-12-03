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

    Map<String, Integer> hashmap = new HashMap<>();
    hashmap.put("red", 12);
    hashmap.put("green", 13);
    hashmap.put("blue", 14);
    
    int possibleGames = 0;

    // Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green

    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputPath));

      String line;
      while ((line = reader.readLine()) != null) {
        boolean isIdPossible = true;
        // get the id
        int id = Integer.parseInt(line.substring(5, line.indexOf(":")));

        // create array of parts
        String substring = line.substring(line.indexOf(":") + 2);
        String[] parts = substring.split("[,;]");

        // check if any values are over the limit
        for (String part : parts) {
          int amount = intFromString(part);
          
          for (String key : hashmap.keySet()) {
            int idx = part.indexOf(key);

            if (idx != -1) {
              if (amount > hashmap.get(key)) {
                isIdPossible = false;
                break;
              }
            }
          }
        }

        if (isIdPossible) {
          possibleGames += id;
        }

      }

      reader.close();

      System.out.println(possibleGames);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
