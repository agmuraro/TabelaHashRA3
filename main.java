import java.util.Random;

public class main {
    public static Registro[] gerarRegistros(int numGen) {
        Registro[] temp = new Registro[numGen];
        int i = 0;
        Random random = new Random(12345);
        while (i < temp.length) {
            int ran = random.nextInt(100000000, 999999999);
            Registro tempReg = new Registro(String.valueOf(ran));
            temp[i] = tempReg;
            i++;
        }
        return temp;
    }

    public static long medirTempoInser(HashMap hashMap, Registro[] setObjetos) {
        long tempoInicio = System.currentTimeMillis();
        for (Registro setObjeto : setObjetos) {
            hashMap.inserir(setObjeto);
        }
        long tempoFim = System.currentTimeMillis();
        long duracao = tempoFim - tempoInicio;
        System.out.println("O tempo gasto foi " + duracao + "ms");
        return duracao;
    }

    public static long medirTempoBusca(HashMap hashMap, Registro[] setObjetos) {
        long tempoInicio = System.currentTimeMillis();
        Random random = new Random();
        int temp = random.nextInt(setObjetos.length);
        hashMap.buscar(setObjetos[temp].getChave());
        long tempoFim = System.currentTimeMillis();
        long duracao = tempoFim - tempoInicio;
        System.out.println("O tempo gasto foi " + duracao + "ms");
        return duracao;
    }

    public static void printColi(HashMap hashMap) {
        System.out.println(hashMap.getNumColisoes());
    }

    public static void limparTabela(HashMap hashMap) {
        hashMap.limparLista();
    }

    public static void main(String[] args) {
        HashMap Primeira = new HashMap(50);
        HashMap Segunda = new HashMap(500);
        HashMap Terceira = new HashMap(5000);
        HashMap Quarta = new HashMap(50000);
        HashMap Quinta = new HashMap(500000);

        Registro[] conjVinte = gerarRegistros(20000);
        Registro[] conjCem = gerarRegistros(100000);
        Registro[] conjQuinhentos = gerarRegistros(500000);
        Registro[] conj1kk = gerarRegistros(1000000);
        Registro[] conj5kk = gerarRegistros(5000000);

        System.out.println("Tempo de Execução da Inserção utilizando Divisão de hash");
        // Hash de Divisão
        medirTempoInser(Primeira, conjVinte);
        medirTempoInser(Segunda, conjCem);
        medirTempoInser(Terceira, conjQuinhentos);
        medirTempoInser(Quarta, conj1kk);
        medirTempoInser(Quinta, conj5kk);

        System.out.println("Tempo de Execução da Busca Divisão de hash");
        medirTempoBusca(Primeira, conjVinte);
        medirTempoBusca(Segunda, conjCem);
        medirTempoBusca(Terceira, conjQuinhentos);
        medirTempoBusca(Quarta, conj1kk);
        medirTempoBusca(Quinta, conj5kk);

        printColi(Primeira);
        printColi(Segunda);
        printColi(Terceira);
        printColi(Quarta);
        printColi(Quinta);

        limparTabela(Primeira);
        limparTabela(Segunda);
        limparTabela(Terceira);
        limparTabela(Quarta);
        limparTabela(Quinta);

        System.out.println("Tempo de Execução da Inserção utilizando Multiplicação de hash");
        // Hash de Multiplicação
        medirTempoInser(Primeira, conjVinte);
        medirTempoInser(Segunda, conjCem);
        medirTempoInser(Terceira, conjQuinhentos);
        medirTempoInser(Quarta, conj1kk);
        medirTempoInser(Quinta, conj5kk);

        System.out.println("Tempo de Execução da Busca utilizando Multiplicação de hash");
        medirTempoBusca(Primeira, conjVinte);
        medirTempoBusca(Segunda, conjCem);
        medirTempoBusca(Terceira, conjQuinhentos);
        medirTempoBusca(Quarta, conj1kk);
        medirTempoBusca(Quinta, conj5kk);

        printColi(Primeira);
        printColi(Segunda);
        printColi(Terceira);
        printColi(Quarta);
        printColi(Quinta);

        limparTabela(Primeira);
        limparTabela(Segunda);
        limparTabela(Terceira);
        limparTabela(Quarta);
        limparTabela(Quinta);

        System.out.println("Tempo de Execução da Inserção utilizando Adição de Bytes de Chave para Hash");
        // Hash de Adição de Bits
        medirTempoInser(Primeira, conjVinte);
        medirTempoInser(Segunda, conjCem);
        medirTempoInser(Terceira, conjQuinhentos);
        medirTempoInser(Quarta, conj1kk);
        medirTempoInser(Quinta, conj5kk);

        System.out.println("Tempo de Execução da Busca utilizando Adição de Bytes de Chave para Hash");
        medirTempoBusca(Primeira, conjVinte);
        medirTempoBusca(Segunda, conjCem);
        medirTempoBusca(Terceira, conjQuinhentos);
        medirTempoBusca(Quarta, conj1kk);
        medirTempoBusca(Quinta, conj5kk);

        printColi(Primeira);
        printColi(Segunda);
        printColi(Terceira);
        printColi(Quarta);
        printColi(Quinta);
    }
}
