package sm;


import neverlang.core.typelang.TypeLangGenerator;
import neverlang.core.typesystem.defaults.Constants;
import simplelang.symboltable.CompilationHelper;
import sm.typesystem.TypeMachine;

import java.util.stream.Stream;

public class StateMachineModule extends TypeLangGenerator {

    public final static String LANGUAGE = "statemachine";

    public final static String LABEL = "state machine";
    public final static String TYPE_PACKAGE = TypeMachine.class.getPackageName();

    public StateMachineModule() {
//        initPackage(TYPE_PACKAGE, LABEL);
//        initPackage(Constants.DEFAULT_TYPES_PACKAGE, Constants.DEFAULT_TYPES_LABEL);
        initPackage(Stream.of(TYPE_PACKAGE, CompilationHelper.class.getPackageName(), Constants.DEFAULT_TYPES_PACKAGE));
    }
}
