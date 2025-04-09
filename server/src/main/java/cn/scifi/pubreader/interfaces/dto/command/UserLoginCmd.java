package cn.scifi.novelogic.interfaces.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * 登录请求
 *
 * @author bingdyee
 * @since 2024/9/28
 */
@Getter
@Setter
@Schema(description = "登录请求")
public class UserLoginCmd {

    @Length(min=1, max=20, message = "用户名或密码错误")
    @Schema(description = "手机/邮箱/用户名", example = "15700112935")
    private String username;

    @Length(min=8, max=20, message = "用户名或密码错误")
    @Schema(description = "密码", example = "12345678")
    private String password;

}
