package application;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import at.jku.isse.designspace.client.java.DesignSpaceClientConnection;
import at.jku.isse.designspace.client.java.primitive.PrimitiveAPI;
import at.jku.isse.designspace.core.FeatureDescription;
import at.jku.isse.designspace.core.workspace.WorkspaceReference;
import at.jku.isse.designspace.richapi.model.Artifact;
import at.jku.isse.designspace.richapi.model.InstanceArtifact;
import at.jku.isse.designspace.richapi.model.PackageArtifact;
import at.jku.isse.designspace.richapi.model.ProjectArtifact;
import at.jku.isse.designspace.richapi.model.TypeArtifact;
import at.jku.isse.designspace.richapi.model.Workspace;
import at.jku.isse.designspace.richapi.model.impl.ProjectArtifactImpl;
import at.jku.isse.designspace.richapi.model.impl.PropertyTypeArtifactImpl;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
 
public class Main extends Application {
  
	private static Workspace clientConnectionHandler = Workspace.init(InetAddress.getLoopbackAddress().getHostAddress(), null);
	private static PrimitiveAPI clientConnection = clientConnectionHandler.getClientConnection();
	
    private final TableView<Matrix> table = new TableView<>();
    private final ObservableList<Matrix> data =
        FXCollections.observableArrayList(
            new Matrix("Jacob", "Smith"),
            new Matrix("Isabella", "Johnson")
           
        );
   
    public static void main(String[] args) throws UnknownHostException {
    	//initUploadToDesignSpace();
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {

    	ProjectArtifact sampleProject = new ProjectArtifactImpl("SampleProject");
		PackageArtifact defaultTypePackage = sampleProject.createPackage();
		PackageArtifact defaultInstancePackage = sampleProject.createPackage();
	//	defaultTypePackage.getArtifactCollection();
		TypeArtifact RequirementType = defaultTypePackage.createType(Set.class.getName());
		TypeArtifact LinkType = defaultTypePackage.createType(Set.class.getName());
		TypeArtifact StateType = defaultTypePackage.createType(Set.class.getName());
		
		RequirementType.addPropertyType(new PropertyTypeArtifactImpl(new FeatureDescription("requirementname", Artifact.STRING_TYPE.getArtifactId(), false)));
		
		InstanceArtifact Requirement1 = defaultInstancePackage.createInstance(RequirementType);
		Requirement1.setPropertyValue("requirementname", "r1");
		
		InstanceArtifact Requirement2 = defaultInstancePackage.createInstance(RequirementType);
		Requirement2.setPropertyValue("requirementname", "r2");
		
		InstanceArtifact Requirement3 = defaultInstancePackage.createInstance(RequirementType);
		Requirement3.setPropertyValue("requirementname", "r3");
		
		InstanceArtifact Requirement4 = defaultInstancePackage.createInstance(RequirementType);
		Requirement4.setPropertyValue("requirementname", "r4");
		
		InstanceArtifact Requirement5 = defaultInstancePackage.createInstance(RequirementType);
		Requirement5.setPropertyValue("requirementname", "r5");
		
		InstanceArtifact Requirement6 = defaultInstancePackage.createInstance(RequirementType);
		Requirement6.setPropertyValue("requirementname", "r6");
		
		InstanceArtifact Requirement7 = defaultInstancePackage.createInstance(RequirementType);
		Requirement7.setPropertyValue("requirementname", "r7");
		
		StateType.addPropertyType(new PropertyTypeArtifactImpl(new FeatureDescription("statename", Artifact.STRING_TYPE.getArtifactId(), false)));
		InstanceArtifact State1 = defaultInstancePackage.createInstance(StateType);
		State1.setPropertyValue("statename", "s1");
		
		InstanceArtifact State2 = defaultInstancePackage.createInstance(StateType);
		State2.setPropertyValue("statename", "s2");
		
		InstanceArtifact State3 = defaultInstancePackage.createInstance(StateType);
		State3.setPropertyValue("statename", "s3");
		
		InstanceArtifact State4 = defaultInstancePackage.createInstance(StateType);
		State4.setPropertyValue("statename", "s4");
		
		InstanceArtifact State5 = defaultInstancePackage.createInstance(StateType);
		State5.setPropertyValue("statename", "s5");
		
		
		LinkType.addPropertyType(new PropertyTypeArtifactImpl(new FeatureDescription("linkname", Artifact.STRING_TYPE.getArtifactId(), false)));
		LinkType.addPropertyType(new PropertyTypeArtifactImpl(new FeatureDescription("linksource", Artifact.STRING_TYPE.getArtifactId(), false)));
		LinkType.addPropertyType(new PropertyTypeArtifactImpl(new FeatureDescription("linktarget", Artifact.STRING_TYPE.getArtifactId(), false)));
		InstanceArtifact link1 = defaultInstancePackage.createInstance(LinkType);
		link1.setPropertyValue("linkname", "l1");
		
		InstanceArtifact link2 = defaultInstancePackage.createInstance(LinkType);
		link2.setPropertyValue("linkname", "l2");
		
		InstanceArtifact link3 = defaultInstancePackage.createInstance(LinkType);
		link3.setPropertyValue("linkname", "l3");
		
		InstanceArtifact link4 = defaultInstancePackage.createInstance(LinkType);
		link4.setPropertyValue("linkname", "l4");
		
		InstanceArtifact link5 = defaultInstancePackage.createInstance(LinkType);
		link5.setPropertyValue("linkname", "l5");
		
		InstanceArtifact link6 = defaultInstancePackage.createInstance(LinkType);
		link6.setPropertyValue("linkname", "l6");
		
		link1.setPropertyValue("linksource", Requirement1);
		link1.setPropertyValue("linktarget", State2);
		
		link2.setPropertyValue("linksource", Requirement2);
		link2.setPropertyValue("linktarget", State2);
		
		link3.setPropertyValue("linksource", Requirement3);
		link3.setPropertyValue("linktarget", State3);
		
		link4.setPropertyValue("linksource", Requirement1);
		link4.setPropertyValue("linktarget", State3);
		
		link5.setPropertyValue("linksource", Requirement2);
		link5.setPropertyValue("linktarget", State1);
		
		link6.setPropertyValue("linksource", Requirement5);
		link6.setPropertyValue("linktarget", State3);
		
		List<InstanceArtifact> LinkList = new ArrayList<InstanceArtifact>(); 
		
		System.out.println("THIS IS LINK 1hhh=========>"+link1);
		
		System.out.println("THIS IS LINK 2=========>"+link2);
		
		System.out.println("THIS IS LINK 3=========>"+link3);
		
		List<InstanceArtifact> RequirementList= new ArrayList<InstanceArtifact>(); 
		RequirementList.add(Requirement1); 
		RequirementList.add(Requirement2); 
		RequirementList.add(Requirement3); 
		RequirementList.add(Requirement4); 
		RequirementList.add(Requirement5); 
		RequirementList.add(Requirement6); 
		RequirementList.add(Requirement7); 
		
		
		List<InstanceArtifact> StateList= new ArrayList<InstanceArtifact>(); 
		StateList.add(State1); 
		StateList.add(State2); 
		StateList.add(State3); 
		StateList.add(State4); 
		StateList.add(State5); 
		
		
		List<InstanceArtifact> ListOfLinks= new ArrayList<InstanceArtifact>(); 
		ListOfLinks.add(link1); 
		ListOfLinks.add(link2); 
		ListOfLinks.add(link3); 
		ListOfLinks.add(link4); 
		ListOfLinks.add(link5); 
		ListOfLinks.add(link6); 
		
		
		GridPane grid= new GridPane(); 
		//grid.setGridLinesVisible(true);
		
		
		try {
			
			Scene scene = new Scene( grid, 1000, 1000); 
			
			
			
			//grid.addRow(rowIndex, children);
			
			
			stage.setScene(scene);
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}

		List<Label> RequirementLabels = new ArrayList<Label>(); 
		List<Label> StateLabels = new ArrayList<Label>(); 
		int i=1; 
		
	
		for (InstanceArtifact ia: RequirementList) {
			String name= "Requirement"+new Integer(i).toString(); 
			RequirementLabels.add(new Label("Requirement"+i)); 
			i++; 
		}
		
		
		i=1; 
		for (InstanceArtifact ia: StateList) {
			StateLabels.add(new Label("State"+i)); 
			i++; 
		}
		//INITIALIZE COLUMN NAMES: REQUIREMENTS 
		int j=0; 
		i=1; 
	for(Label RequirementLabel: RequirementLabels) {
		grid.add(RequirementLabel, i, 0, 1, 1); 
		i++; 
	}
	//INITIALIZE ROW NAMES: STATES 
	i=1; 
	for(Label Statelabel: StateLabels) {
		grid.add(Statelabel, 0, i, 1, 1); 
		i++; 
	}
		
		
	
		
		grid.setAlignment(Pos.CENTER);
		
		ToggleButton link= new ToggleButton("      *         "); 
		ToggleButton Nolink= new ToggleButton("                "); 
		ToggleButton Dontknowlink= new ToggleButton("    ?    "); 
		link.setStyle(" -fx-font-size:50; ");
		Nolink.setStyle(" -fx-font-size:50; ");
		Dontknowlink.setStyle("-fx-font-size:50; ");
        
		
		 grid.setOnMouseEntered((MouseEvent t) -> {
 	        grid.setStyle("-fx-background- color:#dae7f3;");
 	 });

		
     
  
     boolean matrix[][] = new boolean[StateList.size()+1][RequirementList.size()+1];
     
		for( InstanceArtifact li: ListOfLinks) {
			int y=1; 
			for(InstanceArtifact re: RequirementList) {
				int x=1; 
				for(InstanceArtifact state: StateList) {
				 if(li.getPropertyValue("linksource").equals(re) && li.getPropertyValue("linktarget").equals(state)) {
					   
					    // Object node = getNodeByRowColumnIndex( y, x, grid); 
					   //  grid.getChildren().remove(node); 
					    // link= new ToggleButton("    *    "); 
						//tick in cell (1,1)
			        	//grid.add(link, y, x); 
			        	matrix[x][y]= true; 
			        	
			        }
				 else {
					// Object node = getNodeByRowColumnIndex( y, x, grid); 
				    // grid.getChildren().remove(node); 
					 //  link= new ToggleButton("         "); 
						//tick in cell (1,1)
			        	//grid.add(link, y, x); 
			        	
				 }
				 x++; 
				 
				
				 
			}
			y++; 
		}
		
		
		
 
		}
		
	
		
		List<ToggleButton> toggleButtonList = new ArrayList();
		 for(int l=1; l<RequirementList.size()+1; l++) {
				for(int p=1; p<StateList.size()+1; p++) {
					System.out.println("x: " +l + "y: "+p+ " "+matrix[p][l]);
					if(matrix[p][l]==false) {
						link= new ToggleButton("                "); 
						grid.add(link, l, p); 
						toggleButtonList.add(link); 
					}
					else {
						link= new ToggleButton("      *         "); 
						grid.add(link, l, p); 
						toggleButtonList.add(link); 
					}
				}
			}


		
			// for (Node element : grid.getChildren()) {
			      //  element.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
		 
		 
		
		  for(ToggleButton tempToggleButton : toggleButtonList)
	        {
			  
			  int SizeOfLinks=ListOfLinks.size(); 
			  System.out.println("Size of links "+SizeOfLinks);
	            tempToggleButton.setOnAction(actionEvent -> {
	            	int matrixX= GridPane.getRowIndex(tempToggleButton); 
	            	int matrixY= GridPane.getColumnIndex(tempToggleButton); 
	            	System.out.println("matrixX: "+matrixX+"   matrixY: "+matrixY);
	                if(tempToggleButton.getText().contains("*"))
	                {
	                    tempToggleButton.setText("                "); 
	                    matrix[matrixX][matrixY]=false; 
	                }
	                else
	                {boolean flag=false; 
	                	for(InstanceArtifact ia: ListOfLinks) {
	                		
	                		if(flag==false) {
	                	
	                			if(ia.getPropertyValue("linksource")==RequirementList.get(matrixY-1) && ia.getPropertyValue("linktarget")==StateList.get(matrixX-1)) {
	                				flag=true; 
	                			}
	                		}
	                	
	                	}
	                	
	                    if(flag==false){
	                    	int listsize=ListOfLinks.size(); 
		                	InstanceArtifact new_link = defaultInstancePackage.createInstance(LinkType);
		                	int link_number= listsize+1; 
		                	String linkNumber=String.valueOf(link_number); 
		                	String link_name= "l"+linkNumber; 
		                	System.out.println("MATRIX Y"+ matrixY);
		                	new_link.setPropertyValue("linkname", link_name);
		                	new_link.setPropertyValue("linksource", RequirementList.get(matrixY-1)); 
		                	new_link.setPropertyValue("linktarget", StateList.get(matrixX-1)); 
		                	ListOfLinks.add(new_link); 
		                   
		                    
	                    }
	                
	                    
	                    
	                    
	                    tempToggleButton.setText("      *         "); 
	                    matrix[matrixX][matrixY]=true; 
	                    
	                }
	          /*for(int p=0; p<StateList.size()+1; p++) {
	        	  for(int m=0; m<RequirementList.size()+1; m++) {
	        	  System.out.println("State: "+p+ "Requirement: "+ m+"   "+ matrix[p][m]);
	        	  }
	          }*/
	                for( InstanceArtifact l: ListOfLinks) {
	       	        	 
	      	        	  System.out.println("LINK NAME:  "+l.getPropertyValue("linkname"));
	      	        	  System.out.println("LINK SOURCE:  "+l.getPropertyValue("linksource"));
	      	        	  System.out.println("LINK TARGET:  "+l.getPropertyValue("linktarget"));
	      	        	  
	      	          }
	            
	          
	            });
	        }
			        	/* grid.getChildren().forEach(element -> {
			        		 element.setOnMouseClicked(new EventHandler<MouseEvent>() {
			        	
			            @Override
			            public void handle(MouseEvent event) {
			            	int matrixX= GridPane.getRowIndex(element); 
			            	int matrixY= GridPane.getColumnIndex(element); 
			            	if(element!=null  && matrixX!=0 && matrixY!=0) {
			            	  	
				            	 System.out.println("matrixX: "+matrixX+"   matrixY: "+matrixY);
				            	 System.out.println("matrixY: "+matrixY+" "+ matrix[matrixX][matrixY]);
				            	if(matrix[matrixX][matrixY]==true && matrixX!=0 && matrixY!=0) {
				            		
				            		   System.out.println("HEY I AM HERE FIRSTTTTTTTTT");
				            		
				            		  Node newnode= new ToggleButton("                "); 
				            		  grid.getChildren().remove(element); 
				            		  
				            		grid.add(newnode, matrixY, matrixX); 
				            		matrix[matrixX][matrixY]=false; 
				            	
				            		
				            			       		
				            	}
				            	else if(matrix[matrixX][matrixY]==false && matrixX!=0 && matrixY!=0){
				            		
				            		 System.out.println("HEY I AM HERE SECONDDDDDDD   ");
				            	
				            		
				            		    Node falsenode= new ToggleButton("      *         "); 
				            		    //GridPane.clearConstraints(element); 
					            		  grid.getChildren().remove(element); 
					            		
					            		grid.add(falsenode, matrixY, matrixX); 
					            		matrix[matrixX][matrixY]=true; 
					            		
					            		 
				            	}
				            	
				            	
				             //   System.out.println("Row: " + GridPane.getRowIndex(element));
				               // System.out.println("Column: " + GridPane.getColumnIndex(element));
				            }	
			            	}
			          
			        });
			        	 });*/
			 
			 
			 
        stage.show();
        
        
    
  }
    
    
    public Node getNode(GridPane grid, int column, int row){
        Node result = null; 
        for (Node node : grid.getChildren()) {
             if (GridPane.getColumnIndex(node) == column 
                     && GridPane.getRowIndex(node) == row) {
                  result = node;
              }
        }
        return result;
  }
  
    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        System.out.println("ROW: "+ row +"COLUMN: "+column); 
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }
    public static class Matrix {
 
        private final SimpleStringProperty Requirement;
        private final SimpleStringProperty State;
        
 
        private Matrix(String Requirement, String State) {
            this.Requirement = new SimpleStringProperty(Requirement);
            this.State = new SimpleStringProperty(State);
           
        }
 
        public String geRequirement() {
            return Requirement.get();
        }
 
        public void setRequirement(String Req) {
        	Requirement.set(Req);
        }
 
        public String getState() {
            return State.get();
        }
 
        public void setState(String state) {
            State.set(state);
        }
 
      
    }
} 
