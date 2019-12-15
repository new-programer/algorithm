package javaBasic;

class Symbol
{
    private int a = 3;
    private int b = 0;
    private int c = 0;
    private void show(int c){
        try {
            c = a / b;
            System.out.println(c);
        } catch (Exception e) {
            // TODO: handle exception
            // e.printStackTrace();
            System.out.println("there is something wrong !");
        }
    }


    public static void main(String[] args) {
        Symbol s;
        s = new Symbol();
        s.show(s.c);
        System.out.println("hello world!");
    }
}
