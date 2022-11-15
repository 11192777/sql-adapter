package pers.qingyu.snowslide.sql.dialect.mysql.ast.statement;

import pers.qingyu.snowslide.sql.ast.SQLExpr;
import pers.qingyu.snowslide.sql.ast.SQLName;
import pers.qingyu.snowslide.sql.ast.expr.SQLIdentifierExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLTextLiteralExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLValuableExpr;
import pers.qingyu.snowslide.sql.ast.statement.SQLAssignItem;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.FullTextType;
import pers.qingyu.snowslide.sql.dialect.mysql.visitor.MySqlASTVisitor;
import pers.qingyu.snowslide.util.FnvHash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lijun.cailj 2018/8/13
 */
public class MysqlCreateFullTextAnalyzerStatement extends MySqlStatementImpl {


    private SQLName    name;

    private String tokenizer;
    private List<String> charfilters = new ArrayList<String>();
    private List<String> tokenizers = new ArrayList<String>();

    public void accept0(MySqlASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, name);
        }
        visitor.endVisit(this);
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        if (name != null) {
            name.setParent(this);
        }
        this.name = name;
    }

    public String getTokenizer() {
        return tokenizer;
    }

    public void setTokenizer(String tokenizer) {
        this.tokenizer = tokenizer;
    }

    public List<String> getCharfilters() {
        return charfilters;
    }

    public List<String> getTokenizers() {
        return tokenizers;
    }

}
