package idv.heartisan.test.exam.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.ColumnConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
/**
 * @author Jin Qi
 * @date 2023/11/26
 */
public class FlexCodeGen {

    public static void main(String[] args) {
        //配置数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test-exam?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //创建配置内容，两种风格都可以。
        GlobalConfig globalConfig = createGlobalConfigUseStyle1();
        //GlobalConfig globalConfig = createGlobalConfigUseStyle2();

        //通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig);

        //生成代码
        generator.generate();
    }

    public static GlobalConfig createGlobalConfigUseStyle1() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.getStrategyConfig().setUnGenerateTable("flyway_schema_history");
        globalConfig.enableTableDef().setOverwriteEnable(true);
        globalConfig.enableEntity().setOverwriteEnable(true).setWithActiveRecord(true).setClassSuffix("DMO").setWithLombok(true);
        globalConfig.enableMapper().setClassSuffix("DMOMapper");
        globalConfig.enableMapperXml().setFileSuffix("DMOMapper");
        globalConfig.enableService().setClassSuffix("DAO");
        globalConfig.enableServiceImpl().setClassSuffix("DAOImpl");
        //设置根包
        globalConfig.setBasePackage("idv.heartisan.test.exam.dao");
        globalConfig.setServicePackage(globalConfig.getBasePackage());
        globalConfig.setServiceImplPackage(globalConfig.getBasePackage() + ".impl");
        globalConfig.setEntityPackage(globalConfig.getBasePackage() + ".dmo");
        globalConfig.setMapperPackage(globalConfig.getBasePackage() + ".mapper");
        globalConfig.setTableDefPackage(globalConfig.getBasePackage() + ".def");
        return globalConfig;
    }

    public static GlobalConfig createGlobalConfigUseStyle2() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置根包
        globalConfig.getPackageConfig()
                .setBasePackage("com.test");

        //设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setTablePrefix("tb_")
                .setGenerateTable("tb_account", "tb_account_session");

        //设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true);

        //设置生成 mapper
        globalConfig.enableMapper();

        //可以单独配置某个列
        ColumnConfig columnConfig = new ColumnConfig();
        columnConfig.setColumnName("tenant_id");
        columnConfig.setLarge(true);
        columnConfig.setVersion(true);
        globalConfig.getStrategyConfig()
                .setColumnConfig("tb_account", columnConfig);

        return globalConfig;
    }
}
