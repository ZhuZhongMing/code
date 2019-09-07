package org.jeecg.modules.system.service.impl;

import org.jeecg.modules.system.entity.GsMaterial;
import org.jeecg.modules.system.mapper.GsMaterialMapper;
import org.jeecg.modules.system.service.IGsMaterialService;
import org.jeecg.modules.system.vo.GsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 加工材料信息表
 * @Author: jeecg-boot
 * @Date:   2019-09-03
 * @Version: V1.0
 */
@Service
public class GsMaterialServiceImpl extends ServiceImpl<GsMaterialMapper, GsMaterial> implements IGsMaterialService {

    @Resource
    GsMaterialMapper gsMaterialMapper;

    @Override
    public List<GsMaterial> queryListInfo() {
        return this.gsMaterialMapper.queryListInfo();
    }

    @Override
    public GsVO getInfo(String batchid) {
        return this.gsMaterialMapper.getInfo(batchid);
    }
}
