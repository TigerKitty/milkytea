//package util.lnc;
//
//import com.github.qcloudsms.SmsSingleSender;
//import com.github.qcloudsms.SmsSingleSenderResult;
//import com.github.qcloudsms.httpclient.HTTPException;
//import org.json.JSONException;
//import java.io.IOException;
//
//
//public class SendMassage {
//        public static void main(String[] args) {
//                SendMassage sendMassage = new SendMassage();
//                String send = sendMassage.sendSMS("18007886230","hzg202105096");
//                System.out.println(send);
//        }
//        public  String sendSMS(String phoneNumber,String code) {
//                String reStr = ""; //���巵��ֵ
//                // ����Ӧ��SDK AppID ? // 1400��ͷ ? ? ??
//                int appid =1400519715;
//                // ����Ӧ��SDK AppKey ? ? ? ?
//                String appkey = "c72a88c77b6d895081f828ebe7dd5343";
//                // ����ģ��ID����Ҫ�ڶ���Ӧ�������� ? ? ??
//                int templateId =953946;
//                // ǩ����ʹ�õ���`ǩ������`��������`ǩ��ID` ? ? ? ?
//                String smsSign = "ȸʳ��ֵ�";
//                try {
//                        //������һ��Ҫ��Ӧ����ģ���еĲ���˳��͸�����?
//                        String[] params = {code};
//                        //����ssender����
//                        SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
//                        //����
//                        SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,templateId, params, smsSign, "", "");
//                        // ǩ������δ�ṩ����Ϊ��ʱ����ʹ��Ĭ��ǩ�����Ͷ��� ? ? ? ? ? ?
//                        System.out.println(result.toString());
//                        if(result.result==0){
//                                reStr = "success";
//                        }else{
//                                reStr = "error";
//                        }
//                } catch (HTTPException e) {
//                        // HTTP��Ӧ����� ? ? ? ? ??
//                        e.printStackTrace();
//                } catch (JSONException e) {
//                        // json�������� ? ? ? ? ? ?
//                        e.printStackTrace();
//                } catch (IOException e) {
//                        // ����IO���� ? ? ? ? ? ?
//                        e.printStackTrace();
//                }catch (Exception e) {
//                        // ����IO���� ? ? ? ? ? ?
//                        e.printStackTrace();
//                }
//                return reStr;
//        }
//}
//
//
//
