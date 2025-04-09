package cn.scifi.pubreader.infrastructure.mapper;

import cn.scifi.pubreader.infrastructure.po.TagPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 标签 Mapper 接口
 * </p>
 *
 * @author bingdyee
 * @since 2024-10-21
 */
@Mapper
public interface TagMapper extends BaseMapper<TagPO> {

    /**
     * 获取 Top N 标签
     *
     * @param topN Top N
     * @return {@link List<TagPO>}
     */
    List<TagPO> selectTopTags(int topN);

    /**
     * 获取书籍标签列表
     *
     * @param bookId 书籍ID
     * @return 标签列表
     */
    List<TagPO> selectByBookId(Long bookId);

    /**
     * 插入书籍标签
     *
     * @param bookId 书ID
     * @param tagIdList 标签ID列表
     */
    void insertBookTags(Long bookId, List<Long> tagIdList);

}
