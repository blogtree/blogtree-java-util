package org.blogtree.util.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.blogtree.util.base.BaseTest;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonUtilTest extends BaseTest {

    @Test
    public void toStr() {
        User student = new User(1L, "Michael", 20);
        String result = JsonUtil.toStr(student);
        print(result);
    }

    @Test
    public void toObj() {
        // set json
        String json = "{\"age\":20,\"id\":1,\"name\":\"Michael\"}";
        // get class
        User result = JsonUtil.toObj(json, User.class);
        print(result);
        print2Json(result);
    }

    @Test
    public void toList() {
        // create list
        List<User> list = new ArrayList<>();
        list.add(new User(1001L, "Ada", 18));
        list.add(new User(1002L, "Leon", 20));

        // get json
        String json = JsonUtil.toStr(list);
        print(json);

        // get new list
        List<User> newList = JsonUtil.toList(json, User.class);
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
        Map<Long, User> map = new HashMap<>();
        map.put(1001L, new User(1001L, "Ada", 18));
        map.put(1002L, new User(1002L, "Leon", 20));

        // get json
        String json = JsonUtil.toStr(map);
        print(json);

        // get new map
        Map<String, User> newMap = JsonUtil.toMap(json, User.class);
        print(newMap);
        print2Json(newMap);
    }

    @Test
    public void formatJson() {
        // create list
        List<User> list = new ArrayList<>();
        list.add(new User(1001L, "Ada", 18));
        list.add(new User(1002L, "Leon", 20));

        // get json
        String json = JsonUtil.toStr(list);
        print(json);

        // get formatJson
        String formatJson = JsonUtil.formatJson(list);
        print(formatJson);
    }

    @Data
    @AllArgsConstructor
    public class User implements Serializable {

        private static final long serialVersionUID = 3042633748297505811L;

        private Long id;

        private String name;

        private Integer age;
    }

}