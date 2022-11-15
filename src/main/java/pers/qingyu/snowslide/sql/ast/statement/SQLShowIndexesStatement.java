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
package pers.qingyu.snowslide.sql.ast.statement;

import pers.qingyu.snowslide.sql.ast.SQLCommentHint;
import pers.qingyu.snowslide.sql.ast.SQLExpr;
import pers.qingyu.snowslide.sql.ast.SQLName;
import pers.qingyu.snowslide.sql.ast.SQLStatementImpl;
import pers.qingyu.snowslide.sql.ast.expr.SQLIdentifierExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLPropertyExpr;
import pers.qingyu.snowslide.sql.ast.statement.SQLShowStatement;
import pers.qingyu.snowslide.sql.dialect.mysql.visitor.MySqlASTVisitor;
import pers.qingyu.snowslide.sql.visitor.SQLASTVisitor;

import java.util.List;

public class SQLShowIndexesStatement extends SQLStatementImpl implements SQLShowStatement {
    private SQLExprTableSource   table;
    private List<SQLCommentHint> hints;
    private SQLExpr where;
    private String type;

    public SQLExprTableSource getTable() {
        return table;
    }

    public void setTable(SQLName table) {
        setTable(new SQLExprTableSource(table));
    }

    public void setTable(SQLExprTableSource table) {
        this.table = table;
    }

    public SQLName getDatabase() {
        SQLExpr expr = table.getExpr();
        if (expr instanceof SQLPropertyExpr) {
            return (SQLName) ((SQLPropertyExpr) expr).getOwner();
        }
        return null;
    }

    public SQLExpr getWhere() {
        return where;
    }

    public void setWhere(SQLExpr where) {
        this.where = where;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDatabase(String database) {
        table.setSchema(database);
    }

    public void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, table);
            acceptChild(visitor, where);
        }
        visitor.endVisit(this);
    }

    public List<SQLCommentHint> getHints() {
        return hints;
    }

    public void setHints(List<SQLCommentHint> hints) {
        this.hints = hints;
    }
}
