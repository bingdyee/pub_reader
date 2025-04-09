package cn.scifi.pubreader.infrastructure.common.utils;

import java.util.regex.Pattern;

/**
 * @author bingdyee
 * @since 2024/9/27
 */
public final class Validators {

    /** 手机号 */
    public static final String MOBILE_REG = "^1[345789]\\d{9}$";

    /** 邮箱 */
    public static final String EMAIL_REG = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    public static boolean isEmail(String email) {
        return Pattern.matches(EMAIL_REG, email);
    }

    public static boolean isMobile(String mobile) {
        return Pattern.matches(MOBILE_REG, mobile);
    }

}
