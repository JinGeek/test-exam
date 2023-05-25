package idv.heartisan.test.exam.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author Jin Qi
 * @date 2022/8/10
 */
public class MybatisGeneratorUtil {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/test-exam?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "root", "root")
                .globalConfig(builder -> {
                    builder.author("Jin Qi") // 设置作者
                            .disableOpenDir()
                            .dateType(DateType.ONLY_DATE)
                            .outputDir(projectPath + "/src/main/java/"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("idv.heartisan.test.exam") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            .entity("dao.dmo")
                            .service("dao")
                            .serviceImpl("dao.impl")
                            .mapper("dao.mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder()
                            .fileOverride()
                            .enableLombok()
                            .formatFileName("%sDMO")
                            .serviceBuilder()
                            .formatServiceFileName("%sDAO")
                            .formatServiceImplFileName("%sDAOImpl")
                            .mapperBuilder()
                            .formatMapperFileName("%sDMOMapper")
                            .formatXmlFileName("%sDMOMapper")
                            .enableBaseResultMap();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateConfig(builder -> {
                    builder.disable(TemplateType.CONTROLLER);
//                            .disable(TemplateType.SERVICE)
//                            .disable(TemplateType.SERVICEIMPL)
                })
                .execute();

    }
}
