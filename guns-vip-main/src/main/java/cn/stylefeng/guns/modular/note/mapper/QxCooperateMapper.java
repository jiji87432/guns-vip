package cn.stylefeng.guns.modular.note.mapper;

import cn.stylefeng.guns.modular.note.entity.QxCooperate;
import cn.stylefeng.guns.modular.note.model.params.QxCooperateParam;
import cn.stylefeng.guns.modular.note.model.result.QxCooperateResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商务合作 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2019-11-14
 */
public interface QxCooperateMapper extends BaseMapper<QxCooperate> {

    /**
     * 获取列表
     *
     * @author 
     * @Date 2019-11-14
     */
    List<QxCooperateResult> customList(@Param("paramCondition") QxCooperateParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 
     * @Date 2019-11-14
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") QxCooperateParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 
     * @Date 2019-11-14
     */
    Page<QxCooperateResult> customPageList(@Param("page") Page page, @Param("paramCondition") QxCooperateParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 
     * @Date 2019-11-14
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") QxCooperateParam paramCondition);

}