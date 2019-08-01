package com.atguigu.gulimall.oms.controller;

import java.util.Arrays;
import java.util.Map;


import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.QueryCondition;
import com.atguigu.gulimall.commons.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gulimall.oms.entity.WmsShAreaEntity;
import com.atguigu.gulimall.oms.service.WmsShAreaService;




/**
 * 全国省市区信息
 *
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2019-08-01 20:16:55
 */
@Api(tags = "全国省市区信息 管理")
@RestController
@RequestMapping("oms/wmssharea")
public class WmsShAreaController {
    @Autowired
    private WmsShAreaService wmsShAreaService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('oms:wmssharea:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = wmsShAreaService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('oms:wmssharea:info')")
    public Resp<WmsShAreaEntity> info(@PathVariable("id") Integer id){
		WmsShAreaEntity wmsShArea = wmsShAreaService.getById(id);

        return Resp.ok(wmsShArea);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('oms:wmssharea:save')")
    public Resp<Object> save(@RequestBody WmsShAreaEntity wmsShArea){
		wmsShAreaService.save(wmsShArea);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('oms:wmssharea:update')")
    public Resp<Object> update(@RequestBody WmsShAreaEntity wmsShArea){
		wmsShAreaService.updateById(wmsShArea);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('oms:wmssharea:delete')")
    public Resp<Object> delete(@RequestBody Integer[] ids){
		wmsShAreaService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
