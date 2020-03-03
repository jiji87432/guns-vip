package cn.stylefeng.guns.modular.camunda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 控制器
 *
 * @author yongji.zhang
 * @Date 2020-03-03
 */
@Controller
@RequestMapping("/camunda/swagger")
public class CamundaSwaggerController {

    private String PREFIX = "/modular/camunda/swagger";

    /**
     * 跳转到主页面
     *
     * @author yongji.zhang
     * @Date 2020-03-03
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/camunda-swagger-ui.html";
    }

}


