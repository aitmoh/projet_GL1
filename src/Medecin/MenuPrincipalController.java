package Medecin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import Secretariat.GererRDController;
import consultation.mainControler;
import dbUtil.dbConnection;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import statistiques.Statistiques;

public class MenuPrincipalController implements Initializable {
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	//ovrir la fenetre gerer les patient 
	public void gererPatients(ActionEvent event) {
		try{ 
			((Node)event.getSource()).getScene().getWindow().hide();	
				Stage adminStage = new Stage();
				FXMLLoader adminLoader = new FXMLLoader();
				Pane adminroot =(Pane) adminLoader.load(getClass().getResource("/Medecin/Medecin.fxml").openStream());
				MedecinController medecinController = (MedecinController)adminLoader.getController();
				
				Scene scene = new Scene(adminroot);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				adminStage.setScene(scene);
				adminStage.setTitle("G�rer les patients");
				adminStage.setResizable(false);
				adminStage.show();
				
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ovrir la fenetre gerer les Comptes
	public void gererLesComptes(ActionEvent event) {
		try{ 
			((Node)event.getSource()).getScene().getWindow().hide();	
				Stage adminStage = new Stage();
				FXMLLoader adminLoader = new FXMLLoader();
				Pane adminroot =(Pane) adminLoader.load(getClass().getResource("/Medecin/GererLesComptes.fxml").openStream());
				GererLesComptesController gererLesComptesController = (GererLesComptesController)adminLoader.getController();
				
				Scene scene = new Scene(adminroot);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				adminStage.setScene(scene);
				adminStage.setTitle("G�rer les Comptes");
				adminStage.setResizable(false);
				adminStage.show();
				
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//ovrir la fenetre gerer les RDVs
	public void gererRD(ActionEvent event) {
		try{ 
			((Node)event.getSource()).getScene().getWindow().hide();	
				Stage adminStage = new Stage();
				FXMLLoader adminLoader = new FXMLLoader();
				Pane adminroot =(Pane) adminLoader.load(getClass().getResource("/Secretariat/gererRD.fxml").openStream());
				GererRDController gererRDController = (GererRDController)adminLoader.getController();
				
				Scene scene = new Scene(adminroot);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				adminStage.setScene(scene);
				adminStage.setTitle("G�rer les rendez-vous");
				adminStage.setResizable(false);
				adminStage.show();
				
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ovrir la fenetre gerer les Consultation 
	public void gererConsultation(ActionEvent event) {
		try{ 
			((Node)event.getSource()).getScene().getWindow().hide();	
				Stage adminStage = new Stage();
				FXMLLoader adminLoader = new FXMLLoader();
				Pane adminroot =(Pane) adminLoader.load(getClass().getResource("/consultation/GererLesConsultation.fxml").openStream());
				mainControler mainController = (mainControler)adminLoader.getController();
				
				Scene scene = new Scene(adminroot);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				adminStage.setScene(scene);
				adminStage.setTitle("G�rer les consultation");
				adminStage.setResizable(false);
				adminStage.show();
				
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int subYear(String date1,String date2) {
		//dans cette m�thode on va calculer en jours la diff�rence entre deux date 
		//pour qu'on puisse apr�s mettre les le nombre de patients et le montant dans le moi qui convient
		 String s1=null,s2=null,s3=null;
			     s1= date1.substring(0, 2); //extraire le jour
				 s2= date1.substring(3, 5); //extraire le mois
				 s3= date1.substring(6, 10); //extraire l'ann�e
				 int n1= new Integer(s1).intValue(); //transformer le jour en un nombre
				 int n2= new Integer(s2).intValue(); //transformer le mois en un nombre
				 int n3= new Integer(s3).intValue(); //transformer l'ann�e en un nombre
			
				 
				
		
				 String str1=null,str2=null,str3=null;
				 str1=date2.substring(0, 2);
				 str2=date2.substring (3, 5);
				 str3=date2.substring (6, 10);
				 int sn1= new Integer(str1).intValue();
				 int sn2= new Integer(str2).intValue();
				 int sn3= new Integer(str3).intValue();
				
		       int d1=n1 +n2*30 + n3*365;
		       int d2=sn1 +sn2*30 + sn3*365;
		        
		      return d2-d1;
		     
			
			}

		public static String m1=null,m2=null,m3=null,m4=null,m5=null,m6=null,m7=null,m8=null,m9=null,m10=null,m11=null,m12=null;
		public static int nb1=0,nb2=0,nb3=0,nb4=0,nb5=0,nb6=0,nb7=0,nb8=0,nb9=0,nb10=0,nb11=0,nb12=0;
		public static int montant1=0,montant2=0,montant3=0,montant4=0,montant5=0,montant6=0,montant7=0,montant8=0,montant9=0,montant10=0,montant11=0,montant12=0;
		
		public void consulterStatistiques(ActionEvent event) {
			try{ 
				
				//statistiques pour la derni�re ann�e
				
				Date today = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				 String str0 =sdf.format(today); //r�cup�rer la date actuel
				 String str1=null,str2=null,str3=null;
				 str1=str0.substring(0, 2);
				 str2=str0.substring (3, 5);
				 str3=str0.substring (6, 10);
				 int sn1= new Integer(str1).intValue();
				 int sn2= new Integer(str2).intValue();
				 int sn3= new Integer(str3).intValue();
				 //choisir l'ordre des mois dans la courbe selon le mois acctuel
				 switch (sn2) {
				case 1:
					m12="janvier";m11="d�cembre";m10="novembre";m9="octobre";m8="septembre";m7="ao�t";m6="juillet";m5="juin";m4="mai";m3="avril";m2="mars";m1="f�vrier";
					break;
					
	            
				case 2:
					m12="f�vrier";m11="janvier";m10="d�cembre";m9="novembre";m8="octobre";m7="septembre";m6="ao�t";m5="juillet";m4="juin";m3="mai";m2="avril";m1="mars";
					break;
	            
				
				
				case 3:
					m12="mars";m11="f�vrier";m10="janvier";m9="d�cembre";m8="novembre";m7="octobre";m6="septembre";m5="ao�t";m4="juillet";m3="juin";m2="mai";m1="avril";
					break;
	               
	               
	            case 4:
	            	m12="avril";m11="mars";m10="f�vrier";m9="janvier";m8="d�cembre";m7="novembre";m6="octobre";m5="septembre";m4="ao�t";m3="juillet";m2="juin";m1="mai";
					break;
		           
		           
	             case 5:
	            	 m12="mai";m11="avril";m10="mars";m9="f�vrier";m8="janvier";m7="d�cembre";m6="novembre";m5="octobre";m4="septembre";m3="ao�t";m2="juillet";m1="juin";
	 				break;
	             
	             
	             case 6:
	            	 m12="juin";m11="mai";m10="avril";m9="mars";m8="f�vrier";m7="janvier";m6="d�cembre";m5="novembre";m4="octobre";m3="septembre";m2="ao�t";m1="juillet";
	  				break;
		         
	               case 7:
	            	 m12="juillet";m11="juin";m10="mai";m9="avril";m8="mars";m7="f�vrier";m6="janvier";m5="d�cembre";m4="novembre";m3="octobre";m2="septembre";m1="ao�t";
	     			 break;
	     				
	               case 8:
	            	 m12="ao�t";m11="juillet";m10="juin";m9="mai";m8="avril";m7="mars";m6="f�vrier";m5="janvier";m4="d�cembre";m3="novembre";m2="octobre";m1="septembre";
	       			 break;
	       			 
	       			
	               case 9:
	            	 m12="septembre";m11="ao�t";m10="juillet";m9="juin";m8="mai";m7="avril";m6="mars";m5="f�vrier";m4="janvier";m3="d�cembre";m2="novembre";m1="octobre";
	       			 break;
	       			 
	               case 10:
	              	 m12="octobre";m11="septembre";m10="ao�t";m9="juillet";m8="juin";m7="mai";m6="avril";m5="mars";m4="f�vrier";m3="janvier";m2="d�cembre";m1="novembre";
	         			 break;
	         			 
	               case 11:
	                 m12="novembre";m11="octobre";m10="septembre";m9="ao�t";m8="juillet";m7="juin";m6="mai";m5="avril";m4="mars";m3="f�vrier";m2="janvier";m1="d�cembre";
	           			 break;	 
					
				default:
					 m12="d�cembre";m11="novembre";m10="octobre";m9="septembre";m8="ao�t";m7="juillet";m6="juin";m5="mai";m4="avril";m3="mars";m2="f�vrier";m1="janvier";
					break;
				}
				 
				 sn2+=1;
				String m=null;
				if(sn2 !=10 ||  sn2 !=11  ||sn2 !=12 ) m="0";
				
				  m+=String.valueOf(sn2);
				 
				 
				 
				 String s="01/"+m+"/"+str3;
				
				 
				  Date today2 = new Date(01/sn2/sn3);
				  SimpleDateFormat sdf2 = new SimpleDateFormat(s);
	              String variable =sdf2.format(today2);
	              
	              String sql = "select Date,montant from Consultation";
	              Connection conn = dbConnection.getConnection();
	      		ResultSet rs = conn.createStatement().executeQuery(sql);
	      		
	      		
	      		while(rs.next()) {
	      			
	      			    if( subYear(rs.getString(1), variable) <= 30 && 0 < subYear(rs.getString(1), variable) ) { nb1++; montant1+=rs.getInt(2);}
	      			else if( subYear(rs.getString(1), variable) <= 60 ) {nb2++; montant2+=rs.getInt(2);}
	      			else if( subYear(rs.getString(1), variable) <= 90 ) {nb3++; montant3+=rs.getInt(2);}
	      			else if( subYear(rs.getString(1), variable) <= 120 ) {nb4++; montant4+=rs.getInt(2);}
	      			else if( subYear(rs.getString(1), variable) <= 150 ) {nb5++; montant5+=rs.getInt(2);}
	      			else if( subYear(rs.getString(1), variable) <= 180 ) {nb6++; montant6+=rs.getInt(2);}
	      			else if( subYear(rs.getString(1), variable) <= 210 ) {nb7++; montant7+=rs.getInt(2);}
	      			else if( subYear(rs.getString(1), variable) <= 240 ) {nb8++; montant8+=rs.getInt(2);}
	      			else if( subYear(rs.getString(1), variable) <= 270 ) {nb9++; montant9+=rs.getInt(2);}
	      			else if( subYear(rs.getString(1), variable) <= 300 ) {nb10++; montant10+=rs.getInt(2);}
	      			else if( subYear(rs.getString(1), variable) <= 330 ) {nb11++; montant11+=rs.getInt(2);}
	      			else if( subYear(rs.getString(1), variable) <= 360 ) {nb12++; montant12+=rs.getInt(2);}
	      			else continue;
	      		}
	      		
	      		String SQL ="select montant,Date from Consultation";
	      		ResultSet rs1 = conn.createStatement().executeQuery(sql);
			    int argent = 0; 
			    
			    
			 
			    	while(rs1.next()) {
			    		
			    		
			    		argent++;
			    	}
	      		
	      		conn.close();
	      		
				//((Node)event.getSource()).getScene().getWindow().hide();	
					Stage adminStage = new Stage();
					FXMLLoader adminLoader = new FXMLLoader();
					Pane adminroot =(Pane) adminLoader.load(getClass().getResource("/statistiques/Statistiques.fxml").openStream());
					Statistiques statistiques = (Statistiques)adminLoader.getController();
					
					Scene scene = new Scene(adminroot);
					//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					adminStage.setScene(scene);
					adminStage.setTitle("Consulter les statistiques");
					adminStage.setResizable(false);
					adminStage.show();
					
			
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
		
		
		public void SignOut(ActionEvent event) {
			try {
				
				((Node)event.getSource()).getScene().getWindow().hide();
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/application/login.fxml") );
				Scene scene = new Scene(root);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	
	
}
