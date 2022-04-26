package pl.mardom92.MeetingsApp.model.builder;

import pl.mardom92.MeetingsApp.model.dto.EventDto;

import java.time.LocalDateTime;

public class EventDtoBuilder {

    private String title;
    private String description;
    private String place;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public EventDtoBuilder withId(String title) {
        this.title = title;
        return this;
    }

    public EventDtoBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public EventDtoBuilder withPlace(String place) {
        this.place = place;
        return this;
    }

    public EventDtoBuilder withStarDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventDtoBuilder withEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public EventDto build() {

        EventDto eventDto = new EventDto();

        eventDto.setTitle(title);
        eventDto.setDescription(description);
        eventDto.setPlace(place);
        eventDto.setStartDate(startDate);
        eventDto.setEndDate(endDate);

        return eventDto;
    }
}
