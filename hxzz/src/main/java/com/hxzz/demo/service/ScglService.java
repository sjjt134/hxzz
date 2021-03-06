package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.ScglShow;
import com.hxzz.demo.bean.View;
import com.hxzz.demo.entity.Quality;
import com.hxzz.demo.entity.Scgl;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hql
 * @since 2020-10-12
 */
public interface ScglService extends IService<Scgl> {
    List<Scgl> show();

    List<ScglShow> showClient();

    ScglShow showSum();

    List<Scgl> info(LocalDate date1, LocalDate date2);

    List<ScglShow> infoClient(LocalDate date1, LocalDate date2);
    List<Scgl> infoShift(String name,LocalDate date1, LocalDate date2);
    ScglShow infoSum(LocalDate date1, LocalDate date2);
    List<View> each(Integer date, String name);

    View eachYear(Integer date, String name);

    List<View> total(Integer date);

    View totalYear(Integer date);

    void add(String name, Integer targetCapacity, Float actualCapacity,  Float workingHours,
             Float beat,String shift, LocalDate date);

    void del(Integer id);

    void change(Integer id, String name, Integer targetCapacity, Float actualCapacity,  Float workingHours,
                Float beat, String shift,LocalDate date);

    PageInfo<Scgl> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);
    PageInfo<Scgl> findShiftAll(String name,Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);

}
