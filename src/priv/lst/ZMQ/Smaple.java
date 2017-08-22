package priv.lst.ZMQ;

import java.util.Date;

import org.zeromq.ZMQ;

public class Smaple {
	public static void main(String[] args) {

		ZMQ.Context context = ZMQ.context(1);
		ZMQ.Socket socket = context.socket(ZMQ.PUB); // ZMQ.PUB 指定通讯模式为
														// 【发布订阅模式】的 发布者
		socket.bind("tcp://192.168.1.100:9005"); // 绑定服务地址及端口

		while (true) {
			String time = new Date().getTime() + "";

			byte[] reply = time.getBytes();

			socket.send(reply, 0);
			System.out.println("@@@@ Server Send:" + time);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
