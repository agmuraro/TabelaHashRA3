public class HashMap {
    private int tamanho;
    private String funcaoHash;
    private Lista[] tabela;
    private int numColisoes;
    private int numComparacoes; // Adicione esta variável para rastrear as comparações

    public HashMap(int tamanho) {
        this.tamanho = tamanho;
        this.funcaoHash = "divisao"; // Pode definir a função de hash padrão aqui
        this.tabela = new Lista[tamanho];
        this.numColisoes = 0;
        this.numComparacoes = 0; // Inicialize o contador de comparações
    }

    public void inserir(Registro registro) {
        int indice = Math.abs(calcularIndice(registro.getCodigo())) % tamanho;

        if (tabela[indice] == null) {
            tabela[indice] = new Lista();
        }

        tabela[indice].inserir(registro);
    }


    public Registro buscar(String codigo) {
        int indice = calcularIndice(codigo);

        if (tabela[indice] == null) {
            return null;
        }

        numComparacoes++;
        return tabela[indice].buscar(codigo);
    }

    private int calcularIndice(String codigo) {
        // Implemente a função de hash escolhida, por exemplo:
        if (funcaoHash.equals("RestoDivisao")) {
            return Math.abs(codigo.hashCode()) % tamanho;
        } else if (funcaoHash.equals("Multiplicacao")) {
            double A = 0.6180339887; // Constante multiplicativa sugerida
            double produto = codigo.hashCode() * A;
            return (int) (tamanho * (produto - Math.floor(produto)));
        } else if (funcaoHash.equals("Subtracao")) {
            int valorHash = 0;
            for (int i = 0; i < codigo.length(); i++) {
                valorHash -= codigo.charAt(i);
            }
            return Math.abs(valorHash) % tamanho;
        }

        return -1; // Função de hash desconhecida
    }

    public int getNumColisoes() {
        return numColisoes;
    }

    public int getNumComparacoes() {
        return numComparacoes;
    }

    public void limparLista() {
        tabela = new Lista[tamanho];
        numColisoes = 0;
        // Inicialize a tabela e o contador de colisões novamente
    }
}







