import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class StudentServiceTest {
	
	@Before
	public void before(){
		System.out.println("kaishi......");
	}
	
	@After
	public void after(){
		System.out.println("ater");
	}
	@Test
	public void testLogin() {
		 System.out.println("login");
	}
	
	@Test
	public void testPage() {
		 System.out.println("pge");
	}

}
