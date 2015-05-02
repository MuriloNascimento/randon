package webservice;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class Randon {
	
	@Resource
	WebServiceContext wsc;
	
	public double next(double max){
		
		MessageContext mc = wsc.getMessageContext();
		
		@SuppressWarnings("rawtypes")
		Map headers = (Map) mc.get(MessageContext.HTTP_REQUEST_HEADERS);
		
		@SuppressWarnings("rawtypes")
		List usernameList = (List) headers.get("Username");
		
		String username = usernameList != null ? usernameList.get(0).toString() : null;
		
		System.out.println(username);
		
		if("admin".equals(username)){
			return Math.random() * max;
		} else {
			throw new RuntimeException("Usuario ou senha invalidos");
		}
			
		
	}
}
