package Helpers;


import Carrinho.RCadPedido;


public class VerificadorDePedido {

    public String listaVazia (RCadPedido[] rCadPedido){
        String retornoListaVazia = null;
        int pedidoVazio = 0;
        for (int i = 0; i < rCadPedido.length; i++){
            if (rCadPedido[i] == null){
                pedidoVazio++;
            }
        }
        if (pedidoVazio == rCadPedido.length){
             retornoListaVazia = "Lista Vazia – Não Existem Pedidos";
        }
        return retornoListaVazia;

    }

    public boolean verificarVazia (RCadPedido[] rCadPedidos){
        boolean reponse = true;
        if (listaVazia(rCadPedidos) == null){
            reponse = false;
        }
        return reponse;
    }

    public String listaCheia(RCadPedido[] rCadPedidos){
        int pedidoCheio = 0;
        String retornoListaCheia = null;
        for (int i = 0; i < rCadPedidos.length; i++){
            if (rCadPedidos[i] != null){
                pedidoCheio++;
            }
        }
        if (pedidoCheio == rCadPedidos.length){
            retornoListaCheia = "Fila Cheia – Não Pode Mais Incluir Pedidos";
        }
        return retornoListaCheia;
    }
    public boolean verificarCheia (RCadPedido[] rCadPedidos){
        boolean reponse = true;
        if (listaCheia(rCadPedidos) == null ){
            reponse = false;
        }
        return reponse;
    }

}

