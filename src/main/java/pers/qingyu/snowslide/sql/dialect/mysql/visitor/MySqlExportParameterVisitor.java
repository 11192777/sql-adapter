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

import pers.qingyu.snowslide.sql.ast.SQLLimit;
import pers.qingyu.snowslide.sql.ast.SQLOrderBy;
import pers.qingyu.snowslide.sql.ast.expr.SQLBetweenExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLBinaryOpExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLInListExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLMethodInvokeExpr;
import pers.qingyu.snowslide.sql.ast.statement.SQLSelectGroupByClause;
import pers.qingyu.snowslide.sql.ast.statement.SQLSelectItem;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.statement.MySqlFlushStatement;
import pers.qingyu.snowslide.sql.visitor.ExportParameterVisitor;
import pers.qingyu.snowslide.sql.visitor.ExportParameterVisitorUtils;

import java.util.ArrayList;
import java.util.List;

public class MySqlExportParameterVisitor extends MySqlOutputVisitor implements ExportParameterVisitor {

    /**
     * true= if require parameterized sql output
     */
    private boolean requireParameterizedOutput;


    public MySqlExportParameterVisitor(List<Object> parameters, Appendable appender, boolean wantParameterizedOutput){
        super(appender, true);
        this.parameters = parameters;
        this.requireParameterizedOutput = wantParameterizedOutput;
    }

    public MySqlExportParameterVisitor() {
        this(new ArrayList<Object>());
    }

    public MySqlExportParameterVisitor(List<Object> parameters) {
        this(parameters, null, false);
    }

    public MySqlExportParameterVisitor(final Appendable appender) {
        this(new ArrayList<Object>(),appender, true);
    }

    public List<Object> getParameters() {
        return parameters;
    }

    @Override
    public boolean visit(final SQLSelectItem x) {
        if(requireParameterizedOutput){
            return super.visit(x);
        }
        return true;
    }

    @Override
    public boolean visit(SQLLimit x) {
        if(requireParameterizedOutput){
            return super.visit(x);
        }

        return true;
    }

    @Override
    public boolean visit(SQLOrderBy x) {
        if(requireParameterizedOutput){
            return super.visit(x);
        }
        return false;
    }

    @Override
    public boolean visit(SQLSelectGroupByClause x) {
        if(requireParameterizedOutput){
            return super.visit(x);
        }
        return false;
    }

    @Override
    public boolean visit(SQLMethodInvokeExpr x) {
        if(requireParameterizedOutput){
           return super.visit(x);
        }
        
        ExportParameterVisitorUtils.exportParamterAndAccept(this.parameters, x.getArguments());
        return true;
    }

    @Override
    public boolean visit(SQLInListExpr x) {
        if(requireParameterizedOutput){
            return super.visit(x);
         }
        ExportParameterVisitorUtils.exportParamterAndAccept(this.parameters, x.getTargetList());

        return true;
    }

    @Override
    public boolean visit(SQLBetweenExpr x) {
        if(requireParameterizedOutput){
            return super.visit(x);
         }
        ExportParameterVisitorUtils.exportParameter(this.parameters, x);
        return true;
    }

    public boolean visit(SQLBinaryOpExpr x) {
        if(requireParameterizedOutput){
            return super.visit(x);
         }
        ExportParameterVisitorUtils.exportParameter(this.parameters, x);
        return true;
    }

    @Override
    public boolean visit(MySqlFlushStatement x) {
        return true;
    }

    @Override
    public void endVisit(MySqlFlushStatement x) {

    }
}