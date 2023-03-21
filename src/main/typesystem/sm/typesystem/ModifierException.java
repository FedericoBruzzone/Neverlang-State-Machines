package sm.typesystem;

import neverlang.core.typesystem.NeverlangTypesystemException;
import neverlang.core.typesystem.symbols.Location;

public class ModifierException extends NeverlangTypesystemException {
    private final Location location;

    public ModifierException(String message, Location location) {
        super(message);
        this.location = location;
    }

    @Override
    public Location location() {
        return location;
    }
}
