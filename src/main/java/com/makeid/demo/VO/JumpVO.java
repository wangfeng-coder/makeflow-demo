package com.makeid.demo.VO;

import lombok.Data;

import java.util.Map;

/**
 * @author feng_wf
 * @program makeflow-demo
 * @description
 * @create 2023-10-08
 */
@Data
public class JumpVO {
    private String targetCodeId;

    private Long sourceActivityId;

    private String opinion;

    private String currentUserId;

    private Map<String,Object> variables;
}
