package cn.phil.controller;

import cn.phil.controller.base.BaseController;
import cn.phil.model.base.ResponseResult;
import cn.phil.model.socket.Message;
import cn.phil.service.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * @author phil
 */
@RestController
@Slf4j
@RequestMapping("message/")
public class MessageController extends BaseController{
    @Autowired
    private RedisService redisService;

    @PostMapping("notice")
    public ResponseEntity<ResponseResult> sendNotify(@RequestBody Message message) {
        ResponseResult result = new ResponseResult();
        try {
            
        } catch (Exception e) {
            result.setMessage(e.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("history/{userId}")
    public ResponseEntity<ResponseResult> getHistory(@PathVariable("userId") Long userId,
            @PageableDefault(page = 0, size = 20) Pageable pageable) {
        return null;
    }
}
