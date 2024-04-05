package org.experis.wishlist;

public class Gift implements Comparable<Gift> {

    private String name;

    public Gift(String name) throws  IllegalArgumentException{
        if(name == null || name.isEmpty() ){
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                name + "\n";
    }


    // override metodo compare per controllare il name e ordinarlo con il sort
    @Override
    public int compareTo(Gift o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gift gift = (Gift) o;

        return getName() != null ? getName().equals(gift.getName()) : gift.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}
