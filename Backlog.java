public class Backlog {
    private String backlog_item;
    private double points;

    public Backlog(String backlog_item, double points) {
        this.backlog_item= backlog_item;
        this.points= points;
    }

    public String get_backlog_item() {
        return backlog_item;
    }

    public double get_points() {
        return points;
    }

    public void set_backlog_item(String backlog_item){
        this.backlog_item= backlog_item;
    }

    public void set_points(double points) {
        this.points= points;
    }
}
