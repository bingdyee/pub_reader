package cn.scifi.pubreader.interfaces.dto.vo;

import cn.scifi.pubreader.domain.model.valobj.BookStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 书籍基本信息
 *
 * @author bingdyee
 * @since 2024/10/22
 */
@Getter
@Setter
public class BookVO implements Serializable {

    private Long id;

    @Schema(description = "书名")
    private String title;

    @Schema(description = "作者笔名")
    private String author;

    @Schema(description = "简介")
    private String summary;

    @Schema(description = "封面URL")
    private String coverUrl;

    @Schema(description = "主分类ID")
    private Long categoryId;

    @Schema(description = "主分类名")
    private String categoryName;

    @Schema(description = "子分类ID")
    private Long subCategoryId;

    @Schema(description = "子分类名")
    private String subCategoryName;

    @Schema(description = "字数")
    private Integer wordCount;

    @Schema(description = "最新章节ID")
    private Long lastChapterId;

    @Schema(description = "最新章节名")
    private String lastChapterTitle;

    @Schema(description = "最新章节更新时间")
    private LocalDateTime lastChapterUpdateTime;

    @Schema(description = "连载状态：1-连载中；2-已完结")
    private BookStatus status;

}
