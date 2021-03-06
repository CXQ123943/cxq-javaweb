package com.steven.jdbc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author CXQ
 * @version 1.0
 */
public class JdbcTemplateTest {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Test
    public void execute() {
        String sql = "CREATE TABLE `JDBC` (" +
                "`ID` INT AUTO_INCREMENT PRIMARY KEY ," +
                "`NAME` VARCHAR(50) NOT NULL) " +
                "ENGINE = INNODB DEFAULT CHARSET UTF8MB4";
        jdbcTemplate.execute(sql);
    }

    @Test
    public void insert() {
        String sql = "INSERT INTO `ACCOUNT` (`USERNAME`,`PASSWORD`) VALUE (?,?)";
        System.out.println(jdbcTemplate.update(sql,"dajiao", "0000"));
    }

    @Test
    public void update() {
        String sql = "UPDATE `JDBC` SET `NAME` = ? WHERE `ID` = ?";
        System.out.println(jdbcTemplate.update(sql, "aiyowei", 1));
    }

    @Test
    public void delete() {
        String sql = "DELETE FROM `JDBC` WHERE `ID` = ?";
        System.out.println(jdbcTemplate.update(sql,  1));
    }

    @Test
    public void batchInsertWithSameSql() {
        String sql = "INSERT INTO `JDBC` (`NAME`) VALUES (?)";
        Object[] param01 = {"zhaosi"};
        Object[] param02 = {"liuneng"};
        Object[] param03 = {"guangkun"};
        int[] result = jdbcTemplate.batchUpdate(sql, param01, param02, param03);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void batchUpdateWithSameSql() {
        String sql = "UPDATE `JDBC` SET `NAME` = ? WHERE `ID` = ?";
        Object[] param01 = {"aiyiweo",6};
        Object[] param02 = {"nimeifu",7};
        Object[] param03 = {"memeda",8};
        int[] result = jdbcTemplate.batchUpdate(sql,param01,param02,param03);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void batchDeleteWithSameSql() {
        String sql = "DELETE FROM `JDBC` WHERE `ID` = ?";
        Object[] param01 = {3};
        Object[] param02 = {4};
        Object[] param03 = {5};
        int[] result = jdbcTemplate.batchUpdate(sql, param01, param02, param03);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void batchUpdateWithDifferentSql() {
        String insertSql = "INSERT INTO `JDBC` (`NAME`) VALUES ('FEIJI')";
        String updateSql = "UPDATE `JDBC` SET `NAME` = 'DAPAO' WHERE `NAME` = 'FEIJI'";
        String[] sqls = {insertSql, updateSql};
        int[] result = jdbcTemplate.batchUpdate(sqls);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void queryForList() {
        String sql = "SELECT * FROM ACCOUNT";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    public void queryForMap() {
        String sql = "SELECT * FROM EMP WHERE EMPNO = ?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, "7654");
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    public void queryForInt() {
        String sql = "SELECT COUNT(`ID`) FROM JDBC WHERE ID > ?";
        System.out.println(jdbcTemplate.queryForInt(sql,3));
    }
}
