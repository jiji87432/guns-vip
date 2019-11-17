package cn.stylefeng.guns.modular.note.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.note.entity.QxBlacklist;
import cn.stylefeng.guns.modular.note.model.params.QxBlacklistParam;
import cn.stylefeng.guns.modular.note.model.result.QxBlacklistResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 黑名单表 服务类
 * </p>
 *
 * @author 
 * @since 2019-11-14
 */
public interface QxBlacklistService extends IService<QxBlacklist> {

    /**
     * 新增
     *
     * @author 
     * @Date 2019-11-14
     */
    void add(QxBlacklistParam param);

    /**
     * 删除
     *
     * @author 
     * @Date 2019-11-14
     */
    void delete(QxBlacklistParam param);

    /**
     * 更新
     *
     * @author 
     * @Date 2019-11-14
     */
    void update(QxBlacklistParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 
     * @Date 2019-11-14
     */
    QxBlacklistResult findBySpec(QxBlacklistParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 
     * @Date 2019-11-14
     */
    List<QxBlacklistResult> findListBySpec(QxBlacklistParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 
     * @Date 2019-11-14
     */
     LayuiPageInfo findPageBySpec(QxBlacklistParam param);

}