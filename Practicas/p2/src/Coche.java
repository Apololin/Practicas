import java.util.Scanner;

public class Coche {

    private double velocidadRecta;
    private double velocidadCurva;

    Coche(){
        velocidadCurva = 0;
        velocidadRecta = 0;
    }
    Coche(double a){
        velocidadRecta = a;
        velocidadCurva = 1;
    }
    Coche(double a, double b){
        velocidadRecta = a;
        velocidadCurva = b;
    }
    Coche(Coche c){
        velocidadCurva = c.getVelocidadCurva();
        velocidadRecta = c.getVelocidadRecta();
    }


    public double getVelocidadCurva() {
        return velocidadCurva;
    }

    public void setVelocidadCurva(double velocidadCurva) {
        this.velocidadCurva = velocidadCurva;
    }

    public double getVelocidadRecta() {
        return velocidadRecta;
    }

    public void setVelocidadRecta(double velocidadRecta) {
        this.velocidadRecta = velocidadRecta;
    }
    public void acelerarRecta(){
        setVelocidadRecta(getVelocidadRecta()+15);
    }
    public void acelerarCurva(){
        setVelocidadCurva(getVelocidadCurva()+5);
    }
    public void frenarRecta(){
        setVelocidadRecta(getVelocidadRecta()-15);
        if(getVelocidadRecta()<= 0){
            setVelocidadRecta(0);
        }
    }
    public void frenarCurva(){
        setVelocidadCurva(getVelocidadCurva()-5);
        if(getVelocidadCurva()<=0){
            setVelocidadCurva(0);
        }
    }
    public void mejorar(){
        setVelocidadRecta(getVelocidadRecta()+15);
        setVelocidadCurva(getVelocidadCurva()+15);
    }

    public double tiempoRecta(double distancia){
        if (getVelocidadRecta() <= 0){
            return -1;
        }else{
            return distancia/getVelocidadRecta();
        }


    }
    public double tiempoCurva(double distancia){
        if (getVelocidadCurva() <= 0 ){
            return -1;
        }else{
            return distancia/getVelocidadCurva();
        }

    }


}

class DemoCoche{

    public static void printMenu(){
        System.out.println("");

        System.out.println("1. Acelerar coche en recta");
        System.out.println("2. Acelerar coche en curva");
        System.out.println("3. Frenar coche en recta");
        System.out.println("4. Frenar coche en curva");
        System.out.println("5. Mejorar coche");
        System.out.println("6. Calcular tiempo en recta");
        System.out.println("7. Calcular tiempo en curva");
        System.out.println("Seleccione la opción que desee:");

    }

    public static void main(String[] args) {

        Coche a = new Coche(20,30);

        System.out.println("Bienvenido");
        while(true){
            printMenu();
            Scanner reader = new Scanner(System.in);
            int opcion = 0;
            opcion = reader.nextInt();

            switch (opcion){
                case 1:
                    a.acelerarRecta();
                    System.out.println("Coche acelerado en recta");
                    break;
                case 2:
                    a.acelerarCurva();
                    System.out.println("Coche acelerado en curva");
                    break;
                case 3:
                    a.frenarRecta();
                    System.out.println("Coche frenado en recta");
                    break;
                case 4:
                    a.frenarCurva();
                    System.out.println("Coche frenado en curva");
                    break;
                case 5:
                    a.mejorar();
                    System.out.println("Coche mejorado");
                    break;
                case 6:
                    System.out.println("Introduzca distancia recta:");
                    reader = new Scanner(System.in);
                    double distanciaR = reader.nextDouble();
                    double tiempoR = a.tiempoRecta(distanciaR);
                    System.out.println("Tiempo en recorrer "+tiempoR);
                    break;
                case 7:
                    System.out.println("Introduzca distancia curva:");
                    reader = new Scanner(System.in);
                    double distanciaC = reader.nextDouble();
                    double tiempoC = a.tiempoCurva(distanciaC);
                    System.out.println("Tiempo en recorrer "+tiempoC);
                    break;
                case 8:
                    double velocidadR, velocidadC;
                    velocidadR = a.getVelocidadRecta();
                    velocidadC = a.getVelocidadCurva();
                    System.out.println("VelocidadRecta "+velocidadR);
                    System.out.println("VelocidadCurva "+velocidadC);
                    break;

            }
        }
    }

}