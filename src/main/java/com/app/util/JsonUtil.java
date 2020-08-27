package com.app.util;

import java.lang.reflect.Type;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {

	public static String toJsonStr(Object obj) {
		Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
		return gson.toJson(obj);
	}

	public Collection<Integer> st(String json) {
		Type collectionType = new TypeToken<Collection<Integer>>() {
		}.getType();
		Gson gson = new Gson();
		Collection<Integer> array = gson.fromJson(json, collectionType);
		return array;
	}

}
