package com.web.websocket;

import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/websocket/chat1")
public class ChatServer1 {

    private static CopyOnWriteArraySet<Session> sessions;

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client端" + session.getId());
        if (sessions == null) {
            sessions = new CopyOnWriteArraySet<>();
        }
        sessions.add(session);
        System.out.println("歡迎" + session.getId() + "加入");
    }

    @OnMessage
    public void onMessage(String message,Session session) {
        System.out.println("id=" + session.getId() + " 說:" + message);
        sandAll(message);

    }

    @OnClose
    public void OnClose(Session session) {
        System.out.println("Session" + session.getId() + "離開");
        if (sessions != null) {
            sessions.remove(session);
            sandAll("離開" + session.getId());
        }
    }

    private void sandAll(String message) {
        if (sessions != null) {
            for (Session session : sessions) {
                session.getAsyncRemote().sendText(message);
            }
        }
    }
}
