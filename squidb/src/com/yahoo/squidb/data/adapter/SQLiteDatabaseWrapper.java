/*
 * Copyright 2015, Yahoo Inc.
 * Copyrights licensed under the Apache 2.0 License.
 * See the accompanying LICENSE file for terms.
 */
package com.yahoo.squidb.data.adapter;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;

import java.util.List;
import java.util.Locale;

public interface SQLiteDatabaseWrapper {

    void beginTransaction();

    void beginTransactionNonExclusive();

    void beginTransactionWithListener(SquidTransactionListener listener);

    void beginTransactionWithListenerNonExclusive(SquidTransactionListener listener);

    // TODO: Return type
    void compileStatement(String sql);

    int delete(String table, String whereClause, String[] whereArgs);

    void disableWriteAheadLogging();

    void enableWriteAheadLogging();

    void endTransaction();

    void execSQL(String sql);

    void execSQL(String sql, Object[] bindArgs);

    List<Pair<String, String>> getAttachedDbs();

    long getMaximumSize();

    long getPageSize();

    String getPath();

    int getVersion();

    boolean inTransaction();

    long insert(String table, String nullColumnHack, ContentValues values);

    long insertOrThrow(String table, String nullColumnHack, ContentValues values);

    long insertWithOnConflict(String table, String nullColumnHack, ContentValues initialValues, int conflictAlgorithm);

    boolean isDatabaseIntegrityOk();

    boolean isDbLockedByCurrentThread();

    @Deprecated
    boolean isDbLockedByOtherThreads();

    boolean isOpen();

    boolean isReadOnly();

    boolean isWriteAheadLoggingEnabled();

    boolean needUpgrade(int newVersion);

    // TODO: Provide other options?
    Cursor rawQuery(String sql, Object[] bindArgs);

    long replace(String table, String nullColumnHack, ContentValues initialValues);

    long replaceOrThrow(String table, String nullColumnHack, ContentValues initialValues);

    void setForeignKeyConstraintsEnabled(boolean enable);

    void setLocale(Locale locale);

    @Deprecated
    void setLockingEnabled(boolean lockingEnabled);

    void setMaxSqlCacheSize(int cacheSize);

    void setMaximumSize(long numBytes);

    void setPageSize(long numBytes);

    void setTransactionSuccessful();

    void setVersion(int version);

    String toString();

    int update(String table, ContentValues values, String whereClause, String[] whereArgs);

    int updateWithOnConflict(String table, ContentValues values, String whereClause, String[] whereArgs,
            int conflictAlgorithm);

    boolean yieldIfContendedSafely(long sleepAfterYieldDelay);

    boolean yieldIfContendedSafely();

    // From SQLiteCloseable
    void acquireReference();

    void close();

    void releaseReference();

    @Deprecated
    void releaseReferenceFromContainer();

    String simpleQueryForString(String sql, Object[] bindArgs);

    int executeUpdateDelete(String sql, Object[] bindArgs);

    long executeInsert(String sql, Object[] bindArgs);

    void ensureSqlCompiles(String sql);

}
