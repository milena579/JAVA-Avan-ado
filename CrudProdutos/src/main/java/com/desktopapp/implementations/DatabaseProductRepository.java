package com.desktopapp.implementations;

import com.desktopapp.model.ProdutoData;
import com.desktopapp.Context;
import com.desktopapp.repositories.ProductRepository;

public class DatabaseProductRepository implements ProductRepository{
    @Override 
    public void update(ProdutoData produto){
        Context ctx = new Context();
        ctx.begin();
        ctx.update(produto);
        ctx.commit();
    }

    @Override 
    public void delete(ProdutoData produto){
        Context ctx = new Context();
        ctx.begin();
        ctx.delete(produto);
        ctx.commit();
    }
}
