package cn.scifi.novelogic.domain.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author bingdyee
 * @since 2024-10-21
 */
@Getter
@Setter
public class Author {

    private Long id;

    /**
     * 笔名
     */
    private String pseudonym;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像链接
     */
    private String avatarUrl;

    /**
     * 个人介绍
     */
    private String biography;

    /**
     * 地区
     */
    private String locale;

    /**
     * 等级：1-Lv1 2-Lv2 3-Lv3 4-白金 5-殿堂 6-大神
     */
    private Integer vipLevel;

    /**
     * 作品总数
     */
    private Integer totalBooks;

    /**
     * 累计字数
     */
    private Integer totalWords;

    /**
     * 首次创作时间
     */
    private LocalDateTime firstCreationTime;

    /**
     * 邮箱是否已验证：0-否；1-是
     */
    private Boolean emailVerified;

    /**
     * 状态：1-正常；2-封禁；3-注销
     */
    private Integer status;
}
