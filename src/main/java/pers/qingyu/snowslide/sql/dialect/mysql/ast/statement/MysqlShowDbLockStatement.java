package pers.qingyu.snowslide.sql.dialect.mysql.ast.statement;

import pers.qingyu.snowslide.sql.dialect.mysql.visitor.MySqlASTVisitor;

/**
 * @author lijun.cailj 2017/11/16
 */
public class MysqlShowDbLockStatement extends MySqlStatementImpl implements MySqlShowStatement {
    @Override
    public void accept0(MySqlASTVisitor visitor) {
        visitor.visit(this);
        visitor.endVisit(this);
    }
}
