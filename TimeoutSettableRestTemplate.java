import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class TimeoutSettableRestTemplate extends RestTemplate {
    /**@param timeout timeout in milliseconds
     * @return current RestTemplate instance*/
    public RestTemplate setTimeout(int timeout){
        return setTimeout(timeout, this);
    }
    /**@param timeout timeout in milliseconds
     * @param template another template
     * @return current RestTemplate instance*/
    public static RestTemplate setTimeout(int timeout, RestTemplate template){
        if(template.getRequestFactory() instanceof SimpleClientHttpRequestFactory){
            SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) template.getRequestFactory();
            factory.setConnectTimeout(timeout);
            factory.setReadTimeout(timeout);
        }else if(template.getRequestFactory() instanceof HttpComponentsClientHttpRequestFactory){
            HttpComponentsClientHttpRequestFactory factory = (HttpComponentsClientHttpRequestFactory) template.getRequestFactory();
            factory.setConnectTimeout(timeout);
            factory.setReadTimeout(timeout);
        }
        return template;
    }
}
