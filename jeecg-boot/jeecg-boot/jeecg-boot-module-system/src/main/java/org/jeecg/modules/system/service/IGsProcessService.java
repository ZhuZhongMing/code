package org.jeecg.modules.system.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.system.entity.GsProcess;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 工序信息表
 * @Author: jeecg-boot
 * @Date:   2019-09-03
 * @Version: V1.0
 */
@DS("multi-pool")
public interface IGsProcessService extends IService<GsProcess> {

}
