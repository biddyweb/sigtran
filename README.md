SIGTRAN
=======
An attempt at creating an entirely Java-based SIGTRAN stack, without having to
resort to widescale call outs to JNI.

WARNING: This project is in the early stages of development, and is not
recommended for production use (yet).

Modules
-------
 * m3ua
   - Implementation of the MTP3 User Adaptation Layer (see RFC4666), specific
     to sigtran
 * sccp
   - Implementation of SCCP
 * tcap
   - Transaction Capabilities Application Part
 * map
   - A set of classes that can be used in conjunction with an ASN.1 encoder to
     perform ITU MAP operations

Every module represents an element in the SIGTRAN stack.  Each module therefore
depends on the module for the element in the stack beneath it, which may in
turn depend on other modules.

Including this library in your project
--------------------------------------
To use this project, add the following snippet to your pom.xml dependencies:

            <dependency>
                <groupId>uk.me.lwood.sigtran</groupId>
                <artifactId>sigtran-XXXX</artifactId>
                <version>1.0.0-SNAPSHOT</version>
            </dependency>

where XXXX is the highest level module that your application will depend on.
Maven will transitively include all required sub-modules as appropriate.

Helping out
-----------
If you want to help out, feel free to open a pull request with any improvements
that you wish to make, or get in touch with me on freenode IRC (where I can
usually be found lurking in #netty).

Usage (Proposed)
----------------

    ServerBootstrap bootstrap = new ServerBootstrap(
        new SctpServerSocketChannelFactory(
            Executors.newCachedThreadPool()
        )
    );

    bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
        public ChannelPipeline getPipeline() throws Exception {
            return Channels.pipeline(
                new M3uaCodec(),
                new M3uaServiceProvider("test-asp"),
                new SccpCodec(),
                new SccpServiceProvider(),
                new TcapCodec(),
                new TcapServiceProvider(),
                new MapCodec(),
                new ExampleHandler()
            );
        }
    });

    bootstrap.bind(new InetSocketAddress(...));
