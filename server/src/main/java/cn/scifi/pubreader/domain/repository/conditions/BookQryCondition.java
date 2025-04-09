package cn.scifi.pubreader.domain.repository.conditions;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author bingdyee
 * @since 2024/10/22
 */
@Getter
@Setter
public class BookQryCondition {

    /** 书名  */
    private String title;

    /** 分类ID */
    private Long categoryId;

    /** 作品类型 */
    private Integer channel;

    /** 作品状态 */
    private Integer bookStatus;

    /** 作品标签 */
    private Long tagId;

    /** 排序字段 */
    private String orderField;

    /** 更新天数 */
    private Integer updateDays;

    /** 字数范围起始值 */
    private Integer countFrom;

    /** 字数范围结束值 */
    private Integer countTo;

}
