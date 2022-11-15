package pers.qingyu.snowslide.sql.dialect.mysql.ast.statement;

import pers.qingyu.snowslide.sql.ast.SQLStatement;
import pers.qingyu.snowslide.sql.dialect.mysql.visitor.MySqlASTVisitor;

/**
 * version 1.0
 * Author zzy
 * Date 2019-07-22 10:06
 */
public class DrdsInspectDDLJobCache extends MySqlStatementImpl implements SQLStatement {

    public void accept0(MySqlASTVisitor visitor) {
        visitor.visit(this);
        visitor.endVisit(this);
    }

}
