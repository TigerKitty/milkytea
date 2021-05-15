package swing.profitstatistics;


import entity.profit.ProductDean;
import dao.profit.Select;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
�̲�������ͳ��ͼ�����
 */
public class MSoleNUM extends ApplicationFrame {
    private static String box;

    public MSoleNUM(String title, String box) {
        super(title);
        this.box=box;
        this.setContentPane(createPanel());//���캯�����Զ�����Java��panel���

    }

    public static CategoryDataset createDataset(String box) //������״ͼ���ݼ�
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<ProductDean> list = new ArrayList<ProductDean>();
        list = Select.selectm(box);
        for (int i = 0; i < list.size(); i++) {
            dataset.setValue(Integer.parseInt(list.get(i).getPronumber()), "", list.get(i).getProname());
        }
        return dataset;
    }

    public static JFreeChart createChart(CategoryDataset dataset) //�����ݼ�����һ��ͼ��
    {
        JFreeChart chart = ChartFactory.createBarChart3D("�̲�������ͼ", // ͼ�����
                "�̲�", // Ŀ¼�����ʾ��ǩ
                "����", // ��ֵ�����ʾ��ǩ
                dataset, // ���ݼ�
                PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
                false, // �Ƿ����ɹ���
                false // �Ƿ�����URL����
        );

        // ����ͼ��ʾ����
        chart.setTitle(new TextTitle("�̲�������ͼ", new Font("����", Font.BOLD, 16)));

        // ȡ��ͳһ��ĵ�һ��ͼ��
        LegendTitle legend = chart.getLegend(0);
        // �޸�ͼ������
        legend.setItemFont(new Font("����", Font.BOLD, 14));
        // ȡ��״ͼplot����
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        // ������״ͼ�����ֱ�ǩ����
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(new Font("����", Font.BOLD, 20));// X��ı�����������
        domainAxis.setTickLabelFont(new Font("����", Font.BOLD, 20));// X����������ֵ����
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("����", Font.ITALIC, 20));// y��ı�����������
        rangeAxis.setTickLabelFont(new Font("����", Font.BOLD, 20));// y����������ֵ����
        //domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // X���ϵ�Lable����45����б
        // ���þ���ͼƬ��˾���
        domainAxis.setLowerMargin(0);
        // ���þ���ͼƬ�Ҷ˾���
        domainAxis.setUpperMargin(0);
        return chart;
    }



    public static JPanel createPanel()
    {
        JFreeChart chart =createChart(createDataset(box));
        return new ChartPanel(chart); //��chart�������Panel�����ȥ��ChartPanel���Ѽ̳�Jpanel
    }
    /*
    public static void main(String[] args)
    {
        MSoleNUM chart=new MSoleNUM("��ʾ����");
        chart.pack();//�Ժ��ʵĴ�С��ʾ

        chart.setVisible(true);

    }
    */
}