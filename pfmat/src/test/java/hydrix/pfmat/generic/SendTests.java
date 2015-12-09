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
public class SendTests extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception { }

    public void testConnect() throws Exception {
        InputStream inputStream= mock(InputStream.class);
        OutputStream outputStream= mock(OutputStream.class);
        DeviceImplementation device= new DeviceImplementation(inputStream,outputStream);
        device.connect();
        verify(outputStream, times(0)).write(any(byte[].class));
    }

    public void testGetBatteryStatus() throws Exception {
        InputStream inputStream= mock(InputStream.class);
        OutputStream outputStream= mock(OutputStream.class);
        DeviceImplementation device= new DeviceImplementation(inputStream,outputStream);
        device.connect();
        device.sendGetBatteryStatus();
        verify(outputStream, times(1)).write(any(byte[].class));
    }

    public void testSendGetSensorData() throws Exception {
        InputStream inputStream= mock(InputStream.class);
        OutputStream outputStream= mock(OutputStream.class);
        DeviceImplementation device= new DeviceImplementation(inputStream,outputStream);
        device.connect();
        device.sendGetSensorData(0);
        verify(outputStream, times(2)).write(any(byte[].class));//Sending timestamp as well
    }
    public void testSendGetDeviceDetails() throws Exception {
        InputStream inputStream= mock(InputStream.class);
        OutputStream outputStream= mock(OutputStream.class);
        DeviceImplementation device= new DeviceImplementation(inputStream,outputStream);
        device.connect();
        device.sendGetDeviceDetails();
        verify(outputStream, times(1)).write(any(byte[].class));
    }
}