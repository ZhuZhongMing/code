package org.jeecg.modules.system.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.system.entity.GsSchedule;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 加工流水线进度表
 * @Author: jeecg-boot
 * @Date:   2019-08-30
 * @Version: V1.0
 */
@DS("multi-pool")
public interface IGsScheduleService extends IService<GsSchedule> {

}
