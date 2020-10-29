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
    public ActivityTestRule<ListAllDreamsActivity> listAllDreamsActivityTestRule = new ActivityTestRule<ListAllDreamsActivity>(ListAllDreamsActivity.class);
    private ListAllDreamsActivity mListAllDreamsActivity = null;

    @Before
    public void setUp() throws Exception {
        mListAllDreamsActivity = listAllDreamsActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View linearLayout = mListAllDreamsActivity.findViewById(R.id.linearLayout);
        View listView = mListAllDreamsActivity.findViewById(R.id.listView);
        View returnButton = mListAllDreamsActivity.findViewById(R.id.returnButton);
        assertNotNull(linearLayout);
        assertNotNull(listView);
        assertNotNull(returnButton);
    }

    @After
    public void tearDown() throws Exception {
    }
}