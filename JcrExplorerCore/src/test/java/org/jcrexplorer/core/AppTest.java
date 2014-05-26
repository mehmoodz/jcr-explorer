package org.jcrexplorer.core;

import javax.jcr.RepositoryException;

import org.jcrexplorer.core.JCRManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
	private ApplicationContext context=null;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		context=new ClassPathXmlApplicationContext("applicationContext-test.xml");
	}
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws RepositoryException 
     */
    public void testApp() throws RepositoryException
    {
    	JCRManager jcrManager=(JCRManager)context.getBean("jcrManager");
    	jcrManager.login("admin", "admin");
        assertTrue( jcrManager.currentSession()!=null );
    }
}
