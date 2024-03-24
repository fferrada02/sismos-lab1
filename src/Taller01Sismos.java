import java.util.Scanner;
import java.util.Random;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Taller01Sismos {
    public static double[][] data = new double[7][24];
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        boolean flag1 = false;
        Scanner console = new Scanner(System.in);
        System.out.println("Seleciona opcion (1-5) WARNING: Seleciona 1 para cargar datos");
        System.out.println("1.- Ingresar datos \n" +
                "2.- Mostrar sismo de mayor magnitud\n" +
                "3.- Contar sysmos >= a 5.0\n" +
                "4.- Enviar SMS para sismos >= 7.0 \n" +
                "5.- Salir");

        while(flag1 == false){
            int option = console.nextInt();

            if( option == 1){
                ingresarDatos(data);
            }else if( option == 2){
                double max = buscarMayorSismo(data);
                max = Math.round(max * 100d)/ 100d;
                System.out.println("El sismos de mayor grado registrado en la semana es : " + max);
            }else if( option == 3){
                int kont = contarSismos(data, 5.0);
                System.out.println("El numero de sismos mayores a 5.0 es de : " + kont);
            }else if( option == 4){
                enviarSMS(data);
            }else if( option == 5){
                flag1 = salir(true);
            }
        }
    }

    public static void ingresarDatos(double[][] sismos){
        Random rand = new Random();
        for( int i = 0; i < 7; i++){
            for(int j = 0; j < 24; j++){
                sismos[i][j] = rand.nextDouble()*(9.9) + 0.0;
            }
        }
    }
    public static double buscarMayorSismo(double[][] sismos){
        double max = 0.0;
        for( int i = 0; i < 7; i++){
            for(int j = 0; j < 24; j++){
                if(max < sismos[i][j]) max = sismos[i][j] ;
            }
        }
        return max;
    }
    public static int contarSismos( double[][] sismos, double mayorA){
        int kont = 0;
        for( int i = 0; i < 7; i++){
            for(int j = 0; j < 24; j++){
                if( sismos[i][j] >= mayorA) kont++ ;
            }
        }
        return  kont;
    }
    public static void enviarSMS(double[][] sismos){
        for( int i = 0; i < 7; i++){
            for(int j = 0; j < 24; j++){
                if(sismos[i][j]>= 7.0) {
                    System.out.println("Simos de grado = " + Math.round(sismos[i][j] * 100d)/100d);
                    System.out.println("Alerta!!! se debe evacuar zona costera!"
                    );
                }
            }
        }
    }
    public static boolean salir(boolean flag){
        return flag;
    }
}