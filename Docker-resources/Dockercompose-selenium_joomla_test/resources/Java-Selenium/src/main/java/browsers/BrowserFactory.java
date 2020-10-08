package browsers;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.google.gson.JsonObject;

public class BrowserFactory {

    private static String gridUrl = "http://hub:4444/wd/hub";
    private static String proxyAddress = "docker.for.mac.host.internal:3128";

    public static RemoteWebDriver getRemoteBrowser(String browserName, boolean withProxy) throws Exception {
        DesiredCapabilities capabilities = null;
        RemoteWebDriver webDriver = null;

        switch (browserName) {
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                capabilities.acceptInsecureCerts();
                if(withProxy) {
                    capabilities.setCapability("proxy", getFirefoxProxy());
                }
                break;
            case "chrome":
                capabilities = DesiredCapabilities.chrome();
                if(withProxy) {
                    capabilities.setCapability("proxy", getChromeProxy());
                }
                break;
            default:
                throw new Exception("Uncorrect browser name: " + browserName);
        }

        webDriver = new RemoteWebDriver(new URL(gridUrl), capabilities);
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return webDriver;
    }

    private static Proxy getChromeProxy() {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyAddress);
        proxy.setSslProxy(proxyAddress);
        return proxy;
    }

    private static JsonObject getFirefoxProxy() {
        JsonObject json = new JsonObject();
        json.addProperty("proxyType", "MANUAL");
        json.addProperty("httpProxy", proxyAddress);
        json.addProperty("sslProxy", proxyAddress);
        return json;
    }
}
