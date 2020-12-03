package com.steven.dao;

import com.steven.work.dao.AccountDao;
import com.steven.work.dao.impl.AccountDaoImpl;
import org.junit.Test;

/**
 * @author CXQ
 * @version 1.0
 */
public class AccountDaoTest {

    @Test
    public void queryForList(){
        AccountDao loginDao = new AccountDaoImpl();
        System.out.println(loginDao.queryForList());
    }

    @Test
    public void queryForMap(){
        AccountDao loginDao = new AccountDaoImpl();
        System.out.println(loginDao.queryForMap("liuneng"));
    }
}
