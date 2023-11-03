package com.makeid.demo.listener;

import com.makeid.makeflow.workflow.delegate.DelegateTaskReader;
import com.makeid.makeflow.workflow.event.FlowEventListener;
import com.makeid.makeflow.workflow.event.TaskDoneEvent;
import com.makeid.makeflow.workflow.event.TaskRunningEvent;
import com.makeid.makeflow.workflow.eventbus.FlowSubscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author feng_wf
 * @program makeflow-demo
 * @description
 * @create 2023-10-09
 */
@Slf4j
@Component
public class TaskListener implements FlowEventListener {

    @FlowSubscribe(sync = false)
    public void business1(TaskRunningEvent taskRunningEvent) {
        List<? extends DelegateTaskReader> data = taskRunningEvent.getData();
        data.stream().forEach(delegateTaskReader -> {
            log.info("监听器收到  任务已经运行【{}】",delegateTaskReader.getName());
        });
    }

    @FlowSubscribe(sync = false)
    public void business1(TaskDoneEvent taskDoneEvent) {
        List<? extends DelegateTaskReader> data = taskDoneEvent.getData();
        data.stream().forEach(delegateTaskReader -> {
            log.info("监听器收到 任务已经完成【{}】 处理人【{}】",delegateTaskReader.getName(),delegateTaskReader.getHandler());
        });
    }
}
