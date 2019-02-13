package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    @Value("${port:NOT SET}")
    private String port;

    @Value("${memory.limit:NOT SET}")
    private String memoryLimit;

    @Value("${cf.instance.index:NOT SET}")
    private String cfInstanceIndex;

    @Value("${cf.instance.addr:NOT SET}")
    private String cfInstanceAddress;

    public EnvController() {
    }

    public EnvController(String port,String memoryLimit,String cfInstanceIndex,String cfInstanceAddress) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddress = cfInstanceAddress;
    }


    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<>();

        env.put("PORT",port);
        env.put("MEMORY_LIMIT",memoryLimit);
        env.put("CF_INSTANCE_INDEX",cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR",cfInstanceAddress);

        return env;

    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(String memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public String getCfInstanceIndex() {
        return cfInstanceIndex;
    }

    public void setCfInstanceIndex(String cfInstanceIndex) {
        this.cfInstanceIndex = cfInstanceIndex;
    }

    public String getCfInstanceAddress() {
        return cfInstanceAddress;
    }

    public void setCfInstanceAddress(String cfInstanceAddress) {
        this.cfInstanceAddress = cfInstanceAddress;
    }
}
