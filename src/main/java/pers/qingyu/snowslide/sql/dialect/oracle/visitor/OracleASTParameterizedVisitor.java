package pers.qingyu.snowslide.sql.dialect.oracle.visitor;

import pers.qingyu.snowslide.DbType;
import pers.qingyu.snowslide.sql.visitor.SQLASTParameterizedVisitor;

import java.util.List;

public class OracleASTParameterizedVisitor  extends SQLASTParameterizedVisitor implements OracleASTVisitor {
    public OracleASTParameterizedVisitor() {
        super(DbType.oracle);
    }

    public OracleASTParameterizedVisitor(List<Object> parameters) {
        super(DbType.oracle, parameters);
    }
}
