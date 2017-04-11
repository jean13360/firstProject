package sing.boot.test.hello;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import feign.Client;
import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.gson.GsonDecoder;
import feign.hystrix.HystrixFeign;
import feign.okhttp.OkHttpClient;

@Configuration
public class GitFeignConfiguration {
	  //public static final int FIVE_SECONDS = 5000;

	    @Bean
	    public Logger.Level feignLogger() {
	        return Logger.Level.FULL;
	    }
	    /*@Bean
	    public Request.Options options() {
	        return new Request.Options(FIVE_SECONDS, FIVE_SECONDS);
	    }*/
	    
	    @Bean		
		public Decoder feignDecoder() {
			return new ResponseEntityDecoder(new GsonDecoder());
		}
	    
	   /* @Bean
		RequestInterceptor feignRequestInterceptor() {
			return new BasicAuthRequestInterceptor("iran8800", "Bob002:)");
		}*/
	    
	    /*@Bean
		public Feign.Builder feignBuilder() {
			return HystrixFeign.builder().;
		}*/
	  
	    @Bean	  
	    public Client feignClient() {
	    
	    	
	    	Proxy proxyTest = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(proxyHost, proxyPort));
	    	com.squareup.okhttp.OkHttpClient client =
	    			new com.squareup.okhttp.OkHttpClient()
	    				.setProxy(proxyTest)
	    				.setAuthenticator(authenticate())
	    				;
	    	client.setConnectTimeout(60, TimeUnit.SECONDS);
	    	client.setReadTimeout(60, TimeUnit.SECONDS);
	    	client.setWriteTimeout(60, TimeUnit.SECONDS);
	    	
	    	
	    	return new OkHttpClient(client);
	    }
	    
	    private Authenticator authenticate() {
	    	final String credential = Credentials.basic(username, password);
	    	return new Authenticator() {
				
				@Override
				public Request authenticateProxy(Proxy proxy, Response response) throws IOException {
						
					return response.request().newBuilder().header("Proxy-Authorization", credential).build();
				}
				
				@Override
				public Request authenticate(Proxy proxy, Response response) throws IOException {
					// TODO Auto-generated method stub
					return response.request().newBuilder().header("Proxy-Authorization", credential).build();
				}
			};
	    }
	   
}
