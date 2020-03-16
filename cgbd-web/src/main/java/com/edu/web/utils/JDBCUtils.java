package com.edu.web.utils;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class JDBCUtils {


    protected Connection con = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;


    public void SetConnection(String className, String url, String username, String password) {

        try {
            Class.forName(className);
            con = DriverManager.getConnection
                    (url, username, password);

        } catch (Exception e) {
            log.error("", e);
        }

    }

    public void CloseAll() {

        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            log.error("", e);
        }
    }

}
