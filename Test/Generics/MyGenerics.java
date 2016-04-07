public class MyGenerics<T extends Number> {

    MyGenerics<Integer> myG = new MyGenerics<>();
    Integer myInt = new Integer(7);
//    myG.myMethod(myInt);

    public MyGenerics() {

    }

    public void myMethod(T t) {

    }

    public int myMethod(T t1, T t2) {
        return 0;
    }

//    public static void myMethod(K, T)  {
//
//    }
}
