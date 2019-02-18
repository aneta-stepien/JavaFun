package vi;

import org.junit.Assert;
import org.junit.Test;
import vi.TopWords;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class TopWordsTest {

    @Test
    public void getMostFrequent_oneFrequency() {
        String sentence = "3_sun 3_sun 3_sun 3_palm 3_palm 3_palm 2_water 2_water 4_fun 4_fun 4_fun 4_fun 1_holidays";
        Set<String> expected = new HashSet<>(Arrays.asList("4_fun"));
        Set<String> actual = TopWords.getMostFrequent(sentence, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMostFrequent_twoFrequencies() {
        String sentence = "3_sun 3_sun 3_sun 3_palm 3_palm 3_palm 2_water 2_water 4_fun 4_fun 4_fun 4_fun 1_holidays";
        Set<String> expected = new HashSet<>(Arrays.asList("4_fun", "3_sun", "3_palm"));
        Set<String> actual = TopWords.getMostFrequent(sentence, 2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMostFrequent_threeFrequencies() {
        String sentence = "3_sun 3_sun 3_sun 3_palm 3_palm 3_palm 2_water 2_water 4_fun 4_fun 4_fun 4_fun 1_holidays";
        Set<String> expected = new HashSet<>(Arrays.asList("4_fun", "3_sun", "3_palm", "2_water"));
        Set<String> actual = TopWords.getMostFrequent(sentence, 3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMostFrequent_fourFrequencies() {
        String sentence = "3_sun 3_sun 3_sun 3_palm 3_palm 3_palm 2_water 2_water 4_fun 4_fun 4_fun 4_fun 1_holidays";
        Set<String> expected = new HashSet<>(Arrays.asList("4_fun", "3_sun", "3_palm", "2_water", "1_holidays"));
        Set<String> actual = TopWords.getMostFrequent(sentence, 4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMostFrequent_emptySentence() {
        String sentence = "";
        Set<String> actual = TopWords.getMostFrequent(sentence, 2);
        Assert.assertEquals(0, actual.size());
    }
}