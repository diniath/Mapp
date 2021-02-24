package mapp.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;


/*
    enable the WebSocket capabilities
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /*
    registers the “/chat” endpoint, enabling Spring’s STOMP support
     are also adding here an endpoint that works without the SockJS for the sake 
    of elasticity
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/mapp");
        registry.addEndpoint("/mapp").withSockJS();
    }

    /*
    we enable an in-memory message broker to carry the messages back to the client 
    on destinations prefixed with “/topic”.
    the “/app” prefix to filter destinations targeting application annotated methods 
    (via @MessageMapping).
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
}
