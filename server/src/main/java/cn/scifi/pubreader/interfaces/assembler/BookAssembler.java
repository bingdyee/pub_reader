package cn.scifi.pubreader.interfaces.assembler;

import cn.scifi.pubreader.application.manager.UserAuthenticationManager;
import cn.scifi.pubreader.domain.model.aggregates.BookAggregate;
import cn.scifi.pubreader.domain.model.entity.Book;
import cn.scifi.pubreader.domain.model.entity.Chapter;
import cn.scifi.pubreader.domain.model.valobj.BookOrderType;
import cn.scifi.pubreader.domain.model.valobj.Channel;
import cn.scifi.pubreader.domain.repository.conditions.BookQryCondition;
import cn.scifi.pubreader.infrastructure.common.security.UserPrincipal;
import cn.scifi.pubreader.infrastructure.common.utils.BeanConverter;
import cn.scifi.pubreader.interfaces.dto.command.BookCreateCmd;
import cn.scifi.pubreader.interfaces.dto.query.BookGetQuery;
import cn.scifi.pubreader.interfaces.dto.vo.*;
import cn.scifi.pubreader.interfaces.dto.vo.BookDetailVO;
import cn.scifi.pubreader.interfaces.dto.vo.BookVO;
import cn.scifi.pubreader.interfaces.dto.vo.ChapterVO;
import cn.scifi.pubreader.interfaces.dto.vo.PartChapterVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bingdyee
 * @since 2024/10/22
 */
public class BookAssembler {

    public static Book createCmdToBook(BookCreateCmd cmd) {
        Book book = new Book();
        BeanConverter.copyProperties(cmd, book);
        book.setChannel(Channel.codeOf(cmd.getChannel()));
        UserPrincipal currentUser = UserAuthenticationManager.getCurrentUser();
        book.setAuthor(currentUser.getName());
        return book;
    }

    public static BookQryCondition queryToCondition(BookGetQuery query) {
        BookQryCondition condition = new BookQryCondition();
        condition.setTitle(query.getTitle());
        condition.setCategoryId(query.getCate());
        condition.setTagId(query.getTag());
        if (query.getStat() != null) {
            condition.setBookStatus(query.getStat().getCode());
        }
        if (query.getChan() != null) {
            condition.setChannel(query.getChan().getCode());
        }
        if (query.getOrder() != null) {
            condition.setOrderField(query.getOrder().getOrderField());
        } else {
            condition.setOrderField(BookOrderType.HOTTEST.getOrderField());
        }
        if (query.getUpdate() != null) {
            condition.setUpdateDays(query.getUpdate().getDays());
        }
        if (query.getCount() != null) {
            if (query.getCount().getFrom() != null) {
                condition.setCountFrom(query.getCount().getFrom());
            }
            if (query.getCount().getTo() != null) {
                condition.setCountTo(query.getCount().getTo());
            }
        }
        return condition;
    }

    public static List<BookVO> toVOs(List<Book> books) {
        return books.stream().map(book -> {
            BookVO bookVO = new BookVO();
            BeanConverter.copyProperties(book, bookVO);
            return bookVO;
        }).toList();
    }

    public static BookDetailVO toDetail(BookAggregate bookAggregate) {
        BookDetailVO book = new BookDetailVO();
        BeanConverter.copyProperties(bookAggregate, book);

        book.setPartChapterList(toPartChapters(bookAggregate.getChapters()));
        return book;
    }


    public static List<PartChapterVO> toPartChapters(List<Chapter> chapterList) {
        List<ChapterVO> chapters = chapterList.stream().map(BookAssembler::toChapterVO).toList();
        List<PartChapterVO> result = new ArrayList<>();
        PartChapterVO partChapter = null;
        for (ChapterVO chapter : chapters) {
            if (partChapter == null) {
                partChapter = new PartChapterVO();
                partChapter.setPartName(chapter.getPartName());
                partChapter.setChapterList(new ArrayList<>());
            }
            if (!chapter.getPartName().equals(partChapter.getPartName())) {
                result.add(partChapter);
                partChapter = null;
            } else {
                partChapter.getChapterList().add(chapter);
            }
        }
        if (partChapter != null) {
            result.add(partChapter);
        }
        return result;
    }

    public static ChapterVO toChapterVO(Chapter chapter) {
        ChapterVO chapterVO = new ChapterVO();
        BeanConverter.copyProperties(chapter, chapterVO);
        return chapterVO;
    }

}
