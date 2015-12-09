package hydrix.pfmat.generic;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by mauriziopietrantuono on 09/12/15.
 */
public class DeviceTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception { }

    public void testConnectNull() throws Exception {
        DeviceImpl device= new DeviceImpl(null,null);
        device.connect();
    }

    public void testConnectNullIsConnected() throws Exception {
        DeviceImpl device= new DeviceImpl(null,null);
        device.connect();
        assertTrue(!device.isConnected());//Not connected because streams are null
    }
    public void testConnectNotNullIsConnected() throws Exception {
        InputStream inputStream= Mockito.mock(InputStream.class);
        OutputStream outputStream=Mockito.mock(OutputStream.class);
        DeviceImpl device= new DeviceImpl(inputStream,outputStream);
        device.connect();
        assertTrue(device.isConnected());//Connected because streams are not null
    }
}