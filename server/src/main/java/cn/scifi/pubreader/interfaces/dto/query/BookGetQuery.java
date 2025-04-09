package cn.scifi.pubreader.interfaces.dto.query;

import cn.scifi.pubreader.infrastructure.common.web.PageQuery;
import cn.scifi.pubreader.domain.model.valobj.BookOrderType;
import cn.scifi.pubreader.domain.model.valobj.BookStatus;
import cn.scifi.pubreader.domain.model.valobj.BookUpdateRange;
import cn.scifi.pubreader.domain.model.valobj.BookCountRange;
import cn.scifi.pubreader.domain.model.valobj.Channel;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

/**
 * 书籍查询请求
 *
 * @author bingdyee
 * @since 2024/9/28
 */
@Getter
@Setter
@ParameterObject
public class BookGetQuery extends PageQuery {

    @Parameter(description = "书名", example = "三体")
    private String title;

    @Parameter(description = "分类ID", example = "1")
    private Long cate;

    @Parameter(description = "标签ID", example = "1")
    private Long tag;

    @Parameter(description = "频道（1-男频；2-女频；3-出版）", example = "1")
    private Channel chan = Channel.MALE;

    @Parameter(description = "状态（1-连载；2-完结）", example = "1")
    private BookStatus stat;

    @Parameter(description = "排序方式（1-最热；2-最新；3-字数）", example = "1")
    private BookOrderType order;

    @Parameter(description = "更新时间（1-三天内；2-七天内；3-半月内；4-一月内）", example = "1")
    private BookUpdateRange update;

    @Parameter(description = "字数（1-30w以下；2-30-50w；3-50-100w；4-100-200w；5-200w以上）", example = "1")
    private BookCountRange count;

}
