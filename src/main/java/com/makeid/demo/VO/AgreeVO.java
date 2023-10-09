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
public class AgreeVO {

    private Long flowInstId;


    private String  userId;

    private String opinion;

    private Map<String,Object> variables;


}
