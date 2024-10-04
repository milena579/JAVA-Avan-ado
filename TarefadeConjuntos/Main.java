package TarefadeConjuntos;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {

        //Cria as datas(ArrayLists)
        ArrayList<Object> data1 = new ArrayList<>();
        ArrayList<Object> data2 = new ArrayList<>();
        ArrayList<Object> data3 = new ArrayList<>();
        ArrayList<Object> data4 = new ArrayList<>();
        ArrayList<Object> teste = new ArrayList<>();

        //Adiciona numeros nas datas(ArraysList)
        for (int i = 9; i >= 0; i--) {
            data1.add(i);
        }

        for (int i = 9; i >= 0; i--) {
            teste.add(i);
        }
        teste.add(9);
        

        for (int i = 3; i < 10; i++) {
            data2.add(i);
        }

        for (int i = 4; i < 15; i++) {
            data3.add(i);
        }

        for (int i = 7; i < 20; i++) {
            data4.add(i);
        }

        //Adiciona uma data(ArrayList) dentro de outra

       //Cria dois conjuntos com suas datas
        Conjunto conjunto1 = new Conjunto(data1);
        Conjunto conjunto2 = new Conjunto(data2);

        Conjunto conjunto3 = new Conjunto(data3);
        Conjunto conjunto4 = new Conjunto(data4);


        //Adiciona um conjunto dentro do outro
        conjunto2.add(conjunto1);
        conjunto4.add(teste);

        //printa a data do conjunto2
        System.out.println(conjunto2.getData());
        System.out.println(conjunto4.getData());
        System.out.println(conjunto2.interseccao(conjunto4));



    }
}
