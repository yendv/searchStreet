package com.contextlookup;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.driver.manager.client.DriverTypeManager;
import com.driver.manager.client.GuideManager;
import com.driver.manager.client.MerchandiseManager;

public class ContextLookup {
	public static GuideManager initGuiManager() throws NamingException{
		Context context = getInitialContext();
		GuideManager guiManger =
                (GuideManager)context.lookup("GuideManager#com.driver.manager.client.GuideManager");
		return guiManger;
	}
	
	public static DriverTypeManager initDriverTypeManager() throws NamingException{
		Context context = getInitialContext();
		DriverTypeManager driverTypeManager =
                (DriverTypeManager)context.lookup("DriverTypeManager#com.driver.manager.client.DriverTypeManager");
		return driverTypeManager;
	}
	
	public static MerchandiseManager initMerchandiseManager() throws NamingException{
		Context context = getInitialContext();
		MerchandiseManager merchandiseManager =
                (MerchandiseManager)context.lookup("MerchandiseManager#com.driver.manager.client.MerchandiseManager");
		return merchandiseManager;
	}
	
	private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "weblogic.jndi.WLInitialContextFactory");
        //        env.put(Context.PROVIDER_URL, "t3://192.168.50.53:7003");
        //                env.put(Context.PROVIDER_URL, "t3://192.168.50.93:9003");
        //      env.put(Context.PROVIDER_URL, "t3://192.168.57.179:7101");
        //                env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        //        env.put(Context.PROVIDER_URL, "t3://10.96.5.22:7003");
        //                env.put(Context.PROVIDER_URL, "t3://10.96.1.98:7003");
        return new InitialContext(env);
    }
}
