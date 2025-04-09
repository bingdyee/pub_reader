package cn.scifi.pubreader.domain.model.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 小说分类
 * </p>
 *
 * @author bingdyee
 * @since 2024-10-21
 */
@Getter
@Setter
public class Category {

    private Long id;

    /**
     * 上级分类ID
     */
    private Long parentId;

    /**
     * 名称
     */
    private String categoryName;

    /**
     * 描述
     */
    private String remark;

    /**
     * 所属频道：1-男频，2-女频；3-文学
     */
    private Integer channel;

    /**
     * 排序
     */
    private Integer orderNum;
}
