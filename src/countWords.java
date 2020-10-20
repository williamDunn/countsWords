
// William Dunn - Assignment 5 - CPSC 323

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class countWords {

	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();
		String file = "sample input.txt";
		String word;
		String[] wordArray;

		BufferedReader read = new BufferedReader(new FileReader(file));

		String line = read.readLine();

		while (line != null) {
			wordArray = line.split(" ");

			line = read.readLine();

			for (String words : wordArray) {
				word = words.replaceAll("[^A-Za-z]", "");
				word = word.toLowerCase();
				if (word != null) {
					if (wordsMap.containsKey(word)) {
						int wordAppearances = wordsMap.get(word) + 1;

						wordsMap.put(word, wordAppearances);
					} else {
						wordsMap.put(word, 1);
					}
				}
			}
		}

		read.close();

		PrintWriter write = new PrintWriter("newFile.txt", "UTF-8");
		Set<Entry<String, Integer>> hashSet = wordsMap.entrySet();
		hashSet = wordsMap.entrySet();
		for (Entry entry : hashSet) {
			// System.out.println(entry.getKey()+","+entry.getValue());
			write.println(entry.getKey() + "," + entry.getValue());
		}
		write.close();
	}

}
