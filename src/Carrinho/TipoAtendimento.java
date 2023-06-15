package Carrinho;

public enum TipoAtendimento {
    PRESENCIAL(1, "Presencial"),
    DELIVERY(2, "Delivery");

    private int codigo;
    private String atendimento;

    private TipoAtendimento(int codigo, String atendimento) {
        this.codigo = codigo;
        this.atendimento = atendimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getAtendimento() {
        return atendimento;
    }
}
