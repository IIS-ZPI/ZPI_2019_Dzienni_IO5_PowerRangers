public class Main implements IArithmeticDiv, IArithmeticsDiff, IArithmeticsMult, IArithmecticsAdd{

    public static void main(String[] args)  {
        System.out.println("PowerRangers:\nMikołaj Baran: developer\nIgor Jarek: developer\nKarolina Płóciennik: tester\nAbdalhadi Alwazir: developer\nOlena Hrynevych: operations ");
        System.out.println("GitHub ID : igorJarek");
        System.out.println("Crivell\n");
        System.out.println("hadi97\n"); //comentOne_Hadi
        System.out.println("Lola9614\n");
    }

    //first comment Karolina Płóciennik
    public double Division(double A, double B) {
        return A / B;
    }

    @Override
    public double Multiplication(double A, double B) {
        return A*B;
    }

    @Override
    public double Addition(double A, double B) {
        return A+B;
    }

    @Override
    public double Difference(double A, double B) {
        return A-B;
    }
}
