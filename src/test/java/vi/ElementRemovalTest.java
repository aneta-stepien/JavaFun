package vi;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ElementRemovalTest {

    @Test
    public void countNumberOfWaysToRemoveAnElement_empty() {
        int[] elements = {};
        int expected = 0;
        int actual = ElementRemoval.countNumberOfWaysToRemoveAnElement(elements);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countNumberOfWaysToRemoveAnElement_impossible() {
        int[] elements = {1, 4, 2, 8, 7, 3};
        int expected = 0;
        int actual = ElementRemoval.countNumberOfWaysToRemoveAnElement(elements);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countNumberOfWaysToRemoveAnElement_oneSolution() {
        int[] elements = {1, 5, 8, 2, 8};
        int expected = 1;
        int actual = ElementRemoval.countNumberOfWaysToRemoveAnElement(elements);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countNumberOfWaysToRemoveAnElement_twoSolutions() {
        int[] elements = {1, 5, 8, 6, 9};
        int expected = 2;
        int actual = ElementRemoval.countNumberOfWaysToRemoveAnElement(elements);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countNumberOfWaysToRemoveAnElement_nSolutions() {
        int[] elements = {1, 2, 3, 4, 5, 6};
        int expected = 6;
        int actual = ElementRemoval.countNumberOfWaysToRemoveAnElement(elements);
        Assert.assertEquals(expected, actual);
    }

}