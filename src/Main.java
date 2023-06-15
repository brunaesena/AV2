import Carrinho.RCadPedido;
import Carrinho.TipoAtendimento;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        RCadPedido[] rCadPedidos = new RCadPedido[10];
        boolean encerrar = true;
        while (encerrar) {

            System.out.println("###### LANCHONETE######");
            System.out.println("# 1 –INCLUIR PEDIDO   #");
            System.out.println("# 2 -ATENDER PEDIDO   #");
            System.out.println("# 3 -LISTAR PEDIDOS   #");
            System.out.println("# 4– PESQUISAR PEDIDO #");
            System.out.println("# 5– ENCERRAR         #");
            System.out.println("#######################");
            System.out.print("Escolha uma opção: ");
            int opcaoMenu = leia.nextInt();

            switch (opcaoMenu) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = leia.next();
                    System.out.print("Esolha o tipo de atendiemnto (1- Presencial, 2- Delivery): ");
                    int tipoAtendimento = leia.nextInt();
                    TipoAtendimento escolha = null;
                    if (tipoAtendimento == TipoAtendimento.DELIVERY.getCodigo()) {
                        escolha = TipoAtendimento.DELIVERY;
                    } else {
                        escolha = TipoAtendimento.PRESENCIAL;
                    }
                    LocalDateTime horarioDoPedido = LocalDateTime.now();
                    Random numeroAleatorio = new Random();
                    int numeroDoPedido = numeroAleatorio.nextInt(10000);
                    System.out.print("Digite o valor total do pedido: ");
                    float valorTotalDoPedido = leia.nextFloat();
                    RCadPedido pedido = new RCadPedido.Builder()
                            .nomeCliente(nomeCliente)
                            .tipoAtendimento(escolha)
                            .valorTotal(valorTotalDoPedido)
                            .numeroPedido(numeroDoPedido)
                            .horarioPedido(horarioDoPedido)
                            .build();
                    for (int j = 0; j < 10; j++) {
                        if (rCadPedidos[j] == null) {
                            rCadPedidos[j] = pedido;
                            System.out.println("Pedido cadastrado");
                            break;
                        } else {
                            System.out.println("Fila Cheia – Não Pode Mais Incluir Pedidos");
                        }
                    }
                    break;
                case 2:
                    LocalDateTime horarioMaisAntigo = LocalDateTime.now();
                    int position = 0;
                    int pedidoVazio1 = 0;
                    for (int j = 0; j < 10; j++){
                        if (rCadPedidos[j] != null){
                            if (rCadPedidos[j].getHorarioPedido().isBefore(horarioMaisAntigo)){
                                horarioMaisAntigo = rCadPedidos[j].getHorarioPedido();
                                position = j;
                            }
                        }else {
                            pedidoVazio1++;
                        }
                    }
                    rCadPedidos[position] = null;
                    if (pedidoVazio1 == rCadPedidos.length){
                        System.out.println("Lista Vazia – Não Existem Pedidos");
                    }

                    break;
                case 3:
                    int pedidoVazio = 0;
                    for (int j = 0; j <10; j++){
                        if (rCadPedidos[j] != null){
                            System.out.println("---------------------------------------------");
                            System.out.println(rCadPedidos[j].getNumeroPedido());
                            System.out.println(rCadPedidos[j].getNomeCliente());
                            System.out.println(rCadPedidos[j].getTipoAtendimento());
                            System.out.println(rCadPedidos[j].getValorTotal());
                            System.out.println("---------------------------------------------");
                        }else {
                            pedidoVazio++;
                        }
                    }
                    if (pedidoVazio == 10){
                        System.out.println("Lista Vazia – Não Existem Pedidos");
                    }
                    break;
                case 4:
                    int pedidoVazio3 = 0;
                    for (int j =0; j <  rCadPedidos.length; j++){
                        if (rCadPedidos[j] == null){
                            pedidoVazio3++;
                        }
                    }
                    if (pedidoVazio3 == rCadPedidos.length){
                        System.out.println("Lista Vazia – Não Existem Pedidos");
                        break;
                    }
                    System.out.print("Digite o número do pedido: ");
                    int pesquisaPedido = leia.nextInt();

                    for (RCadPedido element:
                         rCadPedidos) {
                        if (element.getNumeroPedido()==pesquisaPedido){
                            System.out.println(element.getNumeroPedido());
                            System.out.println(element.getNomeCliente());
                            System.out.println(element.getTipoAtendimento());
                            System.out.println(element.getValorTotal());
                            break;
                        }else {
                            System.out.println("Pedido não encontrado. Verifique na opção 3 do menu " +
                                    "se é um pedido existente.");
                            break;
                        }
                    }
                    break;
                case 5:
                    int pedidoVazio4 = 0;
                    for (int j =0; j <  rCadPedidos.length; j++){
                        if (rCadPedidos[j] == null){
                            pedidoVazio4++;
                        }
                    }
                    if (pedidoVazio4 != rCadPedidos.length){
                        System.out.println("Ainda existem pedidos a serem atendidos. " +
                                "Não foi possível encerrar o programa.");
                        break;
                    }else {
                        encerrar = false;
                    }
                    break;
            }
        }
    }
}