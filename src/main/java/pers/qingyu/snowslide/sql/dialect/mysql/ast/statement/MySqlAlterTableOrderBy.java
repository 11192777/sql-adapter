package pers.qingyu.snowslide.sql.dialect.mysql.ast.statement;

import pers.qingyu.snowslide.sql.ast.statement.SQLAlterTableItem;
import pers.qingyu.snowslide.sql.ast.statement.SQLSelectOrderByItem;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.MySqlObjectImpl;
import pers.qingyu.snowslide.sql.dialect.mysql.visitor.MySqlASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * version 1.0
 * Author zzy
 * Date 2019-06-03 15:59
 */
public class MySqlAlterTableOrderBy extends MySqlObjectImpl implements SQLAlterTableItem {

    private List<SQLSelectOrderByItem> columns = new ArrayList<SQLSelectOrderByItem>();

    @Override
    public void accept0(MySqlASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, columns);
        }
        visitor.endVisit(this);
    }

    public List<SQLSelectOrderByItem> getColumns() {
        return columns;
    }

    public void addColumn(SQLSelectOrderByItem column) {
        columns.add(column);
    }
}
