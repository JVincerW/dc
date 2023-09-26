package com.vincer.file.controller;

import com.alibaba.fastjson2.JSONObject;
import com.vincer.common.core.domain.R;
import com.vincer.common.core.utils.file.FileUtils;
import com.vincer.file.service.LocalSysFileServiceImpl;
import com.vincer.system.api.domain.SysFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件请求处理
 *
 * @author vincer
 */
@RestController
public class SysFileController {
    private static final Logger log = LoggerFactory.getLogger(SysFileController.class);

    @Autowired
    private LocalSysFileServiceImpl sysFileService;

    /**
     * 文件上传请求
     */
    @PostMapping("upload")
    public R<SysFile> upload(MultipartFile file) {
        try {
            // 上传并返回访问地址
            String url = sysFileService.uploadFile(file);
            SysFile sysFile = new SysFile();
            sysFile.setName(FileUtils.getName(url));
            sysFile.setUrl(url);
            return R.ok(sysFile);
        } catch (Exception e) {
            log.error("上传文件失败", e);
            return R.fail(e.getMessage());
        }
    }

    @PostMapping("uploadEditor")
    public JSONObject uploadEditor(@RequestParam("file") MultipartFile file) {
        JSONObject json = new JSONObject();
        try {
            String url = sysFileService.uploadFile(file);
            JSONObject data = new JSONObject();
            json.put("errno", 0);
            data.put("url", url);
            data.put("alt", FileUtils.getName(url));
            data.put("href", url);
            json.put("data", data);
            System.out.println(json);
        } catch (Exception e) {
            log.error("上传文件失败", e);
            json.put("errno", 1);
            json.put("message", "图片上传失败");
            System.out.println(json);
        }
        return json;
    }
}