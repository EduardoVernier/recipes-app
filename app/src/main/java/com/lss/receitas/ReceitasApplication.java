package com.lss.receitas;

import android.app.Application;

import com.lss.receitas.model.network.RetrofitManager;

public class ReceitasApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		RetrofitManager.init(this);
	}

}
