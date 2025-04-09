package cn.scifi.novelogic.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 章节信息
 * </p>
 *
 * @author bingdyee
 * @since 2024-10-21
 */
@Getter
@Setter
@TableName("novel_chapter")
public class ChapterPO extends BasePO {

    /**
     * 书籍ID
     */
    private Long bookId;

    /**
     * 章节名
     */
    private String title;

    /**
     * 分卷名
     */
    private String partName;

    /**
     * 字数
     */
    private Integer wordCount;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

    /**
     * VIP章节：0-否；1-是
     */
    @TableField("is_vip")
    private Integer vip;

    /**
     * 排序
     */
    private Integer orderNum;

    @TableField(exist = false)
    private String content;

}
