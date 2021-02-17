package com.ruowei.baiduocr.baidu;

import org.springframework.util.StopWatch;

import java.net.URLEncoder;

/**
 * @Auther: fan
 * @Date: 2021/1/12
 * @Description:
 */
public class VinBaidu {
    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String vinCode() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/vin_code";
        try {
            // 本地文件路径
            String filePath = "C:/Users/Fan/Desktop/test.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            //
            String auth = GetToken.getAuth("HDf7FNkwsVMHie62VY4fDS4i","CTAwRv38vXHh8kU6TGuGHIG37rCyEx5Q");
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
//            String accessToken = auth;
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            String result = HttpUtil.post(url, auth, param);
            stopWatch.stop();
            System.out.println(result);
            System.out.println(stopWatch.getTotalTimeSeconds());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        VinBaidu.vinCode();
    }
}
