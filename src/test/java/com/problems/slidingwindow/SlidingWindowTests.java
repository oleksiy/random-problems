package com.problems.slidingwindow;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

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
}
