package com.atguigu.gulimall.oms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.Query;
import com.atguigu.gulimall.commons.bean.QueryCondition;

import com.atguigu.gulimall.oms.dao.WmsShAreaDao;
import com.atguigu.gulimall.oms.entity.WmsShAreaEntity;
import com.atguigu.gulimall.oms.service.WmsShAreaService;


@Service("wmsShAreaService")
public class WmsShAreaServiceImpl extends ServiceImpl<WmsShAreaDao, WmsShAreaEntity> implements WmsShAreaService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<WmsShAreaEntity> page = this.page(
                new Query<WmsShAreaEntity>().getPage(params),
                new QueryWrapper<WmsShAreaEntity>()
        );

        return new PageVo(page);
    }

}