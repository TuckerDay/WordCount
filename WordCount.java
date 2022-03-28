// Takes the name of a text file and displays each word in the file and the number
// of times that word occurs.

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCount {

  public static void main(String[] args) {
    // Limit to a single argument (In future add feature to work with multiple)
    if (args.length != 1){
      System.out.println("This program takes exactly one argument.");
      return;
    }

    try {
      File bookFile = new File(args[0]);
      Scanner sc = new Scanner(bookFile);

      // Use a TreeMap with the word as the count and its occurence as the value
      Map<String, Integer> wordCount = new TreeMap<String, Integer>();

      // Scan each word and add it to 'wordCount', increment if already in wordMap
      while(sc.hasNext()) {
        String word = sc.next();
        // Remove punctuation, make lower case
        word = word.replaceAll("\\s|[^a-zA-Z0-9]","");
        word = word.toLowerCase();

        if(wordCount.containsKey(word)){
          wordCount.put(word, wordCount.get(word) + 1);
        }
        else {
          wordCount.put(word,1);
        }
      }
      // Close Scanner
      sc.close();

      // Display all words and their count
      for(String word : wordCount.keySet())
                System.out.println(word + " " + wordCount.get(word));
            System.out.println("Total number of words: " + wordCount.size());

    }
    catch(IOException e) {
      System.out.println("Can't read file.");
    }
  }
}
