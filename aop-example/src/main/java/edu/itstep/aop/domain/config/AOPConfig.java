package edu.itstep.aop.domain.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@EnableAspectJAutoProxy
@Configuration
public class AOPConfig {

}
