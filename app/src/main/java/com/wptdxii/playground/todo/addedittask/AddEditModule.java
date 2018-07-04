package com.wptdxii.playground.todo.addedittask;

import android.support.annotation.Nullable;

import com.wptdxii.playground.di.module.RxModule;
import com.wptdxii.playground.di.scope.ActivityScoped;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = RxModule.class)
public abstract class AddEditModule {

    @ActivityScoped
    @Provides
    @Nullable
    static String provideTaskId(AddEditActivity addEditActivity) {
        return addEditActivity.getIntent().getStringExtra(AddEditActivity.EXTRA_TASK_ID);
    }

    @Binds
    @ActivityScoped
    abstract AddEditContract.Presenter providePresenter(AddEditPresenter presenter);

    @Provides
    @ActivityScoped
    static boolean provideStatusDataMissing(AddEditActivity addEditActivity) {
        return addEditActivity.isDataMissing();
    }
}
