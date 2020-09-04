package org.example.restaurants.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;


@Entity
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.user", joinColumns = @JoinColumn(name = "user_id"))
})
public class Action {
    @EmbeddedId
    private ActionId primaryKey = new ActionId();

    @Transient
    User user = primaryKey.user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menu;

    @Column(name = "time", nullable = false)
    private LocalTime actionTime;

    @Embeddable
    public static class ActionId implements Serializable {
        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private User user;

        @Temporal(TemporalType.DATE)
        private Date date;

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }


}
