package com.makeid.demo.controller;

import com.makeid.demo.VO.*;
import com.makeid.makeflow.MakeFlowApplication;
import com.makeid.makeflow.workflow.vo.FlowDetailVO;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author feng_wf
 * @program makeflow-service
 * @description
 * @create 2023-10-07
 */
@RequestMapping("workflow")
@RestController
public class workFlowController {


    /**
     * 提交流程
     *
     * @param submitVO
     * @return
     */
    @RequestMapping("submit")
    public Result<Long> submit(@RequestBody SubmitVO submitVO) {
        Long s = MakeFlowApplication.getWorkFlowService().submitFlow(submitVO.getCodeId(), submitVO.getFlowInstId(), submitVO.getUserId(), submitVO.getVariables());
        return Result.ok(s);
    }

    @RequestMapping("detail")
    public Result<FlowDetailVO> getDetail(@RequestParam Long flowInstId, @RequestParam String userId) {
        FlowDetailVO flowDetail = MakeFlowApplication.getWorkFlowService().findFlowDetail(flowInstId, userId);
        return Result.ok(flowDetail);
    }

    @RequestMapping("agree")
    public Result agree(@RequestBody AgreeVO agreeVO) {
        MakeFlowApplication.getWorkFlowService().agreeFlow(agreeVO.getFlowInstId(), agreeVO.getUserId(), agreeVO.getOpinion(), agreeVO.getUserId(), agreeVO.getVariables());
        return Result.ok();
    }


    @PostMapping("disAgree")
    public Result disAgree(@RequestBody AgreeVO agreeVO) {
        MakeFlowApplication.getWorkFlowService().disAgreeFlow(agreeVO.getFlowInstId(), agreeVO.getUserId(), agreeVO.getOpinion(), agreeVO.getUserId(), agreeVO.getVariables());
        return Result.ok();
    }

    @PostMapping("back")
    public Result returnBack(@RequestBody ReturnVO returnVO) {
        MakeFlowApplication.getWorkFlowService().returnTask(returnVO.getTargetCodeId(), returnVO.getTaskId(), returnVO.getHandler(), returnVO.getOpinion(), returnVO.getCurrentUserId(), returnVO.getVariables());
        return Result.ok();
    }

    @PostMapping("jump")
    public Result returnBack(@RequestBody JumpVO jumpVO) {
        MakeFlowApplication.getWorkFlowService().freeJump(jumpVO.getTargetCodeId(), jumpVO.getSourceActivityId(), jumpVO.getOpinion(), jumpVO.getCurrentUserId(), jumpVO.getVariables());
        return Result.ok();
    }


}
