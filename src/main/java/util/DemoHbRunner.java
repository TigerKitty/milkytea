package util;

import com.alipay.demo.trade.model.builder.AlipayHeartbeatSynRequestBuilder;
import com.alipay.demo.trade.model.hb.*;
import com.alipay.demo.trade.service.AlipayMonitorService;
import com.alipay.demo.trade.service.impl.hb.AbsHbRunner;
import com.alipay.demo.trade.service.impl.hb.HbQueue;
import com.alipay.demo.trade.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liuyangkly on 15/10/23.
 ִ�е��ȣ���Ҫ�����������߳���ɣ������̣߳����õ��渶2.0�ӿڣ��ͽ��ױ����̣߳���ѯ����������Ҫ��������
 1.���渶����ÿִ����һ�ʽ��׺󽫽��׽����������ʱ����
 2.��ѯ�̶߳�ȡ��ʱ���У���ȡ�����ɼ���Ϣ�����30��trade_info��Ϣ������֧����monitor.heartbeat.syn�ӿ�
 ʾ���������װ����ε��øýӿ�api���ɼ����ݣ�����ɼ�������Ϣ�����׺�ʱ���쳣��Ϣ�ȣ���Ҫϵͳ�̿�����������ɡ�
 */
public class DemoHbRunner extends AbsHbRunner {

    public DemoHbRunner(AlipayMonitorService monitorService) {
        super(monitorService);
    }

    @Override
    public String getAppAuthToken() {
        // ����ϵͳ�̣������Ϊ���̻�������ر��Ͻӿڣ�����Ҫ����ֵ���������Ϊϵͳ���Լ������ױ��Ͻӿڿ�������ɲ�����
        return null;
    }

    @Override
    public AlipayHeartbeatSynRequestBuilder getBuilder() {
        // ϵͳ��ʹ�õĽ�����Ϣ��ʽ��json�ַ������ͣ��ӽ��׶����л�ȡ
        List<SysTradeInfo> sysTradeInfoList = HbQueue.poll();

        // �쳣��Ϣ�Ĳɼ���ϵͳ���������
        List<ExceptionInfo> exceptionInfoList = new ArrayList<ExceptionInfo>();
        //        exceptionInfoList.add(ExceptionInfo.HE_SCANER);
        //        exceptionInfoList.add(ExceptionInfo.HE_PRINTER);
        //        exceptionInfoList.add(ExceptionInfo.HE_OTHER);

        AlipayHeartbeatSynRequestBuilder builder = new AlipayHeartbeatSynRequestBuilder()
            .setProduct(Product.FP).setType(Type.CR).setEquipmentId("cr1000001")
            .setEquipmentStatus(EquipStatus.NORMAL).setTime(Utils.toDate(new Date()))
            .setStoreId("store10001").setMac("0a:00:27:00:00:00").setNetworkType("LAN")
            .setProviderId("2088911212323549") // ����ϵͳ��pid
            .setSysTradeInfoList(sysTradeInfoList) // ϵͳ��ͬ��trade_info��Ϣ
            .setExceptionInfoList(exceptionInfoList) // ��д�쳣��Ϣ������еĻ�
        ;
        return builder;
    }
}
