package org.jeecg.modules.system.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.system.entity.GsMaterial;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.system.vo.GsVO;

import java.util.List;

/**
 * @Description: 加工材料信息表
 * @Author: jeecg-boot
 * @Date:   2019-09-03
 * @Version: V1.0
 */
@DS("multi-pool")
public interface IGsMaterialService extends IService<GsMaterial> {

    /*查询未加工完毕材料信息*/
    public List<GsMaterial> queryListInfo ();

    /*查询正在加工材料信息*/
    public  GsVO getInfo(String batchid);

}
