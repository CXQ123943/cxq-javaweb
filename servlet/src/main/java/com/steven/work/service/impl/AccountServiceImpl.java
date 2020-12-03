package com.steven.work.service.impl;

import com.steven.work.dao.AccountDao;
import com.steven.work.dao.impl.AccountDaoImpl;
import com.steven.work.service.AccountService;

import java.util.List;
import java.util.Map;

/**
 * @author CXQ
 * @version 1.0
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public boolean login(String username, String password) {
        if (isNull(username) || password == null) {
            return false;
        }
        Map<String, Object> userFromMysql = accountDao.queryForMap(username);
            if (userFromMysql != null && !userFromMysql.isEmpty()) {
                return userFromMysql.get("password").equals(password);
            }
        return false;
    }

    /**
     * 判断是否为空
     *
     * @param strings 前端返回的String类型的数组
     * @return 为空放回true，反之为false
     */
    private boolean isNull(String... strings) {
        for (String str : strings) {
            if (str == null || "".equals(str)) {
                return true;
            }
        }
        return false;
    }
}
