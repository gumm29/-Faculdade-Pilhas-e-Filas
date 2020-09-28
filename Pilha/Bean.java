package Pilha;

public class Bean{
  char[] letras;
  int[] abreParenteses, fechaParenteses;
  int contador;
  int verificacao, contadorVerificador, contaAbreParenteses, contaFechaParenteses = 0;

  public Bean(final int limite){
    letras = new char[limite];
    abreParenteses = new int[limite];
    fechaParenteses = new int[limite];
    contador = -1;
  }

  public void push(char novaLetra){
    if (!isFull()){
      contador++;
      letras[contador] = novaLetra;
    }else{
      System.err.println("Pilha cheia");
    }
  }

  public void pop(){
    if (!isEmpty()){
      letras[contador] = ' ';
      contador--;
    }else{
      System.err.println("Pilha vazia");
    }
  }

  public boolean isEmpty(){
    return contador == -1;
  }

  public boolean isFull(){
    return contador == letras.length -1;
  }

  public void peek(){
    System.out.println(letras[contador]);
  }

  public boolean verificacaoAbrir(){
    if (letras[contador] == '('){
      abreParenteses[contaAbreParenteses] = contador;
      contadorVerificador = contador;
      verificacao++;
      contaAbreParenteses++;
      return true;
    }
    return false;
  }

  public boolean verificacaoFechar(){
    if (letras[contador] == ')'){
      fechaParenteses[contaFechaParenteses] = contador;
      verificacao--;
      contaFechaParenteses++;
      return true;
    }
    return false;
  }

  public boolean verificaOrtografia(){
    return (contaAbreParenteses == contaFechaParenteses && verificacao == 0) ? verificaLogica() : false;
  }

  public boolean verificaLogica(){
    for(int i = 0; i <= contaAbreParenteses -1; i++){
      if (abreParenteses[i] > fechaParenteses[i]) return false;
    }
    return true;
  }

  public void logicaJogo(String operacao){
    for(int i=0; i <= operacao.length() -1; i++){
      this.push(operacao.charAt(i));
      this.verificacaoAbrir();
      this.verificacaoFechar();
    }
  }

  public void desempilhar(String operacao){
    for(int i = operacao.length() -1; i >= 0 ; i--){
      this.pop();
    }
  }
}