/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.geektimes.projects.servlet.web;

import org.geektimes.projects.servlet.filter.MyFilter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

/**
 * Servlet Web 应用初始化器
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 1.0.0
 */
public class ServletWebApplicationInitializer implements ServletContainerInitializer {

    private static final String COMPONENT_ENV_CONTEXT_NAME = "java:comp/env";

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext servletContext) throws ServletException {
        System.out.println("Hello,World 2021");
        servletContext.addFilter("myFilter", MyFilter.class).addMappingForUrlPatterns(null,false, "/my");

        // 获取 JNDI 数据源

        try {
            Context context = new InitialContext();
            Context envContext = (Context) context.lookup(COMPONENT_ENV_CONTEXT_NAME);
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/UserPlatformDB");

            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            // 执行查询语句（DML）
            ResultSet resultSet = statement.executeQuery("SELECT username, password, phone, address FROM admin");
            while (resultSet.next()) {
                System.out.printf("{username: %s, password: %s, phone: %s, address: %s }\n",
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("phone"),
                    resultSet.getString("address"));
            }
            statement.close();
            connection.close();

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }


    }
}
