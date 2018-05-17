package com.example.wordladder_hwk2_1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class WordladderHwk2ApplicationTests {

	@Test
	public void contextLoads() {
	}
    @Test
	public void test1() {
		App wl=new App("dictionary.txt","code","data");
		Assert.assertEquals("A ladder from data back to code:data date cate cade code \n",wl.getRes());
	}

	@Test
	public void test2() {
		App wl=new App("dictionary.txt","kitty","kitty");
		Assert.assertEquals("The two words must be different.",wl.getRes());
	}

	@Test
	public void test3() {
		App wl=new App("dictionary.txt","ghost","boo");
		Assert.assertEquals("The two words must be the same length.",wl.getRes());
	}

	@Test
	public void test4() {
		App wl=new App("dictionary.txt","marty","keith");
		Assert.assertEquals("The two words must be found in the dictionary.",wl.getRes());
	}

	@Test
	public void test5() {
		App wl=new App("smalldict1.txt","code","data");
		Assert.assertEquals("A ladder from data back to code:data date cate cade code \n",wl.getRes());
	}
}
