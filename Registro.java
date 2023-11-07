class Registro {
    private String codigo;
    private Registro proximo;

    public Registro(String codigo) {
        this.codigo = codigo;
        this.proximo = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public Registro getProximo() {
        return proximo;
    }

    public void setProximo(Registro proximo) {
        this.proximo = proximo;
    }

    public String getChave() {
        return codigo;
    }
}
