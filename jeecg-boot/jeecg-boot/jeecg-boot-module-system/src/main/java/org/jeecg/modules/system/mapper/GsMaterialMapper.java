package org.jeecg.modules.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.system.entity.GsMaterial;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.system.vo.GsVO;

/**
 * @Description: 加工材料信息表
 * @Author: jeecg-boot
 * @Date:   2019-09-03
 * @Version: V1.0
 */
public interface GsMaterialMapper extends BaseMapper<GsMaterial> {

    /*查询未加工完毕材料信息*/
    public List<GsMaterial> queryListInfo ();

    /*查询正在加工材料信息*/
    public GsVO getInfo(String batchid);

}
