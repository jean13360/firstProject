package sing.boot.test.hello;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.test.context.junit4.SpringRunner;

import feign.Feign;
import feign.gson.GsonDecoder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BobFeignClientTest {
	
	@Autowired
	private BobFeignClient obj;
	 
	private static final String URI_BOOK = "http://localhost:2012/jamvee/pe/user";
	 @Test
	 public void testFindBookById() {
		 
		  
		 assertNotNull(obj);
	    // find book by id
		 UserDummy[] founded= obj.getAll();
		 
		 BobFeignClient te = Feign.builder().contract(new SpringMvcContract()).decoder(new GsonDecoder()).target(BobFeignClient.class, URI_BOOK);
		UserDummy[] founded2 =te.getAll();
	    assertEquals(founded[0].getNom(), "AgentNom1");
	    int i = 0;
	    i++;
	  }
	 
}
