package pers.qingyu.snowslide.sql.dialect.ads.visitor;

import pers.qingyu.snowslide.sql.dialect.mysql.ast.MySqlPrimaryKey;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import pers.qingyu.snowslide.sql.visitor.SQLASTVisitor;

public interface AdsVisitor extends SQLASTVisitor {
    boolean visit(MySqlPrimaryKey x);
    void endVisit(MySqlPrimaryKey x);

    boolean visit(MySqlCreateTableStatement x);
    void endVisit(MySqlCreateTableStatement x);
}
