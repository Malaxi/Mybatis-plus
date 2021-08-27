package com.neuq;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.sun.prism.PixelFormat;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;

//代码自动生成器测试类,已经成功测试
@SpringBootTest
public class CodeAutoGeneratorTest {
    public static void main(String[] args) {
        //构建一个代码生成器对象
        AutoGenerator mpg = new AutoGenerator();
        //1.全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//获取项目路径
        gc.setOutputDir(projectPath+"/src/main/java");//设置文件的输出路径(目录)
        gc.setAuthor("malax");
        gc.setOpen(false);//是否打开资源管理器
        gc.setFileOverride(false);//是否覆盖原来生成的文件
        gc.setServiceName("%sService");//去除Service的I前缀
        gc.setIdType(IdType.ID_WORKER);//设置主键类型
        gc.setDateType(DateType.ONLY_DATE);//设置日期类型
        gc.setSwagger2(true);//设置Swagger
        mpg.setGlobalConfig(gc);
        //2.数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setUsername("root");
        dsc.setPassword("@Zhujianlin311");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        //3.包的配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.neuq");//将生成的模块放置在输出路径哪个包下
        pc.setModuleName("autoCode");//设置模块的名字
        pc.setEntity("entity");//生成存放entity类的包
        pc.setMapper("mapper");//生成存放mapper接口的包
        pc.setService("service");//生成存放service类的包
        pc.setController("controller");//生成存放controller类的包
        mpg.setPackageInfo(pc);
        //4.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("user");//设置需要映射的表名，重点设置
        strategy.setNaming(NamingStrategy.underline_to_camel);//设置包的命名规则
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//设置列的命名规则
        strategy.setEntityLombokModel(true);//自动生成lombok
        strategy.setLogicDeleteFieldName("deleted");//设置逻辑删除字段
        //设置自动填充策略
        TableFill createTime = new TableFill("createTime", FieldFill.INSERT);
        TableFill updateTime = new TableFill("updateTime", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);
        //设置乐观锁
        strategy.setVersionFieldName("version");
        //设置controller的一些规则
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);//localhost：8080/hello_id_2;
        mpg.setStrategy(strategy);
        //5.执行代码生成器
        mpg.execute();
    }
}
