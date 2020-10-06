package com.app.util;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {

	/**
	 *  日期反序列化
	 * @return
	 */
	public static Gson getGson() {
		Gson gson = new GsonBuilder()
		.registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
			@Override
			public LocalDateTime deserialize(JsonElement json, Type type,
					JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
				String datetime = json.getAsJsonPrimitive().getAsString();
				return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			}
		}).registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
			@Override
			public LocalDate deserialize(JsonElement json, Type type,
					JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
				String datetime = json.getAsJsonPrimitive().getAsString();
				return LocalDate.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}
		}).create();

		return gson;
	}

	/**
	 *  序列化
	 * @param obj
	 * @return json文本
	 */
	public static String toJsonStr(Object obj) {
		Gson gson = new GsonBuilder()
		.registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
			@Override
			public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
				return new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			}
		}).registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
			@Override
			public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
				return new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			}
		}).registerTypeAdapter(LocalTime.class, new JsonSerializer<LocalTime>() {
			@Override
			public JsonElement serialize(LocalTime src, Type typeOfSrc, JsonSerializationContext context) {
				return new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
			}
		}).serializeNulls()
		.setPrettyPrinting()
		.create();

		return gson.toJson(obj);
	}

	/**
	 *  json文本转Object对象
	 * @param json
	 * @return
	 */
	public Collection<Integer> st(String json) {
		Type collectionType = new TypeToken<Collection<Integer>>() {
		}.getType();
		Gson gson = new Gson();
		Collection<Integer> array = gson.fromJson(json, collectionType);
		return array;
	}

}
