package Pilha;

import java.util.Scanner;

public class View{

  public static void equacao(){
    Bean vetor = new Bean(25);
    Scanner output = new Scanner(System.in);
    System.out.println("Digite uma operação matematica");
    String operacao = output.nextLine();
    vetor.logicaJogo(operacao);
    System.out.println(vetor.verificaOrtografia() ? "Equação bem formada" : "Equação mal formada");
    vetor.desempilhar(operacao);
  }
}