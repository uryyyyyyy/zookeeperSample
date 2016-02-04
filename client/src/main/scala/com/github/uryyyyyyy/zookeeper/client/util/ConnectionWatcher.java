package com.github.uryyyyyyy.zookeeper.client.util;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;

public class ConnectionWatcher implements Watcher {
	private CountDownLatch connectedSignal = new CountDownLatch(1);

	private static final int SESSION_TIMEOUT = 5000;

	public ZooKeeper zk;

	public void connect(String hosts) throws InterruptedException, IOException {
		zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
		connectedSignal.await();
	}

	@Override
	public void process(WatchedEvent event) {
		if(event.getState() == KeeperState.SyncConnected) {
			connectedSignal.countDown();
		}
	}

	public void close() throws InterruptedException {
		zk.close();
	}
}