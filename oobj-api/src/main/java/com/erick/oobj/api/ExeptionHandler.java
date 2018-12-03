package com.erick.oobj.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.erick.oobj.api.exception.BusinessException;

@ControllerAdvice
public class ExeptionHandler extends ResponseEntityExceptionHandler {

	private static final String RESOURCE_OPERATION_NOT_ALLOWED = "resource.operation-not-allowed";

	private static final String RESOURCE_NOT_FOUND = "resource.not-found";

	private static final String MESSAGE_INVALID = "message.invalid";
	
	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		final String message = messageSource.getMessage(MESSAGE_INVALID, null, LocaleContextHolder.getLocale());

		Throwable cause = exception.getCause();
		
		final String messageDebug = cause != null ? cause.toString() : exception.toString();

		List<SoninhoExceptionCustom> exceptions = Arrays.asList(new SoninhoExceptionCustom(message, messageDebug));

		return handleExceptionInternal(exception, exceptions, headers, HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<SoninhoExceptionCustom> exceptions = createErrorList(exception.getBindingResult());

		return handleExceptionInternal(exception, exceptions, headers, status, request);
	}
	
	@ExceptionHandler ({DataIntegrityViolationException.class})
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException exception, WebRequest request) {
		String message = messageSource.getMessage(RESOURCE_OPERATION_NOT_ALLOWED, null, LocaleContextHolder.getLocale());

		String messageDebug = ExceptionUtils.getRootCauseMessage(exception);
		
		List<SoninhoExceptionCustom> exceptions = Arrays.asList(new SoninhoExceptionCustom(message, messageDebug));

		return handleExceptionInternal(exception, exceptions, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({EmptyResultDataAccessException.class})
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException exception, WebRequest request) {
		
		String message = messageSource.getMessage(RESOURCE_NOT_FOUND, null, LocaleContextHolder.getLocale());

		String messageDebug = exception.toString();
		
		List<SoninhoExceptionCustom> exceptions = Arrays.asList(new SoninhoExceptionCustom(message, messageDebug));

		return handleExceptionInternal(exception, exceptions, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler({BusinessException.class})
	public ResponseEntity<Object> handleBusinessException(BusinessException exception) {

		String message = messageSource.getMessage(exception.getMessage(), null, LocaleContextHolder.getLocale());

		String messageDebug = exception.toString();
		
		List<SoninhoExceptionCustom> exceptions = Arrays.asList(new SoninhoExceptionCustom(message, messageDebug));

		return ResponseEntity.badRequest().body(exceptions);
	}
	
	private List<SoninhoExceptionCustom> createErrorList(BindingResult bindingResult) {

		List<SoninhoExceptionCustom> exceptions = new ArrayList<>();

		for (FieldError fieldError : bindingResult.getFieldErrors()) {

			String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());

			String messageDebug = fieldError.toString();

			exceptions.add(new SoninhoExceptionCustom(message, messageDebug));
		}

		return exceptions;
	}

	public static class SoninhoExceptionCustom {
		private String message;
		private String cause;

		public SoninhoExceptionCustom(String message, String messageDebug) {
			super();
			this.message = message;
			this.cause = messageDebug;
		}

		public String getCause() {
			return cause;
		}

		public void setCause(String messageDebug) {
			this.cause = messageDebug;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

}
