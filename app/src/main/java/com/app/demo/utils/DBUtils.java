//package com.app.demo.utils;
//
//
//import android.content.Context;
//import android.util.Log;
//
//
//import com.alibaba.fastjson.JSON;
//import com.app.beans.UserBean;
//import com.app.demo.MyApplication;
//import com.app.demo.dbBean.PointBean;
//import com.app.utils.TimeUtil;
//import com.app.utils.ToastUtil;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 数据库工具类：连接数据库用、获取数据库数据用
// * 相关操作数据库的方法均可写在该类
// */
//public class DBUtils {
//
//    private static String driver = "com.mysql.jdbc.Driver";// MySql驱动
//
//    private static String user = "root";// 用户名
//    private static String password = "";// 密码
//    private static String sjk = "22042501";// 数据库名称
//    private static String ip = "192.168.0.107";//ip 地址
//
//    public final static String tag = "--------------";
//
//    //连接数据库的函数
//    private static Connection getConn(String dbName) {
//
//        Connection connection = null;
//        try {
//            Class.forName(driver);// 动态加载类
//            // 尝试建立到给定数据库URL的连接，连接格式：驱动名称+ip地址+端口号+数据库名称+用户名+密码
//            connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbName, user, password);
//            Log.e("-------------", "连接成功");
//        } catch (Exception e) {
////            ToastUtil.showToast(MyApplication.getInstance(), "数据库链接失败");
//            Log.e("-------------", "连接失败");
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    public static List<UserBean> getUserList() {
//
//        List<UserBean> list = new ArrayList<>();
//        // 根据数据库名称，建立连接
//        Connection connection = getConn(sjk);
//
//        try {
//            // mysql简单的查询语句。这里是根据MD_CHARGER表的NAME字段来查询某条记录
//            String sql = "select * from UserBean";
//            if (connection != null) {// connection不为null表示与数据库建立了连接
//                PreparedStatement ps = connection.prepareStatement(sql);
//                if (ps != null) {
//                    // 设置上面的sql语句中的？的值为name
//                    // ps.setString(1, name);
//                    // 执行sql查询语句并返回结果集
//                    ResultSet rs = ps.executeQuery();
//                    if (rs != null) {
//                        int count = rs.getMetaData().getColumnCount();
//                        Log.e("DBUtils", "-------count：" + count);
//                        while (rs.next()) {
//                            // 注意：下标是从1开始的
//                            Map<String, Object> map = new HashMap<>();
//                            for (int i = 1; i <= count; i++) {
//                                String field = rs.getMetaData().getColumnName(i);
//                                map.put(field, rs.getString(field));
//                            }
//                            UserBean userBean = JSON.parseObject(JSON.toJSONString(map), UserBean.class);
//                            list.add(userBean);
//                            Log.e("DBUtils", "-------user：" + userBean.toString());
//                        }
//                        connection.close();
//                        ps.close();
//                        return list;
//                    } else {
//                        return null;
//                    }
//                } else {
//                    return null;
//                }
//            } else {
//                return null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e("DBUtils", "异常：" + e.getMessage());
//            return null;
//        }
//
//    }
//
//
//    public static void insertUser(Context context, String user_id, String name, String password) {
//
//        // 根据数据库名称，建立连接
//        Connection connection = getConn(sjk);
//        try {
//            String time = System.currentTimeMillis() + "";
//            String id = time.substring(time.length() - 5, time.length() - 1);
//            String sql = "INSERT INTO UserBean (id,user_id, name,password) VALUES ('" + id + "','" + user_id + "','" + name + "','" + password + "')";
//            if (connection != null) {// connection不为null表示与数据库建立了连接
//                PreparedStatement ps = connection.prepareStatement(sql);
//                ps.executeUpdate();
//                if (ps != null) {
//                    ToastUtil.showToast(context, "添加成功");
//                    Log.e("-------------", "insert success");
//                } else {
//                    ToastUtil.showToast(context, "添加失败");
//                    Log.e("-------------", "insert faile");
//                }
//            } else {
//                ToastUtil.showToast(context, "数据库链接失败");
//                Log.e("-------------", "连接失败");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e("DBUtils", "异常：" + e.getMessage());
//        } catch (ExceptionInInitializerError e) {
//            e.printStackTrace();
//            Log.e("DBUtils2", "异常：" + e.getMessage());
//        }
//    }
//
//
//    public static void updateUser(String id, String name, String pwd) {
//        // 根据数据库名称，建立连接
//        Connection connection = getConn(sjk);
//        try {
//            String sql = "UPDATE UserBean SET name = '" + name + "',password = '" + pwd + "' WHERE user_id = '" + id + "'  ";
//            if (connection != null) {// connection不为null表示与数据库建立了连接
//                PreparedStatement ps = connection.prepareStatement(sql);
//                ps.executeUpdate();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(tag, "异常：" + e.getMessage());
//        }
//    }
//
//    public static void updatePhoto(String photo, String user_id) {
//        // 根据数据库名称，建立连接
//        Connection connection = getConn(sjk);
//        try {
//            String sql = "UPDATE UserBean SET photo = '" + photo + "' WHERE user_id = '" + user_id + "'  ";
//            if (connection != null) {// connection不为null表示与数据库建立了连接
//                PreparedStatement ps = connection.prepareStatement(sql);
//                ps.executeUpdate();
//                ToastUtil.showToast(MyApplication.getInstance(), "修改成功");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(tag, "异常：" + e.getMessage());
//        }
//    }
//
//
//    public static void delUser(String id) {
//        // 根据数据库名称，建立连接
//        Connection connection = getConn(sjk);
//        try {
//            String sql = "delete from UserBean where user_id = '" + id + "'  ";
//            if (connection != null) {// connection不为null表示与数据库建立了连接
//                PreparedStatement ps = connection.prepareStatement(sql);
//                ps.executeUpdate();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(tag, "异常：" + e.getMessage());
//        }
//    }
//
//
//
//    public static void updatePwd(String pwd, String user_id) {
//        // 根据数据库名称，建立连接
//        Connection connection = getConn(sjk);
//        try {
//            String sql = "UPDATE UserBean SET password = '" + pwd + "' WHERE user_id = '" + user_id + "'  ";
//            if (connection != null) {// connection不为null表示与数据库建立了连接
//                PreparedStatement ps = connection.prepareStatement(sql);
//                ps.executeUpdate();
//                ToastUtil.showToast(MyApplication.getInstance(), "修改成功");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(tag, "异常：" + e.getMessage());
//        }
//    }
//
//
//    public static void updateName(String name, String user_id) {
//        // 根据数据库名称，建立连接
//        Connection connection = getConn(sjk);
//        try {
//            String sql = "UPDATE UserBean SET name = '" + name + "' WHERE user_id = '" + user_id + "'  ";
//            if (connection != null) {// connection不为null表示与数据库建立了连接
//                PreparedStatement ps = connection.prepareStatement(sql);
//                ps.executeUpdate();
//                ToastUtil.showToast(MyApplication.getInstance(), "修改成功");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(tag, "异常：" + e.getMessage());
//        }
//    }
//
//
//    public static List<PointBean> getPointList() {
//
//        List<PointBean> list = new ArrayList<>();
//        // 根据数据库名称，建立连接
//        Connection connection = getConn(sjk);
//
//        try {
//            // mysql简单的查询语句。这里是根据MD_CHARGER表的NAME字段来查询某条记录
//            String sql = "select * from PointBean";
//            if (connection != null) {// connection不为null表示与数据库建立了连接
//                PreparedStatement ps = connection.prepareStatement(sql);
//                if (ps != null) {
//                    // 设置上面的sql语句中的？的值为name
//                    // ps.setString(1, name);
//                    // 执行sql查询语句并返回结果集
//                    ResultSet rs = ps.executeQuery();
//                    if (rs != null) {
//                        int count = rs.getMetaData().getColumnCount();
//                        Log.e("DBUtils", "-------count：" + count);
//                        while (rs.next()) {
//                            // 注意：下标是从1开始的
//                            Map<String, Object> map = new HashMap<>();
//                            for (int i = 1; i <= count; i++) {
//                                String field = rs.getMetaData().getColumnName(i);
//                                map.put(field, rs.getString(field));
//                            }
//                            PointBean userBean = JSON.parseObject(JSON.toJSONString(map), PointBean.class);
//                            list.add(userBean);
//                            Log.e("DBUtils", "-------user：" + userBean.toString());
//                        }
//                        connection.close();
//                        ps.close();
//                        return list;
//                    } else {
//                        return null;
//                    }
//                } else {
//                    return null;
//                }
//            } else {
//                return null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e("DBUtils", "异常：" + e.getMessage());
//            return null;
//        }
//
//    }
//
//
//    public static void insertPoint(Context context, String name, double lat, double lon) {
//
//        // 根据数据库名称，建立连接
//        Connection connection = getConn(sjk);
//        try {
//            String time = TimeUtil.getTodayData("yyyy-MM-dd HH:mm:ss");
//            String user_id = UserManager.getUserId(context);
//            String user_name = UserManager.getUserName(context);
//            String t = System.currentTimeMillis() + "";
//            String id = t.substring(t.length() - 5, t.length() - 1);
//            String sql = "INSERT INTO PointBean (id,name,lat,lon) VALUES ('" + id + "','" + name + "','" + lat + "','" + lon + "')";
//            if (connection != null) {// connection不为null表示与数据库建立了连接
//                PreparedStatement ps = connection.prepareStatement(sql);
//                ps.executeUpdate();
//                if (ps != null) {
//                    ToastUtil.showToast(context, "添加成功");
//                    Log.e("-------------", "insert success");
//                } else {
//                    ToastUtil.showToast(context, "添加失败");
//                    Log.e("-------------", "insert faile");
//                }
//            } else {
//                ToastUtil.showToast(context, "数据库链接失败");
//                Log.e("-------------", "连接失败");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e("DBUtils", "异常：" + e.getMessage());
//        } catch (ExceptionInInitializerError e) {
//            e.printStackTrace();
//            Log.e("DBUtils2", "异常：" + e.getMessage());
//        }
//    }
//
//    public static void delPoint(String id) {
//        // 根据数据库名称，建立连接
//        Connection connection = getConn(sjk);
//        try {
//            String sql = "delete from PointBean where id = '" + id + "'  ";
//            if (connection != null) {// connection不为null表示与数据库建立了连接
//                PreparedStatement ps = connection.prepareStatement(sql);
//                ps.executeUpdate();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(tag, "异常：" + e.getMessage());
//        }
//    }
//
//
//    public static void updatePoint(String id, double lat, double lon) {
//        // 根据数据库名称，建立连接
//        Connection connection = getConn(sjk);
//        try {
//            String sql = "UPDATE PointBean SET lat = '" + lat + "',lon = '" + lon + "' WHERE id = '" + id + "'  ";
//            if (connection != null) {// connection不为null表示与数据库建立了连接
//                PreparedStatement ps = connection.prepareStatement(sql);
//                ps.executeUpdate();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(tag, "异常：" + e.getMessage());
//        }
//    }
//
//}
//
//
