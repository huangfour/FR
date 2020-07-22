package com.fr.mapper;

import com.fr.my.mapper.MyMapper;
import com.fr.pojo.FileStorage;
import com.fr.pojo.PictureStorage;

public interface PictureStorageMapperCustom  {

    int insertUseGeneratedKeys(PictureStorage record);
}