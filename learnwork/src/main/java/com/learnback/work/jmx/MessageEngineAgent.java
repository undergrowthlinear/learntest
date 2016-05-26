package com.learnback.work.jmx;

import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

/*import com.sun.jdmk.comm.HtmlAdaptorServer;*/

public class MessageEngineAgent {
	public void start() {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		try {
			ObjectName mxbeanName = new ObjectName("com.learnback.work.jmx:type=MessageEngine");
			MessageEngineMXBean mxbean = new MessageEngine();
			mbs.registerMBean(mxbean, mxbeanName);
			// JMXConnectorServer service
			// 这句话非常重要，不能缺少！注册一个端口，绑定url后，客户端就可以使用rmi通过url方式来连接JMXConnectorServer
			// 使用rmi进行访问MBean
			LocateRegistry.createRegistry(8888);
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:8888/server");
			JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
			System.out.println("....................begin rmi start.....");
			cs.start();
			System.out.println("....................rmi start.....");
			// 进行html访问MBean
			// 创建适配器，用于能够通过浏览器访问MBean
			/*HtmlAdaptorServer adapter = new HtmlAdaptorServer();
			adapter.setPort(9797);
			mbs.registerMBean(adapter, new ObjectName("com.learnback.work.jmx:name=htmladapter,port=9797"));
			adapter.start();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
