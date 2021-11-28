package com.problems.slidingwindow;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
public class SlidingWindowTests {

    private SlidingWindowProblem utility = new SlidingWindowProblem();

    @Test
    public void testLongestSubstringKDistinctCharacters() {
        String string = "araaci";
        int k = 2;
        assertEquals(4, utility.longestSubstringKDistinctCharacters(string, k));
    }

    @Test
    public void testMaxFruitCountOf2Types() {
        char[] arr = {'A', 'B', 'C', 'A', 'C'};
        assertEquals(3, utility.maxFruitCountOf2Types(arr));
    }

    @Test
    public void testNoRepeatSubstring() {
        String a = "aabccbb";
        assertEquals(3, utility.noRepeatSubstring(a));
    }

    @Test
    public void testLongestSubstringWithSameLettersAfterReplacement() {
        String a = "abccde";
        int k = 1;
        Map<Character, Integer> map = new HashMap<>();
        assertEquals(3, utility.longestSubstringKDistinctCharacters(a, k));
    }
}
