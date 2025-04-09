package cn.scifi.pubreader.interfaces.facade;

import cn.scifi.pubreader.domain.model.aggregates.BookAggregate;
import cn.scifi.pubreader.domain.model.entity.Book;
import cn.scifi.pubreader.domain.model.entity.Chapter;
import cn.scifi.pubreader.domain.repository.BookRepository;
import cn.scifi.pubreader.domain.repository.conditions.BookQryCondition;
import cn.scifi.pubreader.infrastructure.common.web.Paging;
import cn.scifi.pubreader.interfaces.assembler.BookAssembler;
import cn.scifi.pubreader.interfaces.dto.command.BookCreateCmd;
import cn.scifi.pubreader.interfaces.dto.query.BookGetQuery;
import cn.scifi.pubreader.interfaces.dto.vo.BookDetailVO;
import cn.scifi.pubreader.interfaces.dto.vo.BookVO;
import cn.scifi.pubreader.interfaces.dto.vo.ChapterVO;
import cn.scifi.pubreader.interfaces.dto.vo.PartChapterVO;
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
