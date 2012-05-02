SIGTRAN
=======
An attempt at creating an entirely Java-based SIGTRAN stack, without having to
resort to widescale call outs to JNI.

Modules
-------
 * m3ua
   - Implementation of the MTP3 User Adaptation Layer (see RFC4666), specific
     to sigtran
 * sccp
   - Implementation of SCCP; should be able to be wrapped by something else
     and embedded directly in another SS7 stack
 * tcap
   - Transaction Capabilities Application Part
 * map-api
   - A set of interfaces and skeleton framework classes to be used for specifying
     the behaviour and use of the Mobile Application Part.  Users should use this
     module, and also include on the classpath either map-ansi or map-etsi to
     choose which implementation to use
 * map-ansi
   - The ANSI implementation of MAP
 * map-etsi
   - The other implementation of MAP
