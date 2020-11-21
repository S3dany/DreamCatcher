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
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mMainActivity = null;

    @Before
    public void setUp() throws Exception {
        mMainActivity = mainActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View new_dream_button = mMainActivity.findViewById(R.id.new_dream_button);
        View view_dreams_button = mMainActivity.findViewById(R.id.view_dreams_button);
        View Welcome_Message = mMainActivity.findViewById(R.id.Welcome_Message);

        assertNotNull(new_dream_button);
        assertNotNull(view_dreams_button);
        assertNotNull(Welcome_Message);
    }

    @After
    public void tearDown() throws Exception {
    }
}