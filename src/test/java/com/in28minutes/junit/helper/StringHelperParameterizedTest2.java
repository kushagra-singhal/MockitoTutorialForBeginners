package com.in28minutes.junit.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest2 {

    //ABCD => FALSE, ABAB => TRUE, AB => TRUE, A => FALSE
    StringHelper helper = new StringHelper();

    private String input;
    private boolean expectedOutput;

    public StringHelperParameterizedTest2(String input, boolean expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions(){

        Object expectedOutputs[][] = new Object[][]{
                {"ABCD", false},
                {"ABAB", true},
                {"AB",true},
                {"A", false}

        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testAreFirstAndLastCharactersTheSame() {
        assertEquals(expectedOutput,helper.areFirstAndLastTwoCharactersTheSame(input));

    }
}

