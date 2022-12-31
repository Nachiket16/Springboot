package com.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Tutorial;

@SpringBootTest
class TestTutorialDao {
	@Autowired
	private ITutorialDao tutDao;

	@Test
	void test() {
		List<Tutorial> list = tutDao.findByTopicId(2);
		list.forEach(System.out::println);
		assertEquals(2, list.size());
		
	}

}
