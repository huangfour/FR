package com.fr.service.impl;

import java.util.Date;


import com.fr.commom.enums.UploadStyle;
import com.fr.mapper.FileStorageMapper;
import com.fr.mapper.PictureStorageMapper;
import com.fr.pojo.FileStorage;
import com.fr.pojo.PictureStorage;
import com.fr.pojo.bo.GroupStateBO;
import com.fr.pojo.vo.FileInfoVO;
import com.fr.service.FileStorageAttributes;
import com.github.tobato.fastdfs.domain.fdfs.GroupState;
import com.github.tobato.fastdfs.service.TrackerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : hong.Four
 * @date : 2020-07-22 10:36
 **/
@Service
public class FileStorageAttributesImpl implements FileStorageAttributes {


    @Autowired
    private TrackerClient trackerClient;

    @Autowired
    private FileStorageMapper fileStorageMapper;

    @Autowired
    private PictureStorageMapper pictureStorageMapper;

    public List<GroupStateBO> listGroups() {
        List<GroupStateBO> groupStateBOList = new ArrayList<>();
        List<GroupState> list = trackerClient.listGroups();
        for (int i = 0; i < list.size(); i++) {
            GroupStateBO groupStateBO = new GroupStateBO();
            groupStateBO.setGroupName(list.get(i).getGroupName());
            groupStateBO.setTotalMB(list.get(i).getTotalMB());
            groupStateBO.setFreeMB(list.get(i).getFreeMB());
            groupStateBO.setTrunkFreeMB(list.get(i).getTrunkFreeMB());
            groupStateBO.setStorageCount(list.get(i).getStorageCount());
            groupStateBO.setStoragePort(list.get(i).getStoragePort());
            groupStateBO.setStorageHttpPort(list.get(i).getStorageHttpPort());
            groupStateBO.setActiveCount(list.get(i).getActiveCount());
            groupStateBO.setCurrentWriteServer(list.get(i).getCurrentWriteServer());
            groupStateBO.setStorePathCount(list.get(i).getStorePathCount());
            groupStateBO.setSubdirCountPerPath(list.get(i).getSubdirCountPerPath());
            groupStateBO.setCurrentTrunkFileId(list.get(i).getCurrentTrunkFileId());
            groupStateBOList.add(groupStateBO);
        }
        return groupStateBOList;
    }

    @Override
    public List<FileInfoVO> selectAllFile() {
        List<FileInfoVO> FileInfoVOList = new ArrayList<>();

        List<FileStorage> fileStorageList = fileStorageMapper.selectAll();
        List<PictureStorage> pictureStorage = pictureStorageMapper.selectAll();

        for (int i = 0; i < fileStorageList.size(); i++) {
            FileInfoVO fileInfoVO = new FileInfoVO();
            fileInfoVO.setFileStorageId(fileStorageList.get(i).getFileStorageId());
            fileInfoVO.setUserId(fileStorageList.get(i).getUserId());
            fileInfoVO.setFileUrl(fileStorageList.get(i).getFileUrl());
            fileInfoVO.setBaseUrl(fileStorageList.get(i).getBaseUrl());
            fileInfoVO.setFileName(fileStorageList.get(i).getFileName());
            fileInfoVO.setFileStyle(fileStorageList.get(i).getFileStyle());
            fileInfoVO.setCreatTime(fileStorageList.get(i).getCreatTime());
            fileInfoVO.setFileSize(fileStorageList.get(i).getFileSize());
            fileInfoVO.setStyle(UploadStyle.FILE.type);
            FileInfoVOList.add(fileInfoVO);
        }
        for (int i = 0; i < pictureStorage.size(); i++) {
            FileInfoVO fileInfoVO = new FileInfoVO();
            fileInfoVO.setFileStorageId(pictureStorage.get(i).getPictureStorageId());
            fileInfoVO.setUserId(pictureStorage.get(i).getUserId());
            fileInfoVO.setFileUrl(pictureStorage.get(i).getPictureUrl());
            fileInfoVO.setBaseUrl(pictureStorage.get(i).getBaseUrl());
            fileInfoVO.setFileName(pictureStorage.get(i).getPictureName());
            fileInfoVO.setFileStyle(pictureStorage.get(i).getPictureStyle());
            fileInfoVO.setCreatTime(pictureStorage.get(i).getCreatTime());
            fileInfoVO.setFileSize(pictureStorage.get(i).getPictureSize());
            fileInfoVO.setStyle(UploadStyle.IMAGE.type);
            FileInfoVOList.add(fileInfoVO);
        }
        return FileInfoVOList;
    }

}
