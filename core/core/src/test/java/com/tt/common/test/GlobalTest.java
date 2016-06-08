package com.tt.common.test;
import static org.junit.Assert.*;
import com.tt.common.config.Global;
import org.junit.Test;


public class GlobalTest {
	@Test
	public void testvar() {
		// 测试编码  对/错
		assertSame(Global.FALSE, "false");
		assertSame(Global.TRUE, "true");
		//隐藏  显示
		assertSame(Global.SHOW, "1");
		assertSame(Global.HIDE, "0");
		//是否
		assertSame(Global.YES, "1");
		assertSame(Global.NO, "0");
	}
	@Test
	public void testkey(){
		String copyright = Global.getConfig("copyright");
		assertEquals(copyright,"珠海泰坦软件系统有限公司");
		
	}
	
	
	
}
