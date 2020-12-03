package com.steven.work.dao;

import java.util.List;
import java.util.Map;

/**
 * @author CXQ
 * @version 1.0
 */
public interface AccountDao {
    /**
     * 查询全部的账号信息
     *
     * @return 返回全部的账号信息
     */
    List<Map<String, Object>> queryForList();

    /**
     * 查询对应ID的账号信息
     *
     * @return 返回对应ID的账号信息
     */
    Map<String, Object> queryForMap (String username);
}
