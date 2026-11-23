package tn.iteam.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
@ConfigurationProperties(prefix = "accounts")
public record AccountContactInfo(String message,
                                 Map<String, String> contactDetails,
                                 List<String> onCallSupport) {
}
