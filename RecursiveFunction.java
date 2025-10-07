
  // Dana Sader
  
public class RecursiveFunction {

    public static int rec(int x, int y) {

        if(y==0){
            return x;
        }
        else if (y!=0) {
            x = x - 1;
            y = y - 1;
            return x;
        }
        return x;
    }

    public static int iter(int x, int y) {

        if(y==0){
            return x;
        }
        for (int i=0;i<y;i+=1){
            x = x - 1;
            y = y - 1;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(rec(150,30));
        System.out.println(iter(150,30));
        System.out.println(rec(40,30));
        System.out.println(iter(40,30));
    }
}

