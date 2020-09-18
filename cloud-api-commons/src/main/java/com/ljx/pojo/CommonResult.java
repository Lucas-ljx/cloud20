package com.ljx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 李加喜
 * @date 2020/9/15 0015 15:49
 * @Email 1129071273@qq.com
 * 这个类主要是用来向前台传递数据的
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    /**
     * code 404 200等
     * message 响应的信息
     * data 保存发送的数据
     */
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
