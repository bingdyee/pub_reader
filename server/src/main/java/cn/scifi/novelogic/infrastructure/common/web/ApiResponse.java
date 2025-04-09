package cn.scifi.novelogic.infrastructure.common.web;

import cn.scifi.novelogic.infrastructure.common.constants.StatusInfo;
import cn.scifi.novelogic.infrastructure.common.constants.enums.StatusCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 接口返回数据封装
 *
 * @author Bing D. Yee
 * @since 2022/01/12
 */
@Getter
@Setter
public class ApiResponse<E> implements Serializable {

    private static final long serialVersionUID = 3095433538316185016L;

    private int code;
    private String message;
    private E data;
    private String redirectUri;

    public ApiResponse() {
        this(StatusCode.OK.getCode(), StatusCode.OK.getDesc(), null);
    }

    public ApiResponse(int code, String message, E data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <E> ApiResponse<E> ok() {
        return new ApiResponse<>();
    }

    public static <E> ApiResponse<E> ok(E data) {
        return new ApiResponse<>(StatusCode.OK.getCode(), StatusCode.OK.getDesc(), data);
    }

    public static <E> ApiResponse<E> failed(String message) {
        return new ApiResponse<>(StatusCode.BUSINESS_ERROR.getCode(), message, null);
    }

    public static <E> ApiResponse<E> error(String message) {
        return new ApiResponse<>(StatusCode.INTERNAL_SERVER_ERROR.getCode(), message, null);
    }

    public static <E> ApiResponse<E> of(StatusInfo statusInfo) {
        return new ApiResponse<>(statusInfo.getCode(), statusInfo.getDesc(), null);
    }

    public static <E> ApiResponse<E> of(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    public boolean getSuccess() {
        return StatusCode.OK.getCode() == this.code;
    }

}
