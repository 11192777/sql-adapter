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
package pers.qingyu.snowslide.sql.dialect.mysql.ast;

import pers.qingyu.snowslide.DbType;
import pers.qingyu.snowslide.sql.ast.SQLIndex;
import pers.qingyu.snowslide.sql.ast.SQLExpr;
import pers.qingyu.snowslide.sql.ast.statement.SQLTableConstraint;
import pers.qingyu.snowslide.sql.ast.statement.SQLUnique;
import pers.qingyu.snowslide.sql.ast.statement.SQLUniqueConstraint;
import pers.qingyu.snowslide.sql.dialect.ads.visitor.AdsVisitor;
import pers.qingyu.snowslide.sql.dialect.mysql.visitor.MySqlASTVisitor;
import pers.qingyu.snowslide.sql.visitor.SQLASTVisitor;

public class MySqlKey extends SQLUnique implements SQLUniqueConstraint, SQLTableConstraint, SQLIndex {

    public MySqlKey(){
        dbType = DbType.mysql;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor instanceof MySqlASTVisitor) {
            accept0((MySqlASTVisitor) visitor);
        } else  if (visitor instanceof AdsVisitor) {
            accept0((AdsVisitor) visitor);
        }
    }

    protected void accept0(AdsVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, this.getName());
            acceptChild(visitor, this.getColumns());
            acceptChild(visitor, this.getName());
        }
        visitor.endVisit(this);
    }

    protected void accept0(MySqlASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, this.getName());
            acceptChild(visitor, this.getColumns());
            acceptChild(visitor, this.getName());
        }
        visitor.endVisit(this);
    }

    public String getIndexType() {
        return indexDefinition.getOptions().getIndexType();
    }

    public void setIndexType(String indexType) {
        indexDefinition.getOptions().setIndexType(indexType);
    }

    public boolean isHasConstraint() {
        return indexDefinition.hasConstraint();
    }

    public void setHasConstraint(boolean hasConstraint) {
        indexDefinition.setHasConstraint(hasConstraint);
    }

    public void cloneTo(MySqlKey x) {
        super.cloneTo(x);
    }

    public MySqlKey clone() {
        MySqlKey x = new MySqlKey();
        cloneTo(x);
        return x;
    }

    public SQLExpr getKeyBlockSize() {
        return indexDefinition.getOptions().getKeyBlockSize();
    }

    public void setKeyBlockSize(SQLExpr x) {
        indexDefinition.getOptions().setKeyBlockSize(x);
    }
}
