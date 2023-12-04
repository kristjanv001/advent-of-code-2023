import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day_03_Gear_Ratios {

  public static int[] getAdjacentNumbers(char[][] schematic, int row, int col) {

    int[] adjacentNums = { 1, 2, 3 };

    return adjacentNums;
  }

  public static void main(String[] args) {
    String inputPath = "sample.txt";
    int sum = 0;

    ArrayList<char[]> schematics = new ArrayList<>();

    // parse the input and create a 2d char array from it
    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputPath));

      String line;
      while ((line = reader.readLine()) != null) {
        schematics.add(line.toCharArray());
      }

      reader.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < schematics.size(); i++) {
      char[] currentRow = schematics.get(i);

      for (int j = 0; j < currentRow.length; j++) {
        char currentChar = currentRow[j];

        if (!Character.isDigit(currentChar) && currentChar != '.') {
          System.out.println(currentChar);
        }
      }
    }



  }
}


// if (!Character.isDigit(current) && current != '.') {
      //   int[] adjacentNumbers = getAdjacentNumbers(null, i, current);
      // }