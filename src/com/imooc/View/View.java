package com.imooc.View;

import com.imooc.Action.GoodesAction;
import com.imooc.model.Goddes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/5/7.
 */
public class View {

    private static final String CONTEXT = "欢迎来到用户禁区：\n" +
            "下面是用户禁区的功能列表：\n" +
            "[MAIN/M]:主菜单\n" +
            "[QUERY/Q]:查看全部用户的信息\n" +
            "[GET/G]:查看某位用户的详细信息\n" +
            "[ADD/A]:添加用户信息\n" +
            "[UPDATE/U]:更新用户信息\n" +
            "[DELETE/D]:删除用户信息\n" +
            "[SEARCH/S]:查询用户信息(根据姓名、手机号来查询)\n" +
            "[EXIT/E]:退出用户禁区\n" +
            "[BREAK/B]:退出当前功能，返回主菜单";

    private static final String OPERATION_MAIN = "MAIN";
    private static final String OPERATION_QUERY = "QUERY";
    private static final String OPERATION_GET = "GET";
    private static final String OPERATION_ADD = "ADD";
    private static final String OPERATION_UPDATE = "UPDATE";
    private static final String OPERATION_DELETE = "DELETE";
    private static final String OPERATION_SEARCH = "SEARCH";
    private static final String OPERATION_EXIT = "EXIT";
    private static final String OPERATION_BREAK = "BREAK";

    public static void main(String[] args) {
        System.out.println(CONTEXT);
        Scanner scan = new Scanner(System.in);
        Goddes goddes = new Goddes();
        GoodesAction goodesAction = new GoodesAction();

        String prenious = null;
        Integer step = 1;
        List<Map<String, Object>> params = new ArrayList<>();
        Map<String, Object> param = new HashMap<String, Object>();

        while (scan.hasNext()) {
            String in = scan.next().toString();
            if (OPERATION_EXIT.equals(in.toUpperCase())
                    || OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())) {
                System.out.println("您已成功退出");
                break;
            } else if (OPERATION_QUERY.equals(in.toUpperCase())
                    || OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())) {
                try {
                    List<Goddes> list = goodesAction.query();
                    for (Goddes go : list) {
                        System.out.println(go.getId() + "," + go.getUser_name());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else if (OPERATION_ADD.equals(in.toUpperCase())
                    || OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
                    || OPERATION_ADD.equals(prenious)) {
                //add
                prenious = OPERATION_ADD;
                if (1 == step) {
                    System.out.println("请输入女神 【姓名】 ");
                } else if (2 == step) {
                    goddes.setUser_name(in);
                    System.out.println("请输入女神 【年龄】 ");
                } else if (3 == step) {
                    goddes.setAge(Integer.valueOf(in));
                    System.out.println("请输入女神 【生日】，格式如 yyyy-MM-dd ");
                } else if (4 == step) {
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthday = null;
                    try {
                        birthday = sf.parse(in);
                        goddes.setBirthday(birthday);
                        System.out.println("请输入女神 【邮箱】 ");
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("您输入的格式有误 ，请重新输入");
                        step = 3;
                    }
                } else if (5 == step) {
                    goddes.setEmail(in);
                    System.out.println("请输入女神 【手机号】 ");

                } else if (6 == step) {
                    goddes.setMobile(in);
                    try {
                        goodesAction.add(goddes);
                        System.out.println("新增女神成功");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("新增女神失败");
                    }
                }
                if (OPERATION_ADD.equals(prenious)) {
                    step++;
                }


                System.out.println("输入值为 :" + in);

            }/*---------------------------模糊查询功能--------------------------------*/
            else if (OPERATION_SEARCH.equals(in.toUpperCase()) || OPERATION_SEARCH.substring(0, 1).equals(in.toUpperCase()) || OPERATION_SEARCH.equals(prenious)) {
                prenious = OPERATION_SEARCH;
                System.out.println("查询用户信息（根据姓名，手机号来查询）");
                if (1 == step) {
                    System.out.println("输入用户姓名：");
                } else if (2 == step) {
                    param.put("name", "user_name");
                    param.put("rela", "=");
                    param.put("value", in);
                    params.add(param);
                    System.out.println("输入用户手机");
                } else if (3 == step) {
                    param.put("name", "mobile");
                    param.put("rela", "=");
                    param.put("value", in);
                    params.add(param);
                    List<Goddes> result;
                    try {
                        result = goodesAction.query(params);
                        for (int i = 0; i < result.size(); i++) {
                            System.out.println(result.get(i).toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (OPERATION_SEARCH.equals(prenious)) {
                    step++;
                }
            } /*----------------------------详细查询功能--------------------------*/
            else if (OPERATION_GET.equals(in.toUpperCase()) || OPERATION_GET.substring(0, 1).equals(in.toUpperCase()) || OPERATION_GET.equals(prenious)) {
                prenious = OPERATION_GET;
                if (1 == step) {
                    System.out.println("请输入用户编号：");
                } else if (2 == step) {
                    try {
                        Integer id = new Integer(in);
                        Goddes gs = goodesAction.get(id);
                        System.out.println(gs.toString());
                        System.out.println("查询完成！");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (OPERATION_GET.equals(prenious)) {
                    step++;
                }
            } /*---------------------------显示主菜单功能-------------------------------------*/
            else if (OPERATION_MAIN.equals(in.toUpperCase()) || OPERATION_MAIN.substring(0, 1).equals(in.toUpperCase())) {
                System.out.println("显示主菜单");
                System.out.println(CONTEXT);
            } else {
                System.out.println("您输入的值是：" + scan.next().toString());
            }

        }
    }
}
