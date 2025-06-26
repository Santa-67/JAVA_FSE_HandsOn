package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    EvenCheckerTest.class,
    StringUtilsTest.class
})
public class AllTests {
    // This class remains empty, it is used only as a holder for the above annotations
}
