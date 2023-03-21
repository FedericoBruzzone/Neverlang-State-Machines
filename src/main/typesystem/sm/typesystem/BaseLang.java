package sm.typesystem;

import neverlang.core.typesystem.Type;
import neverlang.core.typesystem.symboltable.EntryKind;

import java.util.Map;
import java.util.stream.Stream;

public class BaseLang {

    private final static Map<String, TypeEvent> eventsMap = Map.of(
            "open", new TypeEvent(),
            "close", new TypeEvent(),
            "exit", new TypeEvent()
    );


    public static Stream<SymbolTableEntryFactory> events() {
        return eventsMap.entrySet().stream().map(e ->
            new SymbolTableEntryFactory()
                    .withEntryKind(EntryKind.DEFINE)
                    .withIdentifier(e.getKey())
                    .withEntryType((Type) e.getValue())
        );
    };
}
