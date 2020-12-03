package com.steven.work.service;

/**
 * @author StevenChen
 * @version 1.0
 */
public interface AccountService {

    /**
     * 登录业务，检查登录是否成功
     *
     * @param username 前端传回来的账号
     * @param password 前端传回来的密码
     * @return 如果登录成功，返回true，反之false
     */
    boolean login(String username, String password);
}
