package jarTool.netty.singleserver;


import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.http.HttpRequestDecoder;
import org.jboss.netty.handler.codec.http.HttpResponseEncoder;

/**
中文文档：http://ifeve.com/netty5-user-guide/
 */   
/**  
 * 后台管理服务  
 * http://www.oschina.net/code/snippet_12_2759
 */ 
public class AdminServer {   
    public static void main(String[] args) {   
        start(7777);   
    }   
   
    public static void start(int port) {   
        // 配置服务器-使用java线程池作为解释线程   
        ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));   
        // 设置 pipeline factory.   
        bootstrap.setPipelineFactory(new ServerPipelineFactory());   
        // 绑定端口   
        bootstrap.bind(new InetSocketAddress(port));   
        System.out.println("admin start on "+port);   
    }   
   
    private static class ServerPipelineFactory implements 
            ChannelPipelineFactory {   
        public ChannelPipeline getPipeline() throws Exception {   
            // Create a default pipeline implementation. 
        
            ChannelPipeline pipeline = Channels.pipeline();   
            pipeline.addLast("decoder", new HttpRequestDecoder());   
            pipeline.addLast("encoder", new HttpResponseEncoder());   
            //http处理handler   
            pipeline.addLast("handler", new AdminServerHandler());   
            return pipeline;   
        }   
    }   
}