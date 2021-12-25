package driver;

import java.util.Arrays;
import java.util.Locale;

public enum DriverType {
    CHROME("chrome"), //
    FIREFOX("firefox"), //
    EDGE("edge"), //
    IE("ie");
    private final String value;

    DriverType(String value) {
        this.value = value;
    }

    public static DriverType getType(String value) {
        return Arrays.stream(DriverType.values()).filter(x -> x.value.equals(value.toLowerCase(Locale.ROOT))).findAny()
                .orElseThrow(() -> new RuntimeException("This browser is not supported:" + value));
    }
}
