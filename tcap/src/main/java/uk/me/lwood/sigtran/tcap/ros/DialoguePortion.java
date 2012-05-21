package uk.me.lwood.sigtran.tcap.ros;

import uk.me.lwood.sigtran.tcap.dialogue.DialoguePdu;

/**
 * 
 * @author lukew
 */
public class DialoguePortion {
    private final DialoguePdu dialoguePdu;
    
    public DialoguePortion(DialoguePdu dialoguePdu) {
        this.dialoguePdu = dialoguePdu;
    }
    
    public DialoguePdu getDialoguePdu() {
        return dialoguePdu;
    }
}
