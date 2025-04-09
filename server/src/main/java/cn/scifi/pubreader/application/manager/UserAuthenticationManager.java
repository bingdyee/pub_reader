package cn.scifi.pubreader.application.manager;

import cn.scifi.pubreader.domain.model.entity.Author;
import cn.scifi.pubreader.domain.repository.AuthorRepository;
import cn.scifi.pubreader.infrastructure.common.constants.enums.StatusCode;
import cn.scifi.pubreader.infrastructure.common.exception.AuthException;
import cn.scifi.pubreader.infrastructure.common.exception.BizExecException;
import cn.scifi.pubreader.infrastructure.common.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * 认证授权管理
 *
 * @author bingdyee
 * @since 2024/10/22
 */
@Component
@RequiredArgsConstructor
public class UserAuthenticationManager {

    private final AuthenticationManager authenticationManager;

    private final AuthorRepository userRepository;

    /**
     * 登录
     *
     * @param username email / mobile
     * @param password 密码
     * @return {@link UserPrincipal}
     */
    public UserPrincipal login(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        return (UserPrincipal) authenticate.getPrincipal();
    }

    /**
     * 登录用户信息
     *
     * @return {@link Author}
     */
    public Author getUserInfo() {
        UserPrincipal principal = getCurrentUser();
        Author author = userRepository.findById(principal.getId());
        if (author == null) {
            throw new AuthException("用户不存在");
        }
        return author;
    }

    public static UserPrincipal getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal() == null || !(authentication.getPrincipal() instanceof UserPrincipal principal)) {
            throw new BizExecException(StatusCode.UN_AUTH);
        }
        return principal;
    }

}
