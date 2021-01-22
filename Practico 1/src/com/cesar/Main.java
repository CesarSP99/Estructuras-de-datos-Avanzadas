package com.cesar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ///Entrada estatica

        //Ej 1
        System.out.println(digitoMayor(4956876));
        //Ej 2
        System.out.println(sumaSerie(3));
        //Ej 3
        System.out.println(estaOrdenado(new int[]{3, 2, 4, 5}, 4));
        System.out.println(estaOrdenado(new int[]{1, 3, 4, 8, 10}, 5));
        //Ej 4
        //Probando funcion de primos
//        System.out.println(esPrimo(19, 2));
//        System.out.println(esPrimo(31, 2));
//        System.out.println(esPrimo(84, 2));
//        System.out.println(esPrimo(999, 2));
        //Ej 5
        System.out.println(sumarPrimos(new int[]{6, 4, 8, 10}, 4));
        System.out.println(sumarPrimos(new int[]{1, 13, 19, 2, 5, 6}, 6));
        System.out.println(promedioEnRango(new int[]{1, 2, 3, 4, 5}, 2, 4));
        System.out.println(promedioEnRango(new int[]{1, 2, 3, 4, 5}, 2, 3));

        ///Entranda dinamica

//        Scanner scanner = new Scanner(System.in);
//        int n;
//        int arr[];
//        //Ej 1
//        n = scanner.nextInt();
//        System.out.println(digitoMayor(n));
//        //Ej 2
//        n = scanner.nextInt();
//        System.out.println(sumaSerie(n));
//        //Ej 3
//        n = scanner.nextInt();
//        arr = new int[n];
//        for(int i = 0; i < n; i++)
//            arr[i] = scanner.nextInt();
//        System.out.println(estaOrdenado(arr, n));
//        //Ej 4
//        n = scanner.nextInt();
//        arr = new int[n];
//        for(int i = 0; i < n; i++)
//            arr[i] = scanner.nextInt();
//        System.out.println(sumarPrimos(arr, n);
//        //Ej 5
//        int x;
//        int y;
//        n = scanner.nextInt();
//        x = scanner.nextInt();
//        y = scanner.nextInt();
//        arr = new int[n];
//        for(int i = 0; i < n; i++)
//            arr[i] = scanner.nextInt();
//        System.out.println(promedioEnRango(arr, x, y));
    }

    public static int digitoMayor(int n){
        if (n == 0)
            return 0;
        if(n % 10 > digitoMayor(n/10))
            return n % 10;
        else
            return digitoMayor(n/10);
    }

    public static int factorial(int num){
        if (num == 0)
            return 1;
        else {
            return num * factorial(num - 1);
        }
    }

    public static int pow(int base, int exp){
        if (exp == 0)
            return 1;
        else {
            return base * pow(base, exp - 1);
        }
    }

    public static double sumaSerie(int n){
        if (n == 0)
            return 0;
        else
            return ( (double) factorial(n) / (double) pow(n, 2) ) + sumaSerie(n-1);
    }

    public static boolean estaOrdenado(int[] arr, int n){
        if(n == 0 || n == 1)
            return true;
        else {
            if(arr[n - 2] <= arr[n - 1])
                return estaOrdenado(arr, n - 1);
            else
                return false;
        }
    }

    public static boolean esPrimo(int n, int i) {
        if(n <= 2) {
            if(n == 2)
                return true;
            else
                return false;
        }
        if(i * i > n)
            return true;
        if(n % i == 0)
            return false;
        return esPrimo(n,i+1);
    }

    public static int sumarPrimos(int arr[], int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return esPrimo(arr[0], 2) ? arr[0] : 0;
        if(esPrimo(arr[n-1], 2))
            return arr[n-1] + sumarPrimos(arr, n-1);
        return sumarPrimos(arr, n-1);
    }

    public static double sumaConRangos(int arr[], int n, int m) {
        if(n > m)
            return 0;
        if (m == n)
            return arr[n];
        return arr[m] + sumaConRangos(arr, n, m - 1);
    }

    public static double promedioEnRango(int arr[], int n, int m){
        if(n > m)
            return 0;
        return sumaConRangos(arr, n, m) / (m - n + 1);
    }

}
