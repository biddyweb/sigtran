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
 * map
   - A set of classes that can be used in conjunction with an ASN.1 encoder to
     perform ITU MAP operations
