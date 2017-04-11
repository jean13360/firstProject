package sing.boot.test.hello;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "user-test", url =YOUR_URL, configuration=GitFeignConfiguration.class)
public interface BobFeignClient {
	
	@RequestMapping()
	UserDummy[] getAll();
}
