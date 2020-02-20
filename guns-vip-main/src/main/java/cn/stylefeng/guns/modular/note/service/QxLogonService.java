package cn.stylefeng.guns.modular.note.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.note.entity.QxLogon;
import cn.stylefeng.guns.modular.note.model.params.QxLogonParam;
import cn.stylefeng.guns.modular.note.model.result.QxLogonResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2020-02-19
 */
public interface QxLogonService extends IService<QxLogon> {

    /**
     * 新增
     *
     * @author 
     * @Date 2020-02-19
     */
    void add(QxLogonParam param);

    /**
     * 删除
     *
     * @author 
     * @Date 2020-02-19
     */
    void delete(QxLogonParam param);

    /**
     * 更新
     *
     * @author 
     * @Date 2020-02-19
     */
    void update(QxLogonParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 
     * @Date 2020-02-19
     */
    QxLogonResult findBySpec(QxLogonParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 
     * @Date 2020-02-19
     */
    List<QxLogonResult> findListBySpec(QxLogonParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 
     * @Date 2020-02-19
     */
     LayuiPageInfo findPageBySpec(QxLogonParam param);

}
