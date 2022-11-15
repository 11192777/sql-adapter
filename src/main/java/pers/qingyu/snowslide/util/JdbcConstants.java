/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pers.qingyu.snowslide.util;

import pers.qingyu.snowslide.DbType;

public interface JdbcConstants {

    String ORACLE_DRIVER              = "oracle.jdbc.OracleDriver";
    String ORACLE_DRIVER2             = "oracle.jdbc.driver.OracleDriver";

    DbType MYSQL                      = DbType.mysql;
    String MYSQL_DRIVER               = "com.mysql.jdbc.Driver";
    String MYSQL_DRIVER_6             = "com.mysql.cj.jdbc.Driver";
    String MYSQL_DRIVER_REPLICATE     = "com.mysql.jdbc.";

}
