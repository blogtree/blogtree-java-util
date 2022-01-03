package org.blogtree.util.common;

/**
 * String工具类
 *
 * @author AlanGeeker
 */
public class StringUtil {

    private static char char_A = 'A';
    private static char char_Z = 'Z';
    private static char char_a = 'a';
    private static char char_z = 'z';


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

    /**
     * 字符串首字母大写
     */
    public static String upperCaseFirstLetter(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        if (chars[0] >= char_a && chars[0] <= char_z) {
            chars[0] -= 32;
        }
        return String.valueOf(chars);
    }
}
