package com.problems.slidingwindow;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class SlidingWindowTests {
    @Test
    public void testSlidingWindow() {
        String string = "abbacca";
        Set<Character> s = new HashSet<>();
        char[] charArray = string.toCharArray();
        for(char c: charArray) {
            s.add(c);
        }

        if(string.contains(s.toString())) {
            log.info("yep, it's in there");
        }
    }
}
