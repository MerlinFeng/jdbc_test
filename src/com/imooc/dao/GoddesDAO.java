package com.imooc.dao;

import com.imooc.db.DBUtil;
import com.imooc.model.Goddes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/5.
 */
public class GoddesDAO {

    public void addGod(Goddes goddes) throws Exception {
        Connection connection = DBUtil.getConnection();
//        Statement statement = connection.createStatement();
        String sql = "" +
                "insert into god" +
                "(user_name,sex,age,birthday,email,mobile," +
                "create_user,create_date,update_user,update_date,isdel)" +
                "values(" +
                "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, goddes.getUser_name());
        preparedStatement.setInt(2, goddes.getSex());
        preparedStatement.setInt(3, goddes.getAge());
        preparedStatement.setDate(4, new Date(goddes.getBirthday().getTime()));
        preparedStatement.setString(5, goddes.getEmail());
        preparedStatement.setString(6, goddes.getMobile());
        preparedStatement.setString(7, goddes.getCreate_user());
        preparedStatement.setString(8, goddes.getUpdate_user());
        preparedStatement.setInt(9, goddes.getIsdel());
        preparedStatement.execute();


    }
    public List<Goddes> query() throws Exception{
        List<Goddes> result=new ArrayList<Goddes>();
        Connection conn=DBUtil.getConnection();
        StringBuilder sb=new StringBuilder();
        sb.append("select id,user_name,age from god  ");

        PreparedStatement ptmt=conn.prepareStatement(sb.toString());

        ResultSet rs=ptmt.executeQuery();

        Goddes g=null;
        while(rs.next()){
            g=new Goddes();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            result.add(g);
        }
        return result;
    }


    public List<Goddes> query(List<Map<String, Object>> params) throws Exception {
        Connection connection = DBUtil.getConnection();
        ;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM god where 1=1 ");
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                Map<String, Object> map = params.get(i);
                sb.append(" and " + map.get("name") + " " + map.get("real") + " " + map.get("value"));
            }
        }
        PreparedStatement ptmt = connection.prepareStatement(sb.toString());
        ResultSet rs = ptmt.executeQuery();
        List<Goddes> gs = new ArrayList<Goddes>();

        while (rs.next()) {
            Goddes g = new Goddes();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));
            gs.add(g);

        }


        return gs;
    }

    public Goddes get(Integer id) throws SQLException {

        Connection conn = DBUtil.getConnection();
        String sql = "" +
                " select * from god " +
                " where id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ResultSet resultSet = ptmt.executeQuery();
        Goddes g = new Goddes();
        while (resultSet.next()) {
            g.setUser_name(resultSet.getString("user_name"));
            g.setAge(resultSet.getInt("age"));
            g.setBirthday(resultSet.getDate("birthday"));
            g.setUpdate_user(resultSet.getString("update_user"));
            g.setCreate_user(resultSet.getString("create_user"));
            g.setCreate_date(resultSet.getDate("create_date"));

        }
        return g;


    }






    public void updateGoddess(Goddes g) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "" +
                " update god " +
                " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, " +
                " update_user=?,update_date=current_date(),isdel=? " +
                " where id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, g.getUser_name());
        ptmt.setInt(2, g.getSex());
        ptmt.setInt(3, g.getAge());
        ptmt.setDate(4, new Date(g.getBirthday().getTime()));
        ptmt.setString(5, g.getEmail());
        ptmt.setString(6, g.getMobile());
        ptmt.setString(7, g.getUpdate_user());
        ptmt.setInt(8, g.getIsdel());
        ptmt.setInt(9, g.getId());
        ptmt.execute();
    }


    public void delGod(Integer id) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "" +
                " delete from god " +
                " where id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ptmt.execute();
    }


    public void delGoddess(Integer id) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "" +
                " delete from god " +
                " where id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ptmt.execute();
    }


}
