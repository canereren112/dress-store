package com.eren.assignment.sahibinden.exception;


public enum ResponseCodes {
	SUCCESS(0, "Islem basarili bir sekilde gerceklestirilmistir."),
	ERROR(1, "Sistemsel bir hata olustu."),
	ENTITY_NAME_ALREADY_EXISTS(2, "Ayni isimde bir kayit mevcuttur."),
	ENTITY_NOT_FOUND(3, "Kayit bulunamadi."),
	CART_IS_EMPTY(4, "Sepetiniz bos. Bir icecek ekledikten sonra tekrar deneyin."),
	CART_IS_UNSTABLE(5, "Sepetiniz olusturuken bir hata olustu. Lutfen bastan deneyin.."),
	ITEMS_DEACTIVATED(5, "Sectiginiz bazi icecek veya eklentiler bulunamadi. Lutfen tekrar deneyin.");
	
	public final String message;

	public final int errorCode;

	public final boolean includeExceptionDetail;


	ResponseCodes() {
		message="Sistem Failure";
		errorCode=999;
		includeExceptionDetail=false;
	}

	
	ResponseCodes(String msg) {
		this.message = msg;
		this.errorCode = ordinal();
		this.includeExceptionDetail=false;
	}

	
	ResponseCodes(int errorCode, String msg) {
		this.message = msg;
		this.errorCode = errorCode;
		this.includeExceptionDetail=false;
	}

	
	ResponseCodes(int errorCode, String msg, boolean includeExceptionDetail) {
		this.message = msg;
		this.errorCode = errorCode;
		this.includeExceptionDetail = includeExceptionDetail;
	}


	public String message() {
		return message;
	}

	
	public static ResponseCodes forErrorCode(int errorCode) {
		ResponseCodes[] errors = ResponseCodes.values();
		for (ResponseCodes ec : errors) {
			if (ec.errorCode == errorCode) {
				return ec;
			}
		}
		return ERROR;
	}

	
	public static ResponseCodes forOrdinal(int ordinal) {
		ResponseCodes[] errors = ResponseCodes.values();
		for (ResponseCodes ec : errors) {
			if (ec.ordinal() == ordinal) {
				return ec;
			}
		}
		return ERROR;
	}
}
