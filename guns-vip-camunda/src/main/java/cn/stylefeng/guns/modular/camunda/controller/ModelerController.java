package cn.stylefeng.guns.modular.camunda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 控制器
 *
 * @author stylefeng
 * @Date 2019-08-06 22:03:10
 */
@Controller
@RequestMapping("/modeler")
public class ModelerController {

    private String PREFIX = "/modular/camunda/modeler";

    /**
     * 跳转到主页面
     *
     * @author yongji.zhang
     * @Date 2020-03-03
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/modeler.html";
    }

}


