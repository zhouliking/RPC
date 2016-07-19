package com.zl.serialize;
/**
 * 
 * @author 周力
 */
public interface SerializeInterface {
	public <T> byte[] serialize(T obj);
	public <T> T deserialize(byte[] bytes, Class<?> clazz);
}
