package com.problems.slidingwindow;

import lombok.extern.slf4j.Slf4j;

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
        int end, len;
        end = 0;
        int maxLen = Integer.MIN_VALUE;
        Set<Character> unique = new HashSet<>();
        char[] arr = str.toCharArray();
        Queue<Character> sub = new LinkedList<>();
        while(end < arr.length) {
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
            end++;
        }
        return maxLen;
    }

}
