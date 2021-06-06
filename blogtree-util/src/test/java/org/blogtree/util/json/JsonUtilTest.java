package org.blogtree.util.json;

import org.blogtree.util.base.BaseTest;
import org.blogtree.util.vo.UserPo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonUtilTest extends BaseTest {

    @Test
    public void toStr() {
        UserPo user = new UserPo(1L, "Michael", 20);
        String result = JsonUtil.toStr(user);
        print(result);
    }

    @Test
    public void toObj() {
        // set json
        String json = "{\"age\":20,\"id\":1,\"name\":\"Michael\"}";
        // get class
        UserPo result = JsonUtil.toObj(json, UserPo.class);
        print(result);
        print2Json(result);
    }

    @Test
    public void toList() {
        // create list
        List<UserPo> list = new ArrayList<>();
        list.add(new UserPo(1001L, "Ada", 18));
        list.add(new UserPo(1002L, "Leon", 20));

        // get json
        String json = JsonUtil.toStr(list);
        print(json);

        // get new list
        List<UserPo> newList = JsonUtil.toList(json, UserPo.class);
        print(newList);
        print2Json(newList);
    }

    @Test
    public void toMap() {
        // create map
        Map<String, Integer> map = new HashMap<>();
        map.put("Ada", 18);
        map.put("Leon", 20);

        // get json
        String json = JsonUtil.toStr(map);
        print(json);

        // get new map
        Map newMap = JsonUtil.toMap(json);
        print(newMap);
        print2Json(newMap);
    }

    @Test
    public void toMapWithClass() {
        // create map
        Map<Long, UserPo> map = new HashMap<>();
        map.put(1001L, new UserPo(1001L, "Ada", 18));
        map.put(1002L, new UserPo(1002L, "Leon", 20));

        // get json
        String json = JsonUtil.toStr(map);
        print(json);

        // get new map
        Map<String, UserPo> newMap = JsonUtil.toMap(json, UserPo.class);
        print(newMap);
        print2Json(newMap);
    }

    @Test
    public void formatJson() {
        // create list
        List<UserPo> list = new ArrayList<>();
        list.add(new UserPo(1001L, "Ada", 18));
        list.add(new UserPo(1002L, "Leon", 20));

        // get json
        String json = JsonUtil.toStr(list);
        print(json);

        // get formatJson
        String formatJson = JsonUtil.formatJson(list);
        print(formatJson);
    }
}