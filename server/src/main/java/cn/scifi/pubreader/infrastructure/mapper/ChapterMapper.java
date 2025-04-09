package cn.scifi.novelogic.infrastructure.mapper;

import cn.scifi.novelogic.infrastructure.po.ChapterPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 章节信息 Mapper 接口
 * </p>
 *
 * @author bingdyee
 * @since 2024-10-21
 */
@Mapper
public interface ChapterMapper extends BaseMapper<ChapterPO> {

    /**
     * 获取书的章节列表
     *
     * @param bookId 书籍id
     * @return {@link List<Chapter>}
     */
    List<ChapterPO> selectByBookId(Long bookId);

    /**
     * 获取章节详情
     *
     * @param chapterId 章节ID
     * @return {@link ChapterPO}
     */
    ChapterPO selectChapterDetail(Long chapterId);

}
