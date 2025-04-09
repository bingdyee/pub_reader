package cn.scifi.novelogic.interfaces.dto.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author bingdyee
 * @since 2024/10/22
 */
@Getter
@Setter
public class ChapterVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 2035703538316185016L;

    @Schema(description = "章节ID")
    private Long id;

    @Schema(description = "书籍ID")
    private Long bookId;

    @Schema(description = "章节名")
    private String title;

    @Schema(description = "分卷名")
    private String partName;

    @Schema(description = "字数")
    private Integer wordCount;

    @Schema(description = "发布时间")
    private LocalDateTime publishTime;

    @Schema(description = "状态：1-暂存；2-发布")
    private Integer status;

    @Schema(description = "VIP章节：0-否；1-是")
    private Integer vip;

    @Schema(description = "排序")
    private Integer orderNum;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "作者")
    private String author;

    @Schema(description = "书名")
    private String bookTitle;

}
