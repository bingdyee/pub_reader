package cn.scifi.pubreader.infrastructure.common.utils;

/**
 * 脱敏工具类
 *
 * @author yubinbin
 * @since 2021/04/09
 */
public final class DataMasker {

    public static final String MASKER = "*";

    public static final String EMAIL_MASK = "(^\\w{3})[^@]*(@.*$)";

    /**
     * 手机号脱敏
     *
     * @param phone 手机号
     * @return 脱敏数据
     */
    public static String maskPhone(String phone) {
        return mask(phone, 3, 4, MASKER);
    }

    /**
     * 身份证脱敏
     *
     * @param idCard 身份证号码
     * @return 脱敏数据
     */
    public static String maskIdCard(String idCard) {
        return mask(idCard, 6, 4, MASKER);
    }

    public static String maskEmail(String email) {
        return email.replaceAll(EMAIL_MASK, "$1*****$2");
    }

    public static String mask(String value, int left, int right, String masker) {
        if (Strings.isBlank(value)) {
            throw new IllegalArgumentException();
        }
        StringBuilder rs = new StringBuilder();
        for (int i = 0, n = value.length(); i < n; ++i) {
            rs.append(i < left || i > n - right - 1 ? value.charAt(i) : masker);
        }
        return rs.toString();
    }

}
