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
package pers.qingyu.snowslide.sql.ast;

import pers.qingyu.snowslide.DbType;
import pers.qingyu.snowslide.sql.visitor.VisitorFeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SQLStatement extends SQLObject, SQLDbTypedObject {
    DbType       getDbType();
    boolean      isAfterSemi();
    void         setAfterSemi(boolean afterSemi);
    SQLStatement clone();
    List<SQLObject> getChildren();
    List<SQLCommentHint> getHeadHintsDirect();
    void setHeadHints(List<SQLCommentHint> headHints);

    String toString();
    String toString(VisitorFeature... features);
    Map<Class<?>, List<SQLExpr>> registerMap = new HashMap<>();
}
