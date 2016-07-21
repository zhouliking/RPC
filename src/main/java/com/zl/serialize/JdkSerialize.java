package com.zl.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Java序列化可靠，支持的全面
 * 原因是：Java序列化会把要序列化的对象类的元数据，业务数据，整个继承关系全部序列化
  *对象结构到内容的完全描述，因此效率较低，而且字节流比较大。
  *但是由于确实是序列化了所有内容，因此也更可用和可靠。
  *
  *原生的Serializable对象只序列化属性，不序列化方法、静态变量
  *
 * @author 周力
 */
public class JdkSerialize implements SerializeInterface {

	@Override
	public <T> byte[] serialize(T obj) {
		ObjectOutputStream oos;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		try {
			oos = new ObjectOutputStream(byteArrayOutputStream);
			oos.writeObject(obj);
			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T deserialize(byte[] bytes, Class<?> clazz) {
		ObjectInputStream ois;
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		
		try {
			ois = new ObjectInputStream(bis);
			return (T) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
