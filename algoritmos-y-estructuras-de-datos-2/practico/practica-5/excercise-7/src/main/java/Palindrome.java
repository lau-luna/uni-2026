import java.util.Arrays;
import java.util.Scanner;

import list.*;

public class Palindrome {
  Scanner scanner;
  List<String> word;

  public Palindrome() {
    this.scanner = new Scanner(System.in);
    this.word = new MyArrayList<>();
  }

  public boolean isPalindrome() {
    for (int i = 0, j = word.size() - 1; i < word.size() / 2; i++, j--) {
      if (!word.get(i).equals(word.get(j)))
        return false;
    }
    return true;
  }

  public void readInput() {
    String input;
    String[] word;

    do {
      System.out.println("Enter a word to check if it is a palindome, or 0 to exit");
      input = scanner.nextLine();

      if (!input.equals("0")) {
        word = input.split("");

        for (String w : word) {
          this.word.add(w);
        }

        System.out.println(input + " is" + (isPalindrome() ? " " : " not ") + "a palindrome" );
      }

    } while (!input.equals("0"));
    scanner.close();
  }

  public static void main(String[] args) {
    Palindrome p = new Palindrome();
    p.readInput();

  }
}
