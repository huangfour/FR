package com.fr.service;

import com.fr.pojo.FileStorage;
import com.fr.pojo.PictureStorage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author : hong.Four
 * @date : 2020-07-21 22:07
 **/
public interface FileService {

    /**
     * 上传单个文件(视频流)
     * @return
     */
    public boolean uploadSingleFile(MultipartFile file);

    /**
     * 上传单张图片
     * @param file
     * @return
     */
    public boolean uploadSingleImage(MultipartFile file);

    /**
     * 根据用户ID获取文件存储
     * @param id
     * @return
     */
    public List<FileStorage> findFileStorageByUserId(Integer id);

    /**
     * 根据用户ID获取图片存储
     * @param id
     * @return
     */
    public List<PictureStorage> findPictureStorageByUserId(Integer id);

    /**
     * 删除文件存储
     * @return
     */
    public boolean deleteFileStorageByFileUrl(String fileUrl);

    /**
     * 删除图片存储
     * @param fileUrl
     * @return
     */
    public boolean deletePictureStorageByFileUrl(String fileUrl);


}
