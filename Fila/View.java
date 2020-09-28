package Fila;

import java.util.Scanner;

public class View {

  public static void impressao(){
    Bean imprimir = new Bean(25);
    Scanner output = new Scanner(System.in);
    digitaTresVezes(output, imprimir);
    imprimir.imprimirTudo();
  }

  public static void digitaTresVezes(Scanner output, Bean imprimir) {
    for(int i = 0; i <= 2;i++){
      entrada();
      int operacao = output.nextInt();
      imprimir.enqueue(operacao);
    }
  }

  private static void entrada(){
    System.out.println("############################");
    System.out.print("Digite um numero de 0 a 2000: ");
  }
}
