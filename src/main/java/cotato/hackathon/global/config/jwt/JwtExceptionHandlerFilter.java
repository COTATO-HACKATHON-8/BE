package cotato.hackathon.global.config.jwt;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import cotato.hackathon.global.error.BaseErrorCode;
import cotato.hackathon.global.error.ErrorResponse;
import cotato.hackathon.global.error.exception.TokenValidateException;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JwtExceptionHandlerFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (TokenValidateException e) {
            responseToClient(response, getErrorResponse(e.getErrorCode()));
        }
    }

    private ErrorResponse getErrorResponse(BaseErrorCode errorCode) {

        return ErrorResponse.from(errorCode.getErrorReason());
    }

    private void responseToClient(HttpServletResponse response, ErrorResponse errorResponse)
            throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(Integer.parseInt(errorResponse.getStatus()));
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
