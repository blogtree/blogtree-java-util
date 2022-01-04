package org.blogtree.util.json;

/**
 * 格式化JSON工具
 */
class CommonJsonUtil {
    /**
     * 格式化json字符串。增加制表符和回车，用于json字符串的打印
     *
     * @param json json字符串
     * @return 格式化的字符串，带回车
     */
    protected static String formatJson(String json) {
        if (null == json || "".equals(json)) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        boolean isInQuotationMarks = false;
        for (int i = 0; i < json.length(); i++) {
            last = current;
            current = json.charAt(i);
            switch (current) {
                case '"':
                    if (last != '\\') {
                        isInQuotationMarks = !isInQuotationMarks;
                    }
                    builder.append(current);
                    break;
                case '{':
                case '[':
                    builder.append(current);
                    if (!isInQuotationMarks) {
                        builder.append('\n');
                        indent++;
                        addIndentBlank(builder, indent);
                    }
                    break;
                case '}':
                case ']':
                    if (!isInQuotationMarks) {
                        builder.append('\n');
                        indent--;
                        addIndentBlank(builder, indent);
                    }
                    builder.append(current);
                    break;
                case ',':
                    builder.append(current);
                    if (last != '\\' && !isInQuotationMarks) {
                        builder.append('\n');
                        addIndentBlank(builder, indent);
                    }
                    break;
                default:
                    builder.append(current);
            }
        }
        return builder.toString();
    }

    /**
     * formatJson用到的私有方法：添加制表符
     *
     * @param builder 要拼接的字符串
     * @param indent  缩进长度
     */
    private static void addIndentBlank(StringBuilder builder, int indent) {
        for (int i = 0; i < indent; i++) {
            builder.append('\t');
        }
    }
}
