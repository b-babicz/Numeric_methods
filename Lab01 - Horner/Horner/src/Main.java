import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        int pierw;
        System.out.println("Wprowadź stopień wielonianu");
        n = sc.nextInt();
        int[] wielomian = new int[n+1];
        int[] wielomian2 = new int[n+1];
        System.out.println();
        System.out.println("Podaj współczyniki wielomianu: ");
        for (int i = 0; i < n+1; i++)
        {
            System.out.println("Wprowadź "+(i+1)+" współczynnik wielomianu");
            wielomian[i]= sc.nextInt();
            if (wielomian[0]==0)
            {
                System.out.println("Błąd!");
                return;
            }
        }
        System.out.println();
        System.out.println("Podaj element (a) dwumianu (x+a) przez, który dokonujemy podziału: ");
        pierw = sc.nextInt();
        for (int i = 0; i < n+1; i++)
        {
            if (i==0)
            {
                wielomian2[i]=wielomian[i];
            }
            else
            {
                wielomian2[i] = (wielomian2[i-1]*pierw)+wielomian[i];
            }
        }

        System.out.println();
        System.out.println("Współczynnikami powstałego wielomianu są: ");
        int xp = n-1;
        for(int i = 0; i < n+1; i++,xp--)
        {
            if(i < n-1){
                if(i == 0 && wielomian2[0] >= 0 && wielomian2[0]!= 1){
                    System.out.print(wielomian2[i]+ "x^"+xp);
                    continue;
                }else if(i == 0 && wielomian2[0] == 1){
                    System.out.print("x^"+xp);
                    continue;
                }
                if(wielomian2[i]<0){
                    System.out.print(wielomian2[i] + "x^"+xp);
                }else{
                    System.out.print("+"+wielomian2[i] + "x^"+xp);
                }
            }else if( i == n-1){
                if(wielomian2[i] >0){
                    System.out.print("+"+wielomian2[i] + "");
                }
                else if (wielomian2[i]==0)
                {
                    System.out.print("+"+wielomian2[i] + " ");
                }
                else{
                    System.out.print(wielomian2[i]+ " ");
                }
            }else if( i == n && pierw>0){
                System.out.print("Reszta: " + wielomian2[i]+ "/x+"+pierw);
            }
            else if( i == n && pierw<0){
                System.out.print("Reszta: " + wielomian2[i]+ "/x"+pierw);
            }
        }
    }
}