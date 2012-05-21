package uk.me.lwood.sigtran.tcap.dialogue;

/**
 * 
 * @author lukew
 */
public class AssociateSourceDiagnostic {
    private final DialogueServiceUserDiagnostic dialogueServiceUser;
    private final DialogueServiceProviderDiagnostic dialogueServiceProvider;
    
    public AssociateSourceDiagnostic(DialogueServiceUserDiagnostic dialogueServiceUser,
                                     DialogueServiceProviderDiagnostic dialogueServiceProvider) {
        this.dialogueServiceUser = dialogueServiceUser;
        this.dialogueServiceProvider = dialogueServiceProvider;
    }

    public final DialogueServiceUserDiagnostic getDialogueServiceUser() {
        return dialogueServiceUser;
    }

    public final DialogueServiceProviderDiagnostic getDialogueServiceProvider() {
        return dialogueServiceProvider;
    }

    public static enum DialogueServiceUserDiagnostic {
        NULL,
        NO_REASON_GIVEN,
        APPLICATION_CONTEXT_NAME_NOT_SUPPORTED
    }
    
    public static enum DialogueServiceProviderDiagnostic {
        NULL,
        NO_REASON_GIVEN,
        NO_COMMON_DIALOGUE_PORTION
    }
}
