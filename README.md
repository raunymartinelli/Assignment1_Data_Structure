# Assignment1_Data_Structure
This is a Java program that implements a personal dictionary and spellcheck program using the WordInfo and Dictionary classes. The program loads the initial word list from a file called "wordlist.txt", and allows the user to add new words with their meanings, delete existing words, get the meanings of words, print the list of all the words in the dictionary in alphabetical order, and spellcheck a text file and print all the words that are not in the dictionary.

The program starts by importing the required libraries - Scanner, File, and FileNotFoundException. It then defines the Main class that contains the main method of the program.

Inside the main method, the program creates an instance of the Scanner class to read user input, and an instance of the Dictionary class with a maximum size of 1000. It then tries to read the initial word list from the "wordlist.txt" file and adds each word to the dictionary with an undefined meaning. If the file is not found, the program prints an error message.

The program then displays a menu to the user with six options. It reads the user's choice and performs the corresponding action using a switch statement. If the user enters an invalid choice, the program prints an error message and continues to display the menu.

The first option allows the user to add a new word to the dictionary. The program reads the user's input for the word and checks if the word already exists in the dictionary. If the word exists, the program prints an error message. Otherwise, the program reads the user's input for the meaning and adds the word to the dictionary. If the dictionary is full, the program prints an error message.

The second option allows the user to delete a word from the dictionary. The program reads the user's input for the word and deletes the word from the dictionary if it exists. If the word is not found, the program prints an error message.

The third option allows the user to get the meaning of a word from the dictionary. The program reads the user's input for the word and retrieves the meaning from the dictionary. If the word is not found, the program prints an error message.

The fourth option allows the user to print a list of all the words in the dictionary in alphabetical order.

The fifth option allows the user to spellcheck a text file and print all the words that are not in the dictionary. The program reads the user's input for the file name and reads each line of the file. It then splits each line into individual words and checks if each word exists in the dictionary. If the word does not exist and only contains letters, the program prints an error message.

The sixth and final option allows the user to exit the program.
