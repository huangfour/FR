package com.fr.commom.utils;

import com.fr.pojo.bo.UploadFileResultBO;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadCallback;

import java.io.*;

/**
 * @author : hong.Four
 * @date : 2020-07-26 14:47
 **/
public class DownloadImageCallBack implements DownloadCallback {
    @Override
    public Object recv(InputStream ins) throws IOException {
        System.out.println("回调函数");
        OutputStream os = null;
        File file=new File("D:\\JetBrains\\Project\\IdeaProjects\\FR\\src\\main\\resources\\static\\1234.jpg");
        try {
            os = new FileOutputStream(file);
            int len = 0;
            byte[] buffer = new byte[8192];

            while ((len = ins.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } finally {
            os.close();
        }
        return file;

    }
}
