package pers.qingyu.snowslide.sql.ast;

import pers.qingyu.snowslide.sql.ast.SQLName;
import pers.qingyu.snowslide.sql.ast.SQLObject;
import pers.qingyu.snowslide.sql.ast.statement.SQLSelectOrderByItem;

import java.util.List;

public interface SQLIndex extends SQLObject {
    List<SQLName> getCovering();
    List<SQLSelectOrderByItem> getColumns();
}
