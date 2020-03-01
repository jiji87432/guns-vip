package cn.stylefeng.guns.modular.act.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.core.act.base.ActBaseController;
import cn.stylefeng.guns.core.act.util.TimeCalcUtil;
import cn.stylefeng.guns.modular.act.model.params.TaskParam;
import cn.stylefeng.guns.modular.act.service.HistoryProcessService;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * 历史流程控制器
 *
 * @author fengshuonan
 * @Date 2019-08-19 17:27:26
 */
@Controller
@RequestMapping("/historyProc")
public class HistoryProcessController extends ActBaseController {

    private String PREFIX = "/modular/act/historyProc";

    @Autowired
    private HistoryProcessService historyProcessService;

    /**
     * 跳转到主页面
     *
     * @author fengshuonan
     * @Date 2019-08-19
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/historyProc.html";
    }

    /**
     * 流程历史查询列表
     *
     * @author fengshuonan
     * @Date 2019-08-19
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(TaskParam procinstParam) {

        LayuiPageInfo pageBySpec = this.historyProcessService.findPageBySpec(procinstParam);

        if (ToolUtil.isNotEmpty(pageBySpec.getData()) && pageBySpec.getData().size() > 0) {
            List<Map<String, Object>> maps = pageBySpec.getData();

            for (int i = 0; i < maps.size(); i++) {
                Long ztime = Long.parseLong(maps.get(i).get("DURATION_").toString());

                //用时
                maps.get(i).put("ZTIME", TimeCalcUtil.calc(ztime));

                //流程申请人
                maps.get(i).put("INITATOR", getInitiator((String) maps.get(i).get("PROC_INST_ID_")));
            }
        }

        return pageBySpec;
    }

    /**
     * 删除
     *
     * @author fengshuonan
     * @Date 2019-08-28 15:46
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResponseData delete(@RequestParam("procinstId") String procinstId) {

        if (ToolUtil.isEmpty(procinstId)) {
            throw new ServiceException(500, "procinstId不能为空");
        }

        deleteHiProcessInstance(procinstId);

        return ResponseData.success();
    }

}


