import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Day_03_Gear_Ratios {

  public static Set<Integer> getAdjacentNumbers(ArrayList<char[]> grid, int row, int col) {
    int[][] positions = {
        { -1, -1 }, { -1, 0 }, { -1, 1 },
        { 0, -1 }, /* symbol */ { 0, 1 },
        { 1, -1 }, { 1, 0 }, { 1, 1 } };

    Set<Integer> adjNums = new HashSet<>();

    for (int[] pos : positions) {
      int rowToCheck = row + pos[0];
      int colToCheck = col + pos[1];
      char current = grid.get(rowToCheck)[colToCheck];
      int rowLength = grid.get(rowToCheck).length;
      char[] currentRow = grid.get(rowToCheck);

      if (Character.isDigit(current)) {
        StringBuilder sb = new StringBuilder();
        int idx = colToCheck;

        // if one before is also a digit: loop backwards
        if (Character.isDigit(currentRow[colToCheck - 1])) {

          // increase index until the last found digit
          while (idx < rowLength && Character.isDigit(currentRow[idx+1])) {
            idx++;
          }

          // begin adding digets, adding from the back
          while (idx >= 0 && Character.isDigit(currentRow[idx])) {
            sb.append(currentRow[idx]);
            idx--;
          }
          adjNums.add(Integer.parseInt(sb.reverse().toString()));

          // loop forward
        } else {
          while (idx < rowLength && Character.isDigit(currentRow[idx])) {
            sb.append(currentRow[idx]);
            idx++;
          }
          adjNums.add(Integer.parseInt(sb.toString()));
        }

      }

    }


    return adjNums;

  }


  public static void main(String[] args) {
    String inputPath = "input.txt";
    ArrayList<char[]> schematics = new ArrayList<>();
     int sumOfAdjNums = 0;

    // parse the input and add every line as an char array to the array list
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

    // iterate over every character (column)
    for (int i = 0; i < schematics.size(); i++) {
      char[] currentRow = schematics.get(i);

      for (int j = 0; j < currentRow.length; j++) {
        char currentChar = currentRow[j];

        // If we encounter a symbol, get all the adjacent numbers
        if (!Character.isDigit(currentChar) && currentChar != '.') {
          Set<Integer> adjacentNumbers = getAdjacentNumbers(schematics, i, j);

          if (adjacentNumbers.size() == 2) {
            int multipliedNums = 1;

            for (int adjNum : adjacentNumbers) {
              multipliedNums *= adjNum;
            }
            
            sumOfAdjNums += multipliedNums;
          }
        }
      }
    }
    System.out.println(sumOfAdjNums);
  }
}