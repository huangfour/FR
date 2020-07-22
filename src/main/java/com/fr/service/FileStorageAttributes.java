package com.fr.service;

import com.fr.pojo.bo.GroupStateBO;
import com.fr.pojo.vo.FileInfoVO;

import java.util.List;

/**
 * @author : hong.Four
 * @date : 2020-07-22 10:35
 **/
public interface FileStorageAttributes {

    /**
     * 获取组状态list groups
     *
     * @return
     */
    public List<GroupStateBO> listGroups();


    /**
     * 查询所有的文件
     * @return
     */
    public List<FileInfoVO> selectAllFile();


}
