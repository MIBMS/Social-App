package socialapp.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SocialAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	//loads a context for the ContextLoaderListener
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	//loads a context for the DispatcherServlet
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}
	
	//map request to "/"
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
