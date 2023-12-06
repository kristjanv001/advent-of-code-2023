import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Day_04_Scratchcards {
  String inputPath;

  Day_04_Scratchcards(String input) {
    this.inputPath = input;
  }

  public void getTotalPoints() {
    int total = 0;

    try {
      BufferedReader reader = new BufferedReader(new FileReader(this.inputPath));
      
      String line;
      while ((line = reader.readLine()) != null) {
        String[] numbers = line.split(":")[1].split("\\|");
        Set<Integer> winningNumbers = parseNumbers(numbers[0]);
        Set<Integer> myNumbers = parseNumbers(numbers[1]);

        Set<Integer> matchingNumbers = getMatchingNUmbers(winningNumbers, myNumbers);

        total += getCardPoints(matchingNumbers);
      }

      reader.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(total);
  }

  private int getCardPoints(Set<Integer> matchingNums) {
    return (int)Math.pow(2, matchingNums.size() - 1);
  }

  private Set<Integer> getMatchingNUmbers(Set<Integer> winning, Set<Integer> myNums) {
    Set<Integer> matchingNumbers = new HashSet<>(winning);
    matchingNumbers.retainAll(myNums);

    return matchingNumbers;
  }

  private Set<Integer> parseNumbers(String numbersAsString) {
    Set<Integer> numbers = new HashSet<>();

    for (String number : numbersAsString.trim().split("\\s+")) {
        numbers.add(Integer.parseInt(number));
    }

    return numbers;
}

  public static void main(String[] args) {
    System.out.println("----------------");
    System.out.println("Day 4 --- Part 1");
    System.out.println("----------------");

    Day_04_Scratchcards scratchcards = new Day_04_Scratchcards("input.txt");
    scratchcards.getTotalPoints();

  }
}
