package org.jeecg.modules.system.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Description: 加工材料信息表
 * @Author: jeecg-boot
 * @Date:   2019-09-03
 * @Version: V1.0
 */
@Data
@TableName("gs_material")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="gs_material对象", description="加工材料信息表")
public class GsMaterial {
    
	/**材料批次编码*/
	@TableId(type = IdType.UUID)
	@Excel(name = "材料批次编码", width = 15)
    @ApiModelProperty(value = "材料批次编码")
	private java.lang.String batchid;
	/**材料类型:(1:xx 2:oo)*/
	@Excel(name = "材料类型:(1:xx 2:oo)", width = 15)
    @ApiModelProperty(value = "材料类型:(1:xx 2:oo)")
	private java.lang.Integer materialid;
	/**材料加工模式:(1:xx 2:oo)*/
	@Excel(name = "材料加工模式:(1:xx 2:oo)", width = 15)
    @ApiModelProperty(value = "材料加工模式:(1:xx 2:oo)")
	private java.lang.Integer processmode;
	/**材料加工状态:(1:等待加工 2:正在加工 3:加工完毕)*/
	@Excel(name = "材料加工状态:(1:等待加工 2:正在加工 3:加工完毕)", width = 15)
    @ApiModelProperty(value = "材料加工状态:(1:等待加工 2:正在加工 3:加工完毕)")
	private java.lang.Integer state;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
	private java.lang.String remark;
}
