package com.peng.service;

import com.peng.entity.Dept;

import java.util.List;

public interface DeptService {
    boolean add(Dept dept);

    Dept get(Long deptId);

    List<Dept> list();
}
