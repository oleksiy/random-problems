package com.problems.slidingwindow;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Documented;
import java.util.*;

@Slf4j
public class SlidingWindowProblem {
    public int minSizeSubArray(int S, int[]arr) {
        return 0;
    }
    public int maxSumSubArrayOfSizeK(int k, int[]arr) {
        return 0;
    }
    //easy
    public int minSizeSubArraySum(int S, int[] arr) {
        log.debug(Arrays.toString(arr) + " target: " + S);
        int start,len,minLen, end, sum;
        start = len = minLen = sum = end = 0;
        log.debug("Sum: " + sum + " start: " + start + " end: " + end + " length: " + len + " currentMin: " + minLen);
        boolean advanceEnd = true;
        while(end < arr.length) {
            if(advanceEnd)
                sum += arr[end];
            if(sum >= S) {
                len = end - start + 1;
                if(minLen == 0) {
                    minLen = len;
                } else {
                    minLen = Math.min(len, minLen);
                }
                log.debug("hit target " + sum);
                log.debug("Sum: " + sum + " start: " + start + " end: " + end + " length: " + len + " currentMin: " + minLen);
                sum -=arr[start];
                start++;
                advanceEnd = false;
            } else {
                end++;
                advanceEnd = true;
            }
        }
        return minLen;
    }

    public int longestSubstringKDistinctCharacters(String str, int k) {
        int len;
        int maxLen = Integer.MIN_VALUE;
        Set<Character> unique = new HashSet<>();
        char[] arr = str.toCharArray();
        Queue<Character> sub = new LinkedList<>();

        for(int end = 0; end < arr.length; end++) {
            unique.add(arr[end]);
            sub.add(arr[end]);
            log.info("{} - {}", sub, unique);
            if (unique.size() <= k) {
                len = sub.size();
                maxLen = Math.max(len, maxLen);
            } else {
                while(unique.size() > k) {
                    char removed = sub.remove();
                    if(!sub.contains(removed) && unique.contains(removed)) {
                        unique.remove(removed);
                        log.info("removing {} from unique set - {}", removed, unique);
                    }
                }
            }
        }
        return maxLen;
    }

    /**
     * Given an array of characters where each character represents a fruit tree, you are given two baskets, and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
     * You can start with any tree, but you can’t skip a tree once you have started. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
     * Write a function to return the maximum number of fruits in both baskets.
     * @param arr
     * @return maximum number of fruit you can put in two baskets (can't mix types)
     */
    public static int maxFruitCountOf2Types(char[] arr) {
        System.out.println(Arrays.toString(arr));
        final int BASKETS = 2;
        int maxLen = Integer.MIN_VALUE, start = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int end = 0; end < arr.length; end++){
            char rChar = arr[end];
            charMap.put(rChar, charMap.getOrDefault(rChar, 0) + 1);
            while(charMap.size() > BASKETS) {
                char lChar = arr[start];
                charMap.put(lChar, charMap.get(lChar) - 1);
                if(charMap.get(lChar) == 0) {
                    charMap.remove(lChar);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        log.info(charMap.toString());
        return maxLen;
    }

    public static int noRepeatSubstring(String str) {
        Queue<Character> q = new LinkedList<>();
        char[] arr = str.toCharArray();
        int maxLen = Integer.MIN_VALUE;
        for(int end = 0; end < arr.length; end ++) {
            if(q.contains(arr[end])) {
                while(q.peek() != arr[end]) {
                    q.remove();
                }
            } else {
                q.add(arr[end]);
                maxLen = Math.max(maxLen, q.size());
            }
        }
        return maxLen;
    }

    public static int longestSubstringWithSameLettersAfterReplacement(String str, int k) {
        int windowStart = 0;
        Map<Character, Integer> occurrenceMap = new HashMap<>();
        int maxLength = 0;
        int mostFrequentCharCount = 0;
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rChar = str.charAt(windowEnd);
            occurrenceMap.put(rChar, occurrenceMap.getOrDefault(rChar, 0) + 1);
            mostFrequentCharCount = Math.max(mostFrequentCharCount, occurrenceMap.get(rChar));
            if(windowEnd - windowStart + 1 - mostFrequentCharCount > k) {
                char lChar = str.charAt(windowStart);
                occurrenceMap.put(lChar, occurrenceMap.get(lChar) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static int longestSubArrayWithOnesReplacement(int[] arr, int k) {
        int windowStart = 0;
        int maxLen = 0;
        int maxOnesCount = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if(arr[windowEnd] == 1) {
                maxOnesCount++;
            }

            //if there's more than k zeros, we have to start trimming down the window
            if(windowEnd - windowStart + 1 - maxOnesCount > k) {
                if(arr[windowStart] == 1) {
                    maxOnesCount--;
                }
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }

    /**
     * Given a string and a pattern, find out if the string contains any permutation of the pattern.
     *
     * Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
     *
     * abc
     * acb
     * bac
     * bca
     * cab
     * cba
     * If a string has ‘n’ distinct characters, it will have n! permutations.
     *
     * Example 1:
     *
     * Input: String="oidbcaf", Pattern="abc"
     * Output: true
     * Explanation: The string contains "bca" which is a permutation of the given pattern.
     *
     * Example 2:
     *
     * Input: String="odicf", Pattern="dc"
     * Output: false
     * Explanation: No permutation of the pattern is present in the given string as a substring.
     *
     * @return true or false
     */
    public static boolean problemChallengeOne(String input, String permutation) {
        int windowSize = permutation.length();
        int windowStart = 0;
        if(windowSize > input.length())
            return false;

        for(int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            int matchCounter = 0;
            if (windowEnd - windowStart + 1 == windowSize) {
                log.info("window size hit at start {} and end {}", windowStart, windowEnd);
                for (int i = windowStart; i <= windowEnd; i++) {
                    String c = String.valueOf(input.charAt(i));
                    log.info("checking if {} is in {}", input.charAt(i), permutation);
                    if(permutation.contains(c)) {
                        matchCounter++;
                    }
                    if(matchCounter == windowSize)
                        return true;
                }
                windowStart++;
            }
        }
        return false;
    }

    public static boolean problemChallengeOneMoreEfficient(String input, String permutation) {
        int windowStart = 0;
        int matchCounter = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();

        //fill frequency map
        for(char c: permutation.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for(int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char rChar = input.charAt(windowEnd);
            if(frequencyMap.containsKey(rChar)) {
                frequencyMap.put(rChar, frequencyMap.get(rChar) - 1);
                if(frequencyMap.get(rChar) == 0) {
                    matchCounter++;
                }
            }

            if(matchCounter == permutation.length())
                return true;
            //as soon as we exceed the first n characters (size of the permutation), we want to
            //make sure we maintain a window equal to the permutation.
            //Increment the start, check if that character is in the map
            //if it is in the map, but we already matched it to 0 times, decrement the match counter
            //re-add that character back to the frequency map, incrementing its count
            if(windowEnd >= permutation.length()) {
                windowStart++;
                char lChar = input.charAt(windowStart);
                if(frequencyMap.containsKey(lChar)) {
                    if(frequencyMap.get(lChar) == 0)
                        matchCounter--;
                    frequencyMap.put(lChar, frequencyMap.get(lChar) + 1);
                }
            }
        }
        return false;
    }

    public static List<Integer> problemChallengeTwo(String str, String pattern) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        //create frequency map
        for(char c: pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        log.info("Starting out with map {}", map);
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            if(windowEnd - windowStart + 1 == pattern.length()) {
                boolean isMatch = isAnagram(str.substring(windowStart, windowEnd+1), pattern, new HashMap<>(map));
                log.info("startIndex {} endIndex {} - match found? {}", windowStart, windowEnd, isMatch);
                if(isMatch) {
                    result.add(windowStart);
                    windowStart++;
                } else {
                    windowStart++;
                }
            }
        }
        return result;
    }

    private static boolean isAnagram(String str, String pattern, Map<Character, Integer> map) {
        log.info("substring passed {}, map {}", str, map);
        for(char c : pattern.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }
        for(char c : map.keySet()) {
            if(map.get(c) != 0)
                return false;
        }
        return true;
    }

    public String problemChallengeThree(String str, String pattern) {
        String result = "";
        int windowStart = 0;
        int matchCount = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        //Build a frequency map which will be used for matching, all chars are matched when their counts >=0
        for(char c: pattern.toCharArray())
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd ++) {
            char rChar = str.charAt(windowEnd);
            if(frequencyMap.containsKey(rChar)) {
                frequencyMap.put(rChar, frequencyMap.get(rChar) - 1);
                if(frequencyMap.get(rChar) == 0) {
                    log.info("match found for {}", rChar);
                    matchCount++;
                }
            }

            //attempt to shrink the window to fit the pattern
            if(windowEnd >= pattern.length() - 1) {
                log.info("{}", frequencyMap);
                char lChar = str.charAt(windowStart++);
                log.info("Looking at {}", lChar);
                if(frequencyMap.containsKey(lChar)) {
                    if(frequencyMap.get(lChar) < 0) {
                        log.info("too many, now start is {}", windowStart);
                        frequencyMap.put(lChar, frequencyMap.get(lChar) + 1);
                    }
                }
            }

            if(matchCount == pattern.length()) {
                log.info("pattern matched! start {} end {}", windowStart, windowEnd);
                result = str.substring(windowStart, windowEnd+1);
            }
        }
        return result;
    }
}
