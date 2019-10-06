package com.peng.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;



//注意的是，同时使用@Data 和 @AllArgsConstructor 后 ，默认的无参构造函数失效，如果需要它，要重新设置 @NoArgsConstructor
@NoArgsConstructor
//@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long deptId; // 主键
    private String deptName; // 部门名称
    private String deptSource;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(String deptName) {
        this.deptName = deptName;
    }
}
