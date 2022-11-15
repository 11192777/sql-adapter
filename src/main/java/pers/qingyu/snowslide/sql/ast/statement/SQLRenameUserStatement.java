package pers.qingyu.snowslide.sql.ast.statement;

import pers.qingyu.snowslide.DbType;
import pers.qingyu.snowslide.sql.ast.SQLExpr;
import pers.qingyu.snowslide.sql.ast.SQLName;
import pers.qingyu.snowslide.sql.ast.SQLStatementImpl;
import pers.qingyu.snowslide.sql.ast.expr.SQLIntegerExpr;
import pers.qingyu.snowslide.sql.visitor.SQLASTVisitor;

public class SQLRenameUserStatement extends SQLStatementImpl {
    private SQLName name ;
    private SQLName to;

    public SQLRenameUserStatement() {
        dbType = DbType.mysql;
    }

    protected void accept0(SQLASTVisitor v) {
        if (v.visit(this)) {
            acceptChild(v, name);
            acceptChild(v, to);
        }
        v.endVisit(this);
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }

    public SQLName getTo() {
        return to;
    }

    public void setTo(SQLName to) {
        this.to = to;
    }
}
