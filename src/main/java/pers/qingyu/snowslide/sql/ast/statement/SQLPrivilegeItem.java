package pers.qingyu.snowslide.sql.ast.statement;

import pers.qingyu.snowslide.sql.ast.*;
import pers.qingyu.snowslide.sql.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

public class SQLPrivilegeItem extends SQLObjectImpl {

    private SQLExpr action;
    private List<SQLName> columns = new ArrayList<SQLName>();

    public SQLExpr getAction() {
        return action;
    }

    public void setAction(SQLExpr action) {
        this.action = action;
    }

    public List<SQLName> getColumns() {
        return columns;
    }

    @Override
    protected void accept0(SQLASTVisitor v) {
        if (v.visit(this)) {
            acceptChild(v, action);
            acceptChild(v, this.columns);
        }
        v.endVisit(this);
    }
}