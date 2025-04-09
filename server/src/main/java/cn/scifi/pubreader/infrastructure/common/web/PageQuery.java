package cn.scifi.novelogic.infrastructure.common.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

import java.io.Serializable;

/**
 * 分页查询
 *
 * @author Bing D. Yee
 * @since 2022/01/12
 */
@Getter
@Setter
@ParameterObject
public class PageQuery implements Serializable {

    /**
     * 允许最大页大小
     */
    public static final int MAX_PAGE_SIZE = 20;
    /** 允许最大页*/
    public static final int MAX_PAGE = 99;

    @Parameter(description = "页", example = "1")
    private int page;

    @Parameter(description = "页大小（1-50）", example = "10")
    private int size;

    @JsonIgnore
    private int sortBy;

    @JsonIgnore
    private int total;

    public PageQuery() {
        this.page = 1;
        this.size = 10;
        this.sortBy = 1;
    }

    public PageQuery(int page, int size) {
        this.page = Math.min(page, MAX_PAGE);
        this.size = Math.min(size, MAX_PAGE_SIZE);
        this.sortBy = 1;
    }

    @JsonIgnore
    public int getOffset() {
        return page - 1;
    }

}
