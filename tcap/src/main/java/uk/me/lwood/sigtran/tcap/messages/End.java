package uk.me.lwood.sigtran.tcap.messages;

import uk.me.lwood.sigtran.tcap.DestTransactionId;
import uk.me.lwood.sigtran.tcap.ros.ComponentPortion;
import uk.me.lwood.sigtran.tcap.ros.DialoguePortion;

/**
 * 
 * @author lukew
 */
public class End {
    private final DestTransactionId transactionId;
    private final DialoguePortion dialoguePortion;
    private final ComponentPortion components;
    
    public End(DestTransactionId transactionId, DialoguePortion dialoguePortion, ComponentPortion components) {
        this.transactionId = transactionId;
        this.dialoguePortion = dialoguePortion;
        this.components = components;
    }

    public final DestTransactionId getTransactionId() {
        return transactionId;
    }

    public final DialoguePortion getDialoguePortion() {
        return dialoguePortion;
    }

    public final ComponentPortion getComponents() {
        return components;
    }
}
