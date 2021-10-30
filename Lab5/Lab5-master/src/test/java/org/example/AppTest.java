package org.example;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void deleteAllWordsWithLengthN_deletesAllWordsWithLength5() {
        // Act
        var result = new TextManager(5).deleteAllWordsWithLengthN("word words length");

        // Assert
        Assert.assertTrue(result.contains("word"));
        Assert.assertFalse(result.contains("words"));
        Assert.assertTrue(result.contains("length"));
    }

    @Test
    public void selectThreeWords_returnsFirst3Words() {
        // Act
        var result = new TextManager(5).selectThreeWords("One Two Three Four");

        //Assert
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void selectThreeWords_returnsAllWordsFromDifferentStrings() {
        // Act
        var result1 = new TextManager(5).selectThreeWords(" One Two\n");
        var result2 = new TextManager(5).selectThreeWords(" Three ");

        // Assert
        Assert.assertEquals(0, result1.size() + result2.size());
    }
}
