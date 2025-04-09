package cn.scifi.pubreader.domain.model.entity;

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
public class Chapter {

    private Long id;

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
    private Integer vip;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 章节内容
     */
    private String content;

    private String author;

    private String bookTitle;

}
