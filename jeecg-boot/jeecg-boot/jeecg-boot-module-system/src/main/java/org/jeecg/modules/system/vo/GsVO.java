package org.jeecg.modules.system.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecg.modules.system.entity.GsMaterial;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * @author Guess
 * vo类  包含除备注外的所有字段
 *
 */
@Data
public class GsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**材料批次编码*/
    @ApiModelProperty(value = "材料批次编码")
    private java.lang.String batchid;
    /**材料类型:(1:xx 2:oo)*/
    @ApiModelProperty(value = "材料类型:(1:xx 2:oo)")
    private java.lang.Integer materialid;
    /**材料加工模式:(1:xx 2:oo)*/
    @ApiModelProperty(value = "材料加工模式:(1:xx 2:oo)")
    private java.lang.Integer processmode;
    /**材料加工状态:(1:等待加工 2:正在加工 3:加工完毕)*/
    @ApiModelProperty(value = "材料加工状态:(1:等待加工 2:正在加工 3:加工完毕)")
    private java.lang.Integer state;
    /**工序编号*/
    @ApiModelProperty(value = "工序编号")
    private java.lang.String processid;
    /**工序名称*/
    @ApiModelProperty(value = "工序名称")
    private java.lang.String processname;
    /**反应池编号*/
    @ApiModelProperty(value = "反应池编号")
    private java.lang.String reactioncellid;
    /**工序所需时间*/
    @ApiModelProperty(value = "工序所需时间（单位：秒）")
    private java.lang.Object processtime;
    /**反应池名称*/
    @ApiModelProperty(value = "反应池名称")
    private java.lang.String reactioncellname;
    /**作业单编号ID*/
    @ApiModelProperty(value = "作业单编号ID")
    private java.lang.String workid;
    /**开始时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间")
    private java.util.Date starttime;
    /**结束时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间")
    private java.util.Date endtime;
    /**加工耗时*/
    @ApiModelProperty(value = "加工耗时")
    private java.lang.String worktime;
    /**记录ID*/
    @ApiModelProperty(value = "记录ID")
    private java.lang.String recordid;
    /**温度*/
    @ApiModelProperty(value = "温度（单位：℃）")
    private java.lang.String temperature;
    /**记录时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "记录时间")
    private java.util.Date writetime;


}
