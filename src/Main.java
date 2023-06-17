import Carrinho.RCadPedido;
import Carrinho.TipoAtendimento;
import Helpers.VerificadorDePedido;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        VerificadorDePedido verificadorDePedido = new VerificadorDePedido();
        RCadPedido[] rCadPedidos = new RCadPedido[10];
        boolean execucao = true;
        float valorTotalDosPedidos = 0f;
        int quantidadeDePedidos = 0;

        while (execucao) {

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
                    if (verificadorDePedido.verificarCheia(rCadPedidos)){
                        System.out.println(verificadorDePedido.listaCheia(rCadPedidos));
                        break;
                    }
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
                    float valorDoPedido = leia.nextFloat();
                    RCadPedido pedido = new RCadPedido.Builder()
                            .nomeCliente(nomeCliente)
                            .tipoAtendimento(escolha)
                            .valorTotal(valorDoPedido)
                            .numeroPedido(numeroDoPedido)
                            .horarioPedido(horarioDoPedido)
                            .build();
                    for (int j = 0; j < rCadPedidos.length; j++) {
                        if (rCadPedidos[j] == null) {
                            rCadPedidos[j] = pedido;
                            System.out.println("---------------------------------------------");
                            System.out.println("Pedido #" + pedido.getNumeroPedido() + " cadastrado");
                            System.out.println("---------------------------------------------");
                            valorTotalDosPedidos += valorDoPedido;
                            quantidadeDePedidos++;
                            break;
                        }
                    }
                    break;
                case 2:
                    if (verificadorDePedido.verificarVazia(rCadPedidos)){
                        System.out.println(verificadorDePedido.listaVazia(rCadPedidos));
                        break;
                    }
                    LocalDateTime horarioMaisAntigo = LocalDateTime.now();
                    int position = 0;
                    for (int j = 0; j < rCadPedidos.length; j++){
                        if (rCadPedidos[j] != null){
                            if (rCadPedidos[j].getHorarioPedido().isBefore(horarioMaisAntigo)){
                                horarioMaisAntigo = rCadPedidos[j].getHorarioPedido();
                                position = j;
                            }
                        }
                    }
                    System.out.println("---------------------------------------------");
                    System.out.println("Pedido mais antigo atendido!");
                    System.out.println("Detalhes do pedido ");
                    System.out.println("Número do pedido: #" + rCadPedidos[position].getNumeroPedido());
                    System.out.println("Nome do cliente: " + rCadPedidos[position].getNomeCliente());
                    System.out.println("Tipo de atendimento: " + rCadPedidos[position].getTipoAtendimento());
                    System.out.println("Valor total: " + rCadPedidos[position].getValorTotal());
                    System.out.println("---------------------------------------------");
                    rCadPedidos[position] = null;
                    break;
                case 3:
                    if (verificadorDePedido.verificarVazia(rCadPedidos)){
                        System.out.println(verificadorDePedido.listaVazia(rCadPedidos));
                        break;
                    }
                    for (int j = 0; j < rCadPedidos.length; j++){
                        if (rCadPedidos[j] != null){
                            System.out.println("---------------------------------------------");
                            System.out.println("Número do pedido: #" + rCadPedidos[j].getNumeroPedido());
                            System.out.println("Nome do cliente: " + rCadPedidos[j].getNomeCliente());
                            System.out.println("Tipo de atendimento: " + rCadPedidos[j].getTipoAtendimento());
                            System.out.println("Valor total: " + rCadPedidos[j].getValorTotal());
                            System.out.println("---------------------------------------------");
                        }
                    }
                    break;
                case 4:
                    if (verificadorDePedido.verificarVazia(rCadPedidos)){
                        System.out.println(verificadorDePedido.listaVazia(rCadPedidos));
                        break;
                    }
                    System.out.print("Digite o número do pedido: #");
                    int pesquisaPedido = leia.nextInt();
                    int pesquisaLista = 0;

                    for (int j = 0; j <  rCadPedidos.length; j++){
                        if (rCadPedidos[j] != null && rCadPedidos[j].getNumeroPedido()==pesquisaPedido){
                            System.out.println("---------------------------------------------");
                            System.out.println("Número do pedido: #" + rCadPedidos[j].getNumeroPedido());
                            System.out.println("Nome do cliente: " + rCadPedidos[j].getNomeCliente());
                            System.out.println("Tipo de atendimento: " + rCadPedidos[j].getTipoAtendimento());
                            System.out.println("Valor total do pedido: R$" + rCadPedidos[j].getValorTotal());
                            System.out.println("---------------------------------------------");
                            break;
                        }else {
                            pesquisaLista++;
                        }
                    }
                    if (pesquisaLista == rCadPedidos.length){
                        System.out.println("Pedido não encontrado. Verifique na opção 3 do menu " +
                                "se é um pedido existente.");
                        break;
                    }
                    break;
                case 5:
                    if (verificadorDePedido.verificarVazia(rCadPedidos)){
                        System.out.println("---------------------------------------------");
                        System.out.println("Programa encerrado.");
                        System.out.println("A quantidade de pedidos atendidos foi de: " + quantidadeDePedidos
                                + " pedidos.");
                        System.out.println("Valor total dos pedidos de hoje: R$" + valorTotalDosPedidos);
                        System.out.println("---------------------------------------------");
                        execucao = false;
                    }else {
                        System.out.println("Ainda existem pedidos a serem atendidos. " +
                                "Não foi possível encerrar o programa.");
                        break;
                    }
                    break;
                default:
                    System.out.print("Opção inválida. Escolha uma das oções acima: ");
                    opcaoMenu = leia.nextInt();
            }
        }
    }
}