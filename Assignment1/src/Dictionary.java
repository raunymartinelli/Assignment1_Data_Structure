// This class represents a dictionary of words and their meanings

public class Dictionary {
    private WordInfo[] words;
    private int count;

    public Dictionary(int size) {
        words = new WordInfo[size];
        count = 0;
    }

    // Add a new word to the dictionary
    public boolean add(String word, String meaning) {
        if (exists(word)) {
            return false;
        }
        if (count == words.length) {
            return false;
        }
        WordInfo newWord = new WordInfo(word, meaning);
        int index = findInsertionIndex(word);
        for (int i = count; i > index; i--) {
            words[i] = words[i-1];
        }
        words[index] = newWord;
        count++;
        return true;
    }
    // Delete a word from the dictionary
    public boolean delete(String word) {
        int index = findIndex(word);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < count-1; i++) {
            words[i] = words[i+1];
        }
        words[count-1] = null;
        count--;
        return true;
    }
    // Check if a word exists in the dictionary
    public boolean exists(String word) {
        return findIndex(word) != -1;
    }
    // Get the meaning of a word from the dictionary
    public String getMeaning(String word) {
        int index = findIndex(word);
        if (index == -1) {
            return null;
        }
        return words[index].getMeaning();
    }
    // Get the number of words in the dictionary
    public int getCount() {
        return count;
    }
    // Print a list of all the words in the dictionary in alphabetical order
    public String printWordList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(words[i].getWord()).append("\n");
        }
        return sb.toString();
    }
    // Print the full word and meaning for each word in the dictionary in ascending order
    public void printDictionary() {
        for (int i = 0; i < count; i++) {
            System.out.println(words[i]);
        }
    }
    // Find the index of a word in the dictionary, or -1 if it is not in the dictionary
    private int findIndex(String word) {
        int lo = 0;
        int hi = count - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = words[mid].getWord().compareTo(word);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    private int findInsertionIndex(String word) {
        int lo = 0;
        int hi = count - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = words[mid].getWord().compareTo(word);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
