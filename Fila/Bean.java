package Fila;

public class Bean {
  int comeco, fim, qtd;
  int [] vetor;

  public Bean(int tamanho){
    comeco = 0;
    fim = comeco;
    qtd = 0;
    vetor = new int [tamanho];
  }

  public boolean isFull(){
    return (this.qtd ==  this.vetor.length - 1);
  }

  public boolean isEmpty(){
    return (this.qtd == 0);
  }

  public void enqueue(int novoElemento){
    if (!isFull()){
      filaImprimir(novoElemento);
      vetor[fim] = novoElemento;
      fim++;
      qtd++;
    }else{
      fim = 0;
    }
  }

  public int dequeue(){
    if(!isEmpty()){
      verificaNumero(vetor[comeco]);
      int valorAntigo = vetor[comeco];
      vetor[comeco] = -1;
      qtd--;
      if (!isFull()) comeco++;
      return valorAntigo;
    }
    return 0;
  }

  private void verificaNumero(int novoElemento){
    System.out.println(novoElemento<=1000 ? "imprimindo o arquivo: "+novoElemento : "o seguinte arquivo está corrompido: "+novoElemento );
  }

  private void filaImprimir(int novoElemento){
    System.out.println("############################");
    System.out.println("arquivo " + novoElemento + " na fila para impressao");
  }

  public void imprimirTudo(){
    for (int i = 0; i <= fim -1; i++){
      dequeue();
    }
  }

  public void tamanhoFila(){
    System.out.println("A fila tem "+fim+" arquivos");
    System.out.println("############################");
  }
}