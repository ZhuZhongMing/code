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
 * @Description: 化学反应池信息表
 * @Author: jeecg-boot
 * @Date:   2019-09-03
 * @Version: V1.0
 */
@Data
@TableName("Gs_ReactionCell")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Gs_ReactionCell对象", description="化学反应池信息表")
public class GsReactionCell {
    
	/**反应池编号*/
	@TableId(type = IdType.UUID)
	@Excel(name = "反应池编号", width = 15)
    @ApiModelProperty(value = "反应池编号")
	private java.lang.String reactioncellid;
	/**反应池名称*/
	@Excel(name = "反应池名称", width = 15)
    @ApiModelProperty(value = "反应池名称")
	private java.lang.String reactioncellname;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
	private java.lang.String remark;
}
