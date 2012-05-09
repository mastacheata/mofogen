package com.android.forge.calendar.auto;

import org.apache.cayenne.CayenneDataObject;

import com.android.forge.calendar.Events;

/**
 * Class _Attendees was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Attendees extends CayenneDataObject {

    public static final String ATTENDEE_EMAIL_PROPERTY = "attendeeEmail";
    public static final String ATTENDEE_NAME_PROPERTY = "attendeeName";
    public static final String ATTENDEE_RELATIONSHIP_PROPERTY = "attendeeRelationship";
    public static final String ATTENDEE_STATUS_PROPERTY = "attendeeStatus";
    public static final String ATTENDEE_TYPE_PROPERTY = "attendeeType";
    public static final String TO_EVENTS_PROPERTY = "toEvents";

    public static final String _ID_PK_COLUMN = "_id";

    public void setAttendeeEmail(String attendeeEmail) {
        writeProperty("attendeeEmail", attendeeEmail);
    }
    public String getAttendeeEmail() {
        return (String)readProperty("attendeeEmail");
    }

    public void setAttendeeName(String attendeeName) {
        writeProperty("attendeeName", attendeeName);
    }
    public String getAttendeeName() {
        return (String)readProperty("attendeeName");
    }

    public void setAttendeeRelationship(Integer attendeeRelationship) {
        writeProperty("attendeeRelationship", attendeeRelationship);
    }
    public Integer getAttendeeRelationship() {
        return (Integer)readProperty("attendeeRelationship");
    }

    public void setAttendeeStatus(Integer attendeeStatus) {
        writeProperty("attendeeStatus", attendeeStatus);
    }
    public Integer getAttendeeStatus() {
        return (Integer)readProperty("attendeeStatus");
    }

    public void setAttendeeType(Integer attendeeType) {
        writeProperty("attendeeType", attendeeType);
    }
    public Integer getAttendeeType() {
        return (Integer)readProperty("attendeeType");
    }

    public void setToEvents(Events toEvents) {
        setToOneTarget("toEvents", toEvents, true);
    }

    public Events getToEvents() {
        return (Events)readProperty("toEvents");
    }


}
