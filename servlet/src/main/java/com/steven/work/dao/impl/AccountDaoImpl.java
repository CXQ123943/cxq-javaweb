package com.steven.work.dao.impl;

import com.steven.jdbc.JdbcTemplate;
import com.steven.work.dao.AccountDao;

import java.util.List;
import java.util.Map;

/**
 * @author CXQ
 * @version 1.0
 */
public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public List<Map<String, Object>> queryForList() {
        String sql = "SELECT ID, USERNAME, PASSWORD FROM ACCOUNT";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public Map<String, Object> queryForMap(String username) {
        String sql = "SELECT ID, USERNAME, PASSWORD FROM ACCOUNT WHERE USERNAME = ?";
        return jdbcTemplate.queryForMap(sql, username);
    }
}
