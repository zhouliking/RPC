package com.zl.serialize;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
/**
 * Prostuff序列化
 * @author 周力
 */
public class ProtostuffSerialize implements SerializeInterface{
	private static Map<Class<?>, Schema<?>> schemas = new ConcurrentHashMap<Class<?>, Schema<?>>();

	@SuppressWarnings("unchecked")
	private static <T> Schema<T> getSchema(Class<?> clazz) {
		Schema<T> schema = (Schema<T>) schemas.get(clazz);
		if (schema == null) {
			schema = (Schema<T>) RuntimeSchema.createFrom(clazz);
			if (schema != null)
				schemas.put(clazz, schema);

		}
		return schema;
	}
	@Override
	public <T> byte[] serialize(T obj) {
		Class<?> clazz = obj.getClass();
		Schema<T> schema = getSchema(clazz);
		LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);

		return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T deserialize(byte[] bytes, Class<?> clazz) {
		
		T obj = null;
		try {
			obj = (T) clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		Schema<T> schema = getSchema(clazz);
		ProtostuffIOUtil.mergeFrom(bytes, obj, schema);

		return obj;
	}

}
