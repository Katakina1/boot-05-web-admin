package com.kina.admin.controller;

import lombok.SneakyThrows;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Order(value = Ordered.HIGHEST_PRECEDENCE) // 定义优先级,数字越小，优先级越高
//@Controller
//public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
//    @SneakyThrows
//    @Override
//    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//
//        response.sendError(511,"我定义的异常");
//        return new ModelAndView();
//    }
//}
