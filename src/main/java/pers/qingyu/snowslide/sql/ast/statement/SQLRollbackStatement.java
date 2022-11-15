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

import pers.qingyu.snowslide.DbType;
import pers.qingyu.snowslide.sql.ast.SQLExpr;
import pers.qingyu.snowslide.sql.ast.SQLName;
import pers.qingyu.snowslide.sql.ast.SQLObject;
import pers.qingyu.snowslide.sql.ast.SQLStatementImpl;
import pers.qingyu.snowslide.sql.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

public class SQLRollbackStatement extends SQLStatementImpl {

    private SQLName to;

    // for mysql
    private Boolean chain;
    private Boolean release;
    private SQLExpr force;
    
    public SQLRollbackStatement() {
        
    }
    
    public SQLRollbackStatement(DbType dbType) {
        super (dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, to);

            acceptChild(visitor, force);
        }
        visitor.endVisit(this);
    }

    @Override
    public List<SQLObject> getChildren() {
        List<SQLObject> children = new ArrayList<SQLObject>();
        if (to != null) {
            children.add(to);
        }
        if (force != null) {
            children.add(force);
        }
        return children;
    }

    public SQLName getTo() {
        return to;
    }

    public void setTo(SQLName to) {
        this.to = to;
    }

    public Boolean getChain() {
        return chain;
    }

    public void setChain(Boolean chain) {
        this.chain = chain;
    }

    public Boolean getRelease() {
        return release;
    }

    public void setRelease(Boolean release) {
        this.release = release;
    }

    public SQLExpr getForce() {
        return force;
    }

    public void setForce(SQLExpr force) {
        this.force = force;
    }

}