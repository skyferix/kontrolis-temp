package Kontrolinis_2.ds;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.security.Provider;

public class SleepService extends Service<String> {
    private int Sleep_Time = 1000;

    public SleepService(TextField param1, String param2, int time) {
        Sleep_Time = time;
        setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                param1.setText(param2);
            }
        });
    }

    public SleepService(CheckBox param1, boolean param2, int time) {
        Sleep_Time = time;
        setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                param1.setSelected(param2);
            }
        });
    }

    @Override
    protected Task<String> createTask() {
        return new Task<String>() {
            @Override
            protected String call() throws Exception {
                Thread.sleep(Sleep_Time);
                return "hello";
            }
        };
    }
}
