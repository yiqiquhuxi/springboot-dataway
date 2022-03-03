package com.cyc.util;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.dataql.fx.db.LookupDataSourceListener;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

@DimModule
@Component
public class ExampleModule implements SpringModule {
    @Autowired
    private DataSource dataSource = null;

    @Resource(name = "datasourceB")
    private DataSource datasourceB = null;

    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        // .DataSource form Spring boot into Hasor
        apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));
        apiBinder.installModule(new JdbcModule(Level.Full, "datasourceB", this.datasourceB )); // 数据源B

    }
}
