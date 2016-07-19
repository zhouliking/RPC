package com.zl.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zl.common.RpcRequest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class RpcHandler extends SimpleChannelInboundHandler<RpcRequest> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcHandler.class);

	@Override
	protected void channelRead0(ChannelHandlerContext arg0, RpcRequest arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

//    private final Map<String, Object> handlerMap;
//
//    public RpcHandler(Map<String, Object> handlerMap) {
//        this.handlerMap = handlerMap;
//    }
//
//    @Override
//    public void channelRead0(final ChannelHandlerContext ctx, RpcRequest request) throws Exception {
//        RpcResponse response = new RpcResponse();
//        response.setRequestId(request.getRequestId());
//        try {
//            Object result = handle(request);
//            response.setResult(result);
//        } catch (Throwable t) {
//            response.setError(t);
//        }
//        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
//    }
//
//    private Object handle(RpcRequest request) throws Throwable {
//        String className = request.getClassName();
//        Object serviceBean = handlerMap.get(className);
//
//        Class<?> serviceClass = serviceBean.getClass();
//        String methodName = request.getMethodName();
//        Class<?>[] parameterTypes = request.getParameterTypes();
//        Object[] parameters = request.getParameters();
//
//        /*Method method = serviceClass.getMethod(methodName, parameterTypes);
//        method.setAccessible(true);
//        return method.invoke(serviceBean, parameters);*/
//
//        FastClass serviceFastClass = FastClass.create(serviceClass);
//        FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, parameterTypes);
//        return serviceFastMethod.invoke(serviceBean, parameters);
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//        LOGGER.error("server caught exception", cause);
//        ctx.close();
//    }
}