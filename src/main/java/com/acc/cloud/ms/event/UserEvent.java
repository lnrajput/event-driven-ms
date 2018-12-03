package com.acc.cloud.ms.event;

import com.acc.cloud.ms.domain.User;

/**
 * An event that encapsulates a state transition for the {@link User}
 * domain object.
 *
 * @link Laxminarayan Rajput
 */
public class UserEvent {

    private User subject;
    private EventType eventType;

    public UserEvent() {
    }

    public UserEvent(User subject, EventType eventType) {
        this.subject = subject;
        this.eventType = eventType;
    }

    public User getSubject() {
        return subject;
    }

    public void setSubject(User subject) {
        this.subject = subject;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
