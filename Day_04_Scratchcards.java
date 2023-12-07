import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Day_04_Scratchcards {
  String inputPath;
  Map<Integer, Integer> cardMatches;
  
  Day_04_Scratchcards(String input) {
    this.inputPath = input;
    this.cardMatches =  mapCardIdToMatches();
  }

  public void getTotalCards() {
    Map<Integer, Integer> totalCards = new HashMap<>();

    for (int cardId : cardMatches.keySet()) {
      totalCards.put(cardId, 1);
    }

    for (int i = 1; i <= cardMatches.size(); i++) {
      for (int j = i + 1; j <= i + cardMatches.get(i); j++) {
        totalCards.put(j, totalCards.get(j) + totalCards.get(i));
      }
    }

    int sum = totalCards.values().stream().mapToInt(value -> value.intValue()).sum();
    System.out.println(sum);
  }

  private Map<Integer, Integer> mapCardIdToMatches() {
    Map<Integer, Integer> map = new HashMap<>();

    try {
      BufferedReader reader = new BufferedReader(new FileReader(this.inputPath));

      String line;
      int cardNumber = 1;
      while ((line = reader.readLine()) != null) {
        String[] numbers = line.split(":")[1].split("\\|");
        Set<Integer> winningNumbers = parseNumbers(numbers[0]);
        Set<Integer> myNumbers = parseNumbers(numbers[1]);

        Set<Integer> matchingNumbers = getMatchingNumbers(winningNumbers, myNumbers);

        map.put(cardNumber, matchingNumbers.size());
        cardNumber++;

      }

      reader.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    return map;
  }

  private Set<Integer> getMatchingNumbers(Set<Integer> winning, Set<Integer> myNums) {
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
    scratchcards.getTotalCards();
  }
}
