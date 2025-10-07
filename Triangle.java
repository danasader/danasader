
  // Dana Sader

class Triangle implements Movable {

    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a,Point b,Point c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    private Point getA() {
        return a;
    }

    private Point getB() {
        return b;
    }

    private Point getC() {
        return c;
    }

    private Point[] getPoints() {
        return new Point[]{a, b, c};
    }

    public String toString(){
        return "Triangle"+"\n"+ this.a.getX()+"\n" + this.a.getY()+ "\n"+this.b.getX()+"\n"+ this.b.getY()+"\n"+
                this.c.getX()+"\n"+ this.c.getY()+"\n"+ perimeter();
    }

    public double perimeter(){
        return this.a.distance(this.b)+this.b.distance(this.c)+this.c.distance(this.a);
    }

    @Override
    public void translate(int dx, int dy) {
        this.a.translate(dx,dy);
        this.b.translate(dx,dy);
        this.c.translate(dx,dy);
    }
}