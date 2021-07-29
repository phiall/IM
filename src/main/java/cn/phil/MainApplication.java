package cn.phil;

import cn.phil.common.SpringContextUtil;
import cn.phil.service.socket.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MainApplication
{
    public static void main( String[] args ) throws Exception {
        ApplicationContext app = SpringApplication.run(MainApplication.class, args);
        SpringContextUtil.setApplicationContext(app);
        new NettyServer(8070).start();
    }
}
