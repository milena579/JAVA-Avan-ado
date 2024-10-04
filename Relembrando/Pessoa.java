package Relembrando;
public class Pessoa {
    private String nome;
    public Time birth;

    public Pessoa (String nome, Time birth){
        this.nome = nome;
        this.birth = birth;
    }

    public Time getBirth(){
        return birth;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
