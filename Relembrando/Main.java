package Relembrando;
//relembrando Java

public class Main {
    public static void main(String[] args) {
        System.err.println("Hello world!");

        Pessoa pessoa = new Pessoa("Milena", Time.now());
        System.err.println(pessoa.getNome());

        Time time = new Time(150);
        System.err.println(time.getSeconds());

        Collection<Pessoa> pessoas = new ArrayList<>();
        
        
        pessoas.add(pessoa);
    }
}