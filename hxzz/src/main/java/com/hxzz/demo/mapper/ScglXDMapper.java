package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.ScglDC;
import com.hxzz.demo.entity.ScglSelect;
import com.hxzz.demo.entity.ScglXD;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hql
 * @since 2020-09-14
 */@Component
public interface ScglXDMapper extends BaseMapper<ScglXD> {
    ScglSelect show();
    void add(Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,Float beat);
    List<ScglXD> getData(LocalDate date1, LocalDate date2);
    void del(LocalDate date);
    void change(Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,Float beat, LocalDate date);

}
