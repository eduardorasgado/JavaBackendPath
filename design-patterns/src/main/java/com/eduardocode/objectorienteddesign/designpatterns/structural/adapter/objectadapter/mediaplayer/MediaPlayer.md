The Adapter design pattern typically involves the following parts:

The Target Interface: defines the domain-specific interface that the client uses.
The Adaptee: defines an existing interface that needs adapting.
The Adapter: adapts the Adaptee to the Target Interface.

In the example that I provided, the MediaPlayer interface is the Target Interface, the AdvancedMediaPlayer interface is the Adaptee and the MediaAdapter class is the Adapter. The AudioPlayer class is the client that uses the Target Interface.