package TarefadeConjuntos;

import java.util.ArrayList;

public class Conjunto {
    private ArrayList<Object> data;
    
    public Conjunto(ArrayList<Object> data)
    {   
        data.sort(null);
        this.data = data;
    }
    
    public Conjunto(Conjunto conjunto)
    {
        this.data = conjunto.data;
    }
    
    public void add(Object value)
    {
        data.sort(null);
        data.add(value);
    }
    

    public void add(Conjunto value)
    {
        this.data.add(value.data);
    }
    
    public Object get(int index)
    {
        return data.get(index);
    }
    
    public ArrayList<Object> interseccao(Conjunto conjunto)
    {
        ArrayList<Object> inter = new ArrayList<Object>();
        
        for (Object i : data)
        {
            for (Object j : conjunto.data) 
            {
                if(i.equals(j) && !inter.contains(i))
                {
                    inter.add(i);
                }
            }       
        }
        return inter;
    }



    public ArrayList<Object> getData() 
    {
        return data;
    }
}