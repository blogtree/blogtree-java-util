package org.blogtree.util.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class UserPo implements Serializable {

    private static final long serialVersionUID = -663783266614202953L;

    private Long id;

    private String name;

    private Integer age;

    public UserPo() {
    }

    public UserPo(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
