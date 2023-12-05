import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day_04_Scratchcards {
  Day_04_Scratchcards() { }

  public void readFile(String inputPath) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputPath));

      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }

      reader.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    System.out.println("----------------");
    System.out.println("Day 4 --- Part 1");
    System.out.println("----------------");

    Day_04_Scratchcards scratchcards = new Day_04_Scratchcards();
    scratchcards.readFile("sample.txt");
    
  }
}
