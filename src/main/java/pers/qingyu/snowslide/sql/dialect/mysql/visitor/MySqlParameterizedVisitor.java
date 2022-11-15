/*
 * Copyright 1999-2017 Alibaba Group Holding Ltd.
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
package pers.qingyu.snowslide.sql.dialect.mysql.visitor;

import pers.qingyu.snowslide.DbType;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.*;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.clause.*;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.clause.MySqlCaseStatement.MySqlWhenStatement;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.expr.MySqlCharExpr;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.expr.MySqlOrderingExpr;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.expr.MySqlOutFileExpr;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.expr.MySqlUserName;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.statement.*;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement.TableSpaceOption;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.statement.MySqlCreateUserStatement.UserSpecification;
import pers.qingyu.snowslide.sql.visitor.SQLASTParameterizedVisitor;

import java.util.List;

public class MySqlParameterizedVisitor extends SQLASTParameterizedVisitor implements MySqlASTVisitor {

    public MySqlParameterizedVisitor() {
        super(DbType.mysql);
    }

    public MySqlParameterizedVisitor(List<Object> outParameters) {
        super(DbType.mysql, outParameters);
    }

    @Override
    public boolean visit(MySqlCharExpr x) {
        parameterizeAndExportPara(x);
        return false;
    }

}
