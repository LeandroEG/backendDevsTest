package com.backend.devstest.config;

import org.springframework.http.HttpStatus;

import com.backend.devstest.exceptions.ProductClientApiException;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class RetryerErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(String method, Response response) {
		Exception exception = defaultErrorDecoder.decode(method, response);

		if (exception instanceof RetryableException) {
			return exception;
		}

		if (HttpStatus.valueOf(response.status()).is5xxServerError()) {
			return new RetryableException(response.status(), response.reason(), response.request().httpMethod(), null,
					response.request());
		} else {
			return new ProductClientApiException();
		}

	}
}
