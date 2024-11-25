/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		String ans1 = "";
		String ans2 = "";
		
		for (int i = 0; i < str1.length(); i++) {
			char c = str1.charAt(i);

			if (c != ' ') {
				ans1 = ans1 + str1.charAt(i);
			}
		}
		str1 = ans1;

		for (int i = 0; i < str2.length(); i++) {
			char c = str2.charAt(i);

			if (c != ' ') {
				ans2 = ans2 + str2.charAt(i);
			}
		}
		str2 = ans2;

		if (str1.length() != str2.length()) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++){
			char c1 = str1.charAt(i);
			boolean found = false;

			for (int t = 0; t < str1.length(); t++) {
				if (c1 == str2.charAt(t)) {
					str2 = str2.substring(0, t) + str2.substring(t + 1);
					found = true;
					break;
					}
				}
				if (!found) {
					return false;
				}
			}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		str = str.toLowerCase();
		String ans = "";
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c != '?' && c != '!') {
				ans = ans + str.charAt(i);
			}
		}
		return ans;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		
		str = preProcess(str);
		int wordLength = str.length();
		String randomWord = "";

		while (wordLength > 0){
			int randomIndex = (int) (Math.random() * wordLength);
			char c = str.charAt(randomIndex);
			randomWord = randomWord + c;
			str = str.substring(0, randomIndex) + str.substring(randomIndex + 1);
			wordLength--;
		}
		return randomWord;
	}
}
