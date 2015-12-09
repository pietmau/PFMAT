package hydrix.pfmat.generic;

import junit.framework.TestCase;

import java.io.InputStream;
import java.io.OutputStream;

import hydrix.pfmat.generic.mocks.DeviceImplementation;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by mauriziopietrantuono on 09/12/15.
 */
public class ReceiveTests extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception { }

    public void testRead() throws Exception {
        InputStream inputStream= mock(InputStream.class);
        OutputStream outputStream= mock(OutputStream.class);
        DeviceImplementation device= new DeviceImplementation(inputStream,outputStream);
        device.connect();
        verify(inputStream).read(any(byte[].class));//OK, thread is alive and reading
    }

    public void testReadBatteryStatus() throws Exception {
        InputStream inputStream= mock(InputStream.class);
        OutputStream outputStream= mock(OutputStream.class);
        DeviceImplementation device= new DeviceImplementation(inputStream,outputStream);
        device.connect();
        verify(inputStream).read(any(byte[].class));
    }

}