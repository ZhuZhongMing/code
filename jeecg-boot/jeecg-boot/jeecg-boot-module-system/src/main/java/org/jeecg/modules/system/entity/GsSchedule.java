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
 * @Description: 加工流水线进度表
 * @Author: jeecg-boot
 * @Date:   2019-08-30
 * @Version: V1.0
 */
@Data
@TableName("gs_Schedule")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="gs_Schedule对象", description="加工流水线进度表")
public class GsSchedule {


	/**作业单编号ID*/
	@TableId(type = IdType.UUID)
	@Excel(name = "作业单编号ID", width = 15)
	@ApiModelProperty(value = "作业单编号ID")
	private java.lang.String workid;
	/**材料批次编码*/
	@Excel(name = "材料批次编码", width = 15)
    @ApiModelProperty(value = "材料批次编码")
	private java.lang.String batchid;
	/**工序编号*/
	@Excel(name = "工序编号", width = 15)
	@ApiModelProperty(value = "工序编号")
	private java.lang.String processid;
	/**开始时间*/
	@Excel(name = "开始时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "开始时间")
	private java.util.Date starttime;
	/**结束时间*/
	@Excel(name = "结束时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间")
	private java.util.Date endtime;
	/**加工耗时*/
	@Excel(name = "加工耗时", width = 15)
    @ApiModelProperty(value = "加工耗时")
	private java.lang.String worktime;
}
