/* Generated By:JJTree: Do not edit this line. OPositionalParameter.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.Map;

public class OPositionalParameter extends OInputParameter {

  protected int paramNumber;

  public OPositionalParameter(int id) {
    super(id);
  }

  public OPositionalParameter(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  @Override
  public String toString() {
    return "?";
  }

  public void toString(Map<Object, Object> params, StringBuilder builder) {
    Object finalValue = bindFromInputParams(params);
    if (finalValue == this) {
      builder.append("?");
    } else if (finalValue instanceof String) {
      builder.append("\"");
      builder.append(OExpression.encode(finalValue.toString()));
      builder.append("\"");
    } else if (finalValue instanceof SimpleNode) {
      ((SimpleNode) finalValue).toString(params, builder);
    } else {
      builder.append(finalValue);
    }
  }

  public Object bindFromInputParams(Map<Object, Object> params) {
    if (params != null) {
      Object value = params.get(paramNumber);
      Object result = toParsedTree(value);
      return result;
    }
    return this;
  }

}
/* JavaCC - OriginalChecksum=f73bea7d9b3994a9d4e79d2c330d8ba2 (do not edit this line) */