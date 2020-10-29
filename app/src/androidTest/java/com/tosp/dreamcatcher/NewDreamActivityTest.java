package com.tosp.dreamcatcher;

import android.view.View;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class NewDreamActivityTest {
    @Rule
    public ActivityTestRule<NewDreamActivity> newdreamActivityTestRule = new ActivityTestRule<NewDreamActivity>(NewDreamActivity.class);
    private NewDreamActivity mNewDreamActivity = null;


    @Before
    public void setUp() throws Exception {
        mNewDreamActivity = newdreamActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View badMoodButton = mNewDreamActivity.findViewById(R.id.bad_button);
        View goodMoodButton = mNewDreamActivity.findViewById(R.id.good_button);
        View neutralMoodButton = mNewDreamActivity.findViewById(R.id.neutral_button);
        View saveButton = mNewDreamActivity.findViewById(R.id.save_button);
        View questMood = mNewDreamActivity.findViewById(R.id.moodQuestion);
        View textDream = mNewDreamActivity.findViewById(R.id.dreamInput);

        assertNotNull(badMoodButton);
        assertNotNull(goodMoodButton);
        assertNotNull(neutralMoodButton);
        assertNotNull(questMood);
        assertNotNull(saveButton);
        assertNotNull(textDream);

    }


    @After
    public void tearDown() throws Exception {
    }
}