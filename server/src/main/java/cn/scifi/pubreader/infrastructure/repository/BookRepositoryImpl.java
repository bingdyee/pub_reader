package cn.scifi.novelogic.infrastructure.repository;

import cn.scifi.novelogic.domain.event.BookCreateEvent;
import cn.scifi.novelogic.domain.event.DomainEventPublisher;
import cn.scifi.novelogic.domain.model.aggregates.BookAggregate;
import cn.scifi.novelogic.domain.model.entity.Book;
import cn.scifi.novelogic.domain.model.entity.Chapter;
import cn.scifi.novelogic.domain.repository.BookRepository;
import cn.scifi.novelogic.infrastructure.common.exception.NotFoundException;
import cn.scifi.novelogic.infrastructure.common.utils.BeanConverter;
import cn.scifi.novelogic.infrastructure.common.web.Paging;
import cn.scifi.novelogic.infrastructure.mapper.*;
import cn.scifi.novelogic.infrastructure.po.*;
import cn.scifi.novelogic.domain.repository.conditions.BookQryCondition;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bingdyee
 * @since 2024/10/21
 */
@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookMapper bookMapper;

    private final ChapterMapper chapterMapper;

    @Override
    public BookAggregate findById(Long id) {
        BookPO book = bookMapper.selectById(id);
        if (book == null) {
            throw new NotFoundException();
        }
        List<ChapterPO> chapterList = chapterMapper.selectByBookId(id);
        BookAggregate bookAggregate = new BookAggregate();
        BeanConverter.copyProperties(book, bookAggregate);
        bookAggregate.setChapters(BeanConverter.convertList(chapterList, Chapter.class));
        return bookAggregate;
    }

    @Override
    public void saveBook(Book book, List<Long> tagIdList) {
        BookPO entity = new BookPO();
        BeanConverter.copyProperties(book, entity);
        bookMapper.insert(entity);
        DomainEventPublisher.publish(new BookCreateEvent());
    }

    @Override
    public List<Book> findWithConditions(BookQryCondition condition, Paging paging) {
        Page<BookPO> page = Page.of(paging.getCurrent(), paging.getSize());
        if (condition.getOrderField() != null) {
            OrderItem orderItem = new OrderItem()
                    .setColumn(condition.getOrderField())
                    .setAsc(false);
            page.addOrder(orderItem);
        }
        List<BookPO> bookList = bookMapper.selectWithConditions(condition, page);
        paging.setTotal(Long.valueOf(page.getTotal()).intValue());
        return BeanConverter.convertList(bookList, Book.class);
    }

    @Override
    public List<Chapter> findBookChapters(Long bookId) {
        List<ChapterPO> chapterList = chapterMapper.selectByBookId(bookId);
        return BeanConverter.convertList(chapterList, Chapter.class);
    }

    @Override
    public Chapter findChapterDetail(Long bookId, Long chapterId) {
        BookPO book = bookMapper.selectById(bookId);
        if (book == null) {
            throw new NotFoundException();
        }
        ChapterPO chapter = chapterMapper.selectChapterDetail(chapterId);
        if (chapter == null) {
            throw new NotFoundException();
        }
        Chapter chapterDetail = new Chapter();
        BeanConverter.copyProperties(chapter, chapterDetail);
        chapterDetail.setAuthor(book.getAuthor());
        chapterDetail.setBookTitle(book.getTitle());
        return chapterDetail;
    }

}
