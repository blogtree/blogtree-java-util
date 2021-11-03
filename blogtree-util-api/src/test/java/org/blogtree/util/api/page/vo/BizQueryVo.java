package org.blogtree.util.api.page.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class BizQueryVo {

    private static final long serialVersionUID = 3773663611314755402L;

    private Long id;

    private String name;

}
