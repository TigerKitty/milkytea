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
奶茶月销量统计图表界面
 */
public class MSoleNUM extends ApplicationFrame {
    public MSoleNUM(String title) {
        super(title);
        this.setContentPane(createPanel()); //构造函数中自动创建Java的panel面板
    }

    public static CategoryDataset createDataset() //创建柱状图数据集
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<ProductDean> list = new ArrayList<ProductDean>();
        list = Select.selectm();
        for (int i = 0; i < list.size(); i++) {
            dataset.setValue(Integer.parseInt(list.get(i).getPronumber()), "", list.get(i).getProname());
        }
        return dataset;
    }

    public static JFreeChart createChart(CategoryDataset dataset) //用数据集创建一个图表
    {
        JFreeChart chart = ChartFactory.createBarChart3D("奶茶月销量图", // 图表标题
                "奶茶", // 目录轴的显示标签
                "销量", // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true, // 是否显示图例(对于简单的柱状图必须是false)
                false, // 是否生成工具
                false // 是否生成URL链接
        );

        // 设置图显示标题
        chart.setTitle(new TextTitle("奶茶月销量图", new Font("黑体", Font.BOLD, 16)));

        // 取得统一表的第一个图列
        LegendTitle legend = chart.getLegend(0);
        // 修改图例字体
        legend.setItemFont(new Font("宋体", Font.BOLD, 14));
        // 取得状图plot对象
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        // 设置柱状图各部分标签字体
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(new Font("隶书", Font.BOLD, 20));// X轴的标题文字字体
        domainAxis.setTickLabelFont(new Font("隶书", Font.BOLD, 20));// X轴坐标上数值字体
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("隶书", Font.ITALIC, 20));// y轴的标题文字字体
        rangeAxis.setTickLabelFont(new Font("隶书", Font.BOLD, 20));// y轴坐标上数值字体
        //domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // X轴上的Lable让其45度倾斜
        // 设置距离图片左端距离
        domainAxis.setLowerMargin(0);
        // 设置距离图片右端距离
        domainAxis.setUpperMargin(0);
        return chart;
    }



    public static JPanel createPanel()
    {
        JFreeChart chart =createChart(createDataset());
        return new ChartPanel(chart); //将chart对象放入Panel面板中去，ChartPanel类已继承Jpanel
    }
    /*
    public static void main(String[] args)
    {
        MSoleNUM chart=new MSoleNUM("显示界面");
        chart.pack();//以合适的大小显示

        chart.setVisible(true);

    }
    */
}