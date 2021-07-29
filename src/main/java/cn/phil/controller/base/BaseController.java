package cn.phil.controller.base;

import cn.phil.model.base.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author phil
 */
@RestController
@Slf4j
public class BaseController {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ResponseResult> error(Exception e, HttpServletRequest request) {
        ResponseResult result = new ResponseResult();
        result.setMessage(e.getMessage());
        result.setCode(-1);
        log.error(request.getRequestURL().toString() + "处理失败！！\n" + e.getMessage());
        StackTraceElement[] error = e.getStackTrace();
        for (StackTraceElement stackTraceElement : error) {
            log.error(stackTraceElement.toString());
        }
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
