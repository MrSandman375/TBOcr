package com.ruowei.baiduocr.tencent;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.GeneralBasicOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.GeneralBasicOCRResponse;
import com.tencentcloudapi.ocr.v20181119.models.VinOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.VinOCRResponse;

/**
 * @Auther: fan
 * @Date: 2021/1/12
 * @Description:
 */
public class VinTencent {
    //汽车vin识别
    //    public static void main(String [] args) {
//        try{
//
//            //去腾讯开通后使用自己账号的秘钥
//            Credential cred = new Credential("AKIDzsZ4lDIVMyQs1EbuN2SjmcBmCJiH7eU4", "WlnPAfvAKF2bzQbolSs4jWhcojHdsrb7");
//
//            HttpProfile httpProfile = new HttpProfile();
//            httpProfile.setEndpoint("ocr.tencentcloudapi.com");
//
//            ClientProfile clientProfile = new ClientProfile();
//            clientProfile.setHttpProfile(httpProfile);
//
//            OcrClient client = new OcrClient(cred, "ap-beijing", clientProfile);
//
//            VinOCRRequest req = new VinOCRRequest();
//
//            req.setImageUrl("https://cdn.jsdelivr.net/gh/MrSandman375/pic/20210217135817.png");
//            VinOCRResponse resp = client.VinOCR(req);
//
//            System.out.println(VinOCRResponse.toJsonString(resp));
//        } catch (TencentCloudSDKException e) {
//            System.out.println(e.toString());
//        }
//
//    }
    //普通文字识别（印刷体）
    public static void main(String[] args) {
        try {

            Credential cred = new Credential("AKIDzsZ4lDIVMyQs1EbuN2SjmcBmCJiH7eU4", "WlnPAfvAKF2bzQbolSs4jWhcojHdsrb7");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("ocr.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            OcrClient client = new OcrClient(cred, "ap-beijing", clientProfile);

            GeneralBasicOCRRequest req = new GeneralBasicOCRRequest();
            req.setImageUrl("https://cdn.jsdelivr.net/gh/MrSandman375/pic/20210217140638.png");

            GeneralBasicOCRResponse resp = client.GeneralBasicOCR(req);

            System.out.println(GeneralBasicOCRResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }

    }
}
