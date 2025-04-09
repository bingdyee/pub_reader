package cn.scifi.novelogic.interfaces.dto.command;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * {
 *   "title": "异度旅社",
 *   "summary": "在日常之下，在理性尽头，在你所熟悉的世界之外——是你从未想象过的风景。当于生第一次打开那扇门的时候，他所熟悉的世界便轰然倒塌。而那直抵世界根源的“真相”，扑面而来。",
 *   "coverUrl": "string",
 *   "channel": "1",
 *   "categoryId": 67,
 *   "subCategoryId": 72,
 *   "tags": [
 *     "时空穿梭"
 *   ]
 * }
 *
 * @author bingdyee
 * @since 2024/10/21
 */
@Getter
@Setter
public class BookCreateCmd {

    @Schema(description = "书名", example = "异度旅社")
    @Length(min = 1, max = 15, message = "书名长度限制为不超过15个字符")
    private String title;

    @Schema(description = "简介", example = "在日常之下，在理性尽头，在你所熟悉的世界之外——是你从未想象过的风景。当于生第一次打开那扇门的时候，他所熟悉的世界便轰然倒塌。而那直抵世界根源的“真相”，扑面而来。")
    @Length(min = 50, max = 500, message = "作品简介字数限制为50-500字")
    private String summary;

    @Schema(description = "封面URL", example = "/images/cover/default-cover.png")
    private String coverUrl;

    @Schema(description = "频道：1-男频；2-女频", example = "1")
    @NotNull(message = "请选择目标读者")
    private Integer channel;

    @Schema(description = "分类ID", example = "67")
    @NotNull(message = "请选择作品类型")
    private Long categoryId;

    @Schema(description = "子分类ID", example = "72")
    @NotNull(message = "请选择作品子类型")
    private Long subCategoryId;

    @Schema(description = "标签", examples = {"时空穿梭"})
    @Size(max = 5, message = "最多只能选择5个标签")
    private List<Long> tagIdList;

}
