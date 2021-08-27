package com.neuq;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neuq.mapper.UserMapper;
import com.neuq.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

//简单的说就是将查询条件封装到一个Wrapper对象中，然后在作为参数传入查询语句
@SpringBootTest//条件构造器测试类
public class WrapperTest {
    @Autowired //自动注入
    private UserMapper userMapper;
    @Test
    public void contextLoads(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void WrapperTest1(){
        //查询name不为空的用户，并且邮箱不为空，年龄大于12
        QueryWrapper<User> Wrapper = new QueryWrapper<>();
        Wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age",20);
        List<User> users = userMapper.selectList(Wrapper);
        users.forEach(System.out::println);
    }
    @Test
    public void WrapperTest2(){
        //查询名字等于ubutun
        QueryWrapper<User> Wrapper = new QueryWrapper<>();
        Wrapper.eq("name","ubutun");
        User user = userMapper.selectOne(Wrapper);
        System.out.println(user);
    }
    @Test
    public void WrapperTest3(){
        //查询年龄在20-30之间的用户
        QueryWrapper<User> Wrapper = new QueryWrapper<>();
        Wrapper.between("age",20,30);
        //查询满足条件的记录数
        Integer integer = userMapper.selectCount(Wrapper);
        System.out.println(integer);
    }
    @Test
    public void WrapperTest4(){
        //模糊查询
        QueryWrapper<User> Wrapper = new QueryWrapper<>();
        Wrapper.notLike("name","e")//名字中不包含e，%e%
               .likeRight("email","t");//邮箱like “t%”:邮箱以t打头
        List<Map<String, Object>> maps = userMapper.selectMaps(Wrapper);
        maps.forEach(System.out::println);
    }
    @Test
    public void WrapperTest5(){
        //通过id进行降序排序
        QueryWrapper<User> Wrapper = new QueryWrapper<>();
        Wrapper.orderByDesc("id");
        List<User> users = userMapper.selectList(Wrapper);
        users.forEach(System.out::println);
    }
    @Test
    public void WrapperTest6(){
        //嵌套查询
        QueryWrapper<User> Wrapper = new QueryWrapper<>();
        Wrapper.inSql("id","select id from user where id<3");
        List<User> users = userMapper.selectList(Wrapper);
        users.forEach(System.out::println);
    }
}
