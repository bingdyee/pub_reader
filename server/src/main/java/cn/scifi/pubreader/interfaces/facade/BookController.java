package cn.scifi.novelogic.interfaces.facade;

import cn.scifi.novelogic.domain.model.aggregates.BookAggregate;
import cn.scifi.novelogic.domain.model.entity.Book;
import cn.scifi.novelogic.domain.model.entity.Chapter;
import cn.scifi.novelogic.domain.repository.BookRepository;
import cn.scifi.novelogic.domain.repository.conditions.BookQryCondition;
import cn.scifi.novelogic.infrastructure.common.web.Paging;
import cn.scifi.novelogic.interfaces.assembler.BookAssembler;
import cn.scifi.novelogic.interfaces.dto.command.BookCreateCmd;
import cn.scifi.novelogic.interfaces.dto.query.BookGetQuery;
import cn.scifi.novelogic.interfaces.dto.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 书籍控制层
 *
 * @author bingdyee
 * @since 2024/9/28
 */
@io.swagger.v3.oas.annotations.tags.Tag(name="书籍接口")
@RequestMapping("/v1/book")
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @Operation(summary = "创建书籍")
    @PostMapping
    public void createBook(@Valid @RequestBody BookCreateCmd cmd) {
        bookRepository.saveBook(BookAssembler.createCmdToBook(cmd), cmd.getTagIdList());
    }

    @Operation(summary = "书籍详情")
    @GetMapping("/{id}")
    public BookDetailVO detail(@PathVariable("id") Long id) {
        BookAggregate bookAggregate = bookRepository.findById(id);
        return BookAssembler.toDetail(bookAggregate);
    }

    @Operation(summary = "书籍查询")
    @GetMapping
    public Paging<BookVO> queryPagedBook(BookGetQuery query) {
        Paging<BookVO> page = Paging.of(query.getPage(), query.getSize());
        BookQryCondition condition = BookAssembler.queryToCondition(query);
        List<Book> books = bookRepository.findWithConditions(condition, page);
        page.setRecords(BookAssembler.toVOs(books));
        return page;
    }

    @Operation(summary = "获取书籍全部章节")
    @GetMapping("/{id}/chapter")
    public List<PartChapterVO> chapters(@PathVariable("id") Long id) {
        List<Chapter> bookChapters = bookRepository.findBookChapters(id);
        return BookAssembler.toPartChapters(bookChapters);
    }

    @Operation(summary = "获取书籍章节内容")
    @GetMapping("/{id}/chapter/{chapterId}")
    public ChapterVO getChapterInfo(@PathVariable("id") Long id, @PathVariable("chapterId") Long chapterId) {
        Chapter chapter = bookRepository.findChapterDetail(id, chapterId);
        return BookAssembler.toChapterVO(chapter);
    }



}
