package com.fr.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author : hong.Four
 * @date : 2020-07-21 22:07
 **/
public interface FileService {

    /**
     * 上传单个文件
     * @return
     */
    public boolean updateSingleFile(MultipartFile file);

}
