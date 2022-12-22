package com.nachiket.blog;

import com.nachiket.blog.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;

	private Calculator c = new Calculator();
	@Test
	void contextLoads() {
	}

//	@Test
//	public void repoTest(){
//		String className = this.userRepo.getClass().getName();
//		String pkgName = this.userRepo.getClass().getPackageName();
//		System.out.println(className);
//		System.out.println(pkgName);
//	}

	@Test
	void testSum(){
		//Expected Result
		int expectedResult = 20;
		//Actual Result
		int res = c.doSum(12,3,5);

		//We will use Assertion library
		//import static org.assertj.core.api.Assertions.*;
		assertThat(res).isEqualTo(expectedResult);

	}


}
