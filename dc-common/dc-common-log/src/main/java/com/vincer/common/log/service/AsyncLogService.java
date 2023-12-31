package com.vincer.common.log.service;

import com.vincer.common.core.constant.SecurityConstants;
import com.vincer.system.api.RemoteLogService;
import com.vincer.system.api.domain.SysOperLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步调用日志服务
 *
 * @author vincer
 */
@Service
public class AsyncLogService {
    @Autowired
    private RemoteLogService remoteLogService;

    /**
     * 保存系统日志记录
     */
    @Async
    public void saveSysLog(SysOperLog sysOperLog) {
        try {
            remoteLogService.saveLog(sysOperLog, SecurityConstants.INNER);
        } catch (Exception e) {
            System.out.println("遇到错误了");
            throw new RuntimeException(e);
        }
    }
}
