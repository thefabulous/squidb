package com.yahoo.squidb.ios;

import com.google.j2objc.annotations.Weak;
import com.yahoo.android.sqlite.DefaultDatabaseErrorHandler;
import com.yahoo.android.sqlite.SQLiteDatabase;

public class CustomActionDatabaseErrorHandler extends DefaultDatabaseErrorHandler {

    @Weak public Delegate delegate;

    @Override
    public void onCorruption(SQLiteDatabase dbObj) {
        if (delegate != null && delegate.shouldPerformCustomActionOnCorruption()) {
            delegate.performCustomActionOnCorruption();
        } else {
            super.onCorruption(dbObj);
        }
    }

    public interface Delegate {
        boolean shouldPerformCustomActionOnCorruption();
        void performCustomActionOnCorruption();
    }
}
