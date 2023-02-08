package become.a.developer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> words;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter some text (\033[3;36;44m and press ENTER twice \033[0m):  ");

        words = checkInput(getWords(br));
        System.out.println("The size of the word array ==> " + words.size());

        System.out.println("The first character of each word: ");
        System.out.println(getFirstCharacter(words));

        words = removeDuplicates(words, checkFrequencyCharacter(words));

        System.out.println("\nThe size of the word array ==> " + words.size());

        System.out.println("\nThe first character of each word after deletion: ");
        System.out.println(getFirstCharacter(words));

        uniqueCharacters(getFirstCharacter(words));
    }

    // Method of reading from the console
    private static String getWords(BufferedReader br) throws IOException {
        String input;
        String string;
        StringBuilder sb = new StringBuilder();

        while ((input = br.readLine()) != null) {
            if (input.isEmpty()) break;
            sb.append(input).append("\n");
        }
        string = sb.toString();
        string = string.replace("\"", "");
        string = string.replace("--", "");
        br.close();
        return string;
    }

    // Method checks the input to console
    public static List<String> checkInput(String string) {
        if (string.isEmpty()) System.exit(0);
        return Arrays.asList(string.split("[\\s.,()]+"));
    }

    // Method finds and prints the first characters of array elements
    public static String getFirstCharacter(List<String> words) {
        String firstLetters = null;
        for (int i = 0; i < words.size(); i++) {
            firstLetters += Character.toString(words.get(i).charAt(0));
        }
        firstLetters = firstLetters.substring(4);
        return firstLetters;
    }

    //  Method finds the Frequency of Character in words
    public static List<Integer> checkFrequencyCharacter(List<String> words) {
        List<Integer> positions = new ArrayList<>();
        System.out.println("\nFind the Frequency of Character in words: ");

        for (int i = 0; i < words.size(); i++) {
            for (int j = 1; j < words.get(i).length(); j++) {
                char firstLetter = words.get(i).charAt(0);
                if (firstLetter == words.get(i).charAt(j)) {
                    int word_pos = i;
                    int letter_pos = j + 1;
                    System.out.println("The '" + firstLetter + "' in the word '" + words.get(i) + "' from position "
                            + word_pos + " occurs in the " + letter_pos + " position.");
                    positions.add(word_pos);
                }
            }
        }
        positions = positions.stream().distinct().collect(Collectors.toList());
        return positions;
    }

    // Method removes words that do not match a condition
    public static List<String> removeDuplicates(List<String> words, List<Integer> positions) {
        words = new ArrayList(words);
        System.out.println("\nDelete the element at the specified position ...  ");
        for (int j = 0; j < positions.size(); j++) {
            for (int i = 0; i < words.size(); i++) {
                if (i == positions.get(j)) {
                    words.remove(i);
                }
            }
        }
        return words;
    }

    // Method finds unique character in a string
    public static void uniqueCharacters(String firstLetters) {
        int index = -1;
        char fnc = 0;
        for (char i : firstLetters.toCharArray()) {
            if (firstLetters.indexOf(i) == firstLetters.lastIndexOf(i)) {
                fnc = i;
                break;
            } else {
                index += 1;
            }
        }
        if (index == 1) {
            System.out.println("\nEither all characters are repeating or "
                    + "string is empty");
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("\nFirst non-repeating character is ==> " + fnc);
        }
    }

}

