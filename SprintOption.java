public class SprintOption {
    Pane sprint_1= new Pane();
    Pane sprint_2= new Pane();
    Pane sprint_3= new Pane();
    Pane sprint_4= new Pane();
    Pane sprint_5= new Pane();
    Pane sprint_6= new Pane();
    Pane sprint= new Pane();
    Label sprint_1l= new Label("Sprint 1");
    Label sprint_2l= new Label("Sprint 2");
    Label sprint_3l= new Label("Sprint 3");
@ -33,11 +28,6 @@ public class SprintOption {
    Label sprint_5l= new Label("Sprint 5");
    Label sprint_6l= new Label("Sprint 6");
    Label unassigned_backlog1= new Label("Remaining backlog items not yet assigned to a sprint");
    Label unassigned_backlog2= new Label("Remaining backlog items not yet assigned to a sprint");
    Label unassigned_backlog3= new Label("Remaining backlog items not yet assigned to a sprint");
    Label unassigned_backlog4= new Label("Remaining backlog items not yet assigned to a sprint");
    Label unassigned_backlog5= new Label("Remaining backlog items not yet assigned to a sprint");
    Label unassigned_backlog6= new Label("Remaining backlog items not yet assigned to a sprint");

    TableView<Backlog> table;

@ -45,12 +35,7 @@ public class SprintOption {
    private ArrayList<backlogItemGrid> backlogItems = new ArrayList<backlogItemGrid>();

    public SprintOption(String inputSprintName) {
        sprint_1.getChildren().addAll(sprint_1l, unassigned_backlog1);
        sprint_2.getChildren().addAll(sprint_2l, unassigned_backlog2);
        sprint_3.getChildren().addAll(sprint_3l, unassigned_backlog3);
        sprint_4.getChildren().addAll(sprint_4l, unassigned_backlog4);
        sprint_5.getChildren().addAll(sprint_5l, unassigned_backlog5);
        sprint_6.getChildren().addAll(sprint_6l, unassigned_backlog6);
        sprint.getChildren().addAll(sprint_1l, unassigned_backlog1);
        sprintName = inputSprintName;
    }

@ -77,7 +62,7 @@ public class SprintOption {
        table.setItems(getbacklog());
        table.getColumns().addAll(nameColumn, pointsColumn);
        table.setLayoutY(25);
        sprint_1.getChildren().add(table);
        sprint.getChildren().add(table);
    }

    public ObservableList<Backlog> getbacklog() {
@ -88,51 +73,5 @@ public class SprintOption {
        return backlogs;
    }

    public void sprint_2() {
        unassigned_backlog2.setLayoutX(80);
    }

    public void sprint_3() {
        unassigned_backlog3.setLayoutX(80);
    }

    public void sprint_4() {
        unassigned_backlog4.setLayoutX(80);
    }

    public void sprint_5() {
        unassigned_backlog5.setLayoutX(80);
    }

    public void sprint_6() {
        unassigned_backlog6.setLayoutX(80);
    }


    

    public Pane get_sprint1() {
        return sprint_1;
    }

    public Pane get_sprint2() {
        return sprint_2;
    }

    public Pane get_sprint3() {
        return sprint_3;
    }

    public Pane get_sprint4() {
        return sprint_4;
    }

    public Pane get_sprint5() {
        return sprint_5;
    }

    public Pane get_sprint6() {
        return sprint_6;
    }
}
