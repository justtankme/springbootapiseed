package com.company.project;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.company.project.core.common.BaseController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springboot-quickstart
 * @description:
 * @author: duanzhiwei
 * @created: 2020/12/07 18:12
 */
public class CodeGenPlus {
    public static void main(String[] args) {
        //项目的绝对路径
        String projectPath = System.getProperty("user.dir");
        //生成代码的父级全路径包名
        String parentPackage = "com.company.project";
        //模块名
        String moduleName = "test";
        //表名，多个英文逗号分割
        String tablePrefix = "t_";
        //乐观锁和逻辑删除
        String versionFieldName = "version";
        String logicDeleteFieldName = "deleted";
        //需要生成代码的表
        String includeTable = "t_employee_copy1";

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
//        dataSourceConfig.setSchemaName("public");

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor("duanzhiwei");
        globalConfig.setOpen(false);
        // 实体属性 Swagger2 注解
        globalConfig.setSwagger2(true);
        //xml中的baseResultMap和baseColumnList
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(parentPackage);
        packageConfig.setModuleName(moduleName);

        //模板引擎配置
        AbstractTemplateEngine templateEngine = new FreemarkerTemplateEngine();
        TemplateConfig templateConfig = new TemplateConfig();
        //!!! mybatis-plus-generator包中已经包含了默认模板，在templates目录下 !!!
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        //如果不想生成某种模板的代码，就在这里将其设置为null
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
         templateConfig.setController("generator/template/mycontroller.java");
        //不需要在java目录中生成mapper.xml，由下面的injectionConfig指定xml生成路径
        templateConfig.setXml(null);

        //自定义属性注入配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                //do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        /*
        injectionConfig.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();

        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //表对应实体的父类实体,没有就不用设置!
//        strategy.setSuperEntityClass("");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // controller公共父类,没有就不用设置!
        strategy.setSuperControllerClass(BaseController.class);
        strategy.setInclude(includeTable.split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(tablePrefix);
        //生成的实体类带上表和字段的注释
        strategy.setEntityTableFieldAnnotationEnable(true);

        AutoGenerator generator = new AutoGenerator();
        generator.setGlobalConfig(globalConfig);
        generator.setPackageInfo(packageConfig);
        generator.setDataSource(dataSourceConfig);
        generator.setTemplateEngine(templateEngine);
        generator.setTemplate(templateConfig);
        generator.setCfg(injectionConfig);
        generator.setStrategy(strategy);
//        generator.setConfig();

        generator.execute();
    }
}