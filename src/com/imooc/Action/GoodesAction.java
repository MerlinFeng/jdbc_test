package com.imooc.Action;

import com.imooc.dao.GoddesDAO;
import com.imooc.model.Goddes;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/5.
 */
public class GoodesAction {


    public static void sop(Object obj){
        System.out.println(obj);
    }


    public void add(Goddes goddes) throws Exception{
        GoddesDAO dao = new GoddesDAO();
        dao.addGod(goddes);
    }

    public void edit(Goddes goddes) throws Exception{
        GoddesDAO dao = new GoddesDAO();
        dao.updateGoddess(goddes);

    }

    public List<Goddes> query() throws Exception{
        GoddesDAO dao = new GoddesDAO();
        return dao.query();
    }

    public List<Goddes> query(List<Map<String, Object>> params) throws Exception{
        GoddesDAO dao = new GoddesDAO();
        return dao.query(params);
    }

    public Goddes get(Integer id) throws Exception{
        GoddesDAO dao = new GoddesDAO();
        return  dao.get(id);
    }


    public void del(Integer id) throws Exception{
        GoddesDAO dao = new GoddesDAO();
        dao.delGod(id);
    }


}
