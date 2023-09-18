package com.vincer.gateway.service;

import com.vincer.common.core.exception.CaptchaException;
import com.vincer.common.core.web.domain.AjaxResult;

import java.io.IOException;

/**
 * 验证码处理
 *
 * @author vincer
 */
public interface ValidateCodeService {
    /**
     * 生成验证码
     */
    public AjaxResult createCaptcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    public void checkCaptcha(String key, String value) throws CaptchaException;
}
