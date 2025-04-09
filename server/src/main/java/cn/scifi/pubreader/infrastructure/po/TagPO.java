package cn.scifi.pubreader.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 标签
 * </p>
 *
 * @author bingdyee
 * @since 2024-10-21
 */
@Getter
@Setter
@TableName("novel_tag")
public class TagPO extends BasePO {

    /**
     * 名称
     */
    private String tagName;
}
