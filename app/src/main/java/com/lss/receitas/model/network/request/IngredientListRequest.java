package com.lss.receitas.model.network.request;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class IngredientListRequest implements Parcelable {
    public List<String> ingredients;

    public IngredientListRequest(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    protected IngredientListRequest(Parcel in) {
        if (in.readByte() == 0x01) {
            ingredients = new ArrayList<String>();
            in.readList(ingredients, String.class.getClassLoader());
        } else {
            ingredients = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (ingredients == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(ingredients);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<IngredientListRequest> CREATOR = new Parcelable.Creator<IngredientListRequest>() {
        @Override
        public IngredientListRequest createFromParcel(Parcel in) {
            return new IngredientListRequest(in);
        }

        @Override
        public IngredientListRequest[] newArray(int size) {
            return new IngredientListRequest[size];
        }
    };
}
