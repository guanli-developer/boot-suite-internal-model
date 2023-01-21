package tech.guanli.boot.internal.model.implemention;

import lombok.Builder;
import lombok.Data;
import tech.guanli.boot.internal.model.Returnable;
import tech.guanli.boot.internal.model.constant.ResponseDataConstant;

@Data
@Builder
public class ResponseData<T> implements Returnable, ResponseDataConstant {

	private static final long serialVersionUID = 1L;

	private Integer code;

	private String message;

	private T data;

	private Long timestamp;

	public static final <T> ResponseData<T> success() {
		return ResponseData.<T>builder().code(SUCCESS).message(SUCCESS_MESSAGE).timestamp(System.currentTimeMillis())
				.build();
	}

	public static final <T> ResponseData<T> success(T data) {
		return ResponseData.<T>builder().code(SUCCESS).message(SUCCESS_MESSAGE).data(data)
				.timestamp(System.currentTimeMillis()).build();
	}

	public static final <T> ResponseData<T> failed(Integer code) {
		return failed(code, FAILED_MESSAGE);
	}

	public static final <T> ResponseData<T> failed(String message) {
		return failed(FAILED, message);
	}

	public static final <T> ResponseData<T> failed(Integer code, String message) {
		return ResponseData.<T>builder().code(code).message(message).timestamp(System.currentTimeMillis()).build();
	}

}
