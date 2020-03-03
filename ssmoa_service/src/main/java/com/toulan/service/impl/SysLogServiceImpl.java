package com.toulan.service.impl;

import com.github.pagehelper.PageHelper;
import com.toulan.dao.SysLogDAO;
import com.toulan.domain.SysLog;
import com.toulan.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/3/3 15:13
 * @Message
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDAO sysLogDAO;

    @Override
    public void save(SysLog sysLog) {
        sysLogDAO.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(int page,int size) {
        PageHelper.startPage(page, size);
        return sysLogDAO.findAll();
    }
}
