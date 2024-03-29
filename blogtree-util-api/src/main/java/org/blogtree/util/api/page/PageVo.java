package org.blogtree.util.api.page;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询返回的对象
 *
 * @author AlanGeeker
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageVo<T> implements Serializable {

    private static final long serialVersionUID = -6818743402244693157L;

    private long total = 0L;

    private List<T> list;
}
