package cn.scifi.novelogic.domain.model.aggregates;

import cn.scifi.novelogic.domain.model.entity.Book;
import cn.scifi.novelogic.domain.model.entity.Chapter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 书籍聚合根
 *
 * @author bingdyee
 * @since 2024/10/22
 */
@Getter
@Setter
public class BookAggregate extends Book {

    private List<Chapter> chapters;

}
