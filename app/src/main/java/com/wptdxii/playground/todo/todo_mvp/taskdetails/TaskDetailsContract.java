package com.wptdxii.playground.todo.todo_mvp.taskdetails;

import com.wptdxii.framekit.base.Contract;
import com.wptdxii.playground.todo.todo_mvp.data.Task;

public class TaskDetailsContract {

    interface View extends Contract.View {

        void showMissingTask();

        void showTask(Task task);

        void hideTaskTitle();

        void showTaskTitle(String title);

        void hideTaskDescription();

        void showTaskDescription(String description);

        void showTaskCompletionStatus(boolean completed);

        void showLoadingIndicator();

        void showTaskChecked(boolean checked);

        void showTaskDeleted();

        void showEditTask(String taskId);
    }


    interface Presenter extends Contract.Presenter<View> {

        void getTask();

        void editTask();

        void deleteTask();

        void checkTask(boolean checked);
    }
}

