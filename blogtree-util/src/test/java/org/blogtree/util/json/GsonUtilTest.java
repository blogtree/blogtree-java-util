package org.blogtree.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.blogtree.util.base.BaseTest;
import org.blogtree.util.vo.UserPo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GsonUtilTest extends BaseTest {

    @Test
    public void toStr() {
        UserPo user = new UserPo(1L, "Michael", 20);
        String result = GsonUtil.toStr(user);
        print(result);
        // {"id":1,"name":"Michael","age":20}
        assert "{\"id\":1,\"name\":\"Michael\",\"age\":20}".equals(result);
    }

    @Test
    public void toObj() {
        // set json
        String json = "{\"id\":1,\"age\":20,\"name\":\"Michael\"}";
        // get class
        UserPo result = GsonUtil.toObj(json, UserPo.class);
        print(result);
        print2Json(result);
        assert result != null;
        assert 1 == result.getId();
        assert 20 == result.getAge();
        assert "Michael".equals(result.getName());
    }

    @Test
    public void toList() throws JsonProcessingException {
        // create list
        List<UserPo> list = new ArrayList<>();
        list.add(new UserPo(1001L, "Ada", 18));
        list.add(new UserPo(1002L, "Leon", 20));

        // get json
        String json = GsonUtil.toStr(list);
        print(json);
        // [{"id":1001,"name":"Ada","age":18},{"id":1002,"name":"Leon","age":20}]
        assert "[{\"id\":1001,\"name\":\"Ada\",\"age\":18},{\"id\":1002,\"name\":\"Leon\",\"age\":20}]".equals(json);

        // get new list
        List<UserPo> newList = GsonUtil.toList(json, UserPo.class);
        print(newList);
        print2Json(newList);
        assert newList != null;
        assert newList.size() == 2;
//        assert 1001L == newList.get(0).getId();
//        assert 18 == newList.get(0).getAge();
//        assert "Ada".equals(newList.get(0).getName());
    }

    @Test
    public void toMap() {
        // create map
        Map<String, Integer> map = new HashMap<>();
        map.put("Ada", 18);
        map.put("Leon", 20);

        // get json
        String json = GsonUtil.toStr(map);
        print(json);
        // {"Leon":20,"Ada":18}
        assert "{\"Leon\":20,\"Ada\":18}".equals(json);

        // get new map
        Map<String, Object> newMap = GsonUtil.toMap(json);
        print(newMap);
        print2Json(newMap);
        assert newMap != null;
        assert newMap.size() == 2;
        assert newMap.get("Ada") != null;
        assert 18 == (int) newMap.get("Ada");
    }

    @Test
    public void toMapWithClass() {
        // create map
        Map<Long, UserPo> map = new HashMap<>();
        map.put(1001L, new UserPo(1001L, "Ada", 18));
        map.put(1002L, new UserPo(1002L, "Leon", 20));

        // get json
        String json = GsonUtil.toStr(map);
        print(json);
        // {"1001":{"id":1001,"name":"Ada","age":18},"1002":{"id":1002,"name":"Leon","age":20}}
        assert "{\"1001\":{\"id\":1001,\"name\":\"Ada\",\"age\":18},\"1002\":{\"id\":1002,\"name\":\"Leon\",\"age\":20}}".equals(json);

        // get new map
        Map<String, UserPo> newMap = GsonUtil.toMap(json, UserPo.class);
        print(newMap);
        print2Json(newMap);
        assert newMap != null;
        assert newMap.size() == 2;
        assert newMap.get("1001") != null;
        assert 1001L == newMap.get("1001").getId();
        assert 18 == newMap.get("1001").getAge();
        assert "Ada".equals(newMap.get("1001").getName());
    }

    @Test
    public void formatJson() {
        // create list
        List<UserPo> list = new ArrayList<>();
        list.add(new UserPo(1001L, "Ada", 18));
        list.add(new UserPo(1002L, "Leon", 20));

        // get json
        String json = GsonUtil.toStr(list);
        print(json);

        // get formatJson
        String formatJson = GsonUtil.formatJson(list);
        print(formatJson);
    }
}