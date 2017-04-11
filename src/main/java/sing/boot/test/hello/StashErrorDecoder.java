package sing.boot.test.hello;

import feign.Response;
import feign.codec.ErrorDecoder;

public class StashErrorDecoder implements ErrorDecoder {

	  @Override
	    public Exception decode(String methodKey, Response response) {
		  	return new Exception();
	    }

}
