package cn.scifi.pubreader.domain.repository;

import cn.scifi.pubreader.domain.model.entity.Book;
import cn.scifi.pubreader.domain.model.entity.Author;

import java.util.List;

/**
 * 用户仓储接口
 *
 * @author bingdyee
 * @since 2024/10/21
 */
public interface AuthorRepository {

    /**
     * 根据唯一键查询用户
     *
     * @return User
     */
    Author findByUsername(String username);

    /**
     * 获取用户详情
     *
     * @param id 用户ID
     * @return User
     */
    Author findById(Long id);


    /**
     * 获取作者的书籍列表
     *
     * @param author 作者笔名
     * @return 书籍列表
     */
    List<Book> findAuthorBooks(String author);

}
