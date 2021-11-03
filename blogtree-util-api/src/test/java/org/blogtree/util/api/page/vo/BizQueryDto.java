package org.blogtree.util.api.page.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.blogtree.util.api.page.PageDto;

@Getter
@Setter
@Accessors(chain = true)
public class BizQueryDto extends PageDto {

    private static final long serialVersionUID = 3773663611314755402L;

    private Long id;
}
