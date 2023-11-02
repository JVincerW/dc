package com.vincer.gen.service;

import com.vincer.gen.domain.GenTableColumn;

import java.util.List;

/**
 * 业务字段 服务层
 *
 * @author vincer
 */
public interface IGenTableColumnService {
    /**
     * 查询业务字段列表
     *
     * @param tableId 业务字段编号
     * @return 业务字段集合
     */
    List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId);


}
