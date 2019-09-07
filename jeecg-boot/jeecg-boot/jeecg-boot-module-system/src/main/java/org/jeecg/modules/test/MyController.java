package org.jeecg.modules.test;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Guess
 */
@RestController
@RequestMapping("/my/testDemo")
@Slf4j
public class MyController {

   /* @Autowired
    private IProvincesService provincesService;

    *//**
     * hello world
     * @param
     * @return
     *//*
    *//**
     * 全查询
     * @return
     *//*
    @AutoLog(value = "SQLServer  数据源信息-分页列表查询")
    @ApiOperation(value="SQLServer  数据源信息-分页列表查询", notes="SQLServer  数据源信息-分页列表查询")
    @GetMapping(value = "/getAll")
    public Result<Provinces> getAll(Provinces provinces) {
        Result<Provinces> result = new Result<Provinces>();
        Provinces pageList = provincesService.getById(provinces.getId());
        result.setSuccess(true);
        result.setResult(pageList);
        return result;
    }*/

}
