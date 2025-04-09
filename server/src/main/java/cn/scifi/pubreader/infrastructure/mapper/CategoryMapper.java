package cn.scifi.pubreader.infrastructure.mapper;

import cn.scifi.pubreader.infrastructure.po.CategoryPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 小说分类 Mapper 接口
 * </p>
 *
 * @author bingdyee
 * @since 2024-10-21
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryPO> {

    /**
     * 获取作品类型
     *
     * @param categoryIds 分类ID数组
     * @return {@link List<CategoryPO>}
     */
    List<CategoryPO> selectCategoryByIds(Integer channel, List<Long> categoryIds);

    /**
     * 获取所有书籍类型
     *
     * @return {@link List<CategoryPO>}
     */
    List<CategoryPO> selectAll();

    /**
     * 查询频道下的分类
     *
     * @param channel 频道
     * @return {@link List< Category >}
     */
    List<CategoryPO> selectByChannel(int channel);

}
