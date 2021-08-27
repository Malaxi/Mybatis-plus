package com.neuq;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuq.mapper.UserMapper;
import com.neuq.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired //自动注入
    private UserMapper userMapper;
    @Test//测试查询
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test//测试插入
    public void testInsert(){
        User user=new User();
        user.setId(6L);
        user.setName("peter");
        user.setAge(26);
        user.setEmail("513341071@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("受影响的行数为："+ insert);
    }
    @Test//测试更新
    public void testupdate(){
        User user=new User();
        user.setId(6L);
        user.setEmail("test6@baomidou.com");
        int i = userMapper.updateById(user);
        System.out.println("受影响的行数为："+ i);
    }
    @Test//测试乐观锁成功
    public void testOptimisticLocker1(){
        //1.查询用户信息
        User user=userMapper.selectById(1L);
        //2.修改用户信息
        user.setName("linux");
        //3.执行更新操作
        userMapper.updateById(user);
    }
    @Test//测试乐观锁失败
    public void testOptimisticLocker2(){
        //线程1
        User user1=userMapper.selectById(1L);
        user1.setName("linux");

        //模拟另外一个线程执行插队操作
        User user2=userMapper.selectById(1L);
        user2.setName("ubutun");
        userMapper.updateById(user2);

        userMapper.updateById(user1);//如果没有乐观锁就会覆盖插队线程的值
    }
    @Test//测试Id查询
    public void testSelectById(){
        User user = userMapper.selectById(5L);
        System.out.println(user);
    }
    @Test//测试Id批量查询
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L));
        users.forEach(System.out::println);
    }
    @Test//测试条件查询
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","ubutun");//查询name=ubutun的记录
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    @Test//测试分页插件
    public void testPage(){
        //参数一：当前页；参数二：页面大小
        //selectPage将读取到的数据封装到Page对象中
        Page<User> Page = new Page<>(2, 5);
        userMapper.selectPage(Page,null);
        Page.getRecords().forEach(System.out::println);
    }
    @Test//测试Id删除
    public void testDeleteById(){
        userMapper.deleteById(1L);
    }
    @Test//测试Id批量删除
    public void testDeleteBatchIds(){
        userMapper.deleteBatchIds(Arrays.asList(1L,2L));
    }
    @Test//测试条件删除
    public void testDeleteByMap(){
        HashMap<String, Object> Map = new HashMap<>();
        Map.put("name","ubutun");
        Map.put("age","18");
        userMapper.deleteByMap(Map);
    }
}
