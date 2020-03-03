package com.toulan.service;

import com.toulan.domain.SysLog;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/3/3 15:11
 * @Message
 */
public interface SysLogService {

    /**
     * 保存日志信息
     * @param sysLog
     */
    void save(SysLog sysLog);

    /**
     *
     * @return
     */
    List<SysLog> findAll(int page,int size);
}
