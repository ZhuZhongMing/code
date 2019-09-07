package org.jeecg.modules.system.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.hibernate.validator.constraints.EAN;
import org.jeecg.modules.system.entity.GsTemperature;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.system.vo.GsVO;

import java.util.List;

/**
 * @Description: 温度模块记录表
 * @Author: jeecg-boot
 * @Date:   2019-08-30
 * @Version: V1.0
 */
@DS("multi-pool")
public interface IGsTemperatureService extends IService<GsTemperature> {
    /*根据反应池编号查询温度列表*/
    public List<GsVO> queryListByReactionCellId(String reactioncellid,String batchid);

}
