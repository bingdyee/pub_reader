package cn.scifi.novelogic.domain.service.impl;

import cn.scifi.novelogic.domain.model.entity.Author;
import cn.scifi.novelogic.domain.repository.AuthorRepository;
import cn.scifi.novelogic.domain.service.UserService;
import cn.scifi.novelogic.infrastructure.common.constants.enums.RoleType;
import cn.scifi.novelogic.infrastructure.common.exception.AuthException;
import cn.scifi.novelogic.infrastructure.common.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 *
 * @author bingdyee
 * @since 2024/10/22
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AuthorRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Author author = userRepository.findByUsername(username);
        if (author == null) {
            throw new AuthException("用户名或密码错误");
        }
        return new UserPrincipal
                .Builder()
                .id(author.getId())
                .name(author.getPseudonym())
                .image(author.getAvatarUrl())
                .password(author.getPassword())
                .status(author.getStatus())
                .role(RoleType.writer.name())
                .build();
    }

}
