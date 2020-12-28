# io-stream
this repo will contain project with i/o and network tcp /socket programming

# Socket-server
created server-socket and client programming . where we are writing continously
on output stream after some delay and consuming same on another side using input-stream continously  

# Thread and synchronization
This project contain thread and synchronization  sample example 


# netty.io

Netty Advantages

In general, Netty makes it a lot easier to build scalable, robust networked applications compared to implemeting the same using standard Java. Netty also contains some OS specific optimizations, like using EPOLL on Linux etc.

Netty Tools
Netty contains an impressive set of IO tools. Some of these tools are:

HTTP Server
HTTPS Server
WebSocket Server
TCP Server
UDP Server
In VM Pipe
Netty contains more than this, and Netty keeps growing.

*Using* Netty's IO tools it is **easy** to start an HTTP server, WebSocket server etc. It takes just a few lines of code.


The Netty ChannelPipeline is a very central concept in Netty. Each Netty SocketChannel contains a ChannelPipeline . The ChannelPipeline contains a list of ChannelHandler instances. These ChannelHandler instances are called when data is moving in and out of the SocketChannel.

The ChannelHandler interface has two subinterfaces. These subinterfaces are:

#### ChannelInboundHandler
#### ChannelOutboundHandler

You can add both ChannelInboundHandler and ChannelOutboundHandler instances to the Netty ChannelPipeline. The following diagram illustrates a ChannelPipeline with ChannelInboundHandler and ChannelOutboundHandler instances added:

###Codecs
Netty has the concept of codecs (encoders + decoders). A Netty codec converts bytes to message objects (Java objects), or message objects to bytes. For instance, a codec might convert the raw bytes of an incoming HTTP request to an HTTP object, or convert an HTTP response object back to raw bytes.

A Netty codec object is really just one (or two) ChannelHandler implementations. A codec typically consists of a ChannelInboundHandler implementation which converts request bytes into objects, and a ChannelOutboundHandler which converts response objects into bytes.

Netty comes with codecs for several different protocols, like HTTP, WebSockets, SSL / TLS etc. In order to use those protocols with Netty, you have to add the corresponding protocol codec ChannelInboundHandler and ChannelOutboundHandler to the ChannelPipeline of the SocketChannel you want to use the protocol with

###Netty TCP Server
(One of Netty's servers is a TCP server. To create a Netty TCP server you must do following)
- Create an EventLoopGroup
- Create and configure a ServerBootstrap
- Create a ChannelInitializer
- Start the server


