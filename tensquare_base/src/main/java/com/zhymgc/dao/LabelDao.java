package com.zhymgc.dao;

import com.zhymgc.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2020-3-15.
 */
public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label>{
}
