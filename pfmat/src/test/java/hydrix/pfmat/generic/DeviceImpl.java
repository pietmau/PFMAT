package hydrix.pfmat.generic;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by mauriziopietrantuono on 09/12/15.
 */
public class DeviceImpl extends Device {
    private final InputStream inputStream;
    private final OutputStream outputStream;

    public DeviceImpl(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    protected boolean connectSpecific() {
        return true;
    }

    @Override
    protected void disconnectSpecific() {  }

    @Override
    protected InputStream getInputStream() {
        return inputStream;
    }

    @Override
    protected OutputStream getOutputStream() {
        return outputStream;
    }

    @Override
    public String getDeviceId() {
        return "deviceid";
    }

    @Override
    protected void onConnectionLost() {  }
}
