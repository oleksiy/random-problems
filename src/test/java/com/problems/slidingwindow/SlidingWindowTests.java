package com.problems.slidingwindow;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


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
        assertEquals(3, utility.longestSubstringWithSameLettersAfterReplacement(a, k));
    }

    @Test
    public void testLongestSubstringWithSameLettersAfterReplacement2() {
        String a = "aabccbb";
        int k = 2;
        assertEquals(5, utility.longestSubstringWithSameLettersAfterReplacement(a, k));
    }

    @Test
    public void testLongestSubArrayWithOnesReplacement() {
        int[] arr = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k = 3;
        assertEquals(9, utility.longestSubArrayWithOnesReplacement(arr, k));
        int[] arr2 = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int k2 = 2;
        assertEquals(6, utility.longestSubArrayWithOnesReplacement(arr2, k2));
    }

    @Test
    public void testProblemOneChallengeTest1() {
        String input = "oidbcaf";
        String permutation = "abc";
        assertTrue(utility.problemChallengeOne(input, permutation));
    }

    @Test
    public void testProblemOneChallengeTest2() {
        String input = "odicf";
        String permutation = "dc";
        assertFalse(utility.problemChallengeOne(input, permutation));
    }

    @Test
    public void testProblemOneChallengeMoreEfficientTest1() {
        String input = "oidbcaf";
        String permutation = "abc";
        assertTrue(utility.problemChallengeOneMoreEfficient(input, permutation));
    }

    @Test
    public void testProblemOneChallengeMoreEfficientTest2() {
        String input = "odicf";
        String permutation = "dc";
        assertFalse(utility.problemChallengeOneMoreEfficient(input, permutation));
    }

    @Test
    public void testProblemChallengeTwoTest1() {
        String input = "ppqp";
        String pattern = "qp";
        int[] exResult = {1,2};
        List<Integer> result = utility.problemChallengeTwo(input, pattern);

        log.debug("{}", result);
        for(int e: exResult) {
            assertTrue(result.contains(e), "Doesn't contain " + e);
        }
    }

    @Test
    public void testProblemChallengeTwoTest2() {
        String input = "ppqp";
        String pattern = "qp";
        int[] exResult = {1,2};
        List<Integer> result = utility.problemChallengeTwo(input, pattern);

        log.debug("{}", result);
        for(int e: exResult) {
            assertTrue(result.contains(e), "Doesn't contain " + e);
        }
    }

    @Test
    @Disabled
    public void testProblemChallengeThreeTest1() {
        String input = "aabdec";
        String pattern = "abc";
        String expResult = "abdec";
        assertEquals(expResult, utility.problemChallengeThree(input, pattern));
    }

    @Test
    @Disabled
    public void testProblemChallengeThreeTest2() {
        String input = "abdbca";
        String pattern = "abc";
        String expResult = "bca";
        assertEquals(expResult, utility.problemChallengeThree(input, pattern));
    }

    @Test
    public void testLeetCodeSlidingWindowProblem() {
        String s = "abcabcbb";
        String s2 = "pwwkew";
        assertEquals(3, utility.leetCodeSlidingWindowProblem(s));
        assertEquals(3, utility.leetCodeSlidingWindowProblem(s2));
    }

    @Test
    public void testLeetCodeLongestPalindromicSubstring() {
        String s = "babad";
        String result = "bab";
        log.info(utility.leetCodeLongestPalindromicSubstring(s));

    }


}
