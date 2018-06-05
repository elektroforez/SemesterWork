package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.stage.Stage;

import koorsach.*;

public class GUI_simpleTest extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("First try");
        FunctionF f = new FunctionF(4, -3, -2, 1);
        FunctionG g = new FunctionG(new double[] {0, 0}, new double[] {2, 2});
        g.sortXY();
        Scene scene = new Scene(fgGraph(-7, 7, 1, -7, 7, 1,
                "f(x)", f, "g(x)", g), 350, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public LineChart<Number, Number> fgGraph(double xFrom, double xTo, double xStep,
                                              double yFrom, double yTo, double yStep,
                                              String fName, FunctionF f,
                                              String gName, FunctionG g) {
        NumberAxis xAxis = new NumberAxis(xFrom, xTo, xStep);
        NumberAxis yAxis = new NumberAxis(yFrom, yTo, yStep);
        LineChart<Number, Number> graphChart = new LineChart<>(xAxis, yAxis);
        
        graphChart.setCreateSymbols(false);
        double h = (xTo - xFrom) / 100;
     
        XYChart.Series<Number, Number> fSeries = new XYChart.Series<>();
        fSeries.setName(fName);
        for (double x = xFrom; x <= xTo; x += h) {
            fSeries.getData().add(new XYChart.Data<>(x, f.f(x)));
        } 
       
        XYChart.Series<Number, Number> gSeries = new XYChart.Series<>();
        gSeries.setName(gName);
       for(double x = yFrom; x <= yTo; x += h) {
        	gSeries.getData().add(new XYChart.Data<Number, Number>(x, g.f(x)));
        }
        
	/*	for(int i = 0; i < g.count(); i++)	{
			gSeries.getData().add(new XYChart.Data<>(g.getX(i), g.getY(i)));
		}*/      
        graphChart.getData().addAll(fSeries, gSeries);
        return graphChart;
    }

    public static void main(String[] args) {
        launch(args);
    }
}