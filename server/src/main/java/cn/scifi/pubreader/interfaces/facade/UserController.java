package cn.scifi.pubreader.interfaces.facade;

import cn.scifi.pubreader.application.manager.UserAuthenticationManager;
import cn.scifi.pubreader.domain.model.entity.Book;
import cn.scifi.pubreader.domain.repository.AuthorRepository;
import cn.scifi.pubreader.infrastructure.common.security.UserPrincipal;
import cn.scifi.pubreader.interfaces.assembler.BookAssembler;
import cn.scifi.pubreader.interfaces.dto.vo.BookVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bingdyee
 * @since 2024/10/23
 */
@Tag(name = "作家接口")
@RequestMapping("/v1/author")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final AuthorRepository userRepository;

    @Operation(summary = "获取作者的书籍")
    @GetMapping("/books")
    public List<BookVO> getUserBooks() {
        UserPrincipal currentUser = UserAuthenticationManager.getCurrentUser();
        List<Book> books = userRepository.findAuthorBooks(currentUser.getName());
        return BookAssembler.toVOs(books);
    }

}
