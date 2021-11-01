package org.blogtree.util.common;

import org.blogtree.util.base.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharUtilTest extends BaseTest {

    @Test
    public void toLowerCase() {
        assert 'a' == CharUtil.toLowerCase('A');
        assert 'b' == CharUtil.toLowerCase('B');
        assert 'y' == CharUtil.toLowerCase('Y');
        assert 'z' == CharUtil.toLowerCase('Z');
        assert '3' == CharUtil.toLowerCase('3');
        assert '-' == CharUtil.toLowerCase('-');
        assert ' ' == CharUtil.toLowerCase(' ');
    }

    @Test
    public void toUpperCase() {
        assert 'A' == CharUtil.toUpperCase('a');
        assert 'B' == CharUtil.toUpperCase('b');
        assert 'Y' == CharUtil.toUpperCase('y');
        assert 'Z' == CharUtil.toUpperCase('z');
        assert '3' == CharUtil.toLowerCase('3');
        assert '-' == CharUtil.toLowerCase('-');
        assert ' ' == CharUtil.toLowerCase(' ');
    }
}