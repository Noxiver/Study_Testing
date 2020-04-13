public class main {

    public static void main(String[] args) {
      Vector2d();
      Vector3d();
    }

    private static void Vector2d(){

        System.out.println("==========Vector2D==========");

        Vector2d vector2d_1 = new Vector2d(5, 10);
        Vector2d vector2d_2 = new Vector2d(7, 9);

        System.out.print("a: ");
        vector2d_1.print();
        System.out.print("b: ");
        vector2d_2.print();

        Vector2d vector2d_sum = vector2d_1.add(vector2d_2);
        System.out.print("a + b: ");
        vector2d_sum.print();

        Vector2d vector2d_sub = vector2d_1.subtract(vector2d_2);
        System.out.print("a - b: ");
        vector2d_sub.print();

        double scalarMultiply = vector2d_1.scalarMultiply(vector2d_2);
        System.out.println("scalar multiply: " + scalarMultiply);

        Vector2d vector2d_vectorMultiply = vector2d_1.vectorMultiply(vector2d_2);
        System.out.print("vector multiply: ");
        vector2d_vectorMultiply.print();

    }

    private static void Vector3d(){
        System.out.println("==========Vector3D==========");

        Vector3d vector3d_1 = new Vector3d(4, 5, 8);
        Vector3d vector3d_2 = new Vector3d(1, 7, 14);

        System.out.print("a: ");
        vector3d_1.print();
        System.out.print("b: ");
        vector3d_2.print();

        Vector3d vector3d_sum = vector3d_1.add(vector3d_2);
        System.out.print("a + b: ");
        vector3d_sum.print();

        Vector3d vector3d_sub = vector3d_1.subtract(vector3d_2);
        System.out.print("a - b: ");
        vector3d_sub.print();

        double scalarMultiply = vector3d_1.scalarMultiply(vector3d_2);
        System.out.println("scalar multiply: " + scalarMultiply);

        Vector3d vector3d_vectorMultiply = vector3d_1.vectorMultiply(vector3d_2);
        System.out.print("vector multiply: ");
        vector3d_vectorMultiply.print();

    }

}
