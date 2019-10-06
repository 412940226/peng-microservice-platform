package com.peng.service.impl;

import com.peng.dao.DeptDao;
import com.peng.entity.Dept;
import com.peng.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired private DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long deptId) {
        return deptDao.findById(deptId);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }
}
