package com.adnan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {
	
	@Pointcut("execution(* com.adnan.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// declare a @Pointcut for setters
	@Pointcut("execution(* com.adnan.aopdemo.dao.*.set*(..))")
	public void forSetters() {}
	
	// declare a @Pointcut for getters
	@Pointcut("execution(* com.adnan.aopdemo.dao.*.get*(..))")
	public void forGetters() {}
	
	// create @Pointcut : include package ... exclude getters / setters
	@Pointcut("forDaoPackage() && !(forGetters() || forSetters())")
	public void forDaoPackageNoGettersAndSetters() {}
	
}
