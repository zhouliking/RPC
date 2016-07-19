package com.zl.serialize;

/**
 * 
 * @author 周力
 */
public class SerializationUtil {
	private static SerializeInterface serializeStrategy;
	
	public SerializationUtil(SerializeInterface serialize){
		this.serializeStrategy = serialize;
	}
	
	public static <T> byte[] serialize(T obj) {			
		return serializeStrategy.serialize(obj);		
	}

	public static <T> T deserialize(byte[] bytes, Class<?> clazz) throws Exception {
		return serializeStrategy.deserialize(bytes,clazz);
	}

	// /*
	// * Objenesis 不用反射创建
	// */
	// private static Map<Class<?>, Schema<?>> cachedSchema = new
	
	// T message = (T) objenesis.newInstance(cls); //用objenesis创建对象
	
	// }
}
