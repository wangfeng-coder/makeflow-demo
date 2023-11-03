package com.makeid.demo.listener;

import com.makeid.makeflow.workflow.delegate.DelegateExecuteReader;
import com.makeid.makeflow.workflow.event.FlowEventListener;
import com.makeid.makeflow.workflow.event.ProcessStartedEvent;
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
public class FlowStartListener  implements FlowEventListener {

    @FlowSubscribe(sync = false)
    public void business1(ProcessStartedEvent processStartEvent) {
        DelegateExecuteReader data = processStartEvent.getData();
        log.info("流程id【{}】流程已启动 执行业务business1",data.getFlowInstId());
    }

    @FlowSubscribe(sync = false)
    public void business2(ProcessStartedEvent processStartEvent) {
        DelegateExecuteReader data = processStartEvent.getData();
        log.info("流程id【{}】流程已启动 执行业务business2",data.getFlowInstId());
    }

    @FlowSubscribe(sync = false)
    public void business3(ProcessStartedEvent processStartEvent) {
        DelegateExecuteReader data = processStartEvent.getData();
        log.info("流程id【{}】流程已启动 执行业务business3",data.getFlowInstId());
    }

    @FlowSubscribe(sync = false)
    public void business4(ProcessStartedEvent processStartEvent) {
        DelegateExecuteReader data = processStartEvent.getData();
        log.info("流程id【{}】流程已启动 执行业务business4",data.getFlowInstId());
    }
}
