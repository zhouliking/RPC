package com.zl.serialize;

/**
 * 序列化工具类，方法均为静态的
 * @author 周力
 */
public class SerializationUtil {
	private static SerializeInterface serializeStrategy;
	
	public SerializationUtil(SerializeInterface serialize){
		serializeStrategy = serialize;
	}
	
	public static <T> byte[] serialize(T obj) {
		if(serializeStrategy == null){
			throw new NullPointerException();
		}
		return serializeStrategy.serialize(obj);		
	}

	public static <T> T deserialize(byte[] bytes, Class<?> clazz) throws Exception {
		if(serializeStrategy == null){
			throw new NullPointerException();
		}
		return serializeStrategy.deserialize(bytes,clazz);
	}	
}
