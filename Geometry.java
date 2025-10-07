// Dana Sader

class Geometry {

    public static void main(String[] args) {

        Point t= new Point(4,6);
        System.out.println(t.distance(new Point(1,3)));

        t.translate(2,1);
        System.out.println(t);

        Line z=new Line(t,new Point(2,2));
        z.translate(5,3);
        System.out.println(z);

        Triangle i = new Triangle (new Point (3,1),new Point(2,3),new Point(6,2));
        i.translate(4,5);
        System.out.println(i);
    }
}