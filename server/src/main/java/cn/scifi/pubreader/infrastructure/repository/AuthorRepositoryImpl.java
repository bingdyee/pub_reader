package cn.scifi.novelogic.infrastructure.repository;

import cn.scifi.novelogic.domain.model.entity.Book;
import cn.scifi.novelogic.infrastructure.common.utils.BeanConverter;
import cn.scifi.novelogic.infrastructure.common.utils.Validators;
import cn.scifi.novelogic.domain.model.entity.Author;
import cn.scifi.novelogic.domain.repository.AuthorRepository;
import cn.scifi.novelogic.infrastructure.mapper.BookMapper;
import cn.scifi.novelogic.infrastructure.mapper.AuthorMapper;
import cn.scifi.novelogic.infrastructure.po.BookPO;
import cn.scifi.novelogic.infrastructure.po.AuthorPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户仓储实现
 *
 * @author bingdyee
 * @since 2024/10/21
 */
@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorMapper userMapper;

    private final BookMapper bookMapper;

    @Override
    public Author findByUsername(String username) {
        boolean isMobile = Validators.isMobile(username);
        AuthorPO po = userMapper.selectByUid(isMobile ? null : username, isMobile ? username : null);
        Author author = null;
        if (po != null) {
            author = new Author();
            BeanConverter.copyProperties(po, author);
        }
        return author;
    }

    @Override
    public Author findById(Long id) {
        AuthorPO po = userMapper.selectById(id);
        Author author = null;
        if (po != null) {
            author = new Author();
            BeanConverter.copyProperties(po, author);
        }
        return author;
    }

    @Override
    public List<Book> findAuthorBooks(String author) {
        List<BookPO> books = bookMapper.selectByAuthor(author);
        return BeanConverter.convertList(books, Book.class);
    }

}
