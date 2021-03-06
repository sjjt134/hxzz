package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.View;
import com.hxzz.demo.entity.Quality;
import com.hxzz.demo.entity.Quality;
import com.hxzz.demo.entity.Quality3;
import com.hxzz.demo.mapper.QualityMapper;
import com.hxzz.demo.service.QualityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hql
 * @since 2020-09-24
 */
@Service
public class QualityServiceImpl extends ServiceImpl<QualityMapper, Quality> implements QualityService {
    @Autowired
    QualityMapper qualityMapper;

    @Override
    public List<Quality> show() {
        return qualityMapper.show();
    }

    public List<Quality> showClient() {
        return qualityMapper.showClient();
    }

    public Quality showSum() {
        return qualityMapper.showSum();
    }

    public List<Quality> info(LocalDate date1, LocalDate date2) {
        return qualityMapper.info(date1, date2);
    }

    public List<Quality> infoClient(LocalDate date1, LocalDate date2) {
        return qualityMapper.infoClient(date1, date2);
    }

    public Quality infoSum(LocalDate date1, LocalDate date2) {
        return qualityMapper.infoSum(date1, date2);
    }
    public   List<View> each(Integer date, String name){
        return qualityMapper.each(date,name);
    }

    public View eachYear(Integer date, String name){return
            qualityMapper.eachYear(date,name);}

    public List<View> total(Integer date){return
            qualityMapper.total(date);}

    public View totalYear(Integer date){return qualityMapper.totalYear(date);}
    public void add(String name, Float offLine, Float acoffLine, Float dLine, Float acdLine, Float lingYu, Float aclingYu,
                    Float careLine, Float accareLine, Float roadTest, Float acroadTest,String shift,
                    LocalDate date) {
        qualityMapper.add(name, offLine, acoffLine, dLine, acdLine, lingYu, aclingYu, careLine, accareLine, roadTest,
                acroadTest,shift, date);
    }

    public void change(Integer id, String name, Float offLine, Float acoffLine, Float dLine, Float acdLine, Float lingYu,
                       Float aclingYu,
                       Float careLine, Float accareLine, Float roadTest, Float acroadTest,String shift,
                       LocalDate date) {
        qualityMapper.change(id, name, offLine, acoffLine, dLine, acdLine, lingYu, aclingYu, careLine, accareLine,
                roadTest, acroadTest,shift, date);
    }


    public List<Quality> month() {
        return qualityMapper.month();
    }

    public void del(Integer id) {
        qualityMapper.del(id);
    }

    public PageInfo<Quality> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2) {
        PageHelper.startPage(pageNum, pageSize);
        List<Quality> list = qualityMapper.info(date1, date2);
        PageInfo<Quality> pageInfo = new PageInfo<Quality>(list);
        return pageInfo;
    }

}
