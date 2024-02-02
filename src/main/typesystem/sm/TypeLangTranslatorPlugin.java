package sm;

import neverlang.core.typesystem.defaults.Constants;
import sm.typesystem.StateModifier;
import sm.typesystem.TypeMachine;

import java.util.List;

public class TypeLangTranslatorPlugin extends neverlang.core.typelang.TypeLangTranslatorPlugin {
    public TypeLangTranslatorPlugin() {
        super(new TypeLangModule(), new StateMachineModule());
        importAllPackages(Constants.class, TypeMachine.class, StateModifier.class);
    }

    @Override
    protected String formatImports(List<String> importList) {
        importList.addAll(List.of(
                "neverlang.core.typesystem.symboltable.EntryKind",
                "neverlang.core.typesystem.symbols.*",
                // We cannot use "sm.typesystem.*" because in "sm" there is another State class
                "sm.typesystem.Machine",
                "sm.typesystem.Events",
                "sm.typesystem.State",

//                "simplelang.graph.*",
                "neverlang.core.typesystem.Priority",

                "simplelang.symboltable.CompilationHelper",
//                "simplelang.symboltable.CompilationUnit"
                "neverlang.core.typesystem.defaults.CompilationUnit"
        ));
        return super.formatImports(importList);
    }
}
