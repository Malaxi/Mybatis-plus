package com.neuq.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")//指明该实体类与数据库中的哪张表相对应
@ApiModel("用户实体类")//实体类的文档注释
public class User {
    @TableId(type=IdType.INPUT)
    private Long id;
    @ApiModelProperty("用户名")//实体类字段的文档注释
    private String name;
    private Integer age;
    private String email;
    @Version//乐观锁注解
    private Integer version;
    @TableLogic//逻辑删除注解
    private Integer deleted;
    @TableField(fill = FieldFill.INSERT)//自动填充注解
    //采用驼峰规则命名，该字段在插入时会自动添加填充内容，具体的添加内容见handler包下的：MyMetaObjectHandler
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)//自动填充注解
    //采用驼峰规则命名，该字段在插入和更新时会自动添加填充内容，具体的添加内容见handler包下的：MyMetaObjectHandler
    private Date updateTime;
}
