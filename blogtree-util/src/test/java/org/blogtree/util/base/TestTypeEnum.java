package org.blogtree.util.base;

import lombok.Getter;

@Getter
public enum TestTypeEnum implements BaseEnum<TestTypeEnum> {
    type1(1, "type1 text"),
    type2(2, "type2 text"),
    type3(3, "type3 text"),
    //
    ;

    private Integer value;
    private String text;

    TestTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public TestTypeEnum[] getList() {
        return TestTypeEnum.values();
    }
}
