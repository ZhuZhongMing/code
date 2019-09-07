package org.jeecg.modules.system.controller;

import java.util.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.system.entity.GsSchedule;
import org.jeecg.modules.system.service.IGsScheduleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
 * @Description: 加工流水线进度表
 * @Author: jeecg-boot
 * @Date:   2019-08-30
 * @Version: V1.0
 */
@Slf4j
@Api(tags="加工流水线进度表")
@RestController
@RequestMapping("/system/gsSchedule")
public class GsScheduleController {
	@Autowired
	private IGsScheduleService gsScheduleService;

	 /**
	  * 分页列表查询
	  * @param
	  * @param pageNo
	  * @param pageSize
	  * @param
	  * @return
	  */
	 @AutoLog(value = "加工流水线进度表-分页列表查询")
	 @ApiOperation(value="加工流水线进度表-分页列表查询", notes="加工流水线进度表-分页列表查询")
	 @GetMapping(value = "/getAll")
	 public Result<IPage<GsSchedule>> getAll(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
													@RequestParam(name="pageSize", defaultValue="10") Integer pageSize) {
		 Result<IPage<GsSchedule>> result = new Result<IPage<GsSchedule>>();
		 Page<GsSchedule> page = new Page<GsSchedule>(pageNo, pageSize);

		 //设置排序规则
		 List<OrderItem> orders =new ArrayList<OrderItem>();
		 OrderItem ord= new OrderItem();
		 ord.setColumn("WorkId");
		 ord.setAsc(false);
		 orders.add(ord);
		 page.setOrders(orders);

		 IPage<GsSchedule> pageList = gsScheduleService.page(page);
		 result.setSuccess(true);
		 result.setResult(pageList);
		 return result;
	 }

	
	/**
	  * 分页列表查询
	 * @param gsSchedule
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "加工流水线进度表-分页列表查询")
	@ApiOperation(value="加工流水线进度表-分页列表查询", notes="加工流水线进度表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<GsSchedule>> queryPageList(GsSchedule gsSchedule,
									  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
									  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
									  HttpServletRequest req) {
		Result<IPage<GsSchedule>> result = new Result<IPage<GsSchedule>>();
		QueryWrapper<GsSchedule> queryWrapper = QueryGenerator.initQueryWrapper(gsSchedule, req.getParameterMap());
		Page<GsSchedule> page = new Page<GsSchedule>(pageNo, pageSize);
		IPage<GsSchedule> pageList = gsScheduleService.page(page, queryWrapper);
		result.setSuccess(true);
		result.setResult(pageList);
		return result;
	}
	
	/**
	  *   添加
	 * @param gsSchedule
	 * @return
	 */
	@AutoLog(value = "加工流水线进度表-添加")
	@ApiOperation(value="加工流水线进度表-添加", notes="加工流水线进度表-添加")
	@PostMapping(value = "/add")
	public Result<GsSchedule> add(@RequestBody GsSchedule gsSchedule) {
		Result<GsSchedule> result = new Result<GsSchedule>();
		try {
			gsScheduleService.save(gsSchedule);
			result.success("添加成功！");
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			result.error500("操作失败");
		}
		return result;
	}
	
	/**
	  *  编辑
	 * @param gsSchedule
	 * @return
	 */
	@AutoLog(value = "加工流水线进度表-编辑")
	@ApiOperation(value="加工流水线进度表-编辑", notes="加工流水线进度表-编辑")
	@PutMapping(value = "/edit")
	public Result<GsSchedule> edit(@RequestBody GsSchedule gsSchedule) {
		Result<GsSchedule> result = new Result<GsSchedule>();
		GsSchedule gsScheduleEntity = gsScheduleService.getById(gsSchedule.getWorkid());
		if(gsScheduleEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = gsScheduleService.updateById(gsSchedule);
			//TODO 返回false说明什么？
			if(ok) {
				result.success("修改成功!");
			}
		}
		
		return result;
	}
	
	/**
	  *   通过id删除
	 * @param id
	 * @return
	 */
	@AutoLog(value = "加工流水线进度表-通过id删除")
	@ApiOperation(value="加工流水线进度表-通过id删除", notes="加工流水线进度表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		try {
			gsScheduleService.removeById(id);
		} catch (Exception e) {
			log.error("删除失败",e.getMessage());
			return Result.error("删除失败!");
		}
		return Result.ok("删除成功!");
	}
	
	/**
	  *  批量删除
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "加工流水线进度表-批量删除")
	@ApiOperation(value="加工流水线进度表-批量删除", notes="加工流水线进度表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<GsSchedule> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<GsSchedule> result = new Result<GsSchedule>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.gsScheduleService.removeByIds(Arrays.asList(ids.split(",")));
			result.success("删除成功!");
		}
		return result;
	}
	
	/**
	  * 通过id查询
	 * @param id
	 * @return
	 */
	@AutoLog(value = "加工流水线进度表-通过id查询")
	@ApiOperation(value="加工流水线进度表-通过id查询", notes="加工流水线进度表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<GsSchedule> queryById(@RequestParam(name="id",required=true) String id) {
		Result<GsSchedule> result = new Result<GsSchedule>();
		GsSchedule gsSchedule = gsScheduleService.getById(id);
		if(gsSchedule==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(gsSchedule);
			result.setSuccess(true);
		}
		return result;
	}

  /**
      * 导出excel
   *
   * @param request
   * @param response
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, HttpServletResponse response) {
      // Step.1 组装查询条件
      QueryWrapper<GsSchedule> queryWrapper = null;
      try {
          String paramsStr = request.getParameter("paramsStr");
          if (oConvertUtils.isNotEmpty(paramsStr)) {
              String deString = URLDecoder.decode(paramsStr, "UTF-8");
              GsSchedule gsSchedule = JSON.parseObject(deString, GsSchedule.class);
              queryWrapper = QueryGenerator.initQueryWrapper(gsSchedule, request.getParameterMap());
          }
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
      }

      //Step.2 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      List<GsSchedule> pageList = gsScheduleService.list(queryWrapper);
      //导出文件名称
      mv.addObject(NormalExcelConstants.FILE_NAME, "加工流水线进度表列表");
      mv.addObject(NormalExcelConstants.CLASS, GsSchedule.class);

	  String exportBy = "";
	  // 获取登录用户信息
	  LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
	  if (sysUser != null) {
		  // 登录账号
		  exportBy = sysUser.getRealname();
	  }

      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("加工流水线进度表列表数据", "导出人:"+exportBy, "导出信息"));
      mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
      return mv;
  }

  /**
      * 通过excel导入数据
   *
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
  public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
      for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
          MultipartFile file = entity.getValue();// 获取上传文件对象
          ImportParams params = new ImportParams();
          params.setTitleRows(2);
          params.setHeadRows(1);
          params.setNeedSave(true);
          try {
              List<GsSchedule> listGsSchedules = ExcelImportUtil.importExcel(file.getInputStream(), GsSchedule.class, params);
              gsScheduleService.saveBatch(listGsSchedules);
              return Result.ok("文件导入成功！数据行数:" + listGsSchedules.size());
          } catch (Exception e) {
              log.error(e.getMessage(),e);
              return Result.error("文件导入失败:"+e.getMessage());
          } finally {
              try {
                  file.getInputStream().close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      return Result.ok("文件导入失败！");
  }

}
