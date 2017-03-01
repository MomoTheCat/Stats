package model;

import java.util.Date;
import java.util.List;

/**
 * Created by szymon on 01.03.2017.
 */
public class Stations {

    private String name;
    private List<Statistics> statistics;

    public Stations(List<Statistics> statistics, String name) {
        this.statistics = statistics;
        this.name = name;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class Statistics {

        private Date date;
        private int free_bikes;
        private int free_slots;

        public Statistics(Date date, int free_bikes, int free_slots) {
            this.date = date;
            this.free_bikes = free_bikes;
            this.free_slots = free_slots;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public int getFree_bikes() {
            return free_bikes;
        }

        public void setFree_bikes(int free_bikes) {
            this.free_bikes = free_bikes;
        }

        public int getFree_slots() {
            return free_slots;
        }

        public void setFree_slots(int free_slots) {
            this.free_slots = free_slots;
        }
    }
}
