package org.jeecg.modules.system.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.modules.system.entity.GsTemperature;
import org.jeecg.modules.system.mapper.GsTemperatureMapper;
import org.jeecg.modules.system.service.IGsTemperatureService;
import org.jeecg.modules.system.vo.GsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 温度模块记录表
 * @Author: jeecg-boot
 * @Date:   2019-08-30
 * @Version: V1.0
 */
@Service
@Slf4j
public class GsTemperatureServiceImpl extends ServiceImpl<GsTemperatureMapper, GsTemperature> implements IGsTemperatureService {

    @Resource
    private GsTemperatureMapper gsTemperatureMapper;

    @Override
    public List<GsVO> queryListByReactionCellId(String reactioncellid,String batchid) {
        //log.info("getReactioncellid:"+reactioncellid+"     getBatchid:"+batchid);
        return this.gsTemperatureMapper.queryListByReactionCellId(reactioncellid,batchid);
    }
}
