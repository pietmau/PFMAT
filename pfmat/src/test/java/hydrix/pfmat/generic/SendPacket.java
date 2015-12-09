package hydrix.pfmat.generic;

import junit.framework.TestCase;

import org.mockito.Mockito;

import java.io.InputStream;
import java.io.OutputStream;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by mauriziopietrantuono on 09/12/15.
 */
public class SendPacket extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception { }


    public void testGetBatteryStatus() throws Exception {
        InputStream inputStream= mock(InputStream.class);
        OutputStream outputStream= mock(OutputStream.class);
        DeviceImpl device= new DeviceImpl(inputStream,outputStream);
        device.connect();
        device.sendGetBatteryStatus();
        verify(outputStream, times(2)).write(any(byte[].class));

    }
}