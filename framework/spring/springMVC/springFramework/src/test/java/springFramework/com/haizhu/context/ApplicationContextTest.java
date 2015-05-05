package springFramework.com.haizhu.context;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.haizhu.service.PetStoreService;

public class ApplicationContextTest {
	// create and configure beans
	ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] { "services.xml", "daos.xml" });

	// retrieve configured instance
	PetStoreService service = context
			.getBean("petStore", PetStoreService.class);

	// use configured instance
	List<String> userList = service.getUsernameList();
}
