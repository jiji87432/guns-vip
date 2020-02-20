package cn.stylefeng.guns.modular.note.mapper;

import cn.stylefeng.guns.modular.note.entity.QxLogon;
import cn.stylefeng.guns.modular.note.model.params.QxLogonParam;
import cn.stylefeng.guns.modular.note.model.result.QxLogonResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-02-19
 */
public interface QxLogonMapper extends BaseMapper<QxLogon> {

    /**
     * 获取列表
     *
     * @author 
     * @Date 2020-02-19
     */
    List<QxLogonResult> customList(@Param("paramCondition") QxLogonParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 
     * @Date 2020-02-19
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") QxLogonParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 
     * @Date 2020-02-19
     */
    Page<QxLogonResult> customPageList(@Param("page") Page page, @Param("paramCondition") QxLogonParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 
     * @Date 2020-02-19
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") QxLogonParam paramCondition);

}
