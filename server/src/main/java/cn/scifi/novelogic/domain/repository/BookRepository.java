package cn.scifi.novelogic.domain.repository;

import cn.scifi.novelogic.domain.model.aggregates.BookAggregate;
import cn.scifi.novelogic.domain.model.entity.Book;
import cn.scifi.novelogic.domain.model.entity.Chapter;
import cn.scifi.novelogic.domain.repository.conditions.BookQryCondition;
import cn.scifi.novelogic.infrastructure.common.web.Paging;

import java.util.List;

/**
 * 书籍仓储接口
 *
 * @author bingdyee
 * @since 2024/10/21
 */
public interface BookRepository {

    /**
     * 书籍详情
     *
     * @param id 书籍ID
     * @return {@link BookAggregate}
     */
    BookAggregate findById(Long id);

    /**
     * 保存书籍
     *
     * @param book {@link Book}
     * @param tagIdList 标签ID列表
     */
    void saveBook(Book book, List<Long> tagIdList);

    /**
     * 分页查询书籍
     *
     * @param condition 条件
     * @param page 分页
     * @return {@link List<Book>}
     */
    List<Book> findWithConditions(BookQryCondition condition, Paging page);

    /**
     * 获取书籍章节列表
     *
     * @param bookId 书籍ID
     * @return 章节列表
     */
    List<Chapter> findBookChapters(Long bookId);

    /**
     * 章节详情
     *
     * @param bookId 书ID
     * @param chapterId 章节ID
     * @return {@link Chapter}
     */
    Chapter findChapterDetail(Long bookId, Long chapterId);

}
