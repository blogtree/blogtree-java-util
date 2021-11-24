package org.blogtree.util.common;

/**
 * String工具类
 *
 * @author AlanGeeker
 */
public class StringUtil {
    /**
     * 获取某个字符在字符串中的数量
     */
    public static int getCharCount(String s, char c) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        return getCharCount(chars, c);
    }

    /**
     * 获取某个字符在字符串中的数量
     */
    public static int getCharCount(char[] chars, char c) {
        if (chars.length == 0) {
            return 0;
        }
        int count = 0;
        for (char item : chars) {
            if (item == c) {
                count++;
            }
        }
        return count;
    }
}
