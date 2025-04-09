package cn.scifi.novelogic.infrastructure.mapper;

import cn.scifi.novelogic.domain.repository.conditions.BookQryCondition;
import cn.scifi.novelogic.infrastructure.po.BookPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 书籍信息 Mapper 接口
 * </p>
 *
 * @author bingdyee
 * @since 2024-10-21
 */
@Mapper
public interface BookMapper extends BaseMapper<BookPO> {

    /**
     * 查询书籍
     *
     * @param cond 查询条件
     * @param iPage 分页参数
     * @return 当前页的书籍列表
     */
    List<BookPO> selectWithConditions(BookQryCondition cond, IPage<BookPO> iPage);

    /**
     * 查询作者书籍列表
     *
     * @param author 笔名
     * @return 书籍列表
     */
    List<BookPO> selectByAuthor(String author);

}
