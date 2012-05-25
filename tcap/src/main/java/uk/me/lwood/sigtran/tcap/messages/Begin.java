package uk.me.lwood.sigtran.tcap.messages;

import uk.me.lwood.asn1.annotations.Optional;
import uk.me.lwood.sigtran.tcap.OrigTransactionId;
import uk.me.lwood.sigtran.tcap.ros.ComponentPortion;
import uk.me.lwood.sigtran.tcap.ros.DialoguePortion;

/**
 * 
 * @author lukew
 */
public class Begin {
    private final OrigTransactionId transactionId;
    @Optional
    private final DialoguePortion dialoguePortion;
    @Optional
    private final ComponentPortion components;
    
    public Begin(OrigTransactionId transactionId, DialoguePortion dialoguePortion, ComponentPortion components) {
        this.transactionId = transactionId;
        this.dialoguePortion = dialoguePortion;
        this.components = components;
    }

    public final OrigTransactionId getTransactionId() {
        return transactionId;
    }

    public final DialoguePortion getDialoguePortion() {
        return dialoguePortion;
    }

    public final ComponentPortion getComponents() {
        return components;
    }
}
