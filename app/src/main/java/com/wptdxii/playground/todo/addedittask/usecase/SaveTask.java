package com.wptdxii.playground.todo.addedittask.usecase;

import android.support.annotation.NonNull;

import com.wptdxii.playground.core.executor.PostExecutionThread;
import com.wptdxii.playground.core.executor.ThreadExecutor;
import com.wptdxii.playground.core.interactor.CompletableUseCase;
import com.wptdxii.playground.di.scope.ActivityScoped;
import com.wptdxii.playground.todo.data.TasksRepository;
import com.wptdxii.playground.todo.data.source.Task;

import javax.inject.Inject;

import io.reactivex.Completable;

@ActivityScoped
public class SaveTask extends CompletableUseCase<SaveTask.Request> {

    private final TasksRepository mTasksRepository;

    @Inject
    SaveTask(ThreadExecutor threadExecutor, PostExecutionThread executionThread,
             @NonNull TasksRepository tasksRepository) {
        super(threadExecutor, executionThread);
        mTasksRepository = tasksRepository;
    }

    @Override
    protected Completable buildUseCase(Request request) {
        return Completable.fromAction(() -> mTasksRepository.saveTask(request.getTask()));
    }

    public static final class Request {

        private final Task mTask;

        public Request(Task task) {
            mTask = task;
        }

        public Task getTask() {
            return mTask;
        }
    }
}