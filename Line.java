
 // Dana Sader
 
class Line implements Movable {

    private Point start;
    private Point end;
    
    public Line(Point q,Point l){
        this.start=q;
        this.end=l;
    }
    
    public Point getStart(){
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public String toString(){
        return "Line"+"\n"+ this.start.getX()+"\n"+this.start.getY()+"\n"+this.end.getX()+"\n"+this.end.getY()+"\n"+length();
    }

    public double length(){
        return start.distance(end);
    }

    @Override
    public void translate(int dx, int dy) {
        start.translate(dx,dy);
        end.translate(dx,dy);
    }
}