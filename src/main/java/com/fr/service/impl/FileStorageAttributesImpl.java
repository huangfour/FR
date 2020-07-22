package com.fr.service.impl;


import com.fr.pojo.bo.GroupStateBO;
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

    public List<GroupStateBO> listGroups() {
        List<GroupStateBO> groupStateBOList = new ArrayList<>();
        List<GroupState> list = trackerClient.listGroups();
        for (int i=0;i<list.size();i++){
            GroupStateBO groupStateBO=new GroupStateBO();
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

}
