package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NumberGameTest {
    @InjectMocks @Spy NumberGame numberGame = new NumberGame();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void executeNumberGame() {
        String userInput = "60"+System.getProperty("line.separator")+"no"+System.getProperty("line.separator");
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        Random random = Mockito.mock(Random.class);
        Scanner scanner = new Scanner(System.in);
        when(random.nextInt()).thenReturn(60);
        String actual = numberGame.playNumberGame(-1,60,scanner,0,"yes");
        Assert.assertNotNull(actual);
        Assert.assertEquals("no",actual);
    }
}