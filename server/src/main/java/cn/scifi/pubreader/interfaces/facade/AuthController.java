package cn.scifi.pubreader.interfaces.facade;

import cn.scifi.pubreader.application.manager.UserAuthenticationManager;
import cn.scifi.pubreader.infrastructure.common.security.UserPrincipal;
import cn.scifi.pubreader.interfaces.assembler.UserAssembler;
import cn.scifi.pubreader.interfaces.dto.command.UserLoginCmd;
import cn.scifi.pubreader.interfaces.dto.vo.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author bingdyee
 * @since 2024/9/28
 */
@Tag(name = "认证授权")
@RequestMapping("/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserAuthenticationManager authManager;

    @Operation(summary = "登录")
    @PostMapping("/login")
    public UserPrincipal login(@RequestBody @Valid UserLoginCmd loginCmd) {
        return authManager.login(loginCmd.getUsername(), loginCmd.getPassword());
    }

    @Operation(summary = "获取登录用户信息")
    @GetMapping("/userinfo")
    public UserVO getUserInfo() {
        return UserAssembler.toVO(authManager.getUserInfo());
    }

}
