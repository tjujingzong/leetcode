import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
// You are given a 0-indexed string word of length n consisting of digits, and a positive integer m.

// The divisibility array div of word is an integer array of length n such that:

// div[i] = 1 if the numeric value of word[0,...,i] is divisible by m, or
// div[i] = 0 otherwise.
// Return the divisibility array of word.

// Example 1:

// Input: word = "998244353", m = 3
// Output: [1,1,0,0,0,1,1,0,0]
// Explanation: There are only 4 prefixes that are divisible by 3: "9", "99", "998244", and "9982443".
// Example 2:

// Input: word = "1010", m = 10
// Output: [0,1,0,1]
// Explanation: There are only 2 prefixes that are divisible by 10: "10", and "1010".
class Solution {
  public int[] divisibilityArray(String word, int m) {
    int[] result = new int[word.length()];
    long temp = 0;
    for (int i = 0; i < word.length(); i++) {
      temp = (temp * 10 + word.charAt(i) - '0') % m;
      if (temp == 0) {
        result[i] = 1;
      }
    }
    return result;
  }
}