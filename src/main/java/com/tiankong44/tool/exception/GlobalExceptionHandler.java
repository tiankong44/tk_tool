package com.tiankong44.tool.exception;

import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

/**
 * @author zhanghao_SMEICS
 * @date 2022-10-21 22:39
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseRes handleValidationException(MethodArgumentNotValidException ex) {
        StringBuilder stringBuilder = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach(
                error -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    stringBuilder.append(fieldName).append(":").append(errorMessage).append(",");

                }
        );
        String message = stringBuilder.toString();
        message = StringUtil.trimEnd(message, ",");
        log.error(message);
        return BaseRes.failure(message);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseRes handleConstraintViolationException(ConstraintViolationException e) {
        return BaseRes.failure(e.getMessage());
    }
}
