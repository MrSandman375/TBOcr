package com.ruowei.baiduocr.tencent;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.VinOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.VinOCRResponse;

/**
 * @Auther: fan
 * @Date: 2021/1/12
 * @Description:
 */
public class VinTencent {
    public static void main(String [] args) {
        try{

            //去腾讯开通后使用自己账号的秘钥
            Credential cred = new Credential("xxx", "xxx");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("ocr.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            OcrClient client = new OcrClient(cred, "ap-beijing", clientProfile);

            VinOCRRequest req = new VinOCRRequest();

            req.setImageUrl("https://cdn.jsdelivr.net/gh/MrSandman375/pic/images39-200630161P0A4.jpg");
//            req.setImageUrl("C:/Users/Fan/Desktop/39-200630161P0A4.jpg");
            VinOCRResponse resp = client.VinOCR(req);

            System.out.println(VinOCRResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }

    }
}
