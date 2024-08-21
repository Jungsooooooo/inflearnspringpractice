package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    
    //ctrl + o 로 override 정보 불러올 수 있음.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getMethod();        //Get
        request.getProtocol();      //http/1.1
        request.getScheme();
        request.getRequestURL();    //http://...
        request.getRequestURI();    //request-header
        request.getQueryString();   //username=js...
        request.isSecure();
    
        //헤더 네임들 출력
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println("headerName = " + headerName));
        
        //언어 세팅.. 
        request.getLocales().asIterator()
                .forEachRemaining(name -> System.out.println("name = " + name));
        
        //쿠키
        if(request.getCookies() != null){
            for(Cookie cookie : request.getCookies()){
                System.out.println("cookie = " + cookie);
            }
        }
        
        //GET은 컨텐트 타입 없음
        
    }
}
