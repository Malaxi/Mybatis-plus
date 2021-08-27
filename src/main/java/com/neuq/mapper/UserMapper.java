package com.neuq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neuq.entity.User;
import org.springframework.stereotype.Repository;

//使实体类所对应的Mapper继承基本的类BaseMapper
//将userMapper注入容器
@Repository
public interface UserMapper extends BaseMapper<User>{
    //至此User所有的CRUD编写完成
    //不需要像以前一样配置一大堆文件了
}
