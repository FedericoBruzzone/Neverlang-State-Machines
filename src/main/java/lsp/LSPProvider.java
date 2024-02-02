package lsp;

import neverlang.core.lsp.capabilities.CapabilityBuilder;
import neverlang.core.lsp.defaults.*;
import neverlang.core.lsp.launcher.NeverlangLSPProvider;
import neverlang.core.lsp.services.NeverlangLSPDocumentService;
import neverlang.core.lsp.services.NeverlangLSPLanguageServer;
import neverlang.core.lsp.services.NeverlangLSPWorkspaceService;
import neverlang.core.lsp.services.WorkspaceBuilder;
import sm.StateMachineModule;

import java.util.List;
import java.util.stream.Stream;

public class LSPProvider extends NeverlangLSPProvider {
    
    private static final String typesystem = "sm.typesystem";

    @Override
    public WorkspaceBuilder workspaceBuilder() {
        return (workspace) -> Stream.of(new StateMachineCompilerHandler(workspace));
    }

    @Override
    public List<CapabilityBuilder> capabilities() {
        return List.of(
                () -> new DefaultDocumentSymbol(typesystem),
                () -> new DefaultSemanticToken(typesystem),
                () -> new DefaultDiagnostic(StateMachineModule.LANGUAGE),
                DefaultGoToDefinition::new,
                DefaultReferences::new,
                DefaultFoldingRange::new,
                () -> new DefaultInlayHint(typesystem)
        );
    }


}
