package pers.qingyu.snowslide.adapter;

import pers.qingyu.snowslide.DbType;
import pers.qingyu.snowslide.sql.SQLUtils;
import pers.qingyu.snowslide.sql.ast.SQLExpr;
import pers.qingyu.snowslide.sql.ast.SQLStatement;
import pers.qingyu.snowslide.sql.ast.expr.SQLCharExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLIdentifierExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLInListExpr;

import java.util.ArrayList;


/**
 * <H1></H1>
 *
 * @author Qingyu.Meng
 * @version 1.0
 * @date 2022/11/10 15:09
 */
public class MySqlAdapterUtils {


    public static void main(String[] args) {
        String sql = "select * from ea_form where id in (1, 2, 3)";
        SQLStatement sqlStatement = SQLUtils.parseSingleStatement(sql, DbType.mysql);
        for (SQLExpr sqlExpr : SQLStatement.registerMap.get(SQLInListExpr.class)) {
            SQLInListExpr sqlInListExpr = (SQLInListExpr) sqlExpr;
            if (sqlInListExpr.getTargetList().size() > 2 ) {
                ArrayList<SQLExpr> targetList = new ArrayList<>();
                targetList.add(new SQLCharExpr("555555"));
                sqlInListExpr.setTargetList(targetList);
                SQLExpr expr = sqlInListExpr.getExpr();
                if (expr instanceof SQLIdentifierExpr) {
                    SQLIdentifierExpr expr1 = (SQLIdentifierExpr) expr;
                    expr1.setName("(id, 1)");
                }
            }
        }
        System.out.println(sqlStatement);
    }
}
