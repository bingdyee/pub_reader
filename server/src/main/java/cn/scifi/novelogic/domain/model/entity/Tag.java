package cn.scifi.novelogic.domain.model.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 标签
 * </p>
 *
 * @author bingdyee
 * @since 2024-10-21
 */
@Getter
@Setter
public class Tag {

    private Long id;

    /**
     * 名称
     */
    private String tagName;
}
