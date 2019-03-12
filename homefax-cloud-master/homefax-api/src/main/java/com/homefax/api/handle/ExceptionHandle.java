package com.homefax.api.handle;

import com.homefax.Enum.ResultEnum;
import com.homefax.common.Result;
import com.homefax.common.ResultBody;
import com.homefax.exception.HomefaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @Description:
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2019/2/22 11:06
 * @Create Author: nevermore
 * @File Name: ExceptionHandle
 * @Last version:1.0.0
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody handle(Exception e) {
        if (e instanceof HomefaxException) {
            HomefaxException homefaxException = (HomefaxException) e;
            return new ResultBody(homefaxException.getStatus(), homefaxException.getMessage());
        }else {
            e.printStackTrace();
            return new ResultBody(ResultEnum.exception);
        }
    }

    /**
     * 处理请求对象属性不满足校验规则的异常信息
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultBody exception(HttpServletRequest request, MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder builder = new StringBuilder();

        for (FieldError error : fieldErrors) {
            builder.append(error.getDefaultMessage() + ",");
        }
        return new ResultBody(ResultEnum.exception.getStatus(), builder.toString());
    }

    /**
     * 处理请求单个参数不满足校验规则的异常信息
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public ResultBody constraintViolationExceptionHandler(HttpServletRequest request, ConstraintViolationException exception) {
        logger.info(exception.getMessage());
        return new ResultBody(ResultEnum.exception.getStatus(), exception.getMessage());
    }

}
