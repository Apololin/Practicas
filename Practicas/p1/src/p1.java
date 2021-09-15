import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeMath.random;

public class p1 {
    private static final int MAX = 100 ;
    public static double PRECIO_TRAMO1 = 0.15;
    public static double PRECIO_TRAMO2 = 0.20;
    public static double PRECIO_TRAMO3 = 0.35;
    public static double PRECIO_TRAMO4 = 0.80;

    public static double calculoConsumo(double numero){

        double cuenta = 0;
        if (numero <= 0){
            System.out.print("El numero introducido no es correcto");
        }else{

            if (numero < 100){
                cuenta = numero * PRECIO_TRAMO1;
            }else if(numero < 600 && numero >= 100){
                numero = numero - 100;
                cuenta = 100 * PRECIO_TRAMO1 + numero * PRECIO_TRAMO2;
            }else if (numero < 1100 && numero >= 600){
                numero= numero - 100;
                cuenta = 100 * PRECIO_TRAMO1;
                numero = numero -500;
                cuenta += 500 * PRECIO_TRAMO2;

                if(numero > 0){ //No haría falta la comprobación
                    cuenta += numero* PRECIO_TRAMO3;
                }

            }else if (numero > 1100){
                numero= numero - 100;
                cuenta = 100 * PRECIO_TRAMO1;
                numero = numero -500;
                cuenta += 500 * PRECIO_TRAMO2;
                numero = numero - 500;
                cuenta +=  500 * PRECIO_TRAMO3;
                cuenta += numero * PRECIO_TRAMO4;
            }
        }

        System.out.println("Debe pagar "+cuenta+ " euros");
        return 1;
    }

    public static String calculoTemp(int numero){

        double count = 0;
        int countNegativas = 0;
        double temperaturas[] = new double[numero];

        for (int i =0 ; i <numero;i++){
            Scanner temperatura = new Scanner(System.in);
            temperaturas[i] = temperatura.nextDouble();
        }

        for (int i = 0; i< temperaturas.length;i++ ){
            count += temperaturas[i];
            if (temperaturas[i] < 0){
                countNegativas++;
            }
        }
        double media = count/numero;
        System.out.println("La media de las "+numero+" temperaturas introducidas es "+media+" y han sido "+countNegativas+" veces negativas" );
        for (int i= 0; i< temperaturas.length;i++){
            System.out.print("Las temperaturas introducidas han sido: "+temperaturas[i]+", ");
        }
        return "";
    }

    public static int adivino(){

        int intentos = 7;
        int numAzar = (int) (Math.random()*100 +1);

        boolean acierto = false;

        while (intentos != 0 || acierto == false){

            System.out.println("Intente adivinar el numero. "+intentos+" intentos");

            Scanner numero = new Scanner(System.in);
            int numeroInt = numero.nextInt();
            if (numeroInt != numAzar){
                intentos--;
                if (numeroInt > numAzar){
                    System.out.println("El numero a adiviniar es menor");
                }else{
                    System.out.println("El numero a adiviniar es mayor");
                }

            }else{
                acierto = true;
                System.out.println("¡ENHORABUENA! ¡HA ACERTADO!");
                break;
            }
            if (intentos < 1){
                System.out.println("ha perdido, el numero a adivinar era "+numAzar);
                break;
            }

        }

        return 1;
    }



    public static void main(String[] args) {

        System.out.println("Introduzca la opción que desea utilizar (1. Calcular consumo de agua 2.Calcular temperatura 3.Adivino)");

        Scanner opcion = new Scanner(System.in);
        int op = opcion.nextInt();

        if (op == 1){
            System.out.println("Introduzca el numero de m^3 consumidos:");
            Scanner numero_entrada = new Scanner(System.in);
            double numero = numero_entrada.nextDouble();

            if (numero >0){
                double cuenta = calculoConsumo(numero);
            }else{
                System.out.println("El numero introducido no es correcto");
            }
        }else if(op == 2){
            System.out.println("Introduzca el numero de temperaturas que va introducir");
            Scanner numeroTemp = new Scanner(System.in);
            int numTemp = numeroTemp.nextInt();
            if (numTemp >0){
                String temperaturaSalida = calculoTemp(numTemp);
            }else{
                System.out.println("El numero introducido no es correcto");
            }

            System.out.println("");
        }else if (op == 3){
            adivino();
        }else{
            System.out.println("La opción introducida no se corresponde");
        }
    }
}
