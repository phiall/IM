package cn.phil.controller;

import cn.phil.controller.base.BaseController;
import cn.phil.service.redis.RedisService;
import cn.phil.service.socket.MessageService;
import cn.phil.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author phil
 */
@RestController
@RequestMapping("Group/")
public class GroupController extends BaseController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

}
