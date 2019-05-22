package jenkim49.checkout;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TransactionAdvice {
	private PlatformTransactionManager manager;
	public void setManager(PlatformTransactionManager manager) {
		this.manager = manager;
	}
	public Object doActionWithTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
		DefaultTransactionDefinition dtd=
				new DefaultTransactionDefinition();
		dtd.setPropagationBehavior(
				DefaultTransactionDefinition.PROPAGATION_REQUIRED);
		dtd.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_READ_COMMITTED);
		
		TransactionStatus status = 
			manager.getTransaction(dtd);
		System.out.println("###[TransactionAroundAdvice]status:"+status.isNewTransaction());
		Object result = null;
		try {
			
			result = joinPoint.proceed();
			manager.commit(status);
			System.out.println("###[TransactionAroundAdvice]manager.commit()");	
		} catch (Throwable ex) {
			System.out.println("###[TransactionAroundAdvice]manager.rollback()");	
			manager.rollback(status);
			throw ex;
		}
		return result;
	}

}



