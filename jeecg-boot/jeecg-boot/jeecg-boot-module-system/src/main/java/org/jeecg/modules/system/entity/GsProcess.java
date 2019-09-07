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
 * @Description: 工序信息表
 * @Author: jeecg-boot
 * @Date:   2019-09-03
 * @Version: V1.0
 */
@Data
@TableName("gs_Process")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="gs_Process对象", description="工序信息表")
public class GsProcess {
    
	/**工序编号*/
	@TableId(type = IdType.UUID)
	@Excel(name = "工序编号", width = 15)
    @ApiModelProperty(value = "工序编号")
	private java.lang.String processid;
	/**工序名称*/
	@Excel(name = "工序名称", width = 15)
    @ApiModelProperty(value = "工序名称")
	private java.lang.String processname;
	/**反应池编号*/
	@Excel(name = "反应池编号", width = 15)
    @ApiModelProperty(value = "反应池编号")
	private java.lang.String reactioncellid;
	/**工序所需时间*/
	@Excel(name = "工序所需时间（单位：秒）", width = 15)
    @ApiModelProperty(value = "工序所需时间（单位：秒）")
	private java.lang.Object processtime;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
	private java.lang.String remark;
}
