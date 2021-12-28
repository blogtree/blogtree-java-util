package org.blogtree.util.json.common;

import org.blogtree.util.base.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class FormatJsonUtilTest extends BaseTest {

    @Test
    public void formatJson() {
        // [{"age":18,"id":1001,"name":"Ada"},{"age":20,"id":1002,"name":"Leon"}]
        String json = "[{\"age\":18,\"id\":1001,\"name\":\"Ada\"},{\"age\":20,\"id\":1002,\"name\":\"Leon\"}]";
        String formatJson = FormatJsonUtil.formatJson(json);
        print(json);
        print(formatJson);
    }
}