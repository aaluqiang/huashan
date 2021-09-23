public class a{
    public static void main(String[] args){
        System.out.println(gi());
    }
    public static int gi(){
        int b=10;
        try{
            System.out.println(b/0);
            b=99;
        }
        catch(ArithmeticException e){
//            e.printStackTrace();
            System.out.println(e.getMessage());

            b=66;
           return b;
        }

//        finally{
            b=20;
////            return b;
//        }
return b;
    }
}