package com.tosp.dreamcatcher;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginActivityTest.class,
        RegisterActivityTest.class,
        NewDreamActivityTest.class
})
public class InstrumentedTestSuite {}