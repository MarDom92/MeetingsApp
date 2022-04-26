package pl.mardom92.MeetingsApp.model.builder;

import pl.mardom92.MeetingsApp.model.entity.Event;

import java.time.LocalDateTime;

public class EventBuilder {

    private String title;
    private String description;
    private String place;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public EventBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public EventBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public EventBuilder withPlace(String place) {
        this.place = place;
        return this;
    }

    public EventBuilder withCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public EventBuilder withUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public EventBuilder withStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventBuilder withEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public Event build() {

        Event event = new Event();

        event.setTitle(title);
        event.setDescription(description);
        event.setPlace(place);
        event.setCreatedDate(createdDate);
        event.setUpdatedDate(updatedDate);
        event.setStartDate(startDate);
        event.setEndDate(endDate);

        return event;
    }
}
