package cn.stylefeng.guns.modular.note.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.note.entity.QxLogon;
import cn.stylefeng.guns.modular.note.mapper.QxLogonMapper;
import cn.stylefeng.guns.modular.note.model.params.QxLogonParam;
import cn.stylefeng.guns.modular.note.model.result.QxLogonResult;
import  cn.stylefeng.guns.modular.note.service.QxLogonService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2020-02-19
 */
@Service
public class QxLogonServiceImpl extends ServiceImpl<QxLogonMapper, QxLogon> implements QxLogonService {

    @Override
    public void add(QxLogonParam param){
        QxLogon entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(QxLogonParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(QxLogonParam param){
        QxLogon oldEntity = getOldEntity(param);
        QxLogon newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public QxLogonResult findBySpec(QxLogonParam param){
        return null;
    }

    @Override
    public List<QxLogonResult> findListBySpec(QxLogonParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(QxLogonParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(QxLogonParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private QxLogon getOldEntity(QxLogonParam param) {
        return this.getById(getKey(param));
    }

    private QxLogon getEntity(QxLogonParam param) {
        QxLogon entity = new QxLogon();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
