package com.problems.slidingwindow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        int start, end, len;
        start = end = len = 0;
        int maxLen = Integer.MIN_VALUE;
        Set<Character> unique = new HashSet<>();
        String sub = "";
        for(end = 1;end < str.length(); end++) {
            sub = str.substring(start, end);
            unique.add(str.charAt(end));
            log.info("{} - {}",sub, unique.toString());
            if(unique.size() <= k) {
                unique.add(str.charAt(end));
                //record length so far
                len = sub.length();
                maxLen = Math.max(len, maxLen);
            } else {
                start++;

            }
        }
        return maxLen;
    }

}
