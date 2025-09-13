package com.iep.mycompany.app.config;

import com.iep.commons.exception.BaseCustomException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

@Service
public class FaultToleranceConfig {

    //TODO: reviosar este link para implementacion del circuirbreaker

    @Bean
    public CircuitBreaker defaultCircuitBreaker(){
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)           // se habilita % cuando la tasa de fallo es igual o mayor al umbral pasando a estado open
                //.slowCallRateThreshold(100) // se habilita % llamadas lentas es igual o mayor al umbral pasando a estado open
                .waitDurationInOpenState(Duration.ofMillis(1000))       // Tiempo de espera para transicionar a estado medio habierto half-open
                //.slowCallDurationThreshold(Duration.ofSeconds(2)) // considera el umbral de slowCallRateThreshold cuando las llamadas son consideradas como lentas
                .permittedNumberOfCallsInHalfOpenState(3)       // permite el numero de llamadas cuando el estado se encuentra medio-abierto
                .minimumNumberOfCalls(5)    // configura el numero de llamadas permitidas
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)// se habilita
                .slidingWindowSize(10)      // configura el tamaño de slidingWindow el cual registra el resultado de las llamadas cuando esta en estdo Cerrado
                //.recordException()
                .recordExceptions(IOException.class, org.springframework.web.client.HttpServerErrorException.class)
                //.ignoreExceptions(BusinessException.class, OtherBusinessException.class)
                .build();

        // Create a CircuitBreakerRegistry with a custom global configuration
       CircuitBreakerRegistry circuitBreakerRegistry =
                CircuitBreakerRegistry.of(circuitBreakerConfig);

        return circuitBreakerRegistry.circuitBreaker("default");

    }

}
