package com.yyy.design.designModel6.prototype;
import org.junit.Test;;
public class Client {
	@Test
	public void testProtoType(){
		new TestProtoType(new ContrectProtoType1()).operation();
	}
	class TestProtoType{
		private Prototype prototype;
		public TestProtoType(Prototype prototype){
			this.prototype = prototype;
		}
		public void operation(){
			System.out.println("className=    "+prototype.clone().getClass().getSimpleName()+".java");
		}
		
	}
}
