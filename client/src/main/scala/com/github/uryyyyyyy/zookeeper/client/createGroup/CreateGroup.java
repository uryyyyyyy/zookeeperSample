package com.github.uryyyyyyy.zookeeper.client.createGroup;

import com.github.uryyyyyyy.zookeeper.client.util.ConnectionWatcher;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;

public class CreateGroup extends ConnectionWatcher {

	public void create(String groupName) throws KeeperException, InterruptedException {
		String path = "/" + groupName;
		String createdPath = zk.create(path, null/*data*/, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println("Created " + createdPath);
	}

	public static void main(String[] args) throws Exception {
		CreateGroup createGroup = new CreateGroup();
		createGroup.connect("172.17.0.2:2181");
		createGroup.create("gName");
		createGroup.close();
	}

}