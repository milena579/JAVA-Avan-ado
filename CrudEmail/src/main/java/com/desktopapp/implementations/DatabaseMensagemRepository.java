package com.desktopapp.implementations;

import com.desktopapp.Context;
import com.desktopapp.model.MensagemData;
import com.desktopapp.repositories.MensagemRepository;

public class DatabaseMensagemRepository implements MensagemRepository{
    // @Override 
    // public void view(MensagemData produto){
    //     Context ctx = new Context();
    //     ctx.begin();
    //     ctx.update(produto);
    //     ctx.commit();
    // }

    @Override 
    public void delete(MensagemData produto){
        Context ctx = new Context();
        ctx.begin();
        ctx.delete(produto);
        ctx.commit();
    }
}
