# RPC

---

##Summary
This is a simple implementation of RPC(Remote Procedure Call)  protocol. It can help us to realize the project of distributed services easily.

---
##Use of knowledge
- [Spring](http://spring.io/projects)
- [Netty](http://netty.io/)
- [Zookeeper](http://zookeeper.apache.org/)
- Protostuff
- Hessian

---
##Configurable of features

&#8194; ###Load balancing strategy
- Random LoadBalance
- RoundRobin LoadBalance（按权重轮询）
- LeastActive LoadBalance

&#8194; ### Serialization
- JDK native serialization
- Hessian
- Protostuff

---
##Other Similar projects
- Dubbo
- Thirft
- Hessian
