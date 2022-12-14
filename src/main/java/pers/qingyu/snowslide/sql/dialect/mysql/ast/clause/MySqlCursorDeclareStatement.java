/*
 * Copyright 1999-2017 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pers.qingyu.snowslide.sql.dialect.mysql.ast.clause;

import pers.qingyu.snowslide.sql.ast.SQLName;
import pers.qingyu.snowslide.sql.ast.expr.SQLIdentifierExpr;
import pers.qingyu.snowslide.sql.ast.statement.SQLSelect;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.statement.MySqlStatementImpl;
import pers.qingyu.snowslide.sql.dialect.mysql.visitor.MySqlASTVisitor;

/**
 * 
 * @author zz [455910092@qq.com]
 */
public class MySqlCursorDeclareStatement extends MySqlStatementImpl{
	
	//cursor name
	private SQLName cursorName;
	//select statement
	private SQLSelect select;
	
	public SQLName getCursorName() {
		return cursorName;
	}
	
	public void setCursorName(SQLName cursorName) {
		if (cursorName != null) {
			cursorName.setParent(this);
		}
		this.cursorName = cursorName;
	}

	public void setCursorName(String cursorName) {
		this.setCursorName(new SQLIdentifierExpr(cursorName));
	}

	public SQLSelect getSelect() {
		return select;
	}

	public void setSelect(SQLSelect select) {
		if (select != null) {
			select.setParent(this);
		}
		this.select = select;
	}

	@Override
	public void accept0(MySqlASTVisitor visitor) {
		 if (visitor.visit(this)) {
	         acceptChild(visitor, select);
	        }
	     visitor.endVisit(this);
		
	}

}
