package tn.esprit.spring.controllers;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct; //o
import javax.faces.application.FacesMessage; //o
import javax.faces.bean.RequestScoped;  //o
import javax.faces.context.FacesContext;  //o
import javax.inject.Named; //o

import org.primefaces.event.ItemSelectEvent; //o
import org.primefaces.model.charts.ChartData;  //o
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;  //o
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.bubble.BubbleChartModel;//o
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;//o
import org.primefaces.model.charts.hbar.HorizontalBarChartModel;//o
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;//o
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.pie.PieChartDataSet;//o
import org.primefaces.model.charts.pie.PieChartModel;//o
import org.primefaces.model.charts.polar.PolarAreaChartModel;//o
import org.primefaces.model.charts.radar.RadarChartModel;//o
import org.primefaces.model.charts.scatter.ScatterChartModel;//o
import org.springframework.beans.factory.annotation.Autowired;

@Named
@RequestScoped
public class ChartJsView implements Serializable {
     
    private PieChartModel pieModel;
     
    private PolarAreaChartModel polarAreaModel;
     
    private LineChartModel lineModel;
     
    private LineChartModel cartesianLinerModel;
     
    private BarChartModel barModel;
     
    private BarChartModel barModel2;
     
    private HorizontalBarChartModel hbarModel;
     
    private BarChartModel stackedBarModel;
     
    private BarChartModel stackedGroupBarModel;
     
    private RadarChartModel radarModel;
     
    private RadarChartModel radarModel2;
     
    private BubbleChartModel bubbleModel;
     
    private BarChartModel mixedModel;
     
    private DonutChartModel donutModel;
     
    private ScatterChartModel scatterModel;
 
    @PostConstruct
    public void init() {
        createPieModel();
      
        createLineModel();
       
        createBarModel2();
       
    }
     
    private void createPieModel() {
        pieModel = new PieChartModel();
        ChartData data = new ChartData();
         
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(300);
        values.add(50);
        values.add(100);
        dataSet.setData(values);
         
        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);
         
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Red");
        labels.add("Blue");
        labels.add("Yellow");
        data.setLabels(labels);
         
        pieModel.setData(data);
    }
     
    
    public void createLineModel() {
        lineModel = new LineChartModel();
        ChartData data = new ChartData();
         
        LineChartDataSet dataSet = new LineChartDataSet();
        List<Object> values = new ArrayList<>();
        values.add(65);
        values.add(59);
        values.add(80);
        values.add(81);
        values.add(56);
        values.add(55);
        values.add(40);
        dataSet.setData(values);
        dataSet.setFill(false);
        dataSet.setLabel("My First Dataset");
        dataSet.setBorderColor("rgb(75, 192, 192)");
        dataSet.setLineTension(0.1);
        data.addChartDataSet(dataSet);
         
        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        data.setLabels(labels);
         
        //Options
        LineChartOptions options = new LineChartOptions();        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Line Chart");
        options.setTitle(title);
         
        lineModel.setOptions(options);
        lineModel.setData(data);
    }
     
    
    public void createBarModel2() {
        barModel2 = new BarChartModel();
        ChartData data = new ChartData();
         
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("My First Dataset");
        barDataSet.setBackgroundColor("rgba(255, 99, 132, 0.2)");
        barDataSet.setBorderColor("rgb(255, 99, 132)");
        barDataSet.setBorderWidth(1);
        List<Number> values = new ArrayList<>();
        values.add(65);
        values.add(59);
        values.add(80);
        values.add(81);
        values.add(56);
        values.add(55);
        values.add(40);
        barDataSet.setData(values);
         
        BarChartDataSet barDataSet2 = new BarChartDataSet();
        barDataSet2.setLabel("My Second Dataset");
        barDataSet2.setBackgroundColor("rgba(255, 159, 64, 0.2)");
        barDataSet2.setBorderColor("rgb(255, 159, 64)");
        barDataSet2.setBorderWidth(1);
        List<Number> values2 = new ArrayList<>();
        values2.add(85);
        values2.add(69);
        values2.add(20);
        values2.add(51);
        values2.add(76);
        values2.add(75);
        values2.add(10);
        barDataSet2.setData(values2);
 
        data.addChartDataSet(barDataSet);
        data.addChartDataSet(barDataSet2);
         
        List<String> labels = new ArrayList<>();
        labels.add("Janvier");
        labels.add("Fevrier");
        labels.add("Mars");
        labels.add("Avril");
        labels.add("Mai");
        labels.add("Juin");
        labels.add("Juillet");
        labels.add("Aout");
        labels.add("Septembre");
        labels.add("Octobre");
        labels.add("Novembre");
        labels.add("Decembre");
        data.setLabels(labels);
        barModel2.setData(data);
         
        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);
         
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Bar Chart");
        options.setTitle(title);
         
        barModel2.setOptions(options);
    }

     
     
 
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", DataSet Index:" + event.getDataSetIndex());
 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public PieChartModel getPieModel() {
        return pieModel;
    }
 
    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
 
    public PolarAreaChartModel getPolarAreaModel() {
        return polarAreaModel;
    }
 
    public void setPolarAreaModel(PolarAreaChartModel polarAreaModel) {
        this.polarAreaModel = polarAreaModel;
    }
 
    public LineChartModel getLineModel() {
        return lineModel;
    }
 
    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }
 
    public LineChartModel getCartesianLinerModel() {
        return cartesianLinerModel;
    }
 
    public void setCartesianLinerModel(LineChartModel cartesianLinerModel) {
        this.cartesianLinerModel = cartesianLinerModel;
    }
     
    public BarChartModel getBarModel() {
        return barModel;
    }
 
    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
 
    public BarChartModel getBarModel2() {
        return barModel2;
    }
 
    public void setBarModel2(BarChartModel barModel2) {
        this.barModel2 = barModel2;
    }
 
    public HorizontalBarChartModel getHbarModel() {
        return hbarModel;
    }
 
    public void setHbarModel(HorizontalBarChartModel hbarModel) {
        this.hbarModel = hbarModel;
    }
 
    public BarChartModel getStackedBarModel() {
        return stackedBarModel;
    }
 
    public void setStackedBarModel(BarChartModel stackedBarModel) {
        this.stackedBarModel = stackedBarModel;
    }
 
    public BarChartModel getStackedGroupBarModel() {
        return stackedGroupBarModel;
    }
 
    public void setStackedGroupBarModel(BarChartModel stackedGroupBarModel) {
        this.stackedGroupBarModel = stackedGroupBarModel;
    }
 
    public RadarChartModel getRadarModel() {
        return radarModel;
    }
 
    public void setRadarModel(RadarChartModel radarModel) {
        this.radarModel = radarModel;
    }
 
    public RadarChartModel getRadarModel2() {
        return radarModel2;
    }
 
    public void setRadarModel2(RadarChartModel radarModel2) {
        this.radarModel2 = radarModel2;
    }
 
    public BubbleChartModel getBubbleModel() {
        return bubbleModel;
    }
 
    public void setBubbleModel(BubbleChartModel bubbleModel) {
        this.bubbleModel = bubbleModel;
    }
 
    public BarChartModel getMixedModel() {
        return mixedModel;
    }
 
    public void setMixedModel(BarChartModel mixedModel) {
        this.mixedModel = mixedModel;
    }
 
    public DonutChartModel getDonutModel() {
        return donutModel;
    }
 
    public void setDonutModel(DonutChartModel donutModel) {
        this.donutModel = donutModel;
    }
     
    public ScatterChartModel getScatterModel() {
        return scatterModel;
    }
     
    public void setScatterModel(ScatterChartModel scatterModel) {
        this.scatterModel = scatterModel;
    }
}
