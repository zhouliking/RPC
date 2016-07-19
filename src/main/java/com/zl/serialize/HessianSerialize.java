package com.zl.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

/**
 * Hessian序列化
 * 与java序列化相比，码流小：着重于数据，附带简单的类型信息的方法
 * 像属性Integer a = 1，hessian会序列化成I 1这样的流，I表示int or Integer，1就是数据内容
 * 通过Java的反射机制，hessian把对象所有的属性当成一个Map来序列化
 * 如果一个对象之前出现过，hessian会直接插入一个R index这样的块来表示一个引用位置，
 * 从而省去再次序列化和反序列化的时间
 * @author 周力
 */
public class HessianSerialize implements SerializeInterface {

	@Override
	public <T> byte[] serialize(T obj) {
		if (obj == null)
			throw new NullPointerException();

		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			HessianOutput ho = new HessianOutput(os);
			ho.writeObject(obj);
			return os.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T deserialize(byte[] bytes, Class<?> clazz) {
		if (bytes == null)
			throw new NullPointerException();

		try {
			ByteArrayInputStream is = new ByteArrayInputStream(bytes);
			HessianInput hi = new HessianInput(is);
			return (T) hi.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
