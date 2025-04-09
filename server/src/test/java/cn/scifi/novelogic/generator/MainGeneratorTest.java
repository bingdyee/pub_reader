package cn.scifi.novelogic.generator;

import cn.scifi.pubreader.infrastructure.po.BasePO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.query.SQLQuery;
import org.junit.jupiter.api.Test;

/**
 * @author bingdyee
 * @since 2024/9/27
 */
public class MainGeneratorTest {

    @Test
    public void generate() {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:33306/novels?remarks=true&useInformationSchema=true", "root", "12345678")
                .dataSourceConfig(builder ->
                        builder.databaseQueryClass(SQLQuery.class)
                                .typeConvert(new MySqlTypeConvert())
                                .dbQuery(new MySqlQuery())
                )
                .globalConfig(builder -> {
                    builder.author("bingdyee")
                            .outputDir("src/main/java")
                            .disableOpenDir();
                })
                .packageConfig(builder -> {
                    builder.parent("cn.scifi.novelogic")
                            .moduleName("generated")
                            .entity("entity")
                            .mapper("mapper")
                            .xml("mapper.xml");
                })
                .strategyConfig(builder -> {
                    builder.addTablePrefix("sci_")
                            .addFieldPrefix("is_")
                            .addExclude("sci_role_privilege", "sci_user_role")
                            .controllerBuilder().disable()
                            .serviceBuilder().disable()
                            .entityBuilder()
                            .convertFileName((entityName -> entityName + "PO"))
                            .enableLombok()
                            .disableSerialVersionUID()
                            .idType(IdType.ASSIGN_ID)
                            .superClass(BasePO.class)
                            .logicDeleteColumnName("is_deleted")
                            .naming(NamingStrategy.underline_to_camel)
                            .mapperBuilder()
                            .enableBaseResultMap()
                            .enableBaseColumnList();
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
