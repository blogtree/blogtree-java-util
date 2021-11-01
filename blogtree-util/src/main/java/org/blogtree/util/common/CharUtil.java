package org.blogtree.util.common;

/**
 * char工具类
 *
 * @author AlanGeeker
 */
public class CharUtil {

    private static char char_A = 'A';
    private static char char_Z = 'Z';
    private static char char_a = 'a';
    private static char char_z = 'z';

    /**
     * char 英文字母小写
     */
    public static char toLowerCase(char c) {
        if (c >= char_A && c <= char_Z) {
            c += 32;
        }
        return c;
    }

    /**
     * char 英文字母小写
     */
    public static char toUpperCase(char c) {
        if (c >= char_a && c <= char_z) {
            c -= 32;
        }
        return c;
    }
}
