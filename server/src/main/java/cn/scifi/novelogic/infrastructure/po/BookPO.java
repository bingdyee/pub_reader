package cn.scifi.novelogic.infrastructure.po;

import cn.scifi.novelogic.domain.model.valobj.BookStatus;
import cn.scifi.novelogic.domain.model.valobj.Channel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 书籍信息
 * </p>
 *
 * @author bingdyee
 * @since 2024-10-21
 */
@Getter
@Setter
@TableName("novel_book")
public class BookPO extends BasePO {

    /**
     * 书名
     */
    private String title;

    /**
     * 作者笔名
     */
    private String author;

    /**
     * 简介
     */
    private String summary;

    /**
     * 封面URL
     */
    private String coverUrl;

    /**
     * 所属频道：1-男频，2-女频；3-出版
     */
    private Channel channel;

    /**
     * 主分类ID
     */
    private Long categoryId;

    /**
     * 主分类名
     */
    private String categoryName;

    /**
     * 子分类ID
     */
    private Long subCategoryId;

    /**
     * 子分类名
     */
    private String subCategoryName;

    /**
     * 字数
     */
    private Integer wordCount;

    /**
     * 阅读人数
     */
    private Integer readCount;

    /**
     * 最新章节ID
     */
    private Long lastChapterId;

    /**
     * 最新章节名
     */
    private String lastChapterTitle;

    /**
     * 最新章节更新时间
     */
    private LocalDateTime lastChapterUpdateTime;

    /**
     * 连载状态：1-连载中；2-已完结
     */
    private BookStatus status;

}
