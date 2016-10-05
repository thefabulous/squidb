/*
 * Copyright 2015, Yahoo Inc.
 * Copyrights licensed under the Apache 2.0 License.
 * See the accompanying LICENSE file for terms.
 */
package com.yahoo.squidb.sql;

/**
 * A SQL statement that can be compiled into a {@link CompiledStatement}
 */
public interface SqlStatement {

    Object[] EMPTY_ARGS = new Object[0];

    /** Character substituted by values when used in SQL statements */
    String REPLACEABLE_PARAMETER = "?";
    String REPLACEABLE_ARRAY_PARAMETER = "[?]";
    String REPLACEABLE_ARRAY_PARAMETER_REGEX = "\\[\\?\\]";

    /**
     * Maximum number of variables in a SQLite statement
     */
    int MAX_VARIABLE_NUMBER = 999;

    /**
     * Compile this object into a SQL string and its arguments.
     *
     * @return a {@link CompiledStatement} generated from this object
     */
    CompiledStatement compile(CompileContext compileContext);

    /**
     * @return the raw SQL string generated by this object
     */
    String toRawSql(CompileContext compileContext);
}
