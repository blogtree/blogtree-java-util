package org.blogtree.util.common;

import org.junit.Test;

public class StringUtilTest {

    @Test
    public void getCharCount() {
        assert 0 == StringUtil.getCharCount("", 'h');
        assert 0 == StringUtil.getCharCount("abcxxdef", 'h');
        assert 1 == StringUtil.getCharCount("abcxxdef", 'a');
        assert 2 == StringUtil.getCharCount("abcxxdef", 'x');

        assert 0 == StringUtil.getCharCount("".toCharArray(), 'h');
        assert 0 == StringUtil.getCharCount("abcxxdef".toCharArray(), 'h');
        assert 1 == StringUtil.getCharCount("abcxxdef".toCharArray(), 'a');
        assert 2 == StringUtil.getCharCount("abcxxdef".toCharArray(), 'x');
    }

}