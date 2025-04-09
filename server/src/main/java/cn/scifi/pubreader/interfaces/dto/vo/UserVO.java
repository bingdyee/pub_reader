package cn.scifi.pubreader.interfaces.dto.vo;

import cn.scifi.pubreader.infrastructure.common.serialize.MaskType;
import cn.scifi.pubreader.infrastructure.common.serialize.SensitiveField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户VO
 *
 * @author bingdyee
 * @since 2024/10/22
 */
@Getter
@Setter
public class UserVO implements Serializable {

    @Schema(description = "用户ID")
    private Long id;

    @Schema(description = "笔名")
    private String pseudonym;

    @Schema(description = "手机号")
    @SensitiveField(MaskType.MOBILE)
    private String mobile;

    @Schema(description = "邮箱")
    @SensitiveField(MaskType.EMAIL)
    private String email;

    @Schema(description = "头像链接")
    private String avatarUrl;

    @Schema(description = "个人介绍")
    private String biography;

    @Schema(description = "地区")
    private String locale;

    @Schema(description = "等级：1-Lv1 2-Lv2 3-Lv3 4-白金 5-殿堂 6-大神")
    private Integer vipLevel;

    @Schema(description = "作品总数")
    private Integer totalBooks;

    @Schema(description = "累计字数")
    private Integer totalWords;

    @Schema(description = "粉丝数")
    private Integer followers;

    @Schema(description = "首次创作时间")
    private LocalDateTime firstCreationTime;

}
