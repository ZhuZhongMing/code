package org.jeecg.modules.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.system.entity.GsTemperature;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.system.vo.GsVO;

/**
 * @Description: 温度模块记录表
 * @Author: jeecg-boot
 * @Date:   2019-08-30
 * @Version: V1.0
 */
public interface GsTemperatureMapper extends BaseMapper<GsTemperature> {

    /*根据反应池编号查询温度列表*/
    public List<GsVO> queryListByReactionCellId(String reactioncellid,String batchid);

}
