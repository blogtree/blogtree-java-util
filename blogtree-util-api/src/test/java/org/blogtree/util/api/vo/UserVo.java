package org.blogtree.util.api.vo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserVo implements Serializable {

    private static final long serialVersionUID = -663783266614202953L;

    private Long id;

    private String name;

}
