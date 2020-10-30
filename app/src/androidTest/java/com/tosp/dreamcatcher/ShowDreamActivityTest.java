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

@RunWith(AndroidJUnit4.class)
public class ShowDreamActivityTest {
    @Rule
    public ActivityTestRule<ShowDreamActivity> showDreamActivityTestRule = new ActivityTestRule<ShowDreamActivity>(ShowDreamActivity.class);
    private ShowDreamActivity mShowDreamActivity = null;

    @Before
    public void setUp() throws Exception {
        mShowDreamActivity = showDreamActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View textView = mShowDreamActivity.findViewById(R.id.textView);
        View returnButton = mShowDreamActivity.findViewById(R.id.returnButton);
        assertNotNull(textView);
        assertNotNull(returnButton);
    }

    @After
    public void tearDown() throws Exception {
    }
}