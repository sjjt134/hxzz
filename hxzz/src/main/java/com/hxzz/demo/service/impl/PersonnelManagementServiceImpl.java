package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.PersonnelManagementClient;
import com.hxzz.demo.bean.View;
import com.hxzz.demo.entity.PersonnelManagement;
import com.hxzz.demo.entity.PersonnelManagement;
import com.hxzz.demo.entity.PersonnelManagement;
import com.hxzz.demo.mapper.PersonnelManagementMapper;
import com.hxzz.demo.service.PersonnelManagementService;
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
 * @since 2020-09-16
 */
@Service
public class PersonnelManagementServiceImpl extends ServiceImpl<PersonnelManagementMapper, PersonnelManagement> implements PersonnelManagementService {
    @Autowired
    PersonnelManagementMapper personnelManagementMapper;

    public List<PersonnelManagement> show() {
        return personnelManagementMapper.show();
    }

    public List<PersonnelManagement> showClient() {
        return personnelManagementMapper.showClient();
    }

    public List<PersonnelManagement> info(LocalDate date1, LocalDate date2) {
        return personnelManagementMapper.info(date1, date2);
    }

    public List<PersonnelManagement> infoClient(LocalDate date1, LocalDate date2) {
        return personnelManagementMapper.infoClient(date1, date2);
    }

    public PersonnelManagement showSum() {
        return personnelManagementMapper.showSum();
    }

    public PersonnelManagement infoSum(LocalDate date1, LocalDate date2) {
        return personnelManagementMapper.infoSum(date1, date2);
    }
    public   List<View> each(Integer date, String name){
        return personnelManagementMapper.each(date,name);
    }

    public View eachYear(Integer date, String name){return
            personnelManagementMapper.eachYear(date,name);}

    public List<View> total(Integer date){return
            personnelManagementMapper.total(date);}

    public View totalYear(Integer date){return personnelManagementMapper.totalYear(date);}
    public void add(String name, Integer establishment, Integer actualNumber, Integer availableNumber,
                      Integer shouldArrive, Float actualArrive,String shift, LocalDate date) {
        personnelManagementMapper.add(name, establishment, actualNumber, availableNumber,
                shouldArrive, actualArrive,shift, date);
    }

    public void del(Integer id) {
        personnelManagementMapper.del(id);
    }

    ;

    public void change(Integer id, String name, Integer establishment, Integer actualNumber, Integer availableNumber,

                         Integer shouldArrive, Float actualArrive,String shift, LocalDate date) {
        personnelManagementMapper.change(id, name, establishment, actualNumber, availableNumber,
                shouldArrive, actualArrive,shift, date);
    }

    public PageInfo<PersonnelManagement> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2) {
        PageHelper.startPage(pageNum, pageSize);
        List<PersonnelManagement> list = personnelManagementMapper.info(date1, date2);
        PageInfo<PersonnelManagement> pageInfo = new PageInfo<PersonnelManagement>(list);
        return pageInfo;
    }
}
