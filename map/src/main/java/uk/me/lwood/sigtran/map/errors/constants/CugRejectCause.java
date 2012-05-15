package uk.me.lwood.sigtran.map.errors.constants;

/**
 * 
 * @author lukew
 */
public enum CugRejectCause {
    INCOMING_CALLS_BARRED_WITHIN_CUG,
    SUBSCRIBER_NOT_MEMBER_OF_CUG,
    REQUESTED_BASIC_SERVICE_VIOLATES_CUG_CONSTRAINTS,
    CALLED_PARTY_SS_INTERACTION_VIOLATION
}
