package com.tosp.dreamcatcher;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginActivityTest.class,
        RegisterActivityTest.class,
        NewDreamActivityTest.class,
        MainActivityTest.class,
        ShowDreamActivityTest.class,
        ListAllDreamsActivityTest.class
})
public class InstrumentedTestSuite {}