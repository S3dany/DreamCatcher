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
public class ListAllDreamsActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity> loginActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);
    private LoginActivity mLoginActivity = null;

    @Before
    public void setUp() throws Exception {
        mLoginActivity = loginActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View linearLayout = mLoginActivity.findViewById(R.id.linearLayout);
        View listView = mLoginActivity.findViewById(R.id.listView);
        View returnButton = mLoginActivity.findViewById(R.id.returnButton);
        assertNotNull(linearLayout);
        assertNotNull(listView);
        assertNotNull(returnButton);
    }

    @After
    public void tearDown() throws Exception {
    }
}