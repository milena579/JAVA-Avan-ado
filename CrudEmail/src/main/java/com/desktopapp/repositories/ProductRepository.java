package com.desktopapp.repositories;

import com.desktopapp.model.ProdutoData;

public interface ProductRepository {
    void update(ProdutoData produto);
    void delete(ProdutoData produto);
}
