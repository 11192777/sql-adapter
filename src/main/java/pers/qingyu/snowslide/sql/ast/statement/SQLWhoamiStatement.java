package pers.qingyu.snowslide.sql.ast.statement;

import pers.qingyu.snowslide.sql.ast.SQLStatement;
import pers.qingyu.snowslide.sql.ast.SQLStatementImpl;
import pers.qingyu.snowslide.sql.visitor.SQLASTVisitor;

public class SQLWhoamiStatement extends SQLStatementImpl {
    @Override
    protected void accept0(SQLASTVisitor v) {
        if (v.visit(this)) {

        }
        v.endVisit(this);
    }
}
