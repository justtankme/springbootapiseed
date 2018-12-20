package com.company.project;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.project.core.properties.AddListTest;

public class RedissonTest extends BaseTester {
	@Autowired
	private RedissonClient client;
	@Autowired
	private AddListTest test;

	@Test
	public void test() {
		test.getTestmap().forEach(System.out::println);
	}
	
	@Test
	public void simpleTest() {
		client.getMap("xx", new StringCodec()).put("1", "2");
		client.getMap("xx").forEach((k, v) -> System.out.println("k" + k + "v" + v));
		RKeys keys = client.getKeys();
		List<String> keysList = new ArrayList<>();
		keys.getKeys().forEach(keysList::add);
		keysList.parallelStream().map(StringUtils::upperCase).forEach(System.out::println);
	}

	@Test
	public void asyncTest() {
		client.getKeys().getKeys()
				.forEach(key -> client.getKeys().deleteAsync(key).thenAccept(res -> System.out.println(res)));
	}
}
