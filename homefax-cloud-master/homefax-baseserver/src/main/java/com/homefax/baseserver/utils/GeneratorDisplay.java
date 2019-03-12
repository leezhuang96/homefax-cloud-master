package com.homefax.baseserver.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2018/7/6 16:22
 * @Create Author: nevermore
 * @File Name: GeneratorDisplay
 * @Last version: 2.1.0
 */
public class GeneratorDisplay {

    public void generator() throws Exception{

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File file = new File("");
        System.out.println(file.getCanonicalPath());
        //指定 逆向工程配置文件
        //GeneratorDisplay.class.getResource("/");
        InputStream is = GeneratorDisplay.class.getClassLoader().getResourceAsStream("generatorConfig.xml");
        //File configFile = new File(GeneratorDisplay.class.getResource("/")+"generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

    }

    public static void main(String[] args) throws Exception {
        try {
            GeneratorDisplay generatorSqlmap = new GeneratorDisplay();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
