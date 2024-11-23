package com.csc;

public class Cutie {
    private String description;
    private Integer cutenessRating;

    public Cutie(String description, Integer cutenessRating) {
        this.description = description;
        this.cutenessRating = cutenessRating;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCutenessRating() {
        return cutenessRating;
    }

    @Override
    public String toString() {
        return getDescription() + " (Cuteness: " + getCutenessRating() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cutie cutie = (Cutie) obj;
        return description.equals(cutie.description) && cutenessRating.equals(cutie.cutenessRating);
    }

    @Override
    public int hashCode() {
        return 31 * description.hashCode() + cutenessRating.hashCode();
    }
}
