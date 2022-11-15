package pers.qingyu.snowslide.sql.ast.statement;

import pers.qingyu.snowslide.sql.ast.SQLExpr;
import pers.qingyu.snowslide.sql.ast.SQLObjectImpl;
import pers.qingyu.snowslide.sql.ast.expr.SQLBinaryOperator;
import pers.qingyu.snowslide.sql.ast.expr.SQLIdentifierExpr;
import pers.qingyu.snowslide.sql.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

public class SQLPartitionRef extends SQLObjectImpl {
    private List<Item> items = new ArrayList<Item>();

    @Override
    protected void accept0(SQLASTVisitor v) {
        if (v.visit(this)) {
            acceptChild(v, items);
        }
        v.endVisit(this);
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        item.setParent(this);
        items.add(item);
    }

    public void addItem(SQLIdentifierExpr name, SQLExpr value) {
        Item item = new Item();
        item.setColumnName(name);
        item.setValue(value);
        item.setParent(this);
        this.items.add(item);
    }

    public static class Item extends SQLObjectImpl {

        private SQLIdentifierExpr columnName;
        private SQLExpr value;
        private SQLBinaryOperator operator;

        public Item() {

        }

        public Item(SQLIdentifierExpr columnName) {
            setColumnName(columnName);
        }

        @Override
        protected void accept0(SQLASTVisitor v) {

        }

        public SQLIdentifierExpr getColumnName() {
            return columnName;
        }

        public void setColumnName(SQLIdentifierExpr x) {
            if (x != null) {
                x.setParent(this);
            }
            this.columnName = x;
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr x) {
            if (x != null) {
                x.setParent(this);
            }
            this.value = x;
        }

        public SQLBinaryOperator getOperator() {
            return operator;
        }

        public void setOperator(SQLBinaryOperator operator) {
            this.operator = operator;
        }
    }
}
