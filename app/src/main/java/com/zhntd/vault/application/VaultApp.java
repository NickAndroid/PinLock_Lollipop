package com.zhntd.vault.application;

import android.app.Activity;
import android.app.Application;

import com.zhntd.vault.secure.SecurityLockManager;
import com.zhntd.vault.utils.Logger;

public class VaultApp extends Application {

    private SecurityLockManager mLockManager;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mLockManager == null) {
            mLockManager = new SecurityLockManager(this);
            Logger.d("VaultApp: onCreate() and init with lock manager.", getClass());
        }
    }

    public void checkState(Activity activity) {
        mLockManager.checkState(activity);
    }

    public SecurityLockManager getLockManager() {
        return mLockManager;
    }
}
