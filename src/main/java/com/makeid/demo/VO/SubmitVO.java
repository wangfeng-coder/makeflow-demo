package com.makeid.demo.VO;

import lombok.Data;

import java.util.Map;

/**
 * @author feng_wf
 * @program makeflow-service
 * @description
 * @create 2023-10-07
 */
@Data
public class SubmitVO {


    private String userId;

    private String codeId;

    private Long flowInstId;

    private Map<String,Object> variables;
}
