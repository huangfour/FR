package com.fr.service.impl;

import com.fr.pojo.bo.UploadFileResultBO;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadCallback;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : hong.Four
 * @date : 2020-07-26 14:12
 **/
@Service
public class callback implements DownloadCallback {
    @Override
    public Object recv(InputStream ins) throws IOException {
        System.out.println("回调函数");
        UploadFileResultBO uploadFileResultBO=new UploadFileResultBO();
        uploadFileResultBO.setUrl("nevub");
        return uploadFileResultBO;
    }
}
