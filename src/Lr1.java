import java.util.*;
import java.io.*;


class Lr1 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double m = 0;
        int N = 0;
        while(true) {
            System.out.println("Введите значение переменной m");
            try {
                m = Double.parseDouble(br.readLine());
                break;
            } catch (Exception ex) {
                System.out.println("Неверный формат числа");
            }
        }
        calculation(m);
        System.out.println();

        while(true) {
            System.out.println("Введите целое значение переменной N > 0");
            try {
                N = Integer.parseInt(br.readLine());
                if (N < 0) {
                    System.out.println("Число должно быть положительным!");
                    continue;
                } else {
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Неверный формат числа");
            }
        }
        massProc(N);
    }

    public static void calculation(double m) {
        double a;
        double b;
        double c;
        for (double d=0; d<=3; d++) {
            for (double t=0; t<=4; t+=0.5) {
                if ((t>1)&&(d>1)&&(d>t)) {
                    a = Math.log(t+d*d);
                } else if (t>1) {
                    a = Math.sqrt(t*d);
                } else {
                    a = t*t*d;
                }
                c = 3 * m - (Math.log(Math.pow(a,2) - d)) / (Math.pow(a,3) - d);
                b = 0.25 * Math.pow(a,2) + Math.pow(c,m);
                System.out.print("При d = " + d + "; t = " + t + ":    a = " + a);
                if (b!=b) {
                    System.out.print("   b - не вычисляется");
                } else {
                    System.out.print("   b = " + b);
                }
                if (c!=c) {
                    System.out.println("   c - не вычисляется");
                } else {
                    System.out.println("   c = " + c);
                }
            }
        }
    }

    public static void massProc(int N) {
        int[][] mass = new int[N+15][N+15];
        int temp = 0;
        for (int i=0; i<mass.length; i++) {
            for (int j=0; j<mass[i].length; j++) {
                mass[i][j] = (int)(Math.random()*((N+15+1)-(-N-15))+(-N-15));
            }
        }
        System.out.println("Полученный массив:");
        for (int i=0; i<mass.length; i++) {
            for (int j=0; j<mass[i].length; j++) {
                System.out.format("%-3d         ", mass[i][j]);
            }
            System.out.println();
        }
        //sort
        for (int i=1; i<mass.length; i+=2) {
            for (int j=0; j<mass[i].length; j++) {
                for (int z=0; z<mass[i].length-j-1; z++) {
                    if (mass[z][i]>mass[z+1][i]) {
                        temp = mass[z][i];
                        mass[z][i] = mass[z+1][i];
                        mass[z+1][i] = temp;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Отсортированный массив:");
        for (int i=0; i<mass.length; i++) {
            for (int j=0; j<mass[i].length; j++) {
                System.out.format("%-3d         ", mass[i][j]);
            }
            System.out.println();
        }
    }
}