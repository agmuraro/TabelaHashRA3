class Lista {
    private Registro primeiro;

    public void inserir(Registro registro) {
        if (primeiro == null) {
            primeiro = registro;
        } else {
            Registro atual = primeiro;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(registro);
        }
    }

    public Registro buscar(String codigo) {
        Registro atual = primeiro;

        while (atual != null) {
            if (atual.getCodigo().equals(codigo)) {
                return atual;
            }
            atual = atual.getProximo();
        }

        return null;
    }
}
