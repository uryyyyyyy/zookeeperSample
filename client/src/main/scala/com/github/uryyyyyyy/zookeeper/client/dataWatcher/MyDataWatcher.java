package com.github.uryyyyyyy.zookeeper.client.dataWatcher;

import com.github.uryyyyyyy.zookeeper.client.util.ConnectionWatcher;
import com.github.uryyyyyyy.zookeeper.client.util.MyKeyValueStore;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher.Event.EventType;

import java.io.IOException;

public class MyDataWatcher extends ConnectionWatcher {

	MyKeyValueStore store;

	public MyDataWatcher() throws IOException, InterruptedException {
		store = new MyKeyValueStore();
		store.connect("172.17.0.2:2181");
	}

	public void displayValue() throws KeeperException, InterruptedException {
		String path = "/gName/mName";
		String value = store.read(path, this);
		System.out.printf("Read %s as %s\n", path, value);
	}

	@Override
	public void process(WatchedEvent event) {
		if (event.getType() == EventType.NodeDataChanged) {
			try {
				displayValue();
			} catch (KeeperException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		MyDataWatcher watcher = new MyDataWatcher();
		watcher.displayValue();
//		watcher.close();
	}
}