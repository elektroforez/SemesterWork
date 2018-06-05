package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import koorsach.*;
import koorsach.XMLtest.FReadException;

import java.awt.Desktop;
import java.awt.Point;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.xml.bind.JAXBException;

import XMLgener.EquationData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;

public class Controller implements Initializable{
	
	ObservableList<Points> oblist;
	String filename = "data.xml";
	List<Points> points = new ArrayList<Points>();
	double[] array;
	double[] arr1;
	double[] arr2;
	XMLtest xml;
	private FileChooser chooser;
	private File file;
	List<Double> results;
//	FunctionF f = new FunctionF(array);
//	FunctionG g = new FunctionG(arr1, arr2);
	
	@FXML MenuItem fileMenu;
	@FXML MenuItem saveMenu;
	@FXML MenuItem openMenuItem;
	@FXML MenuItem editMenu;
	@FXML MenuItem helpMenu;
	@FXML MenuItem aboutMenuItem;
	@FXML TableView<Points> table = new TableView<Points>();
	@FXML TableColumn<Points, Double> xColumn;
	@FXML TableColumn<Points, Double> yColumn;
	@FXML Button buildButton;
	@FXML Button addButton;
	@FXML Button applyButton;
	@FXML TextField xField;
	@FXML TextField yField;
	@FXML TextField polinomField;
	@FXML Label polynom;
	@FXML Label rootLable;
	@FXML NumberAxis xAxis = new NumberAxis(-20, 20, 1);
	@FXML NumberAxis yAxis = new NumberAxis(-20, 20, 1);
	@FXML LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
	@FXML TextField from;
	@FXML TextField to;
	XYChart.Series series1;
    XYChart.Series series2;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initList();
		 initLable();
		 initTable();
		 xml = new XMLtest();
		 oblist.clear();
		 table.setItems(null);
		 polynom.setText("");
		 rootLable.setText("Корені:");
		 lineChart.getData().clear();
		 points.clear();
	}
	private XYChart.Series<Number, Number> solveF(){
		FunctionF f = new FunctionF(array);
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
		for (double i = -20; i <= 20; i += 0.1) {
			series.getData().add(new XYChart.Data<>(i, f.f(i)));
		}
		series.setName("f(x)");
		return series;	
	}
	
	private XYChart.Series<Number, Number> solveG(){
		FunctionG g = new FunctionG(arr1, arr2);
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
	/*	for (double i = Double.parseDouble(from.getText()); i <= Double.parseDouble(to.getText()); i += 0.1) {
			series.getData().add(new XYChart.Data<>(i, g.f(i)));
		}*/
		for(int i = 0; i < arr1.length; i++) {
			series.getData().add(new XYChart.Data<>(arr1[i], arr2[i]));
		}
		return series;
	}
	
	public void initTable() {
		for (int i=0;i<oblist.size();i++) {
			if(oblist.get(i)==null) {
				oblist.remove(i);
			}
		}
		table.setItems(oblist);
        table.getColumns().clear();
        table.setEditable(false);
        xColumn.setResizable(false);
        yColumn.setResizable(false);
        xColumn = new TableColumn<Points,Double>("x");
        yColumn = new TableColumn<Points,Double>("y");
        
        xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        xColumn.setCellFactory((TextFieldTableCell.<Points, Double>forTableColumn(
                new DoubleStringConverter())));
        
        yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));
        yColumn.setCellFactory((TextFieldTableCell.<Points, Double>forTableColumn(
                new DoubleStringConverter())));
        table.getColumns().add(xColumn);
        table.getColumns().add(yColumn);
	}
	
	public void initList() {
		XMLtest list = new XMLtest();
		xml = new XMLtest();
		try {
			points.clear();
			arr1 = list.readFromXML(filename).g.getX();
			arr2 = list.readFromXML(filename).g.getY();
			for(int i = 0; i < arr1.length; i++) {
				points.add(new Points(arr1[i], arr2[i]));
			}
			oblist = FXCollections.observableArrayList();
			oblist.clear();
			for (int i = 0; i < points.size(); i++) {
                    oblist.add(points.get(i));
                xml.readFromXML(filename);
            }
		} catch (FReadException e) {
			showError("Помилка читання файлу!");
		}
	}
	
	public void initLable() {
		try {
			XMLtest labl = new XMLtest(); 
			array = labl.readFromXML(filename).f.getKoef();
			String s = "";
			for (int i = array.length - 1, k = 0; i >= 0; i--, k++){
				if(i == 0) {
					if(array[k] > 0) {
						s += " " + "+" + array[k];
					}
					else if(array[k] == 0) {
						s += " " ;
					}
					else {
						s += " " + array[k];
					}
					continue;
				}
				if(i == 1) {
					if(array[k] > 0) {
						s += " " + "+" + array[k] + "x";
					}
					else if(array[k] == 0) {
						s += " " + "+" + "x";
					}
					else {
						s += " " + array[k] + "x";
					}
					continue;
				}
				else {
					if(array[k] > 0) {
						s += " " + "+" + array[k] + "x^" + i;
					}
					else if(array[k] == 0) {
						s += " " + "+" + "x^" + i;
					}
					else {
						s += " " + array[k] + "x^" + i;
					}
				}
			}
			polynom.setText(s);
			polynom.setVisible(true);
		} catch (FReadException | NullPointerException e) {
			showError("Помилка читання файлу!");
		}
	}
	
	public void updateLabel(double[] a) {
		String s = "";
		for (int i = a.length - 1, k = 0; i >= 0; i--, k++){
			if(i == 0) {
				if(array[k] > 0) {
					s += " " + "+" + array[k];
				}
				else if(array[k] == 0) {
					s += " ";
				}
				else {
					s += " " + array[k];
				}
				continue;
			}
			if(i == 1) {
				if(array[k] > 0) {
					s += " " + "+" + array[k] + "x";
				}
				else if(array[k] == 0) {
					s += " " + "+" + "x";
				}
				else {
					s += " " + array[k] + "x";
				}
				continue;
			}
			else {
				if(array[k] > 0) {
					s += " " + "+" + array[k] + "x^" + i;
				}
				else if(array[k] == 0) {
					s += " " + "+" + "x^" + i;
				}
				else {
					s += " " + array[k] + "x^" + i;
				}
			}
		}
		polynom.setText(s);
		polynom.setVisible(true);
	} 
	
	double min() {
		double min = arr1[0];
        for(int i = 1; i < arr1.length; i++){
            if(min > arr1[i]){
                min = arr1[i];
            }
        }
        return min;
	}
	
	double max() {
		double max = arr1[0];
        for(int i = 1; i < arr1.length; i++){
            if(max < arr1[i]){
                max = arr1[i];
            }
        }
        return max;
	}
	
	public void updateroots() {
		FunctionF f = new FunctionF(array);
		FunctionG g = new FunctionG(arr1, arr2);
		DyhotomyRoots r = new DyhotomyRoots();
		results = new ArrayList<>();
		try {
			r.clear();
			r.roots(Double.parseDouble(from.getText()), Double.parseDouble(to.getText()), 0.001, f, g);
			String root = "";
			int k = 1;
			for(int i = 0; i < r.getSize(); i++) {
				if(r.getRoots(i) > min() && r.getRoots(i) < max()) {
						root += "Корінь " + (k) + " : " + String.format("%8.3f",r.getRoots(i)) + "\n";
						k++;
						results.add(r.getRoots(i));
				}
			}
			if(r.getSize() > 20) root = "Безліч коренів";
			if(results.isEmpty())  root = "Коренів немає";
			rootLable.setText(root);
			rootLable.setVisible(true);
		} 
		catch (IntervalException e) {
			// TODO Auto-generated catch blockF
			showError("Невірний інтервал");
		}
	}
	
	//    System interface methods
	
	public static void showMessage(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

	 public static void showError(String message) {
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Помилка");
	        alert.setHeaderText(message);
	        alert.showAndWait();
	    }
	 
	 public static FileChooser getFileChooser(String title) {
	        FileChooser fileChooser = new FileChooser();
	        fileChooser.setInitialDirectory(new File(".")); 
	        fileChooser.getExtensionFilters().add(
	            new FileChooser.ExtensionFilter("XML-files (*.xml)", "*.xml"));
	        fileChooser.getExtensionFilters().add(
	            new FileChooser.ExtensionFilter("All files (*.*)", "*.*"));
	        fileChooser.setTitle(title);
	        return fileChooser;
	    }
	 
	 @FXML public void doBuild(ActionEvent event){
		 try {
		 lineChart.getData().clear();
		 xAxis.setLowerBound(Double.parseDouble(from.getText()));
		 yAxis.setLowerBound(Double.parseDouble(from.getText()));
		 xAxis.setUpperBound(Double.parseDouble(to.getText()));
		 yAxis.setUpperBound(Double.parseDouble(to.getText()));
		 xAxis.setAutoRanging(false);
		 yAxis.setAutoRanging(false);
		 lineChart.setCreateSymbols(false);
		 lineChart.setHorizontalGridLinesVisible(true);
		 XYChart.Series<Number, Number> series1 = solveF();
		 series1.setName("f(x)");
		 XYChart.Series<Number, Number> series2 = solveG();
		 series2.setName("g(x)");
		 lineChart.getData().addAll(series1, series2);
		 lineChart.setVisible(true);
		 updateroots();
		 }
		 catch(NumberFormatException e) {
			 showError("Невірний інтервал");
		 }
	 }
	 
/*	 	 @FXML public void doBuild(ActionEvent event) {
	 		FunctionF f = new FunctionF(array);
	 		FunctionG g = new FunctionG(arr1, arr2);
		 lineChart.setMaxSize(lineChart.getWidth(), lineChart.getHeight());
		 lineChart.getData().clear();
		 xAxis.setAutoRanging(true);
		 
		 double from = -20;
		    double to = 20;
		    xAxis.setLowerBound(from);
		    xAxis.setUpperBound(to);
		    series1.getData().clear();
		    series.getData().clear();
		    g.setX(arr1);
		    g.setY(arr2);
		    f.setKoef(array);
		    for(Double x=from;x<to;x+=0.001){
		       series1.getData().add(new XYChart.Data(x,g.f(x)));
		    }
		    lineChart.getData().add(series1);
		        for(Double x=from;x<to;x+=0.001){
		            series.getData().add(new XYChart.Data(x,f.f(x)));
		        }
		        lineChart.getData().add(series); 
	 } */

	 @FXML public void doOpen(ActionEvent event) {
		 table.setItems(null);
		 FileChooser fileChooser = getFileChooser("Відкрити");
	        if ((file = fileChooser.showOpenDialog(null)) != null) {
	        		
	               filename=file.getPath();
	               initList();            
	               initTable();
	               initLable();
	            }

	        }
	 
	 @FXML public void doNew(ActionEvent event) {
		 initList();
		 initLable();
		 initTable();
		 xml = new XMLtest();
		 oblist.clear();
		 table.setItems(null);
		 polynom.setText("");
		 rootLable.setText("Корені:");
		 lineChart.getData().clear();
		 points.clear();
	 }
	 
	 @FXML public void doReport() {
		 FileChooser fileChooser = new FileChooser();
         File file;
         fileChooser.getExtensionFilters().add(
                 new FileChooser.ExtensionFilter("HTML (*.html)", "*.html"));
         
         if ((file = fileChooser.showSaveDialog(null)) != null) {
	                try {
						report(file);
					} catch (IOException e1) {
						showMessage("Error ");
					}
	                Alert alert = new Alert(AlertType.INFORMATION);
	                alert.setTitle("");
	                alert.setHeaderText("Звіт успішно створено \n Бажаєте його переглянути?");
	                alert.getDialogPane().getButtonTypes().setAll(ButtonType.NO, ButtonType.YES);
	                Optional<ButtonType> result =alert.showAndWait();
	                if (result.get()==ButtonType.NO){
	                    alert.close();
	                }
	                if (result.get()==ButtonType.YES){
	                    try {
	                        java.awt.Desktop.getDesktop().open(file);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	            } else {
	                showMessage("Будь ласка, вкажіть файл");
	            }
	 }
	 
	 public void saveAsPng(LineChart chart) {
	        WritableImage image = chart.snapshot(new SnapshotParameters(), null);
	        File file = new File("screenshot.png");
	        try {
	            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public void report(File file) throws IOException {
	        saveAsPng(lineChart);
	        try (PrintWriter out = new PrintWriter(
	                new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
	            out.printf("<html>%n");
	            out.printf("<head>%n");
	            out.printf("<meta http-equiv='Content-Type' content='text/html; " +
	                    "charset=UTF-8'>%n");
	            out.printf("</head>%n");
	            out.printf("<body bgcolor=\"#FFFFFF\">%n");
	            out.printf("<h2>Корені рівняння методом дихотомії</h2>%n");
	            out.printf("<h2>F(x) = G(x)</h2>%n");
	                
	            out.printf("<p>Графік</p>%n");
	            out.printf("<img src='screenshot.png'>");
	            out.printf("%n");
	            out.printf("<p>На інтервалі [");
	            out.printf(from.getText());
	            out.printf(" ;");
	            out.printf(to.getText(),"</p>%n");
	            out.printf(" ] ");
	            if(results.isEmpty()) {
	            	out.printf("<p>Коренів немає</p>%n");
	            }
	            else {
	                    out.printf("<p>Знайдені корені :</p>%n");
	                    for (int i=0; i<results.size(); i++) {
	                        out.printf("%8.3f<br>%n",results.get(i));
	                    }
	            }
	                out.printf("<p>Дані про функцію F(x)</p>%n");
	                out.printf(polynom.getText());
	                out.printf("<p>Данні для функції G(x)</p>%n");
	                out.printf("<table border = '1' cellpadding=4 ");
	                for (int i = 0; i < oblist.size(); i++) {
	                    out.printf("<tr>%n");
	                    out.printf("<td>%d</td>", i);
	                    out.printf("<td>%8.3f</td>%n", oblist.get(i).getX());
	                    out.printf("<td>%8.3f</td>%n", oblist.get(i).getY());
	                    out.printf("</tr>%n");
	                }
	            out.printf("</body>%n");
	            out.printf("</html>%n");
	        }
	        catch (IOException e){
	        } }
	 
	 @FXML public void doSave(ActionEvent event) {
		 FileChooser fileChooser = new FileChooser();
         File filef;
         fileChooser.getExtensionFilters().add(
                 new FileChooser.ExtensionFilter("XML (*.xml)", "*.xml"));

         if ((filef = fileChooser.showSaveDialog(null)) != null) {
             try {
                 xml.writeXML(filef.getPath(),xml);
                 showMessage("Файл успішно збережено");
             }
             catch (Exception e) {
                 showError("Помилка збереження файлу");
             }
         }
	 }
	 
	 @FXML public void doAbout(ActionEvent event) {
	        Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Про програму");
	        alert.setHeaderText("Програма знаходить корені рівняння методом дихотомії");
	        alert.setContentText("Розробник: Семенович Анна @elektroforez" + '\n' + "Версія 1.0");
	        alert.showAndWait();
	    } 
	 
	 @FXML public void doAdd(ActionEvent event) {
		FunctionF f = new FunctionF(array);
		FunctionG g = new FunctionG(arr1, arr2);
		xml = new XMLtest(f, g);
		double x, y;
		try {
		x = Double.parseDouble(xField.getText());
		y = Double.parseDouble(yField.getText());
		if(oblist.contains(new Points(x, y))) {
			showError("Така точка вже є");
		}
		else {
		oblist.add(new Points(x, y));
		initTable();
		points.add(new Points(x, y));
		double[] tempX = new double[points.size()];
		double[] tempY = new double[points.size()];
		for(int i = 0; i < points.size(); i++){
			tempX[i] = points.get(i).getX();
			tempY[i] = points.get(i).getY();
		}
		arr1 = tempX;
		arr2 = tempY;
		xml.g.setX(arr1);
		xml.g.setY(arr2);
		xml.setArr2(arr2);
		xml.setArr1(arr1);
		xml.setArray(array);
		xField.clear();
		yField.clear();
		}
		}
		catch(NumberFormatException e) {
			showError("Невірні дані");
		}
	}
	
	 @FXML public void doAddPolynom(ActionEvent event) {
		 try {
		String s = polinomField.getText();
		double[] coefs = new double[s.split(" ").length];
		for(int i = 0; i < s.split(" ").length; i++)
		coefs[i] = Double.parseDouble(s.split(" ")[i]);
		array = coefs;
		updateLabel(array);
		polinomField.clear();
		xml.setArray(array);
	}
		 catch(NumberFormatException e) {
				showError("Невірні дані");
			}
		}
	 
	 public void doManual(ActionEvent event) {
	        try {
	            File pdfFile = new File("UserManual.pdf");
	            if (pdfFile.exists()) {
	                if (Desktop.isDesktopSupported()) {
	                    Desktop.getDesktop().open(pdfFile);
	                } else {
	                   showError("PDF type of file is not supported"); }
	            } else {
	                showError("Some problems with file"); }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

}
