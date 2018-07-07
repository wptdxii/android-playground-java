package com.wptdxii.playground.di.module;

import android.app.Application;
import android.content.Context;
import android.support.v4.widget.CircularProgressDrawable;

import com.wptdxii.playground.core.executor.JobExecutor;
import com.wptdxii.playground.core.executor.PostExecutionThread;
import com.wptdxii.playground.core.executor.ThreadExecutor;
import com.wptdxii.playground.core.executor.UIThread;
import com.wptdxii.playground.core.schedulers.ISchedulerProvider;
import com.wptdxii.playground.core.schedulers.SchedulerProvider;
import com.wptdxii.playground.di.qualifier.AppContext;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public abstract class AppModule {

    @AppContext
    @Binds
    abstract Context provideContext(Application application);

    @Singleton
    @Binds
    abstract ThreadExecutor provideExecutor(JobExecutor jobExecutor);

    @Singleton
    @Binds
    abstract PostExecutionThread provideUIThread(UIThread uiThread);

    @Singleton
    @Binds
    abstract ISchedulerProvider provideProvider(SchedulerProvider schedulerProvider);

    @Provides
    @Singleton
    static CompositeDisposable provideDisposiable() {
        return new CompositeDisposable();
    }
}
