
  // Dana Sader
  
class Point implements Movable {

    private int x;
    private int y;
    
    public Point(int x1,int y1){
        this.x=x1;
        this.y=y1;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    public String toString(){
        return "Point"+"\n"+this.x+"\n"+this.y;
    }

    public double distance(Point p){
        int x2=this.x - p.x;
        int y2=this.y - p.y;
        return Math.sqrt(x2*x2+y2*y2);
    }

    @Override
    public void translate(int dx, int dy) {
        this.x +=dx;
        this.y +=dy;
    }
}