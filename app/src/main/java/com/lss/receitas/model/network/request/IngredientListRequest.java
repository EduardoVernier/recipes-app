package com.lss.receitas.model.network.request;

import java.util.List;

public class IngredientListRequest {
    List<String> ingredients;

    public IngredientListRequest(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}