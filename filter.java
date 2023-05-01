import java.util.HashMap;
import java.util.Map;

public class filter {

    Map<String, String> filterSet;

    public filter() {
        this.filterSet = new HashMap<>();
    }

    public void add(String key, String value) {
        if (value.length() > 0)
            filterSet.put(key, value);
    }

    public laptop getFilterSample() {
        int filterRam = Integer.parseInt(this.filterSet.getOrDefault("ram", "0"));
        int filterHDDSize = Integer.parseInt(this.filterSet.getOrDefault("hddSize", "0"));
        String filterOs = this.filterSet.getOrDefault("os", "");
        String filterColor = this.filterSet.getOrDefault("color", "");
        String filterManufacturer = this.filterSet.getOrDefault("manufacturer", "");
        return new laptop(filterRam, filterHDDSize, filterOs, filterColor, filterManufacturer);
    }

}

