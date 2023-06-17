package Carrinho;

import java.time.LocalDateTime;

public class RCadPedido {
    private int numeroPedido;
    private TipoAtendimento tipoAtendimento;
    private String nomeCliente;
    private float valorTotal;
    private LocalDateTime horarioPedido;

    private RCadPedido(Builder builder) {
        this.numeroPedido = builder.numeroPedido;
        this.tipoAtendimento = builder.tipoAtendimento;
        this.nomeCliente = builder.nomeCliente;
        this.valorTotal = builder.valorTotal;
        this.horarioPedido = builder.horarioPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public float getValorTotal() {
        return valorTotal;
    }
    public LocalDateTime getHorarioPedido(){
        return horarioPedido;
    }

    public static class Builder {
        private int numeroPedido;
        private TipoAtendimento tipoAtendimento;
        private String nomeCliente;
        private float valorTotal;
        private LocalDateTime horarioPedido;

        public Builder numeroPedido(int numeroPedido) {
            this.numeroPedido = numeroPedido;
            return this;
        }

        public Builder tipoAtendimento(TipoAtendimento tipoAtendimento) {
            this.tipoAtendimento = tipoAtendimento;
            return this;
        }

        public Builder nomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
            return this;
        }

        public Builder valorTotal(float valorTotal) {
            this.valorTotal = valorTotal;
            return this;
        }
        public Builder horarioPedido(LocalDateTime horarioPedido){
            this.horarioPedido = horarioPedido;
            return this;
        }

        public RCadPedido build() {
            return new RCadPedido(this);
        }

    }
}