package lsp;


import neverlang.core.lsp.compiler.WorkspaceHandler;
import neverlang.core.lsp.services.Workspace;
import neverlang.core.typesystem.Priority;
import neverlang.core.typesystem.compiler.Compiler;
import neverlang.core.typesystem.compiler.SourceSet;
import neverlang.core.typesystem.defaults.DefaultIncrementalCompilationHelper;
import neverlang.core.typesystem.defaults.DefaultSourceSet;
import neverlang.runtime.EndemicSlice;
import neverlang.runtime.Language;
import neverlang.runtime.LayeredRole;
import neverlang.runtime.Role;
import sm.StateMachinesLSPLang;
import simplelang.symboltable.CompilationHelper;
import sm.StateMachineModule;
import sm.typesystem.Events;
import sm.typesystem.Machine;
import sm.typesystem.State;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.stream.Stream;

public class StateMachineCompilerHandler extends WorkspaceHandler {
    public StateMachineCompilerHandler(Workspace workspace) {
        super(workspace, new DefaultIncrementalCompilationHelper());
    }

    @Override
    public SourceSet getSourceSet(Path rootDir) {
        return new DefaultSourceSet.Builder(".sm").buildFromRootDir(rootDir);
    }

    @Override
    public Language language() {
        return new StateMachinesLSPLang(new StateMachineModule());
    }

    @Override
    public Stream<Role> lspRoles() {
        return Stream.of(
            new Role("type_checker", Role.Flags.MANUAL)
        );
    }

    @Override
    public Stream<Class<? extends EndemicSlice>> endemicSlices() {
        return Stream.of(
            CompilationEndemicSlices.class
        );
    }

    @Override
    public Class<? extends neverlang.core.typesystem.AbstractCompilationHelper<?, ?>> compilationHelper() {
        return CompilationHelper.class;
    }

    @Override
    public List<Priority> priorities() {
        return List.of(
            new Machine(),
            new State(),
            new Events()
        );
    }
}
