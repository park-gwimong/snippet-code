import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.util.LinkedHashMap;
import java.util.Map;

public class OsInfo {
  private String createServerInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("availableProcessors", Runtime.getRuntime().availableProcessors());
        map.put("CPU Usage", String.format("%.2f", osBean.getSystemCpuLoad() * 100));
        map.put("Memory Free Space", String.format("%.2f MB", (double) osBean.getFreePhysicalMemorySize() / 1024 / 1024));
        map.put("Memory Total Space", String.format("%.2f MB", (double) osBean.getTotalPhysicalMemorySize() / 1024 / 1024));

        try {
          return objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
          return "error";
        }
    }
  }
