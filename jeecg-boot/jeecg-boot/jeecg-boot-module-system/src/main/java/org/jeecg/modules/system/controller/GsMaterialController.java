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
import org.jeecg.modules.system.entity.GsMaterial;
import org.jeecg.modules.system.service.IGsMaterialService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.system.vo.GsVO;
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
 * @Description: 加工材料信息表
 * @Author: jeecg-boot
 * @Date:   2019-09-03
 * @Version: V1.0
 */
@Slf4j
@Api(tags="加工材料信息表")
@RestController
@RequestMapping("/system/gsMaterial")
public class GsMaterialController {
	@Autowired
	private IGsMaterialService gsMaterialService;

	 /**
	  * 查询正在加工材料信息
	  * @return
	  */
	 @AutoLog(value = "加工材料信息表-查询正在加工材料信息")
	 @ApiOperation(value="加工材料信息表-查询正在加工材料信息", notes="加工材料信息表-查询正在加工材料信息")
	 @GetMapping(value = "/getInfo")
	 public Result<GsVO> getInfo(@RequestParam(name="batchid")String batchid) {
		 Result<GsVO> result = new Result<GsVO>();
		 GsVO vo = gsMaterialService.getInfo(batchid);
		 result.setSuccess(true);
		 result.setResult(vo);
		 return result;
	 }


	 /**
	  * 查询未加工完毕材料信息
	  * @return
	  */
	 @AutoLog(value = "加工材料信息表-查询未加工完毕材料信息")
	 @ApiOperation(value="加工材料信息表-wei", notes="加工材料信息表-查询未加工完毕材料信息")
	 @GetMapping(value = "/queryListInfo")
	 public Result<List<GsMaterial>> queryListInfo() {
		 Result<List<GsMaterial>> result = new Result<List<GsMaterial>>();
		 List<GsMaterial> pageList = gsMaterialService.queryListInfo();
		 result.setSuccess(true);
		 result.setResult(pageList);
		 return result;
	 }


	 /**
	  * 分页列表查询
	  * @param
	  * @param pageNo
	  * @param pageSize
	  * @param
	  * @return
	  */
	 @AutoLog(value = "加工材料信息表-分页列表查询")
	 @ApiOperation(value="加工材料信息表-分页列表查询", notes="加工材料信息表-分页列表查询")
	 @GetMapping(value = "/getAll")
	 public Result<IPage<GsMaterial>> getAll(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
												@RequestParam(name="pageSize", defaultValue="10") Integer pageSize) {
		 Result<IPage<GsMaterial>> result = new Result<IPage<GsMaterial>>();
		 Page<GsMaterial> page = new Page<GsMaterial>(pageNo, pageSize);
		 //设置排序规则
		 List<OrderItem> orders =new ArrayList<OrderItem>();
		 OrderItem ord= new OrderItem();
		 ord.setColumn("batchid");
		 ord.setAsc(false);
		 orders.add(ord);
		 page.setOrders(orders);

		 IPage<GsMaterial> pageList = gsMaterialService.page(page);
		 result.setSuccess(true);
		 result.setResult(pageList);
		 return result;
	 }



	
	/**
	  * 分页列表查询
	 * @param gsMaterial
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "加工材料信息表-分页列表查询")
	@ApiOperation(value="加工材料信息表-分页列表查询", notes="加工材料信息表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<GsMaterial>> queryPageList(GsMaterial gsMaterial,
									  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
									  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
									  HttpServletRequest req) {
		Result<IPage<GsMaterial>> result = new Result<IPage<GsMaterial>>();
		QueryWrapper<GsMaterial> queryWrapper = QueryGenerator.initQueryWrapper(gsMaterial, req.getParameterMap());
		Page<GsMaterial> page = new Page<GsMaterial>(pageNo, pageSize);
		IPage<GsMaterial> pageList = gsMaterialService.page(page, queryWrapper);
		result.setSuccess(true);
		result.setResult(pageList);
		return result;
	}
	
	/**
	  *   添加
	 * @param gsMaterial
	 * @return
	 */
	@AutoLog(value = "加工材料信息表-添加")
	@ApiOperation(value="加工材料信息表-添加", notes="加工材料信息表-添加")
	@PostMapping(value = "/add")
	public Result<GsMaterial> add(@RequestBody GsMaterial gsMaterial) {
		Result<GsMaterial> result = new Result<GsMaterial>();
		try {
			gsMaterialService.save(gsMaterial);
			result.success("添加成功！");
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			result.error500("操作失败");
		}
		return result;
	}
	
	/**
	  *  编辑
	 * @param gsMaterial
	 * @return
	 */
	@AutoLog(value = "加工材料信息表-编辑")
	@ApiOperation(value="加工材料信息表-编辑", notes="加工材料信息表-编辑")
	@PutMapping(value = "/edit")
	public Result<GsMaterial> edit(@RequestBody GsMaterial gsMaterial) {
		Result<GsMaterial> result = new Result<GsMaterial>();
		GsMaterial gsMaterialEntity = gsMaterialService.getById(gsMaterial.getBatchid());
		if(gsMaterialEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = gsMaterialService.updateById(gsMaterial);
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
	@AutoLog(value = "加工材料信息表-通过id删除")
	@ApiOperation(value="加工材料信息表-通过id删除", notes="加工材料信息表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		try {
			gsMaterialService.removeById(id);
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
	@AutoLog(value = "加工材料信息表-批量删除")
	@ApiOperation(value="加工材料信息表-批量删除", notes="加工材料信息表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<GsMaterial> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<GsMaterial> result = new Result<GsMaterial>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.gsMaterialService.removeByIds(Arrays.asList(ids.split(",")));
			result.success("删除成功!");
		}
		return result;
	}
	
	/**
	  * 通过id查询
	 * @param id
	 * @return
	 */
	@AutoLog(value = "加工材料信息表-通过id查询")
	@ApiOperation(value="加工材料信息表-通过id查询", notes="加工材料信息表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<GsMaterial> queryById(@RequestParam(name="id",required=true) String id) {
		Result<GsMaterial> result = new Result<GsMaterial>();
		GsMaterial gsMaterial = gsMaterialService.getById(id);
		if(gsMaterial==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(gsMaterial);
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
      QueryWrapper<GsMaterial> queryWrapper = null;
      try {
          String paramsStr = request.getParameter("paramsStr");
          if (oConvertUtils.isNotEmpty(paramsStr)) {
              String deString = URLDecoder.decode(paramsStr, "UTF-8");
              GsMaterial gsMaterial = JSON.parseObject(deString, GsMaterial.class);
              queryWrapper = QueryGenerator.initQueryWrapper(gsMaterial, request.getParameterMap());
          }
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
      }

      //Step.2 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      List<GsMaterial> pageList = gsMaterialService.list(queryWrapper);
      //导出文件名称
      mv.addObject(NormalExcelConstants.FILE_NAME, "加工材料信息表列表");
	  mv.addObject(NormalExcelConstants.CLASS, GsMaterial.class);

	  String exportBy = "";
	  // 获取登录用户信息
	  LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
	  if (sysUser != null) {
		  // 登录账号
		  exportBy = sysUser.getRealname();
	  }
	  mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("加工材料信息表列表数据", "导出人:"+exportBy, "导出信息"));
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
              List<GsMaterial> listGsMaterials = ExcelImportUtil.importExcel(file.getInputStream(), GsMaterial.class, params);
              gsMaterialService.saveBatch(listGsMaterials);
              return Result.ok("文件导入成功！数据行数:" + listGsMaterials.size());
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
