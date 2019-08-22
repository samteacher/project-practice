package com.sam.shirotest.commen;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * 封装入参出参
 *
 * @param <T>
 * @author yuqiufu
 * @since 2019-08-22
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {


    private boolean success;

    // 返回结果状态
    public Integer resultCode;

    // 返回结果内容
    public String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    // 返回结果数据
    public T data;

    /**
     * constructor
     **/
    public Response() {
    }

    public Response(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Response(Integer resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public Response(Integer resultCode, String message, T data) {
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

    /**
     * getter  or   setter
     **/
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Response<T> success() {
        return success("操作成功");
    }

    public static <T> Response<T> success(String successMessage) {
        return success(HttpStatus.OK.value(), successMessage);
    }

    public static <T> Response<T> success(Integer resultCode, String successMessage) {
        Response<T> response = new Response();
        response.setSuccess(true);
        response.setResultCode(resultCode);
        response.setMessage(successMessage);
        response.setTime(new Date());
        return response;
    }

    public static <T> Response<T> data(T t) {
        return data(t, "");
    }

    public static <T> Response<T> data(T t, String successMessage) {
        return data(t, HttpStatus.OK.value(), successMessage);
    }

    public static <T> Response<T> data(T t, Integer resultCode, String successMessage) {
        Response<T> response = new Response();
        response.setSuccess(true);
        response.setResultCode(resultCode);
        response.setMessage(successMessage);
        response.setData(t);
        response.setTime(new Date());
        return response;
    }

    public static <T> Response<T> error(String failedMessage) {
        return error(HttpStatus.BAD_REQUEST.value(), failedMessage);
    }

    public static <T> Response<T> error(Integer resultCode, String failedMessage) {
        Response<T> response = new Response();
        response.setSuccess(false);
        response.setTime(new Date());
        response.setResultCode(resultCode);
        response.setMessage(failedMessage);
        return response;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Response)) {
            return false;
        } else {
            Response<?> other = (Response)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isSuccess() != other.isSuccess()) {
                return false;
            } else {
                label61: {
                    Object this$resultCode = this.getResultCode();
                    Object other$resultCode = other.getResultCode();
                    if (this$resultCode == null) {
                        if (other$resultCode == null) {
                            break label61;
                        }
                    } else if (this$resultCode.equals(other$resultCode)) {
                        break label61;
                    }

                    return false;
                }

                label54: {
                    Object this$message = this.getMessage();
                    Object other$message = other.getMessage();
                    if (this$message == null) {
                        if (other$message == null) {
                            break label54;
                        }
                    } else if (this$message.equals(other$message)) {
                        break label54;
                    }

                    return false;
                }

                Object this$time = this.getTime();
                Object other$time = other.getTime();
                if (this$time == null) {
                    if (other$time != null) {
                        return false;
                    }
                } else if (!this$time.equals(other$time)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Response;
    }

    public int hashCode() {
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        Object $resultCode = this.getResultCode();
        result = result * 59 + ($resultCode == null ? 43 : $resultCode.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $time = this.getTime();
        result = result * 59 + ($time == null ? 43 : $time.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "Response(success=" + this.isSuccess() + ", resultCode=" + this.getResultCode() + ", message=" + this.getMessage() + ", time=" + this.getTime() + ", data=" + this.getData() + ")";
    }

}
