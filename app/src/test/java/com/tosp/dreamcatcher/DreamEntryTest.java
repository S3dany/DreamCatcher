package com.tosp.dreamcatcher;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class DreamEntryTest {
    private DreamEntry dayDream;


    @Before
    public void setUp() throws Exception {
        dayDream = new DreamEntry("The craziest dream", "I dreamt that i learned to code.", Mood.bad);
         }



    @Test
    public void isTitleEmpty() {
        assertTrue(dayDream.isTitleEmpty()==false);

    }
    @Test
    public void isTextEmpty() {
        assertTrue(dayDream.isTextEmpty()==false);

    }


}