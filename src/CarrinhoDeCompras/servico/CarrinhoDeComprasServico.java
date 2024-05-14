package CarrinhoDeCompras.servico;

import CarrinhoDeCompras.dominio.CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeComprasServico {

    private List<CarrinhoDeCompras> listaCompras;

    public CarrinhoDeComprasServico() {
        this.listaCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        listaCompras.add(new CarrinhoDeCompras(nome, preco, quantidade));
    }

   public void removerUmItem(String nome) {
       for (CarrinhoDeCompras compras : listaCompras) {
           if (compras.getNome().equalsIgnoreCase(nome)) {
               if (compras.getQuantidade() > 1) {
                   compras.setQuantidade(compras.getQuantidade() - 1);
               } else {
                   removerTodosItens(nome);
               }
               return;
           }
       }
   }

        public void removerTodosItens (String nome){
            List<CarrinhoDeCompras> comprasParaRemover = new ArrayList<>();
            if(!listaCompras.isEmpty()) {
                for (CarrinhoDeCompras compras : listaCompras) {
                    if (compras.getNome().equalsIgnoreCase(nome)) {
                        comprasParaRemover.add(compras);
                    }
                }
                listaCompras.removeAll(comprasParaRemover);
            }

        }


            public void exibirItens () {
                for (CarrinhoDeCompras c : listaCompras) {
                    System.out.println(c);
                }
            }


            public static void main (String[]args){
                CarrinhoDeComprasServico servico = new CarrinhoDeComprasServico();

                servico.adicionarItem("mouse", 12.50, 4);
                servico.adicionarItem("teclado", 19.99, 10);
                servico.adicionarItem("jogo", 19.99, 1);

                servico.exibirItens();

               servico.removerUmItem("teclado");
               servico.removerTodosItens("mouse");
               servico.removerUmItem("jogo");

                System.out.println("------------");
                servico.exibirItens();
            }


        }


