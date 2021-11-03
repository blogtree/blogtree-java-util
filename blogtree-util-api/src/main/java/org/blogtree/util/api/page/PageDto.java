package org.blogtree.util.api.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 分页入参
 *
 * @author AlanGeeker
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class PageDto implements Serializable {

    private static final long serialVersionUID = 4862304094187475990L;

    private int pageNo = 1;

    private int pageSize = 10;

    /**
     * 起始Id，从0开始
     */
    public int getStart() {
        return (pageNo - 1) * pageSize;
    }
}
