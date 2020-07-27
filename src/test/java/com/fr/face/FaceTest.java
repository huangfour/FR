package com.fr.face;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.fr.commom.faceUtil.FaceConfig;
import com.fr.commom.faceUtil.FaceResultBo;

import java.util.HashMap;

/**
 * @author : hong.Four
 * @date : 2020-07-27 20:42
 **/
public class FaceTest {
    public static void main(String[] args) {

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("api_key", FaceConfig.API_KEY);
        paramMap.put("api_secret", FaceConfig.API_SECRET);
        paramMap.put("image_file1", "src/main/resources/zyx2.jpg");
        paramMap.put("image_url2", "http://47.106.182.155:8888/group1/M00/00/00/rBLdpV8ep6uAYZB8AABfpNk_LKc490.jpg");
        String result = HttpUtil.post(FaceConfig.URL, paramMap);
        FaceResultBo faceResultBo= JSONObject.parseObject(result,FaceResultBo.class);
        System.out.println(faceResultBo.getConfidence());
    }
}
