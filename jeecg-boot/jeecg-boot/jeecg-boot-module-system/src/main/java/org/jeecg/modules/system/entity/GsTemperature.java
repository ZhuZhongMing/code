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
 * @Description: 温度模块记录表
 * @Author: jeecg-boot
 * @Date:   2019-08-30
 * @Version: V1.0
 */
@Data
@TableName("gs_Temperature")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="gs_Temperature对象", description="温度模块记录表")
public class GsTemperature {
    
	/**反应池编号*/
	@Excel(name = "反应池编号", width = 15)
    @ApiModelProperty(value = "反应池编号")
	private java.lang.String reactioncellid;
	/**记录ID*/
	@TableId(type = IdType.UUID)
	@Excel(name = "记录ID", width = 15)
    @ApiModelProperty(value = "记录ID")
	private java.lang.String recordid;
	/**温度*/
	@Excel(name = "温度（单位：℃）", width = 15)
    @ApiModelProperty(value = "温度（单位：℃）")
	private java.lang.String temperature;
	/**记录时间*/
	@Excel(name = "记录时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "记录时间")
	private java.util.Date writetime;
}
