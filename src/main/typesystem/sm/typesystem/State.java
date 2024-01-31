package sm.typesystem;

import neverlang.core.typelang.annotations.TypeLangAnnotation;
import neverlang.core.typesystem.Priority;
import neverlang.core.typelang.annotations.TypeSystemKind;


@TypeLangAnnotation(
        kind = TypeSystemKind.PRIORITY
)
public class State extends Priority {
}