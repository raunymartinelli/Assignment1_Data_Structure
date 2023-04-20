import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// This program uses the WordInfo and Dictionary classes to implement a personal dictionary and spellcheck program. It loads the initial word list from a file called "wordlist.txt", and allows the user to add new words with their meanings, delete existing words, get the meanings of words
public class javaApplication {

    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Dictionary dictionary = new Dictionary(1000);

            // Import all known words into the dictionary from the text file "wordlist.txt."
            try {
                File file = new File("src/wordList.txt");
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine() && dictionary.getCount() < 1000) {
                    String word = fileScanner.nextLine().trim();
                    dictionary.add(word, "Undefined word");
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Could not read wordlist.txt");
            }

            // Print the menu
            int choice = 0;
            while (choice != 6) {
                System.out.println("\nMenu");
                System.out.println("1: Add new word");
                System.out.println("2: Delete word");
                System.out.println("3: Get meaning");
                System.out.println("4: Dictionary list");
                System.out.println("5: Spell check a text file");
                System.out.println("6: Exit");
                System.out.print("Enter your choice: ");

                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    scanner.nextLine();
                    continue;
                }

                switch (choice) {
                    case 1:
                        // Add new word to the dictionary
                        System.out.print("Enter word to add: ");
                        String word = scanner.nextLine().toLowerCase();
                        if (dictionary.exists(word)) {
                            System.out.println("Word already exists");
                        } else {
                            System.out.print("Enter meaning: ");
                            String meaning = scanner.nextLine();
                            if (dictionary.add(word, meaning)) {
                                System.out.println("Word added");
                            } else {
                                System.out.println("Dictionary full, could not add word");
                            }
                        }
                        break;
                    case 2:
                        // Delete a word from the dictionary
                        System.out.print("Enter word to delete: ");
                        word = scanner.nextLine().toLowerCase();
                        if (dictionary.delete(word)) {
                            System.out.println("Word deleted");
                        } else {
                            System.out.println("Word not found");
                        }
                        break;
                    case 3:
                        // Get the meaning of a word from the dictionary
                        System.out.print("Enter word to get meaning: ");
                        word = scanner.nextLine().toLowerCase();
                        String meaning = dictionary.getMeaning(word);
                        if (meaning != null) {
                            System.out.println("Meaning: " + meaning);
                        } else {
                            System.out.println("Word not found");
                        }
                        break;
                    case 4:
                        // Print a list of all the words in the dictionary in alphabetical order
                        System.out.println("Word list:");
                        System.out.println(dictionary.printWordList());
                        break;
                    case 5:
                        // Spellcheck a text file and print all the words that are not in the dictionary
                        System.out.print("Enter file name: ");
                        String fileName = scanner.nextLine();
                        try {
                            File inputFile = new File(fileName);
                            Scanner fileScanner = new Scanner(inputFile);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                String[] words = line.split("[,\\s]+");
                                for (String w : words) {
                                    if (!dictionary.exists(w.toLowerCase()) && w.matches("^[a-zA-Z]*$")) {
                                        System.out.println("Unknown word: " + w);
                                    }
                                }
                            }
                            fileScanner.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("Could not read file " + fileName);
                        }
                        break;
                    case 6:
                        System.out.println("Exiting program");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }

            scanner.close();
        }
    }

}
