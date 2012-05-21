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

Including this library in your project
--------------------------------------
To use this project, add the following snippet to your pom.xml dependencies:

            <dependency>
                <groupId>uk.me.lwood.sigtran</groupId>
                <artifactId>sigtran-m3ua</artifactId>
                <version>1.0.0-SNAPSHOT</version>
            </dependency>
            <dependency>
                <groupId>uk.me.lwood.sigtran</groupId>
                <artifactId>sigtran-sccp</artifactId>
                <version>1.0.0-SNAPSHOT</version>
            </dependency>
            <dependency>
                <groupId>uk.me.lwood.sigtran</groupId>
                <artifactId>sigtran-map</artifactId>
                <version>1.0.0-SNAPSHOT</version>
            </dependency>

Usage
-----

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
